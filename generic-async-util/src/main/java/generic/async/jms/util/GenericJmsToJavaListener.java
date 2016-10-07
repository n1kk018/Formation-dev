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

//NB le type T doit correspondre à une classe de données comportant l'annotation @XmlRootElement de jaxb2
public abstract class GenericJmsToJavaListener<T> implements MessageListener {
	
	private Class<T> javaMetaClass=null;
	
	public abstract void OnJavaMessage(T msg,AsyncContext asyncContext);
	
	
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
				T javaObj = xmlStringToJava(xmlMsgString);
				OnJavaMessage(javaObj,AsynContextFromJmsMessage(jmsMsg));
			}
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
	public T xmlStringToJava(String xmlString){
		if(this.javaMetaClass==null){
			initJavaMetaClass();
		}
		GenericJaxbTransformer genericJaxbTransformer = new GenericJaxbTransformer(this.javaMetaClass);
		return (T)genericJaxbTransformer.xmlStringToJava(xmlString);
	}

	
	
	private void initJavaMetaClass(){
		try {
	    	   //System.out.println(getClass().getSimpleName());
	    	   ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();  
	    	   //System.out.println("parameterizedType="+parameterizedType.toString());
	    	   Type typeT = parameterizedType.getActualTypeArguments()[0];
	    	   //System.out.println(typeT.toString());
	    	   if(!typeT.toString().equals("T")){
	    		   this.javaMetaClass = (Class<T>) typeT;
	    		   //System.out.println("persistentClass="+persistentClass.getSimpleName());
	    	   }
		} catch (Exception e) {
			//e.printStackTrace();
			System.err.println(e.getMessage());
		}
	}

}
