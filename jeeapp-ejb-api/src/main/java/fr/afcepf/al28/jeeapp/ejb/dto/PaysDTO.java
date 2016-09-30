package fr.afcepf.al28.jeeapp.ejb.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(namespace="http://dto.data.jeeapp.al28.afcepf.fr/")
@XmlRootElement(name="paysDTO")
public class PaysDTO implements Serializable{
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
	private String codePays;
	private String nom;
	private String capitale;
	
	private DeviseDTO devise;
	
	public PaysDTO() {
        super();
    }

    /**
     * @param paramCodePays
     * @param paramNom
     * @param paramCapitale
     */
    public PaysDTO(String paramCodePays, String paramNom, String paramCapitale) {
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

	public DeviseDTO getDevise() {
		return devise;
	}

	public void setDevise(DeviseDTO devise) {
		this.devise = devise;
	}

	public String toString() {
		return "PaysDTO [codePays=" + codePays + ", nom=" + nom + ", capitale=" + capitale + "]";
	}
	
}
