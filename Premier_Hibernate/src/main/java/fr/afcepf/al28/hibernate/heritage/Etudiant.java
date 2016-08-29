package fr.afcepf.al28.hibernate.heritage;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="ETUDIANT")
public class Etudiant extends Personne {
	private String cursus;
	
	public Etudiant() {
		super();
	}

	public Etudiant(Integer id, String nom, String prenom, String adresse, Date naissance,String cursus) {
		super(id, nom, prenom, adresse, naissance);
		this.cursus=cursus;
	}

	public String getCursus() {
		return cursus;
	}

	public void setCursus(String cursus) {
		this.cursus = cursus;
	}
	
}
