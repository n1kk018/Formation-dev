package fr.afcepf.al28.bank.dao;

import fr.afcepf.al28.bank.entity.Compte;
import fr.afcepf.al28.bank.entity.Operation;

public interface IDaoOperation {
	public Operation insert(Operation o);
	public Operation doTransfer(Compte cp,Double amount,Compte dest);
}
