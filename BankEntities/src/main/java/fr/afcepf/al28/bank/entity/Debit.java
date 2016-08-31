package fr.afcepf.al28.bank.entity;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue(value="DEBIT")
public class Debit extends Operation {	
	@ManyToOne()
	@JoinColumn(name="numero_compte_crediter")
	private Compte compte_credit;
	public Debit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Debit(Integer id, Date dateOp, Double montant, String libelle, Compte compte) {
		super(id, dateOp, montant, libelle, compte);
		// TODO Auto-generated constructor stub
	}

	public Debit(Integer id, Date dateOp, Double montant, String libelle, Compte compte, Compte compte_credit) {
		super(id, dateOp, montant, libelle, compte);
		this.compte_credit = compte_credit;
	}
	
	

	
	
}
