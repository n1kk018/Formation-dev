package generic.util.interaction;

/* interface abstraite : envoie d'un message de façon asynchrone
 * (ex: par mail , par message jms , ...) en précisant une adresse/url de retour
 * et une information de correlation
 * NB: from may be null (with default value in properties of implementation)
 */

public interface AsyncUserInteraction {
	public void sendNotification(String subject,String message,String requestAddress,String from);
	public void sendRequestMsg(String subject,String message,String requestAddress,String corrData,String responseAddress,String from);

}
