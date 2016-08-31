package fr.afcepf.al28.bank.web.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import fr.afcepf.al28.bank.biz.IBizClient;
import fr.afcepf.al28.bank.entity.Utilisateur;


@ManagedBean(name="mbBankWeb")
@SessionScoped
public class BankWebManagedBean {
	//Ici nom de l'instance (couplage fort)
	private Utilisateur user;
	//en meme tps pas le choix
	@ManagedProperty(value="#{bizClient}")
	private IBizClient bizClient;
	
	public String identification() {
		String suite=null;
		//simulation de recherche en BDD
		
		
		
		return suite;
	}
	
	public Utilisateur getUser() {
		return user;
	}
	public void setUser(Utilisateur user) {
		this.user = user;
	}
	public IBizClient getBizClient() {
		return bizClient;
	}
	public void setBizClient(IBizClient bizClient) {
		this.bizClient = bizClient;
	}
	
	
}
