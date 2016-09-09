package fr.afcepf.al28.patterns.decorateur.supplement;

import java.util.ArrayList;

import fr.afcepf.al28.patterns.decorateur.ICustomizable;
import fr.afcepf.al28.patterns.decorateur.Supplement;

public class Anchois extends Supplement {
	public Anchois(ICustomizable composant) {
		super(composant);
	}
	
	@Override
	public ArrayList<String> getComposition() {
		ArrayList<String> compo = super.getComposition();
		compo.add("Anchois");
		return compo;
	}

	@Override
	public Float getPrix() {
		return super.getPrix() + 1f;
	}
}
