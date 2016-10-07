package tp.inscription.data;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;

public class VerifEmail  implements Serializable{
	/**
	 */
	private static final long serialVersionUID = 1L;
	
	private String email;
	
	//@CorrData?
	private Integer numInscription;
	
	private String date; //date de la verification (de l'envoi de mail pour s'assurer une réponse et donc d'un email valide)
	
	public VerifEmail(){
		super();
		DateFormat df = DateFormat.getDateInstance();
		this.date = df.format(new Date());
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getNumInscription() {
		return numInscription;
	}
	public void setNumInscription(Integer numInscription) {
		this.numInscription = numInscription;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	
	
}
