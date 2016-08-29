package fr.afcepf.al28.personnel;

import java.util.*;

/**
 * 
 */
public class Personnel {

    /**
     * Default constructor
     */
    public Personnel() {
    }

    /**
     * 
     */
    private Set<Employe> employes;

    /**
     * @param in 
     * @return
     */
    public void ajouterEmploye(Employe in) {
    	if(this.employes==null) {
    		this.employes = new HashSet<Employe>();
    	}
        this.employes.add(in);
        return;
    }

    /**
     * 
     */
    public void calculerSalaires() {
        for (Employe employe : employes) {
        	StringBuilder builder = new StringBuilder();
			System.out.println(builder.append("Salaire de ")
					.append(employe)
					.append(" --> ")
					.append(employe.calculerSalaire())
					.append(" €").toString());
		}
        
    }

    /**
     * @return
     */
    public Double salaireMoyen() {
    	Double salaireTotal=0d;
    	for (Employe employe : employes) {
        	salaireTotal += employe.calculerSalaire();
		}
        return salaireTotal/this.employes.size();
    }

}