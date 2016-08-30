package fr.afcepf.al28.spring.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.afcepf.al28.hibernate.dao.IDaoPersonne;
import fr.afcepf.al28.hibernate.entity.Compte;
import fr.afcepf.al28.hibernate.entity.Personne;

@ManagedBean(name="mbSpring")
@SessionScoped
public class SpringWebManagedBean {
	private Personne persInsert = new Personne();
	private List<Personne> personnes;
	private List<Compte> comptesselected;
	private Personne persSelected;
	//Ici nom de l'instance (couplage fort)
	//en meme tps pas le choix
	@ManagedProperty(value="#{daoPersonneTx}")
	private IDaoPersonne dao;
	
	public void ajouter() {
		persInsert = dao.ajouter(persInsert);
	}
	
	public void rechercher() {
		personnes = dao.rechercheParNom(persInsert.getNom());
		if(personnes.size() > 0){
			persSelected = personnes.get(0);
		}
	}
	
	public Personne getPersInsert() {
		return persInsert;
	}
	public void setPersInsert(Personne persInsert) {
		this.persInsert = persInsert;
	}
	public List<Personne> getPersonnes() {
		return personnes;
	}
	public void setPersonnes(List<Personne> personnes) {
		this.personnes = personnes;
	}
	public List<Compte> getComptesselected() {
		return comptesselected;
	}
	public void setComptesselected(List<Compte> comptesselected) {
		this.comptesselected = comptesselected;
	}
	public Personne getPersSelected() {
		return persSelected;
	}
	public void setPersSelected(Personne persSelected) {
		this.persSelected = persSelected;
	}
	public IDaoPersonne getDao() {
		return dao;
	}
	public void setDao(IDaoPersonne dao) {
		this.dao = dao;
	}
	
	
	
	
}
