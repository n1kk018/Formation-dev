package org.mycontrib.test_primefaces.web.data;

public class Departement {
	
	private Integer numero;
	private String nom;
	private String prefecture;
	
	public Departement() {
		super();
	}
	
	public Departement(Integer numero, String nom) {
		this(numero,nom,null);
	}
	
	public Departement( String nom) {
		this(null,nom,null);
	}
	
	public Departement(Integer numero, String nom, String prefecture) {
		super();
		this.numero = numero;
		this.nom = nom;
		this.prefecture = prefecture;
	}

	@Override
	public String toString() {
		/*return "Departement [numero=" + numero + ", nom=" + nom
				+ ", prefecture=" + prefecture + "]";*/
		return "["+numero+"] " + nom;
	}
	
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrefecture() {
		return prefecture;
	}
	public void setPrefecture(String prefecture) {
		this.prefecture = prefecture;
	}
	
	

}
