package generic.ws.util.interceptor.cxf;

import generic.util.auth.AuthManager;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.cxf.binding.soap.interceptor.SoapHeaderInterceptor;
import org.apache.cxf.configuration.security.AuthorizationPolicy;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Exchange;
import org.apache.cxf.message.Message;
import org.apache.cxf.transport.Conduit;
import org.apache.cxf.ws.addressing.EndpointReferenceType;
import org.apache.log4j.Logger;

/**
 * CXF Interceptor that provides HTTP Basic Authentication validation. Based on
 * the concepts outline here:
 * http://chrisdail.com/2008/03/31/apache-cxf-with-http-basic-authentication
 * 
 * @author CDail & D. Defrance
 */
public class CxfBasicAuthInterceptor extends SoapHeaderInterceptor {
	protected Logger log = Logger.getLogger(getClass());
	
	private AuthManager authManager;
	
	//@Required (spring injection)
	public void setAuthManager(AuthManager authManager) {
		this.authManager = authManager;
	}


	@Override
	public void handleMessage(Message message) throws Fault {
		// This is set by CXF
		AuthorizationPolicy policy = message.get(AuthorizationPolicy.class);
		// If the policy is not set, the user did not specify credentials
		// A 401 is sent to the client to indicate that authentication is
		// required
		if (policy == null) {
			if (log.isDebugEnabled()) {
				log.debug("User attempted to log in with no credentials");
			}
			sendErrorResponse(message, HttpURLConnection.HTTP_UNAUTHORIZED);
			return;
		}
		if (log.isDebugEnabled()) {
			log.debug("Logging in use: " + policy.getUserName());
		}
		// Verify the password:
		
		/*if (authManager.verifyAuth(policy.getUserName(), policy.getPassword())!=AuthStatus.VALID_AUTH) {*/
		if (! authManager.getValidPasswordForUser(policy.getUserName()).equals(policy.getPassword())) {
			log.warn("Invalid username or password for user: "
					+ policy.getUserName());
			sendErrorResponse(message, HttpURLConnection.HTTP_FORBIDDEN);
		}
	}

	private void sendErrorResponse(Message message, int responseCode) {
		Message outMessage = getOutMessage(message);
		outMessage.put(Message.RESPONSE_CODE, responseCode);
		// Set the response headers
		Map<String, List<String>> responseHeaders = (Map<String, List<String>>) message
				.get(Message.PROTOCOL_HEADERS);
		if (responseHeaders != null) {
			responseHeaders.put("WWW-Authenticate",
					Arrays.asList(new String[] { "Basic realm=realm" }));
			responseHeaders.put("Content-Length",
					Arrays.asList(new String[] { "0" }));
		}
		message.getInterceptorChain().abort();
		try {
			getConduit(message).prepare(outMessage);
			close(outMessage);
		} catch (IOException e) {
			log.warn(e.getMessage(), e);
		}
	}

	private Message getOutMessage(Message inMessage) {
		Exchange exchange = inMessage.getExchange();
		Message outMessage = exchange.getOutMessage();
		if (outMessage == null) {
			Endpoint endpoint = exchange.get(Endpoint.class);
			outMessage = endpoint.getBinding().createMessage();
			exchange.setOutMessage(outMessage);
		}
		outMessage.putAll(inMessage);
		return outMessage;
	}

	private Conduit getConduit(Message inMessage) throws IOException {
		Exchange exchange = inMessage.getExchange();
		/*EndpointReferenceType target = exchange
				.get(EndpointReferenceType.class);
		Conduit conduit = exchange.getDestination().getBackChannel(inMessage,
				null, target); en version cxf2*/
		Conduit conduit = exchange.getDestination().getBackChannel(inMessage);//en version cxf3
		exchange.setConduit(conduit);
		return conduit;
	}

	private void close(Message outMessage) throws IOException {
		OutputStream os = outMessage.getContent(OutputStream.class);
		os.flush();
		os.close();
	}
}
