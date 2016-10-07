package tp.test;

import generic.bpm.util.activiti.MyActivitiProcessManager;
import generic.bpm.util.activiti.MySpringActivitiHelper;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tp.test.activiti.pers.Personne;

public class IncrementPersWithWsTestApp {
	
	private static Logger logger = LoggerFactory.getLogger(IncrementPersWithWsTestApp.class);
	
	private static final String ACTIVITI_SPRING_CONFIG="spring/service-activiti-spring.xml";
	private static final String BPMN_PROCESS_FILE="bpmn/activiti_incr_pers_age_via_ws.bpmn";
	private static final String BPMN_PROCESS_NAME="incrementAgeWithWsCalculateur"; //id défini (via properties) à l'intérieur du fichier bpmn

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
			Map<String,Object> params = new HashMap<String,Object>();
			//NB: each param/variable (with all sub-objects) must be serializable !!!
			//params.put("username","username");	
			//params.put("age",new Integer(40));
			params.put("pers", new Personne("username",40L));
			/*String processInstanceId=*/ myActivitiProcessManager.startProcessInstance(BPMN_PROCESS_NAME, params);
			
			Thread.sleep(2 *  1000);//2  s
				
			myActivitiProcessManager.undeployProcessDefinition(bpmnDeploymentId);
			//déchargement du contexte spring (et des beans configurés):
			mySpringActivitiHelper.closeSpringContext();
	} catch (Exception e) {
		e.printStackTrace();
	}

	}

}
