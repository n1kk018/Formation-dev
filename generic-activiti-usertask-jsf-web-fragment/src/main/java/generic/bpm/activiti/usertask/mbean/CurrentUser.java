package generic.bpm.activiti.usertask.mbean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Named
@Component
@Scope(value="session")
public class CurrentUser {
	
	private String username="kermit";//by default

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
	

}
