package fr.afcepf.al28.personnel;

import java.util.*;

/**
 * 
 */
public abstract class Commercial extends Employe {

    

	public Commercial(String nom, String prenom, Integer age) {
		super(nom, prenom, age);
	}

	/**
     * 
     */
    private Double ca_mensuel;

    public Double getCa_mensuel() {
		return ca_mensuel;
	}

	public void setCa_mensuel(Double ca_mensuel) {
		this.ca_mensuel = ca_mensuel;
	}

	/**
     * @return
     */
    public abstract Double calculerSalaire();

}