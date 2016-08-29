package fr.afcepf.al28.personnel;

import java.util.*;

/**
 * 
 */
public class Productif extends Employe {

     
    

    public Productif(String nom, String prenom, Integer age) {
		super(nom, prenom, age);
		this.multiplicateur=5d;
	}



	public Integer getNb_unités() {
		return nb_unités;
	}

	public void setNb_unités(Integer nb_unités) {
		this.nb_unités = nb_unités;
	}



	/**
     * 
     */
    private Integer nb_unités;

    /**
     * 
     */
    private Double multiplicateur;

    /**
     * @return
     */
    public Double calculerSalaire() {
        return nb_unités*multiplicateur;
    }


}