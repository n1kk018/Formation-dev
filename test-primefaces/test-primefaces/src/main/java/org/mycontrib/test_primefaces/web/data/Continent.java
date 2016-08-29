package org.mycontrib.test_primefaces.web.data;

public class Continent {
	public String nom;
	public String imageName;
	public Long superficie; //km2
	public String type ="exist"; //byDefault
	
	public Continent() {
		super();
	}
	

	public Continent(String nom) {
		super();
		this.nom = nom;
	}
	

	public Continent(String nom, String imageName) {
		super();
		this.nom = nom;
		this.imageName = imageName;
	}
	


	public Continent(String nom, String imageName, Long superficie) {
		super();
		this.nom = nom;
		this.imageName = imageName;
		this.superficie = superficie;
	}


	@Override
	public String toString() {
		return "Continent [nom=" + nom + "]";
	}

	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getImageName() {
		return imageName;
	}


	public void setImageName(String imageName) {
		this.imageName = imageName;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public Long getSuperficie() {
		return superficie;
	}


	public void setSuperficie(Long superficie) {
		this.superficie = superficie;
	}
	
	
	
}
