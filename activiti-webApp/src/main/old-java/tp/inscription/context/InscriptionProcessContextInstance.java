package tp.inscription.context;

import generic.process.context.anot.Condition;
import generic.process.context.instance.ProcessContextInstance;
import generic.process.context.itf.SharedProcessCtx;
import generic.process.exec.DynProcessHosting;

import java.io.Serializable;

import tp.inscription.data.Inscription;
import tp.inscription.data.VerifEmail;

public class InscriptionProcessContextInstance extends ProcessContextInstance implements Serializable{
	
	/**
	 */
	private static final long serialVersionUID = 1L;

	public InscriptionProcessContextInstance(){
			//default constructor	
	}

	public InscriptionProcessContextInstance(
			SharedProcessCtx sharedProcessContext,
			DynProcessHosting dynProcessHosting) {
		super(sharedProcessContext, dynProcessHosting);		
	}

	private Inscription inscription;
	private VerifEmail verifEmail;
	private Boolean verifOk=null;
	
	
	public Inscription getInscription() {
		return inscription;
	}
	public void setInscription(Inscription inscription) {
		this.inscription = inscription;
	}
	public VerifEmail getVerifEmail() {
		return verifEmail;
	}
	public void setVerifEmail(VerifEmail verifEmail) {
		this.verifEmail = verifEmail;
	}
	public Boolean getVerifOk() {
		return verifOk;
	}
	public void setVerifOk(Boolean verifOk) {
		this.verifOk = verifOk;
	}

	@Condition("emailOK")
	public boolean isEmailOk(){
		if(verifOk!=null && verifOk==true)
			return true ;
		else
		   return false;
	}
	
	@Condition("uncheckedEmail")
	public boolean isEmailNotOK(){
		if(verifOk==null || verifOk==false)
			return true ;
		else
		   return false;
	}

	
	

}
