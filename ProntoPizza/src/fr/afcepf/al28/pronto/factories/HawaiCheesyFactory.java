package fr.afcepf.al28.pronto.factories;

import fr.afcepf.al28.pizzeria.Garniture;
import fr.afcepf.al28.pizzeria.IPizzaFactory;
import fr.afcepf.al28.pizzeria.Pate;
import fr.afcepf.al28.pronto.garnitures.GarnitureHawai;
import fr.afcepf.al28.pronto.pates.PateCheesy;

public class HawaiCheesyFactory implements IPizzaFactory {

	@Override
	public Pate creerPate() {
		// TODO Auto-generated method stub
		return new PateCheesy();
	}

	@Override
	public Garniture creerGarniture() {
		// TODO Auto-generated method stub
		return new GarnitureHawai();
	}

}
