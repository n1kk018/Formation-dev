package tp;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class MyJmsQueueSender {
	
	private JmsTemplate jmsTemplate;

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public void sendMessage(final String messageText) {
	  this.jmsTemplate.send( /*in default destination/queue,*/ new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(messageText);
			}
		});
	}

}
