package fr.afcepf.al28.patterns.decorateur.test;

import fr.afcepf.al28.patterns.decorateur.ICustomizable;
import fr.afcepf.al28.patterns.decorateur.Pizza;
import fr.afcepf.al28.patterns.decorateur.supplement.Anchois;
import fr.afcepf.al28.patterns.decorateur.supplement.Boite;
import fr.afcepf.al28.patterns.decorateur.supplement.PeanutButter;

public class Test {

	public static void main(String[] args) {
		ICustomizable maPizza=new Boite(
								new PeanutButter(
										new Anchois(
												new Pizza("Napolitaine",12.5f))));
		System.out.println(maPizza.getPrix());
		for (String string : maPizza.getComposition()) {
			System.out.println("- "+string);
		}
	}

}
