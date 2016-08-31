package fr.afcepf.al28.bank.dao.impl;

import java.util.List;

import fr.afcepf.al28.bank.entity.Compte;
import fr.afcepf.al28.bank.entity.Operation;

public interface IDaoCompte {
	public Compte insert(Compte cp);
	public List<Operation> getOperations(Compte cp);
}
