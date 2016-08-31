package fr.afcepf.al28.hibernate.dao;

import java.util.List;

import fr.afcepf.al28.hibernate.entity.Personne;

public interface IDaoPersonne {
	public Personne ajouter(Personne p);
	public Integer supprimer(Personne p);
	public List<Personne> rechercheParNom (String nom);
}
