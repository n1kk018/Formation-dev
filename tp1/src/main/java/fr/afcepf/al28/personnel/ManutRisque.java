package fr.afcepf.al28.personnel;

import java.util.*;

/**
 * 
 */
public class ManutRisque extends Manutentionnaire implements EmployeRisque {

   

    public ManutRisque(String nom, String prenom, Integer age) {
		super(nom, prenom, age);
		// TODO Auto-generated constructor stub
	}

	public Double calculerSalaire() {
		return super.calculerSalaire()+PRIME;
	}

}