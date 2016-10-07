package tp.activiti.test.app;

import generic.bpm.util.activiti.MyActivitiProcessManager;
import generic.bpm.util.activiti.MySpringActivitiHelper;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tp.activiti.data.Commande;
import tp.activiti.data.SyncResult;
import tp.activiti.listener.SyncMap;

public class TvaBpmnTestUn {
	
	private static Logger logger = LoggerFactory.getLogger(TvaBpmnTestUn.class);
	
	private static final String ACTIVITI_SPRING_CONFIG="spring/service-activiti-spring.xml";
	private static final String BPMN_PROCESS_FILE="bpmn/tva.bpmn";
	private static final String BPMN_PROCESS_NAME="tvaProcess"; //id défini (via properties) à l'intérieur du fichier bpmn

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
			
			/*Commande commande = new Commande();
			commande.setPrixTotalHt(80.0);
			initialProcessVariablesParams.put("commande", commande);*/
			/*String processInstanceId=*/ myActivitiProcessManager.startProcessInstance(BPMN_PROCESS_NAME, initialProcessVariablesParams);
			
			/*
			 NB: le processus basicSyncAxbProcess.bpmn n'effectue que des opérations synchrones/bloquantes (ce qui est extrêmement rare)
			 dès son lancement , il s'execueta de manière bloquante (par le thread en cours)
			 et la suite du code de cette méthode ne sera exécutée qu'après la fin de l'execution du processus.
			 */
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
