package fr.afcepf.al28.patterns.decorateur.supplement;

import java.util.ArrayList;

import fr.afcepf.al28.patterns.decorateur.ICustomizable;
import fr.afcepf.al28.patterns.decorateur.Supplement;

public class Boite extends Supplement {
	public Boite(ICustomizable composant) {
		super(composant);
	}
	
	@Override
	public ArrayList<String> getComposition() {
		ArrayList<String> compo = super.getComposition();
		compo.add("Boite en toncar");
		return compo;
	}

	@Override
	public Float getPrix() {
		return super.getPrix()+3f;
	}
}
