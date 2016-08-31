package fr.afcepf.al28.bank.web.mbean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import fr.afcepf.al28.bank.entity.Compte;



@ManagedBean
@RequestScoped
public class VirementMBean {
	@ManagedProperty("#{clientMBean}")
	private ClientMBean clientMBean;
	private Long numCptDeb;
	private Long numCptCred;
	private Double montant;
	
	public String effectuerVirement(){
		String suite = null;
		if(this.montant==null || this.montant<=0D){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Montant invalide",""));
		} else {
			if(this.numCptDeb==this.numCptCred){
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Opération impossible",""));
			} else {
				Compte oCompteDeb = null;
				Compte oCompteCred = null;
				/*for(Compte compte:clientMBean.getComptes()){
					if(compte.getNumero()==this.numCptDeb){
						oCompteDeb = compte;
					}
					if(compte.getNumero()==this.numCptCred){
						oCompteCred = compte;
					}
				}*/
				/*if(montant > oCompteDeb.getSolde()){
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Solde insuffisant",""));
				} else {
					oCompteDeb.setSolde(oCompteDeb.getSolde()-montant);
					oCompteCred.setSolde(oCompteCred.getSolde()+montant);
					suite="espaceClient";
				}*/
			}
		}
		return suite;
	}

	public Long getNumCptDeb() {
		return numCptDeb;
	}

	public void setNumCptDeb(Long numCptDeb) {
		this.numCptDeb = numCptDeb;
	}

	public Long getNumCptCred() {
		return numCptCred;
	}

	public void setNumCptCred(Long numCptCred) {
		this.numCptCred = numCptCred;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public ClientMBean getClientMBean() {
		return clientMBean;
	}

	public void setClientMBean(ClientMBean clientMBean) {
		this.clientMBean = clientMBean;
	}
}
