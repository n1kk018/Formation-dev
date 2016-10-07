package tp.activiti.test.app;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyFirstActivitiProcessWithSpringTestApp {
	
	private static Logger logger = LoggerFactory.getLogger(MyFirstActivitiProcessWithSpringTestApp.class);
	
	private static final String ACTIVITI_SPRING_CONFIG="spring/service-activiti-spring.xml";
	private static final String BPMN_PROCESS_FILE="bpmn/MyFirstProcess.bpmn";
	private static final String BPMN_PROCESS_NAME="myFirstProcess"; //id défini (via properties) à l'intérieur du fichier bpmn

	public static void main(String[] args) {
		try{
			//chargement configuration "spring" + accès (via spring) au services techniques d'activi:
			ClassPathXmlApplicationContext applicationContext = 
				    new ClassPathXmlApplicationContext(ACTIVITI_SPRING_CONFIG);
			RepositoryService repositoryService = (RepositoryService) applicationContext.getBean("repositoryService");
			RuntimeService activitiRuntimeService = (RuntimeService) applicationContext.getBean("runtimeService");
			logger.info("springApplicationContext loaded/started with activi services from config file:" + ACTIVITI_SPRING_CONFIG);
			//chargement de la définition du processus BPMN :
			String bpmnDeploymentId = repositoryService
			  .createDeployment()
			  .addClasspathResource(BPMN_PROCESS_FILE)
			  .deploy()
			  .getId();
			logger.info("definition of file "+BPMN_PROCESS_FILE + " with internal processId=" + BPMN_PROCESS_NAME + " is deployed in activiti. "
					    + "activitiBpmnDeploymentId = " + bpmnDeploymentId);
			//démarrer une instance du processus bpmn (identifié via le processName/Id configuré dans un .bpmn préalablement chargé):
			Map<String,Object> params = new HashMap<String,Object>();
			//NB: each param/variable (with all sub-objects) must be serializable !!!
			//params.put("name1","value1");	
			//params.put("name2",new Integer(18));
			 ProcessInstance activitiProcessInstance = activitiRuntimeService.startProcessInstanceByKey(BPMN_PROCESS_NAME, params);
				
				// dès le démarrage ---> initialisation dans eventuel ActivitiStartProcessListener
			    // si défini dans .bpmn
				String processInstanceId=activitiProcessInstance.getId();
				logger.info("a new processInstance of [" + BPMN_PROCESS_FILE + "," + BPMN_PROCESS_NAME + "] is started with processInstanceId="+processInstanceId);
				
				Thread.sleep(2 * 1000);//2s
				
				
				//activitiRuntimeService.deleteProcessInstance(processInstanceId, "raison=arret_immmediat_souhaite");
				// soulève une exception si l'instance du processus est déjà terminée/arrêtée et donc plus retrouvée

				//déchargement de la définition du processus BPMN:
				repositoryService.deleteDeployment(bpmnDeploymentId);
				logger.info("definition of file "+BPMN_PROCESS_FILE + " with internal processId=" + BPMN_PROCESS_NAME + " is undeployed in activiti."
					    + "undeployed activitiBpmnDeploymentId = " + bpmnDeploymentId);
				//déchargement du contexte spring (et des beans configurés):
				applicationContext.close();
				logger.info("springApplicationContext closed/stopped , end of application");
	} catch (Exception e) {
		e.printStackTrace();
	}

	}

}
