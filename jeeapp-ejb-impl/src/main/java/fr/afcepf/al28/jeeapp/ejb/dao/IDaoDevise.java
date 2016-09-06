package fr.afcepf.al28.jeeapp.ejb.dao;

import java.util.List;

import javax.ejb.Local;

import fr.afcepf.al28.jeeapp.entity.Devise;

@Local
public interface IDaoDevise {

	Devise getDeviseByCode(String codeDevise);

	List<Devise> getAllDevise();

}