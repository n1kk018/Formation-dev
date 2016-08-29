package fr.afcepf.al28.personnel;

import java.util.*;

/**
 * 
 */
public abstract class Employe {

    /**
     * Default constructor
     */
    public Employe() {
    }

    /**
     * 
     */
    private String nom;

    /**
     * 
     */
    private String prenom;

    /**
     * 
     */
    private Integer age;

    /**
     * @return
     */
    public String toString() {
        return "L'employé "+" "+this.nom+" "+this.prenom+ " - "+this.age+ " ans ";
    }

    public Employe(String nom, String prenom, Integer age) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
	}

	/**
     * @return
     */
    public abstract Double calculerSalaire();

}