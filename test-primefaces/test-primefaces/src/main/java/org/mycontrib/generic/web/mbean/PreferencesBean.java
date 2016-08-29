package org.mycontrib.generic.web.mbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class PreferencesBean {
	
  
	
	public String theme;
	
	public PreferencesBean(){
		theme="aristo"; //default primeFaces THEME
	}

	public String getTheme() {
		return theme;
	}
	

	public void setTheme(String theme) {
		this.theme = theme;
		System.out.println("set new theme : " + theme);
	}
	
	//listener a mettre au point:
	public void saveTheme() {  
		System.out.println("saveTheme() called");
         
    } 
	
	
	

}
