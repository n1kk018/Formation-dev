package fr.afcepf.al28.hibernate.heritage;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="FORMATEUR")
public class Formateur extends Personne {
	private Double salaire;
	

	public Formateur(Integer id, String nom, String prenom, String adresse, Date naissance, Double salaire) {
		super(id, nom, prenom, adresse, naissance);
		this.salaire = salaire;
	}

	public Formateur() {
		super();
	}

	public Double getSalaire() {
		return salaire;
	}

	public void setSalaire(Double salaire) {
		this.salaire = salaire;
	}

}
