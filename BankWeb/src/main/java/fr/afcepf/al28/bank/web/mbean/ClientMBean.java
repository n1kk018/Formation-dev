package fr.afcepf.al28.bank.web.mbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import fr.afcepf.al28.bank.entity.Client;
import fr.afcepf.al28.bank.entity.Compte;



@ManagedBean
@SessionScoped
public class ClientMBean {
	private Long numero;
	private Client client;
	private List<Compte> comptes;
	
	public String identification() {
		String suite=null;
		//simulation de recherche en BDD
		if(this.numero<=0 || this.numero > 999){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("numéro de client invalide","pas entre 0 et 999"));
		}else{	
			//this.client = new Client("Therieur","Alex","2 rue elle 75000 Paris ci", this.numero);
			suite = "espaceClient"; //.jsp ou .xhtml
		}
		
		return suite;
	}
	
	public String majCoord() {
		String suite=null;
		suite="espaceClient";
		
		return suite;
	}
	
	public String recupererComptes()
	{
		String suite = null;
		this.comptes = new ArrayList<Compte>();
		/*this.comptes.add(new Compte(1l,"compte 1", 2000.0));
		this.comptes.add(new Compte(2l,"compte 2", 50.0));
		this.comptes.add(new Compte(3l,"compte 3", 300.0));*/
		return suite;
	}
	
	public List<Compte> getComptes() {
		return comptes;
	}
	
	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	} 

}
