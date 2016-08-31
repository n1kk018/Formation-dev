package fr.afcepf.al28.bank.biz;

import org.springframework.beans.factory.annotation.Autowired;

import fr.afcepf.al28.bank.dao.impl.IDaoCompte;
import fr.afcepf.al28.bank.dao.impl.IDaoUtilisateur;
import fr.afcepf.al28.bank.entity.Client;
import fr.afcepf.al28.bank.entity.Compte;
import fr.afcepf.al28.bank.entity.Utilisateur;

public class BizConseiller implements IBizConseiller {
	private IDaoUtilisateur daoU;
	private IDaoCompte daoC;
	@Autowired
	public void setDaoU(IDaoUtilisateur dao){
		this.daoU = dao;
	}

	@Override
	public Client NewClient(Client c) {
		this.daoU.insert(c);
		return c;
	}

	@Override
	public Compte NewAccount(Compte c) {
		this.daoC.insert(c);
		return c;
	}

	@Override
	public Utilisateur Login(Utilisateur u) {
		return this.daoU.getByLoginAndMdp(u.getEmail(),u.getMdp());
	}

}
