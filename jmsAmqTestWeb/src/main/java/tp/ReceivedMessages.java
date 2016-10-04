package tp;

import java.util.ArrayList;
import java.util.List;
//pour stocker en memoire les messages recemment recus
public class ReceivedMessages {
	private List<MessageEssential> messageList = new ArrayList<MessageEssential>();

	public List<MessageEssential> getMessageList() {
		return messageList;
	}

	public void setMessageList(List<MessageEssential> messageList) {
		this.messageList = messageList;
	}
	
	public void addMessage(MessageEssential m){
		messageList.add(m);
	}
	
	//+future méthode pour supprimer tres anciens messages
}
