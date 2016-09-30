package fr.afcepf.al28.jeeapp.ejb.impl;

import java.util.ArrayList;
/*import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;*/
import java.util.List;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
//import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
//import javax.sql.DataSource;
import javax.jws.WebService;

import fr.afcepf.al28.jeeapp.ejb.api.IServiceDevise;
import fr.afcepf.al28.jeeapp.ejb.dao.IDaoDevise;
import fr.afcepf.al28.jeeapp.ejb.dto.DeviseDTO;
import fr.afcepf.al28.jeeapp.ejb.dto.PaysDTO;
import fr.afcepf.al28.jeeapp.entity.Devise;
import fr.afcepf.al28.jeeapp.entity.Pays;

@Stateless
@DeclareRoles({"admin","user"})
@WebService(endpointInterface="fr.afcepf.al28.jeeapp.ejb.api.IServiceDevise")
public class ServiceDeviseBean implements IServiceDevise {
	/*@Resource(mappedName="java:/DeviseDS")
	public DataSource deviseDS;*/
	@EJB
	private IDaoDevise dao;

	@Override
	//@RolesAllowed({"admin"})
	@PermitAll
	public DeviseDTO rechercherDevise(String codeDevise) {
		//V3
		return entityDevise2DeviseDTO(dao.getDeviseByCode(codeDevise));
		// Version1 no bdd
		//return new Devise(codeDevise, "monnaie_" + codeDevise, 1.25);
		//Version 2 (Avec JDBC/SQL)
		/*Devise d =null;
		Connection cnx = null;
		try {
			cnx = deviseDS.getConnection();
			PreparedStatement req = cnx.prepareStatement("SELECT * FROM Devise WHERE codeDevise=?");
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
		return d;*/
	}

	@Override
	@PermitAll
	public List<DeviseDTO> toutesDevises() {
	    List<DeviseDTO> listDTO  = new ArrayList<DeviseDTO>();
	    for (Devise devise : dao.getAllDevises()) {
	        listDTO.add(entityDevise2DeviseDTO(devise));
        }
		return listDTO;
	}

	@Override
	@PermitAll
	public Double convertir(Double montant, String devSource, String devCible) {
		Devise rootD = dao.getDeviseByCode(devSource);
		Devise targetD = dao.getDeviseByCode(devCible);
		return montant*rootD.getTauxChange()-targetD.getTauxChange();
	}

	@Override
	@PermitAll
	public List<PaysDTO> listePaysPartageantDevise(String devise) {
	    List<PaysDTO> listDTO = new ArrayList<PaysDTO>();
	    for (Pays pays : dao.getListePaysPartageantDevise(devise)) {
            listDTO.add(new PaysDTO(pays.getCodePays(),pays.getNom(),pays.getCapitale()));
        }
		return listDTO;
	}
	
	private DeviseDTO entityDevise2DeviseDTO(Devise d) {
	    return new DeviseDTO(d.getCodeDevise(), d.getMonnaie(), d.getTauxChange());
	}
}
