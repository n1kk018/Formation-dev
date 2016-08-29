package fr.afcepf.al28.hibernate.heritage;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="HPersonne")
@Table(name="h_personne")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type")
public class Personne {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable=false)
	private Integer id;
	@Column(name="nom", nullable=false,length=45)
	private String nom;
	@Column(name="prenom", nullable=false,length=45)
	private String prenom;
	@Column(name="adresse", nullable=false,length=255)
	private String adresse;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="naissance", nullable=false)
	private Date naissance;
	@Column(insertable=false,updatable=false)
	private String type;
	
	public Personne(Integer id, String nom, String prenom, String adresse, Date naissance) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.naissance = naissance;
	}
	
	public Personne() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
		
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Date getNaissance() {
		return naissance;
	}
	public void setNaissance(Date naissance) {
		this.naissance = naissance;
	}
	@Override
	public String toString() {
		return "Personne [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", naissance="
				+ naissance + "]";
	}
}
