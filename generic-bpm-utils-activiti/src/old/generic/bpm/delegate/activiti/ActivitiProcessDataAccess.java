package generic.bpm.delegate.activiti;

import org.activiti.engine.delegate.DelegateExecution;

import generic.bpm.delegate.ProcessDataAccess;

public class ActivitiProcessDataAccess implements ProcessDataAccess{
	
	private DelegateExecution execution;
	
	public ActivitiProcessDataAccess(DelegateExecution execution){
		this.execution=execution;
	}

	@Override
	public Object getVariable(String varName) {
		return execution.getVariable(varName);
	}

	@Override
	public void setVariable(String varName, Object value) {
		execution.setVariable(varName, value);
	}

	@Override
	public String getProcessInstanceId() {
		return execution.getProcessInstanceId();
	}

}
