package generic.bpm.util.activiti;

import java.util.List;

//import javax.annotation.PostConstruct;

//for Spring or ...
public class AutoBpmnLoaderHelper {
	
	private MyActivitiProcessManager processManager;
	private List<String> bpmnFileNameList;
	
	//injection
	public void setProcessManager(MyActivitiProcessManager processManager) {
		this.processManager = processManager;
	}


    //injection
	public void setBpmnFileNameList(List<String> bpmnFileNameList) {
		this.bpmnFileNameList = bpmnFileNameList;
	}
	
	//@PostConstruct or init-method="loadBpmnDefinitions" of bean in xml
	public void loadBpmnDefinitions(){
		if(bpmnFileNameList==null){
			System.err.println("bpmnFileNameList not injected/initialized");
			return;
		}
		for(String bpmnFileName : this.bpmnFileNameList){
			System.out.println("loading of "+bpmnFileName+" ...");
			processManager.deployProcessDefinition(bpmnFileName);
		}
	}
	
	public List<String> getBpmnFileNameList() {
		return bpmnFileNameList;
	}
	

}
