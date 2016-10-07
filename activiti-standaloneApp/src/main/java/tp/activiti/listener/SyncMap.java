package tp.activiti.listener;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SyncMap {
	
	private static Logger logger = LoggerFactory.getLogger(SyncMap.class);
	
	private  static Map<String,Object> mapResult = new HashMap<String,Object>();
	private  static Map<String,Semaphore> mapSemaphore = new HashMap<String,Semaphore>();
	
	public static synchronized Semaphore  initProcessInstanceSemaphore(String processInstanceId){
		Semaphore  semaphore = new Semaphore(0);
		mapSemaphore.put(processInstanceId, semaphore);
		logger.info("new semaphore for processInstanceId="+processInstanceId + " is " + semaphore);
		return semaphore;
	}
	
	public static synchronized void releaseProcessInstanceSemaphore(String processInstanceId){
		Semaphore semaphore = mapSemaphore.get(processInstanceId);
		if(semaphore!=null){
			semaphore.release();			
			mapSemaphore.remove(processInstanceId);
			logger.info("released semaphore for processInstanceId="+processInstanceId + " is " + semaphore);
		}
		else{
			logger.info("no semaphore released  for processInstanceId="+processInstanceId );
		}
	}
	
	public static synchronized void storeResult(String processInstanceId,Object result){
		mapResult.put(processInstanceId, result);
		logger.info("result stored for processInstanceId="+processInstanceId + " is " + result);
	}
	
	public static synchronized Object getAndRemoveResult(String processInstanceId){
		Object res  = mapResult.get(processInstanceId);
		if(res!=null){
			mapResult.remove(processInstanceId);
			logger.info("result removed in mapResult for processInstanceId="+processInstanceId);
		}
		else{
			logger.info("no result found in mapResult for processInstanceId="+processInstanceId);
		}
		return res;
	}

}
