package fr.afcepf.al28.jeeapp.ejb.dao;

import java.util.List;

import javax.ejb.Local;

import fr.afcepf.al28.jeeapp.entity.Devise;
import fr.afcepf.al28.jeeapp.entity.Pays;


@Local
public interface IDaoDevise {

	void updateDevise(Devise d);

	void deleteDevise(Devise d);

	String createDevise(Devise d);

	Devise getDeviseByCode(String code);

	Devise getDeviseByName(String nom);

	List<Devise> getAllDevises();

	List<Pays> getListePaysPartageantDevise(String codeDevise);

}