package tp.inscription.service;


import generic.bpm.util.activiti.MyActivitiProcessManager;

import java.util.HashMap;
import java.util.Map;

import javax.jws.WebService;

import tp.inscription.data.Inscription;

@WebService(endpointInterface="tp.inscription.service.ServiceInscription")
public class ServiceInscriptionBean implements ServiceInscription {
	
	private MyActivitiProcessManager myActivitiProcessManager;
	
    //injection method for Spring
	public void setMyActivitiProcessManager(MyActivitiProcessManager myActivitiProcessManager) {
		this.myActivitiProcessManager = myActivitiProcessManager;
	}
	
	@Override
	public String traiterInscription(Inscription inscription) {
		//processManager.deployProcessDefinition("inscription_activiti.bpmn"); préalablement déclenché via AutoBpmLoader (spring)
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("inscription", inscription);
		//String processInstanceId=myActivitiProcessManager.startProcessInstance("processInscription", params);
		String processInstanceId=myActivitiProcessManager.startProcessInstanceByMessage("inscriptionRequestMsg",params);
		System.out.println("started (with spring) new processInstanceId="+processInstanceId);
		
		String msgAR = "A.R: demande d'inscription " + inscription.getNumInscription() + " bien recue , en attente de confirmation adresse email"; 
		return msgAR;
	}


	

}
