package fr.afcepf.al28.jeeapp.ejb.impl;

import java.util.List;

import javax.ejb.Stateless;

import fr.afcepf.al28.jeeapp.ejb.api.IServiceDevise;
import fr.afcepf.al28.jeeapp.entity.Devise;

@Stateless
public class ServiceDeviseBean implements IServiceDevise {

	@Override
	public Devise rechercherDevise(String codeDevise) {
		// Version1 no bdd
		return new Devise(codeDevise, "monnaie_" + codeDevise, 1.25);
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
