package generic.jms.util;

import javax.jms.QueueConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;

public class MyJmsContext {
	
	private static String amqBrokerUrl="tcp://localhost:61616";//default value
	/*
	private static MyJmsContext uniqueInstance;
	
	public static MyJmsContext getInstance(){
		if(uniqueInstance==null){
			uniqueInstance=new MyJmsContext();
		}
		return uniqueInstance;
	}
    */
	public static String getAmqBrokerUrl() {
		return amqBrokerUrl;
	}

	public static void setAmqBrokerUrl(String amqBrokerUrl) {
		MyJmsContext.amqBrokerUrl = amqBrokerUrl;
	}
	
	public static QueueConnectionFactory getQueueConnectionFactory(){
		ActiveMQConnectionFactory queueConnectionFactory = new org.apache.activemq.ActiveMQConnectionFactory(MyJmsContext.amqBrokerUrl);
		return queueConnectionFactory;
	}
	
	public static JmsQueueSender getJmsQueueSenderWithDefaultConnectionFactory(){
		JmsQueueSender jmsQueueResponseSender = new JmsQueueSender();
		QueueConnectionFactory queueConnectionFactory = MyJmsContext.getQueueConnectionFactory();
		jmsQueueResponseSender.setQueueConnectionFactory(queueConnectionFactory);
		return jmsQueueResponseSender;
	}
	
	public static JmsQueueSender getJmsQueueSenderFromConnectionFactory(QueueConnectionFactory queueConnectionFactory){
		JmsQueueSender jmsQueueResponseSender = new JmsQueueSender();
		jmsQueueResponseSender.setQueueConnectionFactory(queueConnectionFactory);
		return jmsQueueResponseSender;
	}

}
