package generic.process.exec.activiti;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// a associer à l'evenement "end" du processus
//<activi:executionLinener event="end" class="generic.process.exec.activiti.ActivitiEndProcessListener" />
public class ActivitiEndProcessListener implements ExecutionListener {
	
	private static Logger logger = LoggerFactory.getLogger(ActivitiEndProcessListener.class);

	/** 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void notify(DelegateExecution execution) throws Exception {
		//if(execution.getEventName().equals("end")){
		    String activitiProcessInstanceId=execution.getProcessInstanceId();
		    ActivitiCorrelationService activitiCorrelationService =ActivitiCorrelationService.getInstance();
			logger.debug("activiti process instance" + activitiProcessInstanceId + " is ended");
			activitiCorrelationService.retreiveProcessContextInstanceFromActiviPIId(activitiProcessInstanceId).releaseResourcesOnEnd();
			activitiCorrelationService.removeActiviPIId_PCI(activitiProcessInstanceId);
		//}
		
	}
	
}
