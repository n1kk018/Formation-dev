package fr.afcepf.al28.bank.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.afcepf.al28.bank.biz.IBizClient;
import fr.afcepf.al28.bank.entity.*;


@ManagedBean(name="mbBankWeb")
@SessionScoped
public class BankWebManagedBean {
	
	//Ici nom de l'instance (couplage fort)
	//en meme tps pas le choix
	@ManagedProperty(value="#{bizClient}")
	private IBizClient bizClient;
	
	@ManagedProperty(value="#{user}")
	private Utilisateur user=new Utilisateur();
	
	@ManagedProperty(value="#{listeOp}")
	private List<Operation> listeOp=new ArrayList<Operation>();
	
	public String identification() {
		String suite=null;
		user=bizClient.Login(user);
		if(user.getNom()!=null) {
			if(user.getClass().getName()=="fr.afcepf.al28.bank.entity.Client"){
				suite = "pages/espaceClient";
			}
		}

		return suite;
	}
	
	public void chargerOperations(Compte cp){
		this.listeOp = bizClient.getOperationsByCompte(cp);
		
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

	public List<Operation> getListeOp() {
		return listeOp;
	}	
	
}
