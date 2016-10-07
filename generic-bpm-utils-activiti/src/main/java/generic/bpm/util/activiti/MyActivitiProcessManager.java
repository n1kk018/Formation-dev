package generic.bpm.util.activiti;

import java.util.Map;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyActivitiProcessManager {
	
	private static Logger logger = LoggerFactory.getLogger(MyActivitiProcessManager.class);
	
	private RepositoryService repositoryService;
	private RuntimeService activitiRuntimeService;
	
	
	//injection
	public void setRuntimeService(RuntimeService runtimeService) {
		this.activitiRuntimeService = runtimeService;		
	}
	
	//injection
	public void setRepositoryService(RepositoryService repositoryService) {
		this.repositoryService = repositoryService;
	}
	
	public void undeployProcessDefinition(String bpmnDeploymentId){
		repositoryService.deleteDeployment(bpmnDeploymentId , true /*cascade*/);
		logger.info("undeployed activitiBpmnDeploymentId = " + bpmnDeploymentId);
	}
	
	public String deployProcessDefinition(String bpmnFileName) {
		String deploymentId = null;
		try {
			deploymentId= repositoryService
					  .createDeployment()
					  .addClasspathResource(bpmnFileName)
					  .deploy()
					  .getId();
			logger.info(bpmnFileName + "is deployed with deploymentId=" + deploymentId );
		} catch (RuntimeException e) {
			logger.error("deployProcessDefinition fail" ,e);
			throw e;
		}
		return deploymentId;
	}
	
	public String startProcessInstance(String processName,
			Map<String, Object> initialProcessVariablesParams) {
		  String processInstanceId=null;
		 try {
			ProcessInstance activitiProcessInstance = activitiRuntimeService.startProcessInstanceByKey(processName, initialProcessVariablesParams);
			 processInstanceId=activitiProcessInstance.getId();
			// dès le démarrage ---> declenchement d' eventuel ActivitiStartProcessListener si défini dans .bpmn
			 logger.info("a new instance of " + processName + "is started with processInstanceId=" + processInstanceId );
		} catch (RuntimeException e) {
			logger.error("startProcessInstance fail" ,e);
			throw e;
		}
		 return processInstanceId;
	}
	
	public String startProcessInstanceByMessage(String messageName,
			Map<String, Object> initialProcessVariablesParams) {
		  String processInstanceId=null;
		 try {
			ProcessInstance activitiProcessInstance = activitiRuntimeService.startProcessInstanceByMessage(messageName, initialProcessVariablesParams);
			 processInstanceId=activitiProcessInstance.getId();
			// dès le démarrage ---> declenchement d' eventuel ActivitiStartProcessListener si défini dans .bpmn
			 logger.info("a new instance of Bpmn process (starting with message " + messageName + ") is started with processInstanceId=" + processInstanceId );
		} catch (RuntimeException e) {
			logger.error("startProcessInstance fail" ,e);
			throw e;
		}
		 return processInstanceId;
	}


	
	
	public void signalEvent(String processName , String processInstanceId , String signalName ){
		try {
			Execution execution = activitiRuntimeService.createExecutionQuery()
					.processDefinitionKey(processName)
					.processInstanceId(processInstanceId)
					.signalEventSubscriptionName(signalName).singleResult();
			activitiRuntimeService.signalEventReceived(signalName,
	
					execution.getId());
		} catch (RuntimeException e) {
			logger.error("signalEvent fail" ,e);
			throw e;
		} 
	}
	
	
	public void messageEvent(String processName , String processInstanceId , String eventName , Map<String,Object> newProcessVariablesParams){
	try {
		Execution execution = activitiRuntimeService.createExecutionQuery()
				.processDefinitionKey(processName)
				.processInstanceId(processInstanceId)
				.messageEventSubscriptionName(eventName).singleResult();
		activitiRuntimeService.messageEventReceived(eventName,execution.getId(),newProcessVariablesParams); 
	} catch (Exception e) {
		logger.error("messageEvent fail" ,e);
		throw e;
	}
	}


	

	

}
