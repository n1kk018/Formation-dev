package generic.async.jms.util;

import generic.async.util.AsyncContext;
import generic.jaxb.util.GenericJaxbTransformer;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.TextMessage;

//NB className doit correspondre à une classe de données comportant l'annotation @XmlRootElement de jaxb2
public abstract class GenericJmsToObjectListener implements MessageListener {
	

	public abstract void OnJavaMessage(Object msg,AsyncContext asyncContext);
	public abstract String getClassName(); 
	
	private AsyncContext AsynContextFromJmsMessage(Message jmsMsg){
		AsyncContext asyncContext = new AsyncContext();
		try {
			asyncContext.setCorrelationId(jmsMsg.getJMSCorrelationID());
			Destination dest = jmsMsg.getJMSReplyTo();
			if(dest!=null){
				if(dest instanceof Queue){
					Queue q = (Queue)dest;
					asyncContext.setReplyDestinationName(q.getQueueName());
				}
			}
			
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return asyncContext;
	}

	@Override
	public void onMessage(Message jmsMsg) {
		//System.out.println("received message:" + jmsMsg);	
		try {
			if(jmsMsg instanceof TextMessage){
				TextMessage jmsTxtMsg = (TextMessage) jmsMsg;
				String xmlMsgString = jmsTxtMsg.getText();
				Object javaObj = xmlStringToJava(xmlMsgString);
				OnJavaMessage(javaObj,AsynContextFromJmsMessage(jmsMsg));
			}
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
	public Object xmlStringToJava(String xmlString){
		Object res=null;
		try {
			Class javaMetaClass = Class.forName(this.getClassName());
			GenericJaxbTransformer genericJaxbTransformer = new GenericJaxbTransformer(javaMetaClass);
			res= genericJaxbTransformer.xmlStringToJava(xmlString);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return res;
	}

}
