package org.mycontrib.test_primefaces.web.mbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.mycontrib.test_primefaces.web.data.User;
import org.primefaces.event.FlowEvent;

@ManagedBean
@SessionScoped
public class WizardBean {
	
    private User user = new User();
	
    private Boolean skipOptions=false;
	private String options;
	
	private boolean confirmation;
	
	
	public String onFlowProcess(FlowEvent event){
		//NB: new/old step = id of p:tab in p:wizard
		//dans cet exemple coordStep , optionStep , confirmStep
		
		String suite=event.getNewStep(); //par defaut
		System.out.println("current wizard step:" + event.getOldStep());
		System.out.println("next step:" + event.getNewStep());
		if(event.getOldStep().equals("coordStep") && event.getNewStep().equals("optionStep") && skipOptions == true )
			suite = "confirmStep";
		return suite;
	}
	
	public String confirmer(){
		System.out.println("confirmation:" + this.confirmation);
		return null;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public String getOptions() {
		return options;
	}


	public void setOptions(String options) {
		this.options = options;
	}


	public boolean isConfirmation() {
		return confirmation;
	}


	public void setConfirmation(boolean confirmation) {
		this.confirmation = confirmation;
	}


	public Boolean getSkipOptions() {
		return skipOptions;
	}


	public void setSkipOptions(Boolean skipOptions) {
		this.skipOptions = skipOptions;
	}
	
	
	
	

}
