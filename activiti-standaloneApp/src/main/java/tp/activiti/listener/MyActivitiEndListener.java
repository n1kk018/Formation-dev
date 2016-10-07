package tp.activiti.listener;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;

public class MyActivitiEndListener implements ExecutionListener {
	private static final long serialVersionUID = 1L;
 
	@Override
	public void notify(DelegateExecution execution) throws Exception {
		  String processInstanceId = execution.getProcessInstanceId();
		  Object resultObj = execution.getVariable("result");
		  if(resultObj!=null){
			  SyncMap.storeResult(processInstanceId, resultObj);
		  }
          System.out.println("listener was called - end of processInstance of id:" + processInstanceId);
          SyncMap.releaseProcessInstanceSemaphore(processInstanceId);
	}
}
