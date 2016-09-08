package fr.afcepf.magasin.articles;

import fr.afcepf.al28.pizzeria.Pizza;

public class PizzaAdapter extends Article {
	private Pizza pizza;

	public PizzaAdapter(Pizza pizza) {
		super(12.5f,pizza.getPate()+ " "+pizza.getGarniture());
		this.pizza = pizza;
	}

	@Override
	public String toString() {
		return "Pizza [prix=" + getPrix() + ", modele=" + getModele() + "]";
	}
	
	
}
