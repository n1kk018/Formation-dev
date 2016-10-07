package generic.util.interaction;

/**
 * interface abstraite d'un service d'interaction avec un utilisateur
 * ici en mode synchrone (ex: boite de dialogue , popup , saisie console , ...) en local ou à distance
 */

public interface UserInteraction {
	/**
	 * 
	 * @param message : question posée à l'utilisateur
	 * @param contextTitle : titre , context ou sujet (may be null)
	 * @return texte de la réponse de l'utilisateur
	 */
	public String replyMsgToRequestMsg(String message,String contextTitle);
	
	/**
	 * 
	 * @param message : message à confirmer
	 * @param contextTitle : titre , context ou sujet (may be null)
	 * @return true or false
	 */
	public boolean confirmMsg(String message,String contextTitle);

}
