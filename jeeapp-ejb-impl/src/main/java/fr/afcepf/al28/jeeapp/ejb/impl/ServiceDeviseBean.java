package fr.afcepf.al28.jeeapp.ejb.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;

import fr.afcepf.al28.jeeapp.ejb.api.IServiceDevise;
import fr.afcepf.al28.jeeapp.entity.Devise;

@Stateless
public class ServiceDeviseBean implements IServiceDevise {
	@Resource(mappedName="java:/DeviseDS")
	public DataSource deviseDS;

	@Override
	public Devise rechercherDevise(String codeDevise) {
		// Version1 no bdd
		//return new Devise(codeDevise, "monnaie_" + codeDevise, 1.25);
		//Version 2 (Avec JDBC/SQL)
		Devise d =null;
		Connection cnx = null;
		try {
			cnx = deviseDS.getConnection();
			PreparedStatement req = cnx.prepareStatement("SELECT * FROM devise WHERE codeDevise=?");
			req.setString(1, codeDevise);
			ResultSet rs = req.executeQuery();
			if(rs.next()){
				d=new Devise(rs.getString("codeDevise"),rs.getString("monnaie"),rs.getDouble("tauxChange"));
			}
			rs.close();
			req.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				cnx.close();
			}catch (Exception e) {}
		}
		return d;
	}

	@Override
	public List<Devise> toutesDevises() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double convertir(Double montant, String devSource, String devCible) {
		// TODO Auto-generated method stub
		return null;
	}

}
