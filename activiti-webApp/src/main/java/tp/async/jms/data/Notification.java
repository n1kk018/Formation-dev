package tp.async.jms.data;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement()//defaultName="notification"
public class Notification implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String subject;
	private String message;
	
	public Notification() {
		super();
	}
	
	public Notification(String id, String subject, String message) {
		super();
		this.id = id;
		this.subject = subject;
		this.message = message;
	}

	@Override
	public String toString() {
		return "Notification [id=" + id + ", subject=" + subject + ", message="
				+ message + "]";
	}

	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	
	

}
