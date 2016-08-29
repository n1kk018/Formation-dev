package fr.afcepf.al28.web.mbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.event.ValueChangeEvent;

import fr.afcepf.al28.data.Operation;

@ManagedBean
@RequestScoped
public class OperationMBean {
	private List<Operation> listeOperations;
	
	private Long numCptSel;
	
	public void initOperations(ComponentSystemEvent event) {
		chargerOperations();
	}
	
	public void onNumCptChange(ValueChangeEvent event){
		this.numCptSel = (Long)event.getNewValue();
		chargerOperations();
	}
	
	public void chargerOperations(){
		this.listeOperations = new ArrayList<Operation>();
		this.listeOperations.add(new Operation("op 1 (paye) du compte n°" + this.numCptSel, 2500.0));
		this.listeOperations.add(new Operation("op 2 (achat) du compte n°" + this.numCptSel, -82.0));
	}
	
	public String recupererOperations(){
		this.chargerOperations();		
		return "operations";
	}

	public Long getNumCptSel() {
		return numCptSel;
	}

	public void setNumCptSel(Long numCptSel) {
		this.numCptSel = numCptSel;
	}

	public List<Operation> getListeOperations() {
		return listeOperations;
	}
}
