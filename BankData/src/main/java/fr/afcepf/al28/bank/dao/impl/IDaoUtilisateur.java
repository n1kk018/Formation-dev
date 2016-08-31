package fr.afcepf.al28.bank.dao.impl;

import fr.afcepf.al28.bank.entity.Utilisateur;

public interface IDaoUtilisateur {
	public Utilisateur insert(Utilisateur u);
	public Utilisateur getByLogin(String login);
	public Utilisateur getByLoginAndMdp(String login,String mdp);
}
