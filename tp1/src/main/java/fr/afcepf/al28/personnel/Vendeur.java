package fr.afcepf.al28.personnel;

import java.util.*;

/**
 * 
 */
public class Vendeur extends Commercial {

    

   

	public Vendeur(String nom, String prenom, Integer age) {
		super(nom, prenom, age);
		// TODO Auto-generated constructor stub
	}

	/**
     * 
     */
    private double POURCENTAGE_VENDEUR = 0.2;

    /**
     * @return
     */
    public Double calculerSalaire() {
        return this.getCa_mensuel()*POURCENTAGE_VENDEUR;
    }

}