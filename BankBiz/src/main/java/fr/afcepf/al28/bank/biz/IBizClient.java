package fr.afcepf.al28.bank.biz;

import java.util.List;

import fr.afcepf.al28.bank.entity.Compte;
import fr.afcepf.al28.bank.entity.Operation;
import fr.afcepf.al28.bank.entity.Utilisateur;

public interface IBizClient {
	public Utilisateur Login(Utilisateur u);
	public List<Operation> getOperationsByIdCompte(Integer id);
}
