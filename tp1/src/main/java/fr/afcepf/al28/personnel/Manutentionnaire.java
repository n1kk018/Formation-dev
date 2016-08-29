package fr.afcepf.al28.personnel;

import java.util.*;

/**
 * 
 */
public class Manutentionnaire extends Employe {

    public Float getNb_heures() {
		return nb_heures;
	}

	public void setNb_heures(Float nb_heures) {
		this.nb_heures = nb_heures;
	}

	public Manutentionnaire(String nom, String prenom, Integer age) {
		super(nom, prenom, age);
		this.taux_horaire=20d;
		// TODO Auto-generated constructor stub
	}

	/**
     * 
     */
    private Float nb_heures;

    /**
     * 
     */
    private Double taux_horaire;

    /**
     * @return
     */
    public Double calculerSalaire() {
        return nb_heures*taux_horaire;
    }

}