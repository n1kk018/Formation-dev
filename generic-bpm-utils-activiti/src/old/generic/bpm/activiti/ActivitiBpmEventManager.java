package generic.bpm.activiti;

import generic.bpm.ProcessEventManager;

import java.util.Map;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.Execution;

public class ActivitiBpmEventManager implements ProcessEventManager {
	
    private RuntimeService activitiRuntimeService;
	
    //injection
	public void setActivitiRuntimeService(RuntimeService activitiRuntimeService) {
		this.activitiRuntimeService = activitiRuntimeService;
	}
	
	@Override
	public void signalEvent(String processName , String processInstanceId , String signalName ){
		try {
			Execution execution = activitiRuntimeService.createExecutionQuery()
					.processDefinitionKey(processName)
					.processInstanceId(processInstanceId)
					.signalEventSubscriptionName(signalName).singleResult();
			activitiRuntimeService.signalEventReceived(signalName,
	
					execution.getId());
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	@Override
	public void messageEvent(String processName , String processInstanceId , String eventName , Map<String,Object> newProcessVariablesParams){
	try {
		Execution execution = activitiRuntimeService.createExecutionQuery()
				.processDefinitionKey(processName)
				.processInstanceId(processInstanceId)
				.messageEventSubscriptionName(eventName).singleResult();
		activitiRuntimeService.messageEventReceived(eventName,execution.getId(),newProcessVariablesParams); 
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
}
