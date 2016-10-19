package fr.afcepf.al28.jeeapp.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import fr.afcepf.al28.jeeapp.entity.Pays;

@Entity
@NamedQuery(name="devise.findAll",query="SELECT d FROM Devise d")
public class Devise implements Serializable{
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
    @Id
	private String codeDevise;// "EUR", "USD"
	private String monnaie;//"euro"
	private Double tauxChange;
	
	@OneToMany(mappedBy="devise"/*,cascade=CascadeType.DETACH*/)
	private List<Pays> pays;
	
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
	public List<Pays> getPays() {
		return pays;
	}
	public void setPays(List<Pays> pays) {
		this.pays = pays;
	}
	
	
}
