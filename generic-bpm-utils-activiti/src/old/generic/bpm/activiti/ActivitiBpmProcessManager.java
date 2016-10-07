package generic.bpm.activiti;

import generic.bpm.ProcessEventManager;
import generic.bpm.ProcessManager;

import java.util.Map;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ActivitiBpmProcessManager implements ProcessManager , ProcessEventManager {
	
	private static Logger logger = LoggerFactory.getLogger(ActivitiBpmProcessManager.class);
	
	private RepositoryService repositoryService;
	private RuntimeService runtimeService;
	
	private ActivitiBpmEventManager activitiBpmEventManager;
	
	//injection
	public void setRuntimeService(RuntimeService runtimeService) {
		this.runtimeService = runtimeService;
		activitiBpmEventManager=new ActivitiBpmEventManager();
		activitiBpmEventManager.setActivitiRuntimeService(runtimeService);
	}
	
	//injection
	public void setRepositoryService(RepositoryService repositoryService) {
		this.repositoryService = repositoryService;
	}

	@Override
	public void signalEvent(String processName, String processInstanceId,
			String signalName) {
		activitiBpmEventManager.signalEvent(processName, processInstanceId, signalName);
	}

	@Override
	public void messageEvent(String processName, String processInstanceId,
			String eventName, Map<String, Object> newProcessVariablesParams) {
		activitiBpmEventManager.messageEvent(processName, processInstanceId, eventName, newProcessVariablesParams);
	}

	@Override
	public String deployProcessDefinition(String bpmnFileName) {
		String deploymentId = null;
		try {
			deploymentId= repositoryService
					  .createDeployment()
					  .addClasspathResource(bpmnFileName)
					  .deploy()
					  .getId();
			logger.info(bpmnFileName + "is deployed with deploymentId=" + deploymentId );
		} catch (Exception e) {
			logger.error("deployProcessDefinition fail" ,e);
			e.printStackTrace();
		}
		return deploymentId;
	}

	@Override
	public String startProcessInstance(String processName,
			Map<String, Object> initialProcessVariablesParams) {
		  String processInstanceId=null;
		 try {
			ProcessInstance activitiProcessInstance = runtimeService.startProcessInstanceByKey(processName, initialProcessVariablesParams);
			 processInstanceId=activitiProcessInstance.getId();
			// dès le démarrage ---> declenchement d' eventuel ActivitiStartProcessListener si défini dans .bpmn
			 logger.info("a new instance of " + processName + "is started with processInstanceId=" + processInstanceId );
		} catch (Exception e) {
			logger.error("startProcessInstance fail" ,e);
			e.printStackTrace();
		}
		 return processInstanceId;
	}

}
