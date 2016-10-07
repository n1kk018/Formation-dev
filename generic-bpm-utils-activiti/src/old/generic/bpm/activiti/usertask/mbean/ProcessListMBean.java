package generic.bpm.activiti.usertask.mbean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Named
@Component
@Scope(value="session")
public class ProcessListMBean {
	
	//@Inject
	@Autowired
	private RepositoryService repositoryService;
	
	//@Inject
	@Autowired
	private RuntimeService activitiRuntimeService ;
	
	private String processDefinitionKey; //toStart
	
	private List<ProcessDefinition> processDefinitionList;
	

	public List<ProcessDefinition> getProcessDefinitionList() {
		System.out.println("getProcessDefinitionList");
		processDefinitionList = repositoryService.createProcessDefinitionQuery().list();
		return processDefinitionList;
	}
	
	public String startProcessByKey(){
		System.out.println("startProcessByKey() with processDefinitionKey="+processDefinitionKey);
		Map<String,Object> params = new HashMap<String,Object>();
		//empty params (in this generic beta version)
		 ProcessInstance activitiProcessInstance = activitiRuntimeService.startProcessInstanceByKey(this.processDefinitionKey, params);
			// dès le démarrage ---> initialisation dans eventuel ActivitiStartProcessListener si défini dans .bpmn
			String processInstanceId=activitiProcessInstance.getId();
			System.out.println("started (with spring) new processInstanceId="+processInstanceId);
		return "welcome";
	}

	public String getProcessDefinitionKey() {
		return processDefinitionKey;
	}

	public void setProcessDefinitionKey(String processDefinitionKey) {
		this.processDefinitionKey = processDefinitionKey;
	}

	
	
	

}
