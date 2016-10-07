package generic.async.jms.util;

import generic.jaxb.util.GenericJaxbTransformer;
import generic.jms.util.JmsQueueSender;

import javax.jms.QueueConnectionFactory;

public class GenericJavaJmsClient {
	
		
	private JmsQueueSender jmsQueueSender;

	//injection
	public void setQueueConnectionFactory(
			QueueConnectionFactory queueConnectionFactory) {
		jmsQueueSender = new JmsQueueSender();
		jmsQueueSender.setQueueConnectionFactory(queueConnectionFactory);
	}
	
	public void sendJavaMessageViaJms(Object javaMsgObj,String destinationName,String corrId,String replyDestinationName){
		if(jmsQueueSender==null){
			System.err.println("jmsQueueSender not initialized / queueConnectionFactory not injected in GenericJavaJmsClient");
			return;
		}
		String messageText = (new GenericJaxbTransformer(javaMsgObj.getClass())).javaToXmlString(javaMsgObj);
		jmsQueueSender.sendTxtMessageWithDestinationNameCorrIdAndReplyDestinationName(messageText, destinationName, corrId, replyDestinationName);
	}

}
