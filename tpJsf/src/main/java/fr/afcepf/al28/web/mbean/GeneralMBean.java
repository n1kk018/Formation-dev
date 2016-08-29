package fr.afcepf.al28.web.mbean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class GeneralMBean {
	private Date date;
	private String pays;
	private List<String> listePays = Arrays.asList("Allemagne","France","Italie","Espagne","Algérie","Finlande");
	
	public List<String> completePays(String p){
		List<String> suggestions = new ArrayList<String>();
		String uP = p.substring(0, 1).toUpperCase();
		if(p.length()>1) uP+=p.substring(1);
		for(String s : listePays){
			if(s.startsWith(uP))
			suggestions.add(s);
		} 
		return suggestions;
	}
	
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	} 
	
	

}
