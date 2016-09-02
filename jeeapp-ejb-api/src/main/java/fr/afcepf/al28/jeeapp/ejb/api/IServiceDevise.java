package fr.afcepf.al28.jeeapp.ejb.api;

import java.util.List;

import javax.ejb.Local;

import fr.afcepf.al28.jeeapp.entity.Devise;

@Local
//@Remote
//@WebService
public interface IServiceDevise {
	public Devise rechercherDevise(String codeDevise);
	public List<Devise> toutesDevises();
	public Double convertir(Double montant, String devSource, String devCible);
}
