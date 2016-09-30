package fr.afcepf.al28.jeeapp.ejb.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
@XmlType(namespace="http://dto.data.jeeapp.al28.afcepf.fr/")
@XmlRootElement(name="deviseDTO")
public class DeviseDTO implements Serializable{
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
	private String codeDevise;// "EUR", "USD"
	private String monnaie;//"euro"
	private Double tauxChange;
	
	private List<PaysDTO> pays;
	
	public DeviseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DeviseDTO(String codeDevise, String monnaie, Double tauxChange) {
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
	public String toString() {
		return "DeviseDTO [codeDevise=" + codeDevise + ", monnaie=" + monnaie + ", tauxChange=" + tauxChange + "]";
	}
	public List<PaysDTO> getPays() {
		return pays;
	}
	public void setPays(List<PaysDTO> pays) {
		this.pays = pays;
	}
	
	
}
