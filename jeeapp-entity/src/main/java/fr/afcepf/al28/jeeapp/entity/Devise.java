package fr.afcepf.al28.jeeapp.entity;

import javax.ejb.Local;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Devise {
	@Id
	private String codeDevise;// "EUR", "USD"
	private String monnaie;//"euro"
	private Double tauxChange;
	public Devise() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Devise(String codeDevise, String monnaie, Double tauxChange) {
		super();
		this.codeDevise = codeDevise;
		this.monnaie = monnaie;
		this.tauxChange = tauxChange;
	}
	public String getCodeDevise() {
		return codeDevise;
	}
	public void setCodeDevise(String codeDevise) {
		this.codeDevise = codeDevise;
	}
	public String getMonnaie() {
		return monnaie;
	}
	public void setMonnaie(String monnaie) {
		this.monnaie = monnaie;
	}
	public Double getTauxChange() {
		return tauxChange;
	}
	public void setTauxChange(Double tauxChange) {
		this.tauxChange = tauxChange;
	}
	@Override
	public String toString() {
		return "Devise [codeDevise=" + codeDevise + ", monnaie=" + monnaie + ", tauxChange=" + tauxChange + "]";
	}
	
	
}
