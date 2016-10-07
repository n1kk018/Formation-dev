package generic.util.interaction.mail;

import generic.util.interaction.AsyncUserInteraction;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * envoi direct d'un e-mail(localement via l'api java-mail et  sans service intermediaire ) (via smtp)
 * une autre version "remote" assurera la même fonctionnalité via un appel intermédiaire de service web
 */

public class LocalMailUserInteraction implements AsyncUserInteraction{
	
	private static Logger logger = LoggerFactory.getLogger(LocalMailUserInteraction.class);
	
	private String smtpHost;
	private String defaultFrom;
	
	public LocalMailUserInteraction() {
		super();
		this.smtpHost="localhost"; //by default
		this.defaultFrom = "no-reply@localhost";//by default
	}
	
	public LocalMailUserInteraction(String smtpHost, String defaultFrom) {
		super();
		this.smtpHost = smtpHost;
		this.defaultFrom = defaultFrom;
	}
	
	public LocalMailUserInteraction(String smtpHost) {
		this(smtpHost,"no-reply@localhost");
	}
	
	@Override
	public void sendNotification(String subject, String message,
			String requestAddress,String from) {
		String htmlMessage="<p>"+message +  "</p>" ;
		this.sendHtmlMail(subject,htmlMessage,requestAddress,from);
	}
		
	
	public void sendHtmlMail(String subject, String htmlMessage ,String to,String from) {
		try {
			Session mailSession = this.prepareMailSession();
			MimeMessage mimeMessage =this.prepareMessage(mailSession ,to,subject,from);
			mimeMessage.setText(htmlMessage,"utf-8" , "html");
			Transport.send(mimeMessage);
		} catch (MessagingException e) {
			//e.printStackTrace();
			logger.error(e.getMessage());
		}
	}
	
	private Session prepareMailSession(){
		Properties props = System.getProperties();
		props.put("mail.smtp.host", smtpHost);
		Session mailSession = Session.getDefaultInstance(props, null);
		return mailSession;
	}
	
	private MimeMessage prepareMessage(Session mailSession ,String to,String subject,String from){
		MimeMessage mimeMessage =null;
		try {
			mimeMessage = new MimeMessage(mailSession);
			if(from==null)
				from=defaultFrom;
			mimeMessage.setFrom(new InternetAddress(from));
			mimeMessage.addRecipient( Message.RecipientType.TO,   new InternetAddress(to));
			mimeMessage.setSubject(subject);
		} catch (MessagingException e) {
			//e.printStackTrace();
			logger.error(e.getMessage());
		}
		return mimeMessage;
	}

	@Override
	public void sendRequestMsg(String subject, String message,
			String requestAddress, String corrData, String responseAddress,String from) {	
		String globalHtmlMessage="<p>"+message +  "</p><hr/><a href='" + responseAddress +"?corrData=" + corrData + "'> reply_url  </a>" ;
		this.sendHtmlMail(subject,globalHtmlMessage,requestAddress,from);		
	}
	
	public String getSmtpHost() {
		return smtpHost;
	}
	public void setSmtpHost(String smtpHost) {
		this.smtpHost = smtpHost;
	}

	public String getDefaultFrom() {
		return defaultFrom;
	}

	public void setDefaultFrom(String defaultFrom) {
		this.defaultFrom = defaultFrom;
	}
	

	

}
