package fr.afcepf.al28.patterns.decorateur;

import java.util.ArrayList;

public abstract class Supplement implements ICustomizable {
	
	private ICustomizable composant;
	
	public Supplement(ICustomizable composant) {
		this.composant = composant;
	}

	@Override
	public ArrayList<String> getComposition() {
		return composant.getComposition();
	}

	@Override
	public Float getPrix() {
		return composant.getPrix();
	}

}
