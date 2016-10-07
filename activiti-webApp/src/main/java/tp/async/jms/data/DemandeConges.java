package tp.async.jms.data;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement()
public class DemandeConges implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long numDemande;
	private String idEmploye;
	private String nom;
	private String prenom;
	private String dateDebut; //au format aaaa-mm-dd (ex: 2013-12-25 )
	private String dateFin;
	
	
	@Override
	public String toString() {
		return "DemandeConges [numDemande=" + numDemande + ", idEmploye="
				+ idEmploye + ", nom=" + nom + ", prenom=" + prenom
				+ ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + "]";
	}
	public Long getNumDemande() {
		return numDemande;
	}
	public void setNumDemande(Long numDemande) {
		this.numDemande = numDemande;
	}
	public String getIdEmploye() {
		return idEmploye;
	}
	public void setIdEmploye(String idEmploye) {
		this.idEmploye = idEmploye;
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
	public String getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}
	public String getDateFin() {
		return dateFin;
	}
	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	} 
	

	
}
