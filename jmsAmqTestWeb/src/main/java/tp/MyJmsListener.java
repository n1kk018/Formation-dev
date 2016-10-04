package tp;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class MyJmsListener implements MessageListener {
	
	private ReceivedMessages receivedMessages; //a injecter
	
	
	public void onMessage(Message message) {
		if (message instanceof TextMessage) {
			try {				
				receivedMessages.addMessage(new MessageEssential(((TextMessage) message).getText()));
				//System.out.println(((TextMessage) message).getText());
			} catch (Exception ex) {
				throw new RuntimeException(ex);
			}
		} else {
			throw new IllegalArgumentException(
					"Message must be of type TextMessage");
		}
	}


	public void setReceivedMessages(ReceivedMessages receivedMessages) {
		this.receivedMessages = receivedMessages;
	}
	
	
}