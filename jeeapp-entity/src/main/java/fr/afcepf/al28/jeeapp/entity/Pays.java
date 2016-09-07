package fr.afcepf.al28.jeeapp.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class Pays {
	@Id
	private String codePays;
	private String nom;
	private String capitale;
	
	@ManyToOne()
	@JoinColumn(name ="refDevise")
	private Devise devise;

	public String getCodePays() {
		return codePays;
	}

	public void setCodePays(String codePays) {
		this.codePays = codePays;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCapitale() {
		return capitale;
	}

	public void setCapitale(String capitale) {
		this.capitale = capitale;
	}

	public Devise getDevise() {
		return devise;
	}

	public void setDevise(Devise devise) {
		this.devise = devise;
	}

	@Override
	public String toString() {
		return "Pays [codePays=" + codePays + ", nom=" + nom + ", capitale=" + capitale + "]";
	}
	
}
