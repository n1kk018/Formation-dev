package fr.afcepf.al28.bank.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import fr.afcepf.al28.bank.biz.IBizClient;
import fr.afcepf.al28.bank.entity.*;


@ManagedBean(name="mbBankWeb")
@SessionScoped
public class BankWebManagedBean {
	//Ici nom de l'instance (couplage fort)
	//en meme tps pas le choix
	@ManagedProperty(value="#{bizClient}")
	private IBizClient bizClient;
	private Utilisateur user=new Utilisateur();
	private Client client=new Client();
	private List<Operation> listeOp=new ArrayList<Operation>();
	private Logger logger = LoggerFactory.getLogger(BankWebManagedBean.class);
	private Marker fatal = MarkerFactory.getMarker("FATAL");
	
	public String identification() {
		String suite=null;
		user=bizClient.Login(user);
		if(user.getNom()!=null) {
			if(user.getClass().getName()=="fr.afcepf.al28.bank.entity.Client"){
				setClient((Client)user);
				suite = "pages/espaceClient";
			}
		}
		return suite;
	}
	
	public String espaceClient() {
		return null;
	}
	
	public String chargerOperations(String numCpt){
		listeOp= bizClient.getOperationsByIdCompte(Integer.parseInt(numCpt));
		logger.debug(listeOp.toString());
		return null;
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
	
	
	public void setListeOp(List<Operation> listeOp) {
		this.listeOp = listeOp;
	}

	public List<Operation> getListeOp() {
		return listeOp;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}	
	
}
