package tp.activiti.test.app;

import generic.bpm.util.activiti.MyActivitiProcessManager;
import generic.bpm.util.activiti.MySpringActivitiHelper;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tp.activiti.data.SyncResult;
import tp.activiti.listener.SyncMap;

public class WaitForEventWithTimeoutTestApp {
	
	private static Logger logger = LoggerFactory.getLogger(WaitForEventWithTimeoutTestApp.class);
	
	private static final String ACTIVITI_SPRING_CONFIG="spring/service-activiti-spring.xml";
	private static final String BPMN_PROCESS_FILE="bpmn/waitForEventWithTimeout.bpmn";
	private static final String BPMN_PROCESS_NAME="waitForEventWithTimeout"; //id défini (via properties) à l'intérieur du fichier bpmn

	
	public static void main(String[] args) {
		try{
			//chargement configuration "spring" + accès (via spring) au services techniques d'activi:
			MySpringActivitiHelper mySpringActivitiHelper = new MySpringActivitiHelper();
			mySpringActivitiHelper.loadSpringActivitiConfig(ACTIVITI_SPRING_CONFIG);
			mySpringActivitiHelper.initMyActivitProcessManagerFromSpringActivitiServices();
			
			MyActivitiProcessManager myActivitiProcessManager = mySpringActivitiHelper.getMyActivitiProcessManager();
			
			//chargement de la définition du processus BPMN :
			String bpmnDeploymentId = myActivitiProcessManager.deployProcessDefinition(BPMN_PROCESS_FILE);
		
			//démarrer une instance du processus bpmn (identifié via le processName/Id configuré dans un .bpmn préalablement chargé):
			Map<String,Object> initialProcessVariablesParams = new HashMap<String,Object>();
			
			String processInstanceId = myActivitiProcessManager.startProcessInstance(BPMN_PROCESS_NAME, initialProcessVariablesParams);
			
			System.out.println("Process instance started with id="+processInstanceId);
			Semaphore semaphore = SyncMap.initProcessInstanceSemaphore(processInstanceId);
			
			int nbSecBeforeSendingResponse = 40; //simulation d'un temps de réaction 
			                                     //inférieur ou bien supérieur au timeout (de 60s)
			
			Thread.sleep(nbSecBeforeSendingResponse * 1000);
			//envoi  de l'événement "asyncResponseEvent" (simulation de la réponse d'un utilisateur ou application partenaire):
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("accepted", true);
			//params.put("accepted", false);
			myActivitiProcessManager.messageEvent(BPMN_PROCESS_NAME, processInstanceId, "asyncResponseEvent", params);
			
			
			//waiting for end of processInstance:
			
			//semaphore.acquire();
			if(semaphore.tryAcquire(5, TimeUnit.MINUTES)){
				System.out.println("processIntance terminated");
			}else{
				System.out.println("after 5mn (process instance not terminated)");
			}
		
				
			//déchargement de la définition du processus BPMN:
			myActivitiProcessManager.undeployProcessDefinition(bpmnDeploymentId);
			//déchargement du contexte spring (et des beans configurés):
			mySpringActivitiHelper.closeSpringContext();
	} catch (Exception e) {
		e.printStackTrace();
	}

	}

}
