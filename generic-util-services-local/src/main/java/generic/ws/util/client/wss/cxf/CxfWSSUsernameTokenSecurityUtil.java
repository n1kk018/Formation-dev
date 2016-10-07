package generic.ws.util.client.wss.cxf;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.wss4j.common.ext.WSPasswordCallback; // cxf3
import org.apache.wss4j.dom.WSConstants; // cxf3
import org.apache.wss4j.dom.handler.WSHandlerConstants; // cxf3
/*
import org.apache.ws.security.WSConstants; // cxf2
import org.apache.ws.security.WSPasswordCallback; // cxf2
import org.apache.ws.security.handler.WSHandlerConstants; // cxf2
*/



public class CxfWSSUsernameTokenSecurityUtil {

    private String login=null;
    private String pwd=null;
    
    /*classe imbriquee:*/
    public class ClientPasswordCallback implements CallbackHandler {
    	 
        public void handle(Callback[] callbacks) throws IOException,
            UnsupportedCallbackException {
     
            WSPasswordCallback pc = (WSPasswordCallback) callbacks[0];
     
            // set the password for our message.
            pc.setPassword(pwd);
           }
    }
    /*fin classe imbriquee*/
    
    
    public void setLogin(String login) {
		this.login = login;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public CxfWSSUsernameTokenSecurityUtil() {
		super();
    }
	
    public CxfWSSUsernameTokenSecurityUtil(String login, String pwd) {
		super();
		this.login = login;
		this.pwd = pwd;
	}
    
    public void setWssSecurityViaCxf(Object wsProxy){
    	
		Map<String,Object> outProps = new HashMap<String,Object>();
		outProps.put(WSHandlerConstants.ACTION, WSHandlerConstants.USERNAME_TOKEN);
		// Specify our username
		outProps.put(WSHandlerConstants.USER, login);
		// Password type : plain text
		outProps.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
		// for hashed password use:
		//properties.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_DIGEST);
		// Callback used to retrieve password for given user.
		//outProps.put(WSHandlerConstants.PW_CALLBACK_CLASS,ClientPasswordCallback.class.getName()); with problem on inner class
		outProps.put(WSHandlerConstants.PW_CALLBACK_REF,new ClientPasswordCallback()); //ok on inner class
		
		
		WSS4JOutInterceptor wssOut = new WSS4JOutInterceptor(outProps);
		
		org.apache.cxf.endpoint.Client client = ClientProxy.getClient(wsProxy);
		org.apache.cxf.endpoint.Endpoint cxfEndpoint = client.getEndpoint();
		cxfEndpoint.getOutInterceptors().add(wssOut);		
    }
    

	}
