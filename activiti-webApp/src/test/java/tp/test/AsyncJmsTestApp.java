package tp.test;

import generic.bpm.util.activiti.MyActivitiProcessManager;
import generic.bpm.util.activiti.MySpringActivitiHelper;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.runtime.ProcessInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tp.async.jms.data.DemandeConges;
import tp.test.activiti.pers.Personne;

public class AsyncJmsTestApp {
	
	private static Logger logger = LoggerFactory.getLogger(AsyncJmsTestApp.class);
	
	private static final String ACTIVITI_SPRING_CONFIG="spring/service-activiti-spring.xml";
	private static final String BPMN_PROCESS_FILE="bpmn/test_async_activiti_jms.bpmn";
	private static final String BPMN_PROCESS_NAME="myAsyncProcess"; //id défini (via properties) à l'intérieur du fichier bpmn

	public static void main(String[] args) {
		try{
			//chargement configuration "spring" + accès (via spring) au services techniques d'activi:
			MySpringActivitiHelper mySpringActivitiHelper = new MySpringActivitiHelper();
			mySpringActivitiHelper.loadSpringActivitiConfig(ACTIVITI_SPRING_CONFIG,"spring/jms-spring.xml");
			mySpringActivitiHelper.initMyActivitProcessManagerFromSpringActivitiServices();
			
			MyActivitiProcessManager myActivitiProcessManager = mySpringActivitiHelper.getMyActivitiProcessManager();
			
			//chargement de la définition du processus BPMN :
			String bpmnDeploymentId = myActivitiProcessManager.deployProcessDefinition(BPMN_PROCESS_FILE);
			//démarrer une instance du processus bpmn (identifié via le processName/Id configuré dans un .bpmn préalablement chargé):
			Map<String,Object> params = new HashMap<String,Object>();
			DemandeConges demandeConges = new DemandeConges();
			demandeConges.setNumDemande(1L);demandeConges.setIdEmploye("employe1");
			demandeConges.setPrenom("Alain"); demandeConges.setNom("Therieur");
			demandeConges.setDateDebut("2013-12-23");demandeConges.setDateFin("2014-01-03");
			params.put("demandeConges", demandeConges);
			String processInstanceId= myActivitiProcessManager.startProcessInstance(BPMN_PROCESS_NAME, params);
			System.out.println("test_async_activiti_jms.bpmn : started new processInstanceId="+processInstanceId);
			
			System.out.println("5s de pause");
			  Thread.sleep(5*1000);	
			  
			Map<String,Object> params2 = new HashMap<String,Object>();
			DemandeConges demandeConges2 = new DemandeConges();
				demandeConges2.setNumDemande(2L);demandeConges2.setIdEmploye("employe2");
				demandeConges2.setPrenom("Alex"); demandeConges2.setNom("Therieur");
				demandeConges2.setDateDebut("2014-08-01");demandeConges2.setDateFin("2014-08-15");
				params2.put("demandeConges", demandeConges2);
			String processInstanceId2= 
						 myActivitiProcessManager.startProcessInstance(BPMN_PROCESS_NAME, params2);
			System.out.println("test_async_activiti_jms.bpmn : started new processInstanceId="+processInstanceId2);  
			
			Thread.sleep(2 * 60*  1000);//2 * 60 s
				
			myActivitiProcessManager.undeployProcessDefinition(bpmnDeploymentId);
			//déchargement du contexte spring (et des beans configurés):
			mySpringActivitiHelper.closeSpringContext();
	} catch (Exception e) {
		e.printStackTrace();
	}

	}

}
