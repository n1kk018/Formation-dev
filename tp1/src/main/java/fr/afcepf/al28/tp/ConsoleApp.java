package fr.afcepf.al28.tp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConsoleApp {
	
	private static Logger logger = LoggerFactory.getLogger(ConsoleApp.class);

	public static void main(String[] args) {
		ObjetVolant ov = null;
		AvionV3 avion = new AvionV3();
		avion.addElement(new Personne("Alice",50f,50));
		avion.addElement(new Personne("Bob",50f,56));
		avion.addElement(new Personne());
		avion.addElement(new Employe("Michael",90.5f,82,2550d));
		avion.addElement(new Employe());
		avion.addElement(new Bagage(15.6f,"Valise-Michael",45));
		avion.addElement(new Bagage(20.8f,"Sac-Bob",70));
		avion.addElement(new Bagage(31.5f,"Valise-Alice",100));
		avion.setCouleur("rouge");
		avion.afficher();
		ov=avion;
		logger.info("nombre de personnes: " +Personne.getNbInstances());
		logger.info("nombre d'employés: " + Employe.getNbInstances());
		logger.info("Couleur de l'objet volant : " + ov.getCouleur());
		logger.info("Plafond objet volant en m : " + ov.getPlafond());
	}

}
