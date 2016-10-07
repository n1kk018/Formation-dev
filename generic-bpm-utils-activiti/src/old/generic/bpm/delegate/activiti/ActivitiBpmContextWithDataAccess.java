package generic.bpm.delegate.activiti;

import generic.bpm.delegate.ProcessExecutionContextWithDataAccess;

import org.activiti.engine.delegate.DelegateExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/* si cette classe est enregistrée via un listener comme une variable d'execution , est doit alors
 * être serializable (car potentiellement bean de donnees).
 * Si par contre cette classe de traitement est prise en charge par spring , alors elle n'a pas besoin
 * d'être serialisable et sera automatiquement vu par activiti (pris en charge par spring)
 */

public class ActivitiBpmContextWithDataAccess {

	protected static Logger logger = LoggerFactory.getLogger(ActivitiBpmContextWithDataAccess.class);
	private ProcessExecutionContextWithDataAccess processContextWithDataAccess;
	
	//spring injection
	public void setProcessContextWithDataAccess(
			ProcessExecutionContextWithDataAccess processContext) {
		this.processContextWithDataAccess = processContext;
	}
	
	public Object doAction(DelegateExecution execution,String actionName){
		Object result=null;
		logger.debug("activiti-do- actionName=" + actionName + " , instanceId : " +  execution.getProcessInstanceId());
		result = processContextWithDataAccess.doActionWithDataAccess(new ActivitiProcessDataAccess(execution), actionName);
		return result;
	}
	
	public Object doActionWithArgs(DelegateExecution execution,String actionName,Object ... args){
		Object result=null;
		logger.debug("activiti-do- actionName=" + actionName + " , instanceId : " +  execution.getProcessInstanceId());
		result = processContextWithDataAccess.doActionWithDataAccess(new ActivitiProcessDataAccess(execution), actionName, args);
		return result;
	}

	
	public boolean eval(DelegateExecution execution,String conditionName,Object ... args){
		logger.debug("activiti-eval- conditionName=" + conditionName + " , instanceId : " +  execution.getProcessInstanceId());
		processContextWithDataAccess.evalWithDataAccess(new ActivitiProcessDataAccess(execution),conditionName, args);
		return false;
	}

}
