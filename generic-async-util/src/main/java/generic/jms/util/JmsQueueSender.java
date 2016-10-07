package generic.jms.util;


import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.TextMessage;

public class JmsQueueSender {
	
	private QueueConnectionFactory queueConnectionFactory;

	public void setQueueConnectionFactory(
			QueueConnectionFactory queueConnectionFactory) {
		this.queueConnectionFactory = queueConnectionFactory;
	}
	
	public void sendTxtMessageWithDestinationName(String messageText,String destinationName) {
		sendTxtMessageWithDestinationNameAndCorrId(messageText,destinationName,null);
	}
	
	public void sendTxtMessageWithDestinationNameAndCorrId(String messageText,String destinationName,String corrId) {
		sendTxtMessageWithDestinationNameCorrIdAndReplyDestinationName(messageText, destinationName, corrId,null);
	}
	
	public void sendTxtMessageWithDestinationNameCorrIdAndReplyDestinationName(String messageText,String destinationName,String corrId,String replyDestinationName) {
		try {
			QueueConnection cnn = queueConnectionFactory.createQueueConnection();
			QueueSession session = cnn.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
			Queue queue = session.createQueue(destinationName);
			QueueSender sender = session.createSender(queue);	
			
			TextMessage jmsTextMessage= session.createTextMessage(messageText);
			if(corrId!=null)
			   jmsTextMessage.setJMSCorrelationID(corrId);
			if(replyDestinationName!=null){
				Queue replyQueue = session.createQueue(replyDestinationName);
				jmsTextMessage.setJMSReplyTo(replyQueue);
			}
			sender.send(jmsTextMessage);
			sender.close();session.close();cnn.close();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
	

}
