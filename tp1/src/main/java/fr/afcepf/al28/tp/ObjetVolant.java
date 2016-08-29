package fr.afcepf.al28.tp;

import java.io.Serializable;

public abstract class ObjetVolant implements Serializable{
	private static final long serialVersionUID = 1L;
	private String couleur;
	protected static Integer PLAFOND;
	
	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	
	public abstract Integer getPlafond();

}
