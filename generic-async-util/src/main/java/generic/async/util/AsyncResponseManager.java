package generic.async.util;


public class AsyncResponseManager {
	
	private AsyncResponseSender asyncResponseSender; //selon technologie de transport (ex : Jms)
	
	public AsyncResponseManager(){
		super();
	}
	
	public AsyncResponseManager(AsyncResponseSender asyncResponseSender){
		this.asyncResponseSender=asyncResponseSender;
	}

	public void sendAsyncResponse(String key,Object responseObj) {
		try {
			if(key!=null){
				AsyncMapStorage asyncMapStorage = AsyncMapStorage.getInstance();
				asyncResponseSender.sendResponseWithAsyncContext(responseObj, asyncMapStorage.getAsyncContextByKey(key));
				asyncMapStorage.removeAllEntriesForKey(key);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public AsyncResponseSender getAsyncResponseSender() {
		return asyncResponseSender;
	}



	public void setAsyncResponseSender(AsyncResponseSender asyncResponseSender) {
		this.asyncResponseSender = asyncResponseSender;
	}

}
