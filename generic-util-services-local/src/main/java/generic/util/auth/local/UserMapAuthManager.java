package generic.util.auth.local;

import generic.util.auth.AuthManager;

import java.util.Map;

import org.apache.log4j.Logger;

public class UserMapAuthManager implements AuthManager {
	
	protected Logger log = Logger.getLogger(getClass());
	/** Map of allowed users to this system with their corresponding passwords. */
	private Map<String, String> users;

	public void setUsers(Map<String, String> users) {
		this.users = users;
	}
	

	@Override
	public String getValidPasswordForUser(String username) {
		String validPwd=null;
		try {
			validPwd = users.get(username);
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
