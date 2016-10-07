package generic.util.auth.local;

import generic.util.auth.AuthManager;

import org.apache.log4j.Logger;
import org.springframework.security.core.userdetails.UserDetailsService;

public class SpringSecurityUserSerciceAuthManagerAdapter implements AuthManager  {
	
	private UserDetailsService userDetailsService; //of spring-security
	
	
	//for spring injection
	public void setUserDetailsService(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	protected Logger log = Logger.getLogger(getClass());
	
	@Override
	public String getValidPasswordForUser(String username) {
		String validPwd=null;
		try {
			validPwd = userDetailsService.loadUserByUsername(username).getPassword();
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
		}
		return validPwd;
	}

	@Override
	public Boolean verifyAuth(String username, String password) {
		Boolean res = null;
		String validPwd = getValidPasswordForUser(username);
		if(validPwd==null)
			res=false;
		else if(validPwd.equals(password))
			res=true;
		else res=false;
		return res;
	}

}
