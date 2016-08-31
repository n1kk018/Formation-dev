package fr.afcepf.al28.bank.biz;

import fr.afcepf.al28.bank.entity.Client;
import fr.afcepf.al28.bank.entity.Compte;
import fr.afcepf.al28.bank.entity.Utilisateur;

public interface IBizConseiller {
	public Client NewClient(Client c);
	public Compte NewAccount(Compte c);
	public Utilisateur Login(Utilisateur u);
}
