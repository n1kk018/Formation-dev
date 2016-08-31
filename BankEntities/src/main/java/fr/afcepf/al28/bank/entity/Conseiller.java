package fr.afcepf.al28.bank.entity;

import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@DiscriminatorValue(value="CONSEILLER")
public class Conseiller extends Utilisateur {
	@OneToMany(mappedBy="conseiller")
	private Set<Client> clients;
	
	public Conseiller() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Conseiller(Integer id, String nom, String prenom, String adresse, String email, String mdp) {
		super(id, nom, prenom, adresse, email, mdp);
		// TODO Auto-generated constructor stub
	}
	
}
