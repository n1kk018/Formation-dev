package tp.activiti.test.app;

import generic.bpm.util.activiti.MyActivitiProcessManager;
import generic.bpm.util.activiti.MySpringActivitiHelper;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tp.activiti.data.SyncResult;
import tp.activiti.listener.SyncMap;

public class BasicSyncAxbWithGenericBpmUtilTestApp {
	
	private static Logger logger = LoggerFactory.getLogger(BasicSyncAxbWithGenericBpmUtilTestApp.class);
	
	private static final String ACTIVITI_SPRING_CONFIG="spring/service-activiti-spring.xml";
	private static final String BPMN_PROCESS_FILE="bpmn/basicSyncAxbProcess.bpmn";
	private static final String BPMN_PROCESS_NAME="basicSyncAxbProcess"; //id défini (via properties) à l'intérieur du fichier bpmn

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
			/*String processInstanceId=*/ myActivitiProcessManager.startProcessInstance(BPMN_PROCESS_NAME, initialProcessVariablesParams);
			
			/*
			 NB: le processus basicSyncAxbProcess.bpmn n'effectue que des opérations synchrones/bloquantes (ce qui est extrêmement rare)
			 dès son lancement , il s'execueta de manière bloquante (par le thread en cours)
			 et la suite du code de cette méthode ne sera exécutée qu'après la fin de l'execution du processus.
			 */
			
			System.out.println("syncResult.res="+syncResult.getRes());//retreiving 14 (good result)
			System.out.println("res=" +initialProcessVariablesParams.get("res"));//retreiving null
				
			//déchargement de la définition du processus BPMN:
			myActivitiProcessManager.undeployProcessDefinition(bpmnDeploymentId);
			//déchargement du contexte spring (et des beans configurés):
			mySpringActivitiHelper.closeSpringContext();
	} catch (Exception e) {
		e.printStackTrace();
	}

	}

}
