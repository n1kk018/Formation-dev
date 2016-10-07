package generic.process.exec.activiti;

import generic.process.context.instance.ProcessContextInstance;

import java.util.HashMap;
import java.util.Map;

public class ActivitiCorrelationService {
	
	private static ActivitiCorrelationService uniqueInstance;
	
	public static ActivitiCorrelationService getInstance(){
		if(uniqueInstance==null){
			uniqueInstance=new ActivitiCorrelationService();
		}
		return uniqueInstance;
	}
	
	private Map<String, ProcessContextInstance> mapActiviProcInstanceId_PCI = new HashMap<String, ProcessContextInstance>();
	
	public void storeActiviPIId_PCI(String activitiProcessInstanceId, ProcessContextInstance processContextInstance){
		mapActiviProcInstanceId_PCI.put(activitiProcessInstanceId, processContextInstance);
	}
	
	public void removeActiviPIId_PCI(String activitiProcessInstanceId){
		mapActiviProcInstanceId_PCI.remove(activitiProcessInstanceId);
	}
	
	public ProcessContextInstance retreiveProcessContextInstanceFromActiviPIId(String activitiProcessInstanceId){
		return mapActiviProcInstanceId_PCI.get(activitiProcessInstanceId);
	}

}
