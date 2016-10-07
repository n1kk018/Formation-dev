package tp.inscription.data;

import java.io.Serializable;

public class Inscription implements Serializable{
	/**
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer numInscription;
	private String email;
	private String name;
	private String adresse;
	
	
	
	public Inscription() {
		super();
		numInscription=0;
		email="unknown@nowhere.com";
		name="unknown";
		adresse="homeless";
	}
	public Integer getNumInscription() {
		return numInscription;
	}
	public void setNumInscription(Integer numInscription) {
		this.numInscription = numInscription;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	
}
