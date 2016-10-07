package tp.async.jms.data;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AR implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String refId; //corrData (id de la chose bien reçue)
	private String status; //ex: OK
	private String message;//ex: bien recu
	
	public AR() {
		super();
	}
	

	public AR(String refId, String status, String message) {
		super();
		this.refId = refId;
		this.status = status;
		this.message = message;
	}


	@Override
	public String toString() {
		return "StatusNotif [status=" + status + ", message=" + message + "]";
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public String getRefId() {
		return refId;
	}

	public void setRefId(String refId) {
		this.refId = refId;
	}


}
