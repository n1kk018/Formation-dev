package tp.inscription.service.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import tp.inscription.context.InscriptionProcessContext;

@Path("/emailCheckedCallback/")
public class CopyOfEmailCheckedCallbackRestV1 {
	
	private InscriptionProcessContext inscriptionProcessContext;
	
	//injection method for Spring
		public void setInscriptionProcessContext(
				InscriptionProcessContext inscriptionProcessContext) {
			this.inscriptionProcessContext = inscriptionProcessContext;
		}
	
	
	@GET
	@Path("/notifyEmailOk")
	// pour URL = http://localhost:8080/inscription-bpmn-web/services/rest/
                                //emailCheckedCallback/notifyEmailOk?corrData=1
	@Produces("text/plain")
	public String notifyEmailOk(@QueryParam("corrData")String corrData) {
		String numInscription = corrData;
		System.out.println("notifyEmailOk (via rest) for numInscription="+numInscription);
		inscriptionProcessContext.receiveSimpleEMailConfirmation(numInscription);
		return "ok, adresse email (et inscription) bien verifie";
	}

}
