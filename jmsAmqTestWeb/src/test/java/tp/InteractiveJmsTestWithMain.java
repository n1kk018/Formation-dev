package tp;


import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

/*
 * Cette classe (orientée "test") sert à envoyer quelques messages "jms"
 * au sein d'une file "queue.A" gérée par le serveur "activeMQ" 
 * à préalablement lancer/démarrer via "activemq start broker:tcp://localhost:61616"
 * =============
 * lorsqu'elle fonctionne, la console web de activemq est accessible au bout de 
 * l'url suivante: http://localhost:8161/admin (admin/admin)
 * 
 */

public class InteractiveJmsTestWithMain {

	public static void main(String[] args) {
	  try{
		ConnectionFactory connectionFactory = null;
		connectionFactory =	new ActiveMQConnectionFactory("tcp://localhost:61616");
		
		/*
		//version artemis:
		Properties props = new Properties();
		props.setProperty("java.naming.factory.initial", "org.apache.activemq.artemis.jndi.ActiveMQInitialContextFactory");
		props.setProperty("connectionFactory.ConnectionFactory", "tcp://myhost:5445");
		InitialContext ic = new InitialContext(props);
		connectionFactory = (ConnectionFactory) ic.lookup("ConnectionFactory");
		*/
		
	    //predefini dans glassfish
		Connection connection = connectionFactory.createConnection();
	    Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		
		//queue = (Queue) jndiContext.lookup("myQueue"); //or jms/myQueue ?
		
		Queue queue=session.createQueue("queue.A"); //NB: createQueue() create a new queue or open an existing one
		
		MessageProducer messageProducer = session.createProducer(queue);
		TextMessage message = session.createTextMessage();
		
		final int NUM_MSGS=3;
		for (int i = 0; i < NUM_MSGS; i++) {
		    message.setText("This is message " + (i + 1));
		    System.out.println("Sending message: " + message.getText());
		    messageProducer.send(message);
		}
		messageProducer.close();
		session.close();
		connection.close();
	} catch (Exception e) {
			e.printStackTrace();
	}

	}

}
