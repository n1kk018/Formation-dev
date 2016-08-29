package fr.afcepf.al28.tp;

import java.io.Serializable;

public class Employe extends Personne implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Double salaire;
	private static int nbEmployes=0;
	
	public Employe() {
		super();
		nbEmployes++;
		this.salaire = 1725.56;
	}

	public Employe(String nom, Float poids, Integer age, Double salaire) {
		super(nom, poids, age);
		nbEmployes++;
		this.salaire = salaire;
	}
	
	public static int getNbInstances() {
		return nbEmployes;
	}
	
	@Override
	public String toString() {
		return super.toString().replace("Personne", "Employé").replace("]", ", salaire=" + this.salaire + "€]");
	}
	
	@Override
	protected void finalize() {
		super.finalize();
		nbEmployes--;
	}
}
