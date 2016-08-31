package fr.afcepf.al28.bank.web.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.afcepf.al28.bank.biz.IBizClient;
import fr.afcepf.al28.bank.entity.Utilisateur;


@ManagedBean(name="mbBankWeb")
@SessionScoped
public class BankWebManagedBean {
	private Utilisateur user=new Utilisateur();
	//Ici nom de l'instance (couplage fort)
	//en meme tps pas le choix
	@ManagedProperty(value="#{bizClient}")
	private IBizClient bizClient;
	
	public String identification() {
		String suite=null;
		//simulation de recherche en BDD
		Object test = bizClient.Login(user);
		if(test!=null) {
			suite = "pages/espaceClient";
		}

		return suite;
	}
	
	public Utilisateur getUser() {
		return user;
	}
	public void setUser(Utilisateur user) {
		this.user = user;
	}
	
	public void setBizClient(IBizClient bizClient) {
		this.bizClient = bizClient;
	}
	
	
}
