package fr.afcepf.al28.jeeapp.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class Pays implements Serializable{
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    @Id
	private String codePays;
	private String nom;
	private String capitale;
	
	@ManyToOne()
	@JoinColumn(name ="refDevise")
	private Devise devise;
	
	/**
     * 
     */
    public Pays() {
        super();
    }

    /**
     * @param paramCodePays
     * @param paramNom
     * @param paramCapitale
     */
    public Pays(String paramCodePays, String paramNom, String paramCapitale) {
        super();
        codePays = paramCodePays;
        nom = paramNom;
        capitale = paramCapitale;
    }

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
