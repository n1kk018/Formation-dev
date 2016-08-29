package fr.afcepf.al28.data;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Client {
	private String nom;
	private int age;
	
	public Client() {
		super();
	}
	
	public Client(String nom, int age) {
		super();
		this.nom = nom;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Client [nom=" + nom + ", age=" + age + "]";
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
