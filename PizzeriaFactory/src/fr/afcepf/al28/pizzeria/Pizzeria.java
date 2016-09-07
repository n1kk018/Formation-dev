package fr.afcepf.al28.pizzeria;

public class Pizzeria 
{
	public Pizza creerPizza(IPizzaFactory pf)
	{
		Pizza resultat = new Pizza();
		
		resultat.setGarniture(pf.creerGarniture());
		resultat.setPate(pf.creerPate());
		resultat.Cuire();
		
		return resultat;
	}
}
