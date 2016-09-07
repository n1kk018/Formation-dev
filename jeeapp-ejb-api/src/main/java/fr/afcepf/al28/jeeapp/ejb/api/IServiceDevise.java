package fr.afcepf.al28.jeeapp.ejb.api;

import java.util.List;

import javax.ejb.Local;

import fr.afcepf.al28.jeeapp.entity.Devise;
import fr.afcepf.al28.jeeapp.entity.Pays;

@Local
//@Remote
//@WebService
public interface IServiceDevise 
{
	public Devise rechercherDevise(String codeDevise);
	public List<Devise> toutesDevises();
	public Double convertir(Double montant, String devSource, String devCible);
	public List<Pays> listePaysPartageantDevise(String devise);
}
