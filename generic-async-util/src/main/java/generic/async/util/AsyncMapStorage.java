package generic.async.util;

import java.util.HashMap;
import java.util.Map;

public class AsyncMapStorage {
	
	private static AsyncMapStorage uniqueInstance;
	public static AsyncMapStorage getInstance(){
		if(uniqueInstance==null){
			uniqueInstance=new AsyncMapStorage();
		}
		return uniqueInstance;
	}
	
	private int simpleNumericKey=0;//incremental key/id/pk
	
	Map<String,Object> mapIdRequestObj = new HashMap<String,Object>();
	Map<String,AsyncContext> mapIdRequestCtx = new HashMap<String,AsyncContext>();
	
	private String storeRequestObject(Object requestObject){
		String key = String.valueOf(simpleNumericKey++);
		mapIdRequestObj.put(key,requestObject);
		return key;
	}
	
	private void storeAsyncContext(String key,AsyncContext asyncContex){
			mapIdRequestCtx.put(key,asyncContex);
	}
	
	public String storeRequestObjectWithAsyncContext(Object requestObject,AsyncContext asyncContex){
		String key = storeRequestObject(requestObject);
		storeAsyncContext(key,asyncContex);
		return key;
	}
	
	public Object getResquestObjectByKey(String key){
		return mapIdRequestObj.get(key);
	}
	
	public AsyncContext getAsyncContextByKey(String key){
		return mapIdRequestCtx.get(key);
	}
	
	public String getFirstKey(){
		return (String)mapIdRequestObj.keySet().iterator().next();
	}
	
	public int getSize(){
		return mapIdRequestObj.size();//theoriquement = mapIdRequestCtx.size();
	}
	
	public void  removeAllEntriesForKey(String key){
		mapIdRequestObj.remove(key);
		mapIdRequestCtx.remove(key);
	}

}
