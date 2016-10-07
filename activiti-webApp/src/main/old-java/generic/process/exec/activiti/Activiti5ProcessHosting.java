package generic.process.exec.activiti;

import generic.process.exec.DynProcessHosting;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Activiti5ProcessHosting  extends DynProcessHosting {

	private static Logger logger = LoggerFactory.getLogger(Activiti5ProcessHosting.class);
	
	/*
	 * Version operationnelle (mais peaufinable) 
	 */
	
	private String bpmn2FileName;
	private String processIdName;
	private String processInstanceId;
	
	private ProcessInstance activitiProcessInstance;
	private RuntimeService activitiRuntimeService ;
	

	public Activiti5ProcessHosting() {
		super();		
	}
	

	public Activiti5ProcessHosting(String bpmn2FileName, String processIdName) {
		super();
		this.bpmn2FileName = bpmn2FileName;
		this.processIdName = processIdName;
	}

	

	@Override
	public void signalEvent(String eventName) {
		//eventName au sens signalName (signalRef)
		try {
			logger.debug("jbpm signaled event:" + eventName+ " on activi process instance " +this.processInstanceId );
			for(Execution execution : activitiRuntimeService.createExecutionQuery().processInstanceId(this.processInstanceId).signalEventSubscriptionName(eventName).list()){
				//generalement une seule execution par processInstance et autre possibilite (sans boucle for):
				//activitiRuntimeService.createExecutionQuery().processInstanceId(this.processInstanceId).signalEventSubscriptionName(eventName).singleResult();
				
				//activitiRuntimeService.messageEventReceived(eventName,execution.getId()); // message with data
				activitiRuntimeService.signalEventReceived(eventName,execution.getId()); //signal without data
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void start() {
		try {
			Map<String,Object> params = new HashMap<String,Object>();
			//NB: each param/variable (with all sub-objects) must be serializable !!!
			params.put("ctx",this.getOutboundProcessInstanceContext());	
			//params.put("aCtx", new ActivitiContext()); //now done via StartListener , specific activi adapter aCtx = activitiCtx
						
			// Create Activiti process engine
			ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
			 /* ProcessEngine processEngine = ProcessEngineConfiguration
			    .createStandaloneProcessEngineConfiguration()
			    .buildProcessEngine();*/
			  
			  // Get Activiti services
			  RepositoryService repositoryService = processEngine.getRepositoryService();
			  this.activitiRuntimeService = processEngine.getRuntimeService();
			  
			  // Deploy the process definition
			  repositoryService.createDeployment()
			    .addClasspathResource(bpmn2FileName)
			    .deploy();			
			
			
			//this.activitiProcessInstance = activitiRuntimeService.startProcessInstanceByKey(this.processIdName);
			this.activitiProcessInstance = activitiRuntimeService.startProcessInstanceByKey(this.processIdName, params);
		    //NB: le processus démarre immédiatement et les lignes qui suivent peuvent quequefois s'executer bien après 
			// le démarrage ---> initialisation dans ActivitiStartProcessListener
			this.processInstanceId=this.activitiProcessInstance.getId();
			//System.out.println("started new processInstanceId="+this.processInstanceId);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		            
	}

	public String getBpmn2FileName() {
		return bpmn2FileName;
	}

	public void setBpmn2FileName(String bpmn2FileName) {
		this.bpmn2FileName = bpmn2FileName;
	}

	public String getProcessIdName() {
		return processIdName;
	}

	public void setProcessIdName(String processIdName) {
		this.processIdName = processIdName;
	}
	
	

}
