package tp.test.activiti;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleActivitiStartListener implements ExecutionListener {
	
private static Logger logger = LoggerFactory.getLogger(SimpleActivitiStartListener.class);
	
	/**
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void notify(DelegateExecution execution) throws Exception {
		 logger.debug("activiti process instance" + execution.getProcessInstanceId() + " is started");
			//...
		
	}

}
