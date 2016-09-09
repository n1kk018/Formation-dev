package fr.afcepf.al28.patterns.decorateur;

import java.util.ArrayList;

public class Pizza implements ICustomizable{
	private String nom;
	private Float Prix;
	
	
	
	public Pizza(String nom, Float prix) {
		super();
		this.nom = nom;
		Prix = prix;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public Float getPrix() {
		return Prix;
	}



	public void setPrix(Float prix) {
		Prix = prix;
	}



	public ArrayList<String> getComposition() {
		ArrayList<String> composition = new ArrayList<String>();
		composition.add(this.nom);
		return composition;
	}
}
