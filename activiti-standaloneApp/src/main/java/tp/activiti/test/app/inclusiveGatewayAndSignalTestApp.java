package tp.activiti.test.app;

import generic.bpm.util.activiti.MyActivitiProcessManager;
import generic.bpm.util.activiti.MySpringActivitiHelper;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class inclusiveGatewayAndSignalTestApp {
	
	private static Logger logger = LoggerFactory.getLogger(inclusiveGatewayAndSignalTestApp.class);
	
	private static final String ACTIVITI_SPRING_CONFIG="spring/service-activiti-spring.xml";
	private static final String BPMN_PROCESS_FILE="bpmn/inclusiveGatewayAndSignal.bpmn";
	private static final String BPMN_PROCESS_NAME="inclusiveGatewayAndSignal"; //id défini (via properties) à l'intérieur du fichier bpmn

	public static void main(String[] args) {
		try{
			//chargement configuration "spring" + accès (via spring) au services techniques d'activi:
			MySpringActivitiHelper mySpringActivitiHelper = new MySpringActivitiHelper();
			mySpringActivitiHelper.loadSpringActivitiConfig(ACTIVITI_SPRING_CONFIG);
			mySpringActivitiHelper.initMyActivitProcessManagerFromSpringActivitiServices();
			
			MyActivitiProcessManager myActivitiProcessManager = mySpringActivitiHelper.getMyActivitiProcessManager();
			
			//chargement de la définition du processus BPMN :
			String bpmnDeploymentIdForCalledPubActivity = myActivitiProcessManager.deployProcessDefinition("bpmn/pubEnBoucle.bpmn");
			String bpmnDeploymentId = myActivitiProcessManager.deployProcessDefinition(BPMN_PROCESS_FILE);
		
			//démarrer une instance du processus bpmn (identifié via le processName/Id configuré dans un .bpmn préalablement chargé):
			Map<String,Object> initialProcessVariablesParams = new HashMap<String,Object>();
			/*String processInstanceId=*/ myActivitiProcessManager.startProcessInstance(BPMN_PROCESS_NAME, initialProcessVariablesParams);
			
			Thread.sleep(5 * 1000 * 60);//5mn
				
			//déchargement de la définition du processus BPMN:
			myActivitiProcessManager.undeployProcessDefinition(bpmnDeploymentId);
			myActivitiProcessManager.undeployProcessDefinition(bpmnDeploymentIdForCalledPubActivity);
			//déchargement du contexte spring (et des beans configurés):
			mySpringActivitiHelper.closeSpringContext();
	} catch (Exception e) {
		e.printStackTrace();
	}

	}

}
