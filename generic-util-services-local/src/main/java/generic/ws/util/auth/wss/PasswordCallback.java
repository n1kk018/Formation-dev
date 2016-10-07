package generic.ws.util.auth.wss;

import generic.util.auth.AuthManager;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.wss4j.common.ext.WSPasswordCallback; // cxf 3

//import org.apache.ws.security.WSPasswordCallback; // cxf 2



public class PasswordCallback implements CallbackHandler
{
	
    private AuthManager authManager;
	
	//@Required (spring injection)
	public void setAuthManager(AuthManager authManager) {
		this.authManager = authManager;
	}

    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException
    {
        WSPasswordCallback pc = (WSPasswordCallback) callbacks[0];
        // WSPasswordCallback is an indirect dependency of cxf-rt-ws-security 

        String username = pc.getIdentifier();
        String validPwdToCompare = authManager.getValidPasswordForUser(username);
        pc.setPassword(validPwdToCompare);
        /*
        if (pc.getIdentifier().equals("user1"))
        {
            pc.setPassword("pwd1");
        }
        else if (pc.getIdentifier().equals("user2"))
        {
            pc.setPassword("pwd2");
        }*/
    }
}
