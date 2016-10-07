package generic.bpm.util.activiti;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MySpringActivitiHelper {
	private static Logger logger = LoggerFactory.getLogger(MySpringActivitiHelper.class);
	
	private ClassPathXmlApplicationContext applicationContext;//+get/set
	private RepositoryService activitiRepositoryService;//+get/set
	private RuntimeService activitiRuntimeService;//+get/set
	private MyActivitiProcessManager myActivitiProcessManager;//+get/set
	
	
	public void loadSpringActivitiConfig(String springActivitiConfig, Object ...args){
		if(args==null){
		applicationContext = 
			    new ClassPathXmlApplicationContext(springActivitiConfig);
		}
		else {
			String[] springActivitiConfigTab = new String[args.length+1];
			int i=0;
			springActivitiConfigTab[i]=springActivitiConfig;
			for(Object configFileName : args){
				i++;
				springActivitiConfigTab[i]=(String) configFileName;
			}
		applicationContext = 
				    new ClassPathXmlApplicationContext(springActivitiConfigTab);
		}
		activitiRepositoryService = (RepositoryService) applicationContext.getBean("repositoryService");
		activitiRuntimeService = (RuntimeService) applicationContext.getBean("runtimeService");
		logger.info("springApplicationContext loaded/started with activi services from config file:" + springActivitiConfig);
	}
	
	public void initMyActivitProcessManagerFromSpringActivitiServices(){
		myActivitiProcessManager = new MyActivitiProcessManager();
		myActivitiProcessManager.setRepositoryService(activitiRepositoryService);
		myActivitiProcessManager.setRuntimeService(activitiRuntimeService);
	}
	
	public void closeSpringContext(){
		applicationContext.close();
		logger.info("springApplicationContext closed/stopped");
	}

	public ClassPathXmlApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public void setApplicationContext(
			ClassPathXmlApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	public RepositoryService getActivitiRepositoryService() {
		return activitiRepositoryService;
	}

	public void setActivitiRepositoryService(
			RepositoryService activitiRepositoryService) {
		this.activitiRepositoryService = activitiRepositoryService;
	}

	public RuntimeService getActivitiRuntimeService() {
		return activitiRuntimeService;
	}

	public void setActivitiRuntimeService(RuntimeService activitiRuntimeService) {
		this.activitiRuntimeService = activitiRuntimeService;
	}

	public MyActivitiProcessManager getMyActivitiProcessManager() {
		return myActivitiProcessManager;
	}

	public void setMyActivitiProcessManager(
			MyActivitiProcessManager myActivitiProcessManager) {
		this.myActivitiProcessManager = myActivitiProcessManager;
	}
	
	

}
