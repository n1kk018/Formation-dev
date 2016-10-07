package tp.inscription.context;

import generic.process.context.CorrelationHelper;
import generic.process.context.ProcessContext;
import generic.process.context.anot.Action;
import generic.process.context.anot.Post;
import generic.process.context.anot.Pre;
import generic.process.context.instance.ProcessContextInstance;
import generic.process.exec.activiti.Activiti5ProcessHosting;
import generic.util.interaction.AsyncUserInteraction;
import generic.util.interaction.mail.LocalMailUserInteraction;
import tp.inscription.data.Inscription;
import tp.inscription.data.VerifEmail;

public class InscriptionProcessContext extends ProcessContext {
	
	
	private CorrelationHelper<Integer,InscriptionProcessContextInstance> 
	    inscriptionCorrelationHelper  = new CorrelationHelper<Integer,InscriptionProcessContextInstance>();
	
	
	@Override
	public void releaseResourcesOnEnd(ProcessContextInstance instance) {
		inscriptionCorrelationHelper.removeProcessInstanceWithCorrData((InscriptionProcessContextInstance)instance);
	}
	
	// (point d'entree externe , declenchement ) receive & immediate AR reply
	public String traiterInscription(Inscription inscription){
		String msgAR = "A.R: demande d'inscription " + inscription.getNumInscription() + " bien recue , en attente de confirmation adresse email"; 
		startInscriptionProcess(inscription);
		return msgAR;
	}
	
	// demarrage du processus (start)
	public void startInscriptionProcess(Inscription inscription){
		InscriptionProcessContextInstance instance  = new InscriptionProcessContextInstance(this,
				new Activiti5ProcessHosting("inscription_activiti.bpmn", "inscription"));
		instance.setInscription(inscription);
		inscriptionCorrelationHelper.storeProcessInstanceCorrData(instance,inscription.getNumInscription());
		instance.start();
	}
	
	//@Event?("emailChecked")//a prendre en compte via automatisme ???
	public void receiveSimpleEMailConfirmation(String numInscription){
		InscriptionProcessContextInstance instance  = inscriptionCorrelationHelper.getInstanceFromCorrData(Integer.parseInt(numInscription));
		if(instance!=null){
		    instance.setVerifOk(true);
			instance.signalEvent("emailCheckedOrNot");
		}
	}
	
	
	
	public void noReceiveMailConfirmation(String numInscription){
		InscriptionProcessContextInstance instance  = inscriptionCorrelationHelper.getInstanceFromCorrData(Integer.parseInt(numInscription));
		if(instance!=null){
		    instance.setVerifOk(false);
			instance.signalEvent("emailCheckedOrNot");
		}
	}
	
	@Pre(action="verifEmail")
	public void prepareVerifEmail(InscriptionProcessContextInstance instance){
		VerifEmail verifEmail = new VerifEmail();
		verifEmail.setEmail(instance.getInscription().getEmail());
		verifEmail.setNumInscription(instance.getInscription().getNumInscription());
		instance.setVerifEmail(verifEmail);
	}
	
	@Action("verifEmail")
	public void sendVerifEmail(InscriptionProcessContextInstance instance){
		//simulation:
		System.out.println("envoi d'un mail de verification vers " + instance.getVerifEmail().getEmail());
		//véritable envoi:
		AsyncUserInteraction asyncUserInteraction = new LocalMailUserInteraction();
		asyncUserInteraction.sendRequestMsg("verification email valide" /*subject*/, 
				"veuillez cliquer sur le lien hypertexte suivant pour confirmer votre email et votre inscription"/*message*/, 
				instance.getVerifEmail().getEmail() /*requestAddress*/,
				instance.getVerifEmail().getNumInscription().toString()/*corrData*/,
				"http://localhost:8080/inscription-bpmn-web/services/rest/emailCheckedCallback/notifyEmailOk"/*responseUrl*/,null);
	}
	
	
	@Post(action="verifEmail")
	public void finalizeVerifEmail(InscriptionProcessContextInstance instance){
		//System.out.println("post/verifEmail");
	}
	
	@Action("notifierInscriptionOK")
	public void notifierInscriptionOK(InscriptionProcessContextInstance instance){
		//simulation:
		System.out.println("inscription" + instance.getInscription().getNumInscription() + " ok");
	}

	@Action("annulerInscription")
	public void annulerInscription(InscriptionProcessContextInstance instance){
		//simulation:
		System.out.println("inscription" + instance.getInscription().getNumInscription() + " annulee car email non verifie");
	}
	
	
   
}
