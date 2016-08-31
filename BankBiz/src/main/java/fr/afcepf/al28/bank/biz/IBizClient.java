package fr.afcepf.al28.bank.biz;

import fr.afcepf.al28.bank.entity.Utilisateur;

public interface IBizClient {
	public Utilisateur Login(Utilisateur u);
}
