package tp.activiti.data;

import java.io.Serializable;

public class SyncResult implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private double res;
	private String message;
	public double getRes() {
		return res;
	}
	public void setRes(double res) {
		this.res = res;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "SyncResult [res=" + res + ", message=" + message + "]";
	}
	
	

}
