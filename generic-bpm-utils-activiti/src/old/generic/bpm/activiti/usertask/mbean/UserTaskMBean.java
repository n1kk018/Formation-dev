package generic.bpm.activiti.usertask.mbean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.FormService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.TaskService;
import org.activiti.engine.form.FormProperty;
import org.activiti.engine.form.TaskFormData;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Named
@Component
@Scope(value="session")
public class UserTaskMBean {
	
	//@Inject
	@Autowired
	private RepositoryService repositoryService;
	
	//@Inject
	@Autowired
	private CurrentUser currentUser;
	
	@Autowired
	private FormService formService;
	
	private String taskIdToClaim;
	private String taskIdToComplete;
	
	private Task currentTask; //to perform/complete
	
	
	private List<FormProperty> formProperties; 
	
	//@Inject
	@Autowired
	private TaskService taskService;
	
	private List<Task> availableTasks; //to claim
	
	private List<Task> assignedTasks;//to complete
	
	public String claimTask(){
		System.out.println("claimTask() with taskIdToClaim" + taskIdToClaim);
		taskService.claim(taskIdToClaim,currentUser.getUsername());
		return null;
	}
	
	public String completeFormTask(){
		String suite=null;
		System.out.println("completeFormTask() with taskIdToComplete" + taskIdToComplete);
		//TaskFormData taskFormData = formService.getTaskFormData(taskIdToComplete);
		Map<String,String> idValuesPropertyMap = new HashMap<String,String>();
		for(FormProperty prop:formProperties){
			//writable , required , type , name , id , ...
			System.out.println("formProperties[id="+prop.getId()+",value="+ String.valueOf(prop.getValue())+"]");
			if(prop.isWritable()){
			   idValuesPropertyMap.put(prop.getId(), String.valueOf(prop.getValue()));
			}
		}
		formService.submitTaskFormData(taskIdToComplete, idValuesPropertyMap);//complete task with values
		suite="userTask";//.xhtml
		return suite;
	}
	
	public String performTask(){
		String suite=null;
		currentTask=taskService.createTaskQuery().taskId(this.taskIdToComplete).singleResult(); //pour details;
		System.out.println("performTask() with taskIdToComplete" + taskIdToComplete);
		TaskFormData taskFormData = formService.getTaskFormData(taskIdToComplete);
		formProperties = taskFormData.getFormProperties();
		if(formProperties!=null && !formProperties.isEmpty())
		{
			suite="performTask";//.xhtml
			// later : formService.submitTaskFormData(taskId, properties);
		}
		else{
		System.out.println("directly complete task with form properties");
		taskService.complete(taskIdToComplete);
		}
		return suite;
	}

	public List<Task> getAvailableTasks() {
		availableTasks = taskService.createTaskQuery().taskCandidateGroup("management").list();
		return availableTasks;
	}

	public List<Task> getAssignedTasks() {
		assignedTasks = taskService.createTaskQuery().taskAssignee(currentUser.getUsername()).list();
		return assignedTasks;
	}

	public String getTaskIdToClaim() {
		return taskIdToClaim;
	}

	public void setTaskIdToClaim(String taskIdToClaim) {
		this.taskIdToClaim = taskIdToClaim;
	}

	public String getTaskIdToComplete() {
		return taskIdToComplete;
	}

	public void setTaskIdToComplete(String taskIdToComplete) {
		this.taskIdToComplete = taskIdToComplete;
	}

	public List<FormProperty> getFormProperties() {
		return formProperties;
	}

	public void setFormProperties(List<FormProperty> formProperties) {
		this.formProperties = formProperties;
	}

	public Task getCurrentTask() {
		return currentTask;
	}

	public void setCurrentTask(Task currentTask) {
		this.currentTask = currentTask;
	}
	
	
	
	

}
