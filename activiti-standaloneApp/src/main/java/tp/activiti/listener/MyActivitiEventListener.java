package tp.activiti.listener;

import org.activiti.engine.delegate.event.ActivitiActivityEvent;
import org.activiti.engine.delegate.event.ActivitiEntityEvent;
import org.activiti.engine.delegate.event.ActivitiEvent;
import org.activiti.engine.delegate.event.ActivitiEventListener;
import org.activiti.engine.delegate.event.ActivitiSequenceFlowTakenEvent;
import org.activiti.engine.delegate.event.ActivitiVariableEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyActivitiEventListener implements ActivitiEventListener{
	
	private static Logger logger = LoggerFactory.getLogger(MyActivitiEventListener.class);

	@Override
	public boolean isFailOnException() {
	    // The logic in the onEvent method of this listener is not critical, exceptions
	    // can be ignored if logging fails...
	    return false;
	  }

	@Override
	public void onEvent(ActivitiEvent event) {
	    switch (event.getType()) {

	      case JOB_EXECUTION_SUCCESS:
	      case JOB_EXECUTION_FAILURE:
	      case ENTITY_CREATED:
	      case ENTITY_DELETED:
	      case ENTITY_INITIALIZED:
	    	  ActivitiEntityEvent eEvent = (ActivitiEntityEvent) event;
	    	  logger.debug("Event received: " + event.getType()  + ":" + eEvent.getEntity().toString());
	        break;

	      case SEQUENCEFLOW_TAKEN:
	    	  ActivitiSequenceFlowTakenEvent sftEvent = (ActivitiSequenceFlowTakenEvent) event;
	    	  logger.debug("Event received: " + event.getType() 
	    			           + " from " + sftEvent.getSourceActivityName() + "[id="  + sftEvent.getSourceActivityId()+ "]"
	    			           + " to " + sftEvent.getTargetActivityName() + "[id="  + sftEvent.getTargetActivityId()+ "]");
	    	  break;
	    	  
	      case VARIABLE_CREATED:
	      case VARIABLE_DELETED:
	    	  ActivitiVariableEvent vEvent = (ActivitiVariableEvent) event;
	    	  logger.debug("Event received: " + event.getType() + ":" + vEvent.getVariableName());
	    	  break;
	    	  
	        
	      case ACTIVITY_STARTED:
	      case ACTIVITY_COMPLETED:
	      case ACTIVITY_COMPENSATE:
	    	  ActivitiActivityEvent aEvent = (ActivitiActivityEvent) event;
	    	  logger.debug("Event received: " + event.getType()+ ":" + aEvent.getActivityName());
	       break;
	       
		       
	      default:
	    	  logger.debug("Event received: " + event.getType());
	    }
	  }

}
