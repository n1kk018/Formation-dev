package generic.process.exec.activiti;

import generic.process.context.instance.ProcessContextInstance;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// a associer à l'evenement "start" du processus
//<activi:executionLinener event="start" class="generic.process.exec.activiti.ActivitiEndProcessListener" />
public class ActivitiStartProcessListener implements ExecutionListener {
	
	private static Logger logger = LoggerFactory.getLogger(ActivitiStartProcessListener.class);

	/** 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void notify(DelegateExecution execution) throws Exception {
		//if(execution.getEventName().equals("start")){
		    logger.debug("activiti process instance" + execution.getProcessInstanceId() + " is started");
			if(execution.getVariable("aCtx")==null){
				execution.setVariable("aCtx", new ActivitiContext());
			}
			
			ProcessContextInstance ctx = (ProcessContextInstance)execution.getVariable("ctx");
			if(ctx!=null){
				ActivitiCorrelationService.getInstance().storeActiviPIId_PCI(execution.getProcessInstanceId(), ctx);
				//une fois stockée, on peut eventuellement l'enlever de l'execution activi:
				//execution.removeVariable("ctx");
				//ou bien le laisser pour que activiti puisse éventuellement gérer la serialisation des donnees
			}
		//}
		
	}
	
}
