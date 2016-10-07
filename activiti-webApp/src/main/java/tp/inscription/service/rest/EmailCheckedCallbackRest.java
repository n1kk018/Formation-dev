package tp.inscription.service.rest;

import generic.bpm.util.activiti.MyActivitiProcessManager;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/emailCheckedCallback/")
public class EmailCheckedCallbackRest {
	
	private MyActivitiProcessManager myActivitiProcessManager;
	
	//injection method for Spring
	public void setMyActivitiProcessManager(MyActivitiProcessManager myActivitiProcessManager) {
		this.myActivitiProcessManager = myActivitiProcessManager;
	}
	
	
	@GET
	@Path("/notifyEmailOk")
	// pour URL = http://localhost:8080/activiti-webApp/services/rest/
                                //emailCheckedCallback/notifyEmailOk?corrData=1
	@Produces("text/plain")
	public String notifyEmailOk(@QueryParam("corrData")String corrData) {
		String message="?";
		//String numInscription = corrData; //old version
		String processInstanceId=corrData;  //new version
		System.out.println("notifyEmailOk (via rest) for processInstanceId="+processInstanceId);
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("verifOk", Boolean.TRUE);
		try {
			myActivitiProcessManager.messageEvent("processInscription", processInstanceId, "emailChecked", params);
			message = "ok, adresse email (et inscription) bien verifie";
		} catch (Exception e) {
			e.printStackTrace();
			message="validation mal gérée (reçue trop tard ou erreur technique) - tentez une nouvelle inscription";
		}
		return message; 
	}

	

}
