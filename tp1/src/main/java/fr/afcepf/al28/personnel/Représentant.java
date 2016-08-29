package fr.afcepf.al28.personnel;

import java.util.*;

/**
 * 
 */
public class Représentant extends Commercial {

    public Représentant(String nom, String prenom, Integer age) {
		super(nom, prenom, age);
		// TODO Auto-generated constructor stub
	}

	/**
     * 
     */
    private double POURCENTAGE_REPRESENTANT = 0.25;

    /**
     * @return
     */
    public Double calculerSalaire() { 
        return this.getCa_mensuel()*POURCENTAGE_REPRESENTANT;
    }

}