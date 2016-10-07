package tp.test.activiti;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

/* simple exemple technique (non utile pour le framework)*/
public class DelegateContext implements JavaDelegate{

	@Override
	public void execute(DelegateExecution execution) throws Exception {
	System.out.println("**** delegate / " + execution.getProcessInstanceId());
	//...	
	}

}
