package generic.async.util;

public class AsyncContext {
	private String correlationId;
	private String replyDestinationName;//url ou queueName ou ...
	
	public String getCorrelationId() {
		return correlationId;
	}
	public void setCorrelationId(String correlationId) {
		this.correlationId = correlationId;
	}
	public String getReplyDestinationName() {
		return replyDestinationName;
	}
	public void setReplyDestinationName(String replyDestinationName) {
		this.replyDestinationName = replyDestinationName;
	}
	
	
}
