package org.mycontrib.test_primefaces.web.mbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.DualListModel;


@ManagedBean
@SessionScoped
public class PickListBean {
	
	private DualListModel<String> cities;  
	
	public PickListBean(){
		 //Cities  
        List<String> citiesSource = new ArrayList<String>();  
        List<String> citiesTarget = new ArrayList<String>();  
          
        citiesSource.add("Paris");  
        citiesSource.add("Bordeaux");  
        citiesSource.add("Lyon");  
        citiesSource.add("Marseille");  
        citiesSource.add("Lille"); 
        citiesSource.add("Nantes");
        citiesSource.add("Toulouse");
          
        cities = new DualListModel<String>(citiesSource, citiesTarget); 
	}

	public DualListModel<String> getCities() {
		return cities;
	}

	public void setCities(DualListModel<String> cities) {
		this.cities = cities;
	}
	
	

}
