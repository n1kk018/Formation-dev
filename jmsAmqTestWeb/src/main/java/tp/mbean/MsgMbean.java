package tp.mbean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import tp.MessageEssential;
import tp.MyJmsQueueSender;
import tp.ReceivedMessages;

/**
 * @author Didier DEFRANCE
 *
 * ManagedBean JSF (pour afficher liste messages recus)
 */

@ManagedBean
@SessionScoped
public class MsgMbean {
	
	private List<MessageEssential> listeJmsReceivedMessages;
	
	private String status="?";
	
	private String responseMessageText; //information a saisir
	
	@ManagedProperty(value="#{receivedMessages}")//ici #{idSpring}
	private ReceivedMessages receivedMessages; //a injecter
	
	@ManagedProperty(value="#{myJmsQueueSender}")//ici #{idSpring}
	private MyJmsQueueSender jmsQueueSender;  //a injecter

	public MyJmsQueueSender getJmsQueueSender() {
		return jmsQueueSender;
	}

	public void setJmsQueueSender(MyJmsQueueSender jmsQueueSender) {
		this.jmsQueueSender = jmsQueueSender;
	}

	//methode declenche par commandButton de jsf
	public String refreshReceivedMessageList(){
		this.listeJmsReceivedMessages=this.receivedMessages.getMessageList();
		status="?";
		return null;//pour rester sur meme page jsf
	}
	
	//methode declenche par commandButton de jsf
	public String sendResponse(){	
		try {
			jmsQueueSender.sendMessage(this.responseMessageText);
			System.out.println("message envoye dans file queue.B");
			responseMessageText=""; //re-initialiser le message pour montrer envoi
			status="ok (message successfully sent)";
		} catch (Exception e) {
			//	e.printStackTrace();
			status="echec : " + e.getMessage();
		}
		return null;//pour rester sur meme page jsf
	}
	
	public ReceivedMessages getReceivedMessages() {
		return receivedMessages;
	}

	public void setReceivedMessages(ReceivedMessages receivedMessages) {
		this.receivedMessages = receivedMessages;
	}

	public List<MessageEssential> getListeJmsReceivedMessages() {
		return listeJmsReceivedMessages;
	}

	public void setListeJmsReceivedMessages(
			List<MessageEssential> listeJmsReceivedMessages) {
		this.listeJmsReceivedMessages = listeJmsReceivedMessages;
	}

	public String getResponseMessageText() {
		return responseMessageText;
	}

	public void setResponseMessageText(String responseMessageText) {
		this.responseMessageText = responseMessageText;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
	

}
