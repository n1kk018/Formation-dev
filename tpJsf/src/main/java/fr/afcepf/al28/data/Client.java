package fr.afcepf.al28.data;

import javax.validation.constraints.*;

public class Client {
	@NotNull(message="Le nom est obligatoire")
	@Size(max=32,message="Le nom ne doit pas faire plus de 32 caractères")
	private String nom;
	private String prenom;
	@NotNull(message="L'adresse est obligatoire")
	@Size(max=55,message="L'adresse ne doit pas faire plus de 55 caractères")
	private String adresse;
	private Long num;
	@Min(0)
	@Max(150)
	private Integer age;
	
	
	public Client(String nom, String prenom, String adresse, Long num) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.num = num;
	}
	
	public Client(String nom, String prenom, String adresse, Long num, Integer age) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.num = num;
		this.age=age;
	}
	
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Client() {
		super();
	}

	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getAdresse() {
		return adresse;
	}
	
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public Long getNum() {
		return num;
	}
	
	public void setNum(Long num) {
		this.num = num;
	}
}
