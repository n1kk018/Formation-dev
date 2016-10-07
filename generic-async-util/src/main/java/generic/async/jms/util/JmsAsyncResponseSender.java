package generic.async.jms.util;

import generic.async.util.AsyncContext;
import generic.async.util.AsyncResponseSender;
import generic.jaxb.util.GenericJaxbTransformer;
import generic.jms.util.JmsQueueSender;
import generic.jms.util.MyJmsContext;

import javax.jms.QueueConnectionFactory;

public class JmsAsyncResponseSender implements AsyncResponseSender {

	@Override
	public void sendResponseWithAsyncContext(Object responseObj, AsyncContext asyncContext) {
		GenericJaxbTransformer genericJaxbTransformer
	     = new GenericJaxbTransformer(responseObj.getClass());
	
	JmsQueueSender jmsQueueResponseSender = MyJmsContext.getJmsQueueSenderWithDefaultConnectionFactory();
	
	jmsQueueResponseSender.sendTxtMessageWithDestinationNameAndCorrId(
			                  genericJaxbTransformer.javaToXmlString(responseObj),
			                  asyncContext.getReplyDestinationName(),asyncContext.getCorrelationId());
	}

}
