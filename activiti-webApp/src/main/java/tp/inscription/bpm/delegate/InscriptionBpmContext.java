package tp.inscription.bpm.delegate;

import generic.util.interaction.AsyncUserInteraction;
import generic.util.interaction.mail.LocalMailUserInteraction;

import org.activiti.engine.delegate.DelegateExecution;

import tp.inscription.data.Inscription;
import tp.inscription.data.VerifEmail;

public class InscriptionBpmContext  {

	
	
	//Action("verifEmail")
	public Object doVerifEmail(DelegateExecution execution , Object... args) {
		Object result=null;
			Inscription inscription   = (Inscription) execution.getVariable("inscription");
			
			VerifEmail verifEmail = new VerifEmail();
			verifEmail.setEmail(inscription.getEmail());
			verifEmail.setNumInscription(inscription.getNumInscription());
			
			execution.setVariable("verifEmail", verifEmail);
			
			//simulation:
			System.out.println("envoi d'un mail de verification vers " + verifEmail.getEmail());
			//véritable envoi:
			AsyncUserInteraction asyncUserInteraction = new LocalMailUserInteraction();
			asyncUserInteraction.sendRequestMsg("verification email valide" /*subject*/, 
					"veuillez cliquer sur le lien hypertexte suivant pour confirmer votre email et votre inscription"/*message*/, 
					verifEmail.getEmail() /*requestAddress*/,
					execution.getProcessInstanceId()/*verifEmail.getNumInscription().toString()*//*corrData*/,
					"http://localhost:8080/activiti-webApp/services/rest/emailCheckedCallback/notifyEmailOk"/*responseUrl*/,
					"no-reply"/*from*/);
		return result;
	}


}

