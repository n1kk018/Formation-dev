package generic.process.exec.activiti;

import generic.process.context.instance.ProcessContextInstance;

import java.io.Serializable;

import org.activiti.engine.delegate.DelegateExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*ActivitiContext = sorte de adapteur entre "execution activiti" et "ProcessContextIntance"
 * via une map qui n'est pas prise en charge par activiti.
 * Logique d'activi : variables serialisables  plutôt de données (pas pour gros traitements)
 * 
 * NB: cet adapateur sera pris en charge par activiti en tant que minuscule objet de "délégation de traitement"
 *     La map doit donc être externe à cette classe et gérée par un service .
 */

public class ActivitiContext implements Serializable{
	
	private static Logger logger = LoggerFactory.getLogger(ActivitiContext.class);
	
	/**
	 */
	private static final long serialVersionUID = 1L;

	public void doAction(String actionName,DelegateExecution execution){
		logger.debug("activiti-do- actionName=" + actionName + " , instanceId : " +  execution.getProcessInstanceId());
		ProcessContextInstance pci = ActivitiCorrelationService.getInstance().retreiveProcessContextInstanceFromActiviPIId(execution.getProcessInstanceId());
		pci.doAction(actionName);
	}
	
	public boolean eval(String conditionName,DelegateExecution execution){
		logger.debug("activiti-eval- conditionName=" + conditionName + " , instanceId : " +  execution.getProcessInstanceId());
		ProcessContextInstance pci = ActivitiCorrelationService.getInstance().retreiveProcessContextInstanceFromActiviPIId(execution.getProcessInstanceId());
		return pci.eval(conditionName);
	}

}
