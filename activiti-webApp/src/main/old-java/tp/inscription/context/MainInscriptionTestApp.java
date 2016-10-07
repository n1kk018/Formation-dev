package tp.inscription.context;

import generic.util.interaction.UserInteraction;
import generic.util.local.interaction.LocalConsoleUserInteraction;
import generic.util.local.interaction.LocalSwingMessageDialog;
import tp.inscription.data.Inscription;
import tp.inscription.data.VerifEmail;

public class MainInscriptionTestApp {
	public static void main(String[] args) {
		
		Inscription nouvelleInscription = new Inscription();
		nouvelleInscription.setNumInscription(1);
		nouvelleInscription.setAdresse("1 rue elle Paris-ci");
		nouvelleInscription.setEmail("user1@localhost");
		nouvelleInscription.setName("dupond");
		InscriptionProcessContext processContextInscription = new InscriptionProcessContext();
		processContextInscription.traiterInscription(nouvelleInscription);
		/*
		try {
			Thread.sleep(3000); //pause 3s
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		
		VerifEmail verifEmail = new VerifEmail();
		verifEmail.setEmail("user1@localhost");
		verifEmail.setNumInscription(1);
		System.out.println("date="+verifEmail.getDate());
		
		UserInteraction userInteraction = new LocalSwingMessageDialog();
		//UserInteraction userInteraction = new LocalConsoleUserInteraction();
		/*String replyMsg = userInteraction.replyMsgToRequestMsg("quelle est votre couleur préférée");
		System.out.println("votre couleur préférée est " + replyMsg);*/
		boolean ok = userInteraction.confirmMsg("is this e-mail ok : " + verifEmail.getEmail(),null);
		
		if(/*Math.random()>0.5*/ ok)
		processContextInscription.receiveSimpleEMailConfirmation(String.valueOf(verifEmail.getNumInscription())); //pour signaler l'evenement "emailChecked"
		else
		processContextInscription.noReceiveMailConfirmation(String.valueOf(verifEmail.getNumInscription())); //pour signaler l'evenement "emailChecked"
		
		
	}
	
}
