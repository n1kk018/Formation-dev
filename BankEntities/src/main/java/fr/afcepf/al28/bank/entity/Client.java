package fr.afcepf.al28.bank.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue(value="CLIENT")
public class Client extends Utilisateur {
	@Column(name="isFirstConnect")
	private Boolean isFirstConnect=true;
	@OneToMany(mappedBy="client")
	private Set<Compte> comptes;
	@ManyToOne()
	@JoinColumn(name="id_conseiller")
	private Conseiller conseiller;
	
	
	
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Client(Integer id, String nom, String prenom, String adresse, String email, String mdp) {
		super(id, nom, prenom, adresse, email, mdp);
	}
	public Client(Integer id, String nom, String prenom, String adresse, String email, String mdp,
			Boolean isFirstConnect) {
		super(id, nom, prenom, adresse, email, mdp);
		this.isFirstConnect = isFirstConnect;
	}
	public Set<Compte> getComptes() {
		return comptes;
	}
	public void setComptes(Set<Compte> comptes) {
		this.comptes = comptes;
	}
}
