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

public class SpeudoSyncAxbEvtWithGenericBpmUtilTestApp {
	
	private static Logger logger = LoggerFactory.getLogger(SpeudoSyncAxbEvtWithGenericBpmUtilTestApp.class);
	
	private static final String ACTIVITI_SPRING_CONFIG="spring/service-activiti-spring.xml";
	private static final String BPMN_PROCESS_FILE="bpmn/speudoSyncAxbProcessWithEvent.bpmn";
	private static final String BPMN_PROCESS_NAME="speudoSyncAxbProcessWithEvent"; //id défini (via properties) à l'intérieur du fichier bpmn

	
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
			initialProcessVariablesParams.put("a", 2.0);
			initialProcessVariablesParams.put("x", 3.0);
			initialProcessVariablesParams.put("b", 8.0);
			SyncResult syncResult = new SyncResult();
			initialProcessVariablesParams.put("result", syncResult);
			
			String processInstanceId = myActivitiProcessManager.startProcessInstanceByMessage("receiveAxbRequest", initialProcessVariablesParams);
			
			System.out.println("Process instance started with id="+processInstanceId);
			
			
			//Thread.sleep(2 * 1000);//2s
			//waiting for end of processInstance:
			Semaphore semaphore = SyncMap.initProcessInstanceSemaphore(processInstanceId);
			//semaphore.acquire();
			if(semaphore.tryAcquire(10000, TimeUnit.MILLISECONDS)){
				System.out.println("result in map:"+SyncMap.getAndRemoveResult(processInstanceId));
			}else{
				System.out.println("no result found after 10s (process instance not terminated)");
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
