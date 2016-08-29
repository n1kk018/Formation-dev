package org.mycontrib.test_primefaces.web.data;

public class Region {
	
	private String nom;
	private String capitale;
	
	public Region() {
		super();
	}
	
	public Region(String nom) {
		this(nom,null);
	}
	
	public Region(String nom, String capitale) {
		super();
		this.nom = nom;
		this.capitale = capitale;
	}

	@Override
	public String toString() {
		//return "Region [nom=" + nom + ", capitale=" + capitale + "]";
		return nom;
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
	
	

}
