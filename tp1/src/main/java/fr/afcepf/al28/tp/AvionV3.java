package fr.afcepf.al28.tp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AvionV3 extends ObjetVolant implements Serializable{
	private static final long serialVersionUID = 1L;
	private List<Descriptible> listeElements;

	static{
		PLAFOND=25000;
	}

	public AvionV3() {
		super();
		this.listeElements = new ArrayList<Descriptible>() ;
	}
	
	public void addElement(Descriptible element) {
		this.listeElements.add(element);
	}
	
	public void afficher() {
		float chargeUtileTotale=0;
		for (Descriptible descriptible : listeElements) {
			System.out.println(descriptible.getDesignation());
			chargeUtileTotale += descriptible.getPoids();
		}
		System.out.println("Nombre d'éléments = "+this.listeElements.size());
		System.out.println("chargeUtileTotale = "+chargeUtileTotale+" kgs");
	}

	@Override
	public Integer getPlafond() {
		return PLAFOND;
	}
	
	
}