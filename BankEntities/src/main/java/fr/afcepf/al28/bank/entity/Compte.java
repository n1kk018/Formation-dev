package fr.afcepf.al28.bank.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="compte")
public class Compte {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer numero;
	@Column(name="libelle", nullable=false,length=45)
	private String libelle;
	@ManyToOne()
	@JoinColumn(name="id_client")
	private Utilisateur client;
	@OneToMany(mappedBy="compte")
	private Set<Operation> operations;
	
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Compte(Integer numero, String libelle, Utilisateur client) {
		super();
		this.numero = numero;
		this.libelle = libelle;
		this.client = client;
	}
	
	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	public Set<Operation> getOperations() {
		return operations;
	}

	public void setOperations(Set<Operation> operations) {
		this.operations = operations;
	}
	

	public Utilisateur getClient() {
		return client;
	}

	public void setClient(Utilisateur client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "Compte [numero=" + numero + ", libelle=" + libelle +"]";
	}
	
	
}
