package fr.afcepf.magasin.test;

import fr.afcepf.al28.pizzeria.Pizza;
import fr.afcepf.al28.pizzeria.Pizzeria;
import fr.afcepf.al28.pronto.factories.Cheesy4SaisonsFactory;
import fr.afcepf.magasin.Magasin;
import fr.afcepf.magasin.articles.Guitare;
import fr.afcepf.magasin.articles.PizzaAdapter;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Magasin mag = new Magasin();
		mag.ajouter(new Guitare(2563f, "Les Paul", "Gibson"));
		mag.ajouter(new Guitare(1546f, "Stratocaster", "Fender"));
		
		Pizzeria p = new Pizzeria();
		Pizza p1 = p.creerPizza(new Cheesy4SaisonsFactory());
		mag.ajouter(new PizzaAdapter(p1));
		
		mag.affichercatalogue();
	}

}
