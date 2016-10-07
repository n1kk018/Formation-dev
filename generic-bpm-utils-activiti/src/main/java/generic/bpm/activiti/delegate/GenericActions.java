package generic.bpm.activiti.delegate;

import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JOptionPane;

import org.activiti.engine.delegate.DelegateExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//simple (sans annotations , directement execution.... )

public class GenericActions {
	
	private static Logger logger = LoggerFactory.getLogger(GenericActions.class);
	
	public void logInfo(String message) {
		logger.info(message);
	}
	
	public void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
	}
	
	public void dumpAllVariables(DelegateExecution execution){
		Map<String,Object> varMap = execution.getVariables();
		System.out.println("**In process " + execution.getProcessDefinitionId() + " - instanceId:" + execution.getProcessInstanceId()
				+ " with ProcessBusinessKey=" + execution.getProcessBusinessKey());
		for(Entry<String,Object> varEntry : varMap.entrySet()){
			if(varEntry.getValue()!=null)
			   System.out.println(">>" + varEntry.getKey() + "=" + varEntry.getValue().toString() + "[type=" + varEntry.getValue().getClass().getName() + "]");
		}
	}
	
	public void display(String message) {
		System.out.println(message);
	}
	
	public void inputVariable(DelegateExecution execution,String varName , String message){
		String value = JOptionPane.showInputDialog(null, message, "saisir la valeur", JOptionPane.QUESTION_MESSAGE);
		if(value==null || value.isEmpty()){
			value="null";
		}
		execution.setVariable(varName, value);
	}
	
	public void diplayMessageWithArgs(String message,Object ...args) {
		System.out.print(message + " ");
		for(Object obj:args)
			System.out.print(obj.toString()+" ");
		System.out.print("\n");
	}
	
	public Object executeNamedAction(DelegateExecution execution,String actionName,Object ...args){
		Object res= null;
		if(actionName.equals("...")){
			//...
		}
		else if(actionName.equals("..")){
			//...
		}
		return res;
	}
	
}
