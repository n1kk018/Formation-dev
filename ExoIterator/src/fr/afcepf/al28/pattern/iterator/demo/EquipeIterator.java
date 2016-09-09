package fr.afcepf.al28.pattern.iterator.demo;

import java.util.ArrayList;
import java.util.Iterator;

public class EquipeIterator implements Iterator<Joueur> {
	
	private ArrayList<Joueur> titulaires;
	private ArrayList<Joueur> remplacants;
	private int posCur;

	public EquipeIterator(ArrayList<Joueur> titulaires,ArrayList<Joueur> remplacants) {
		this.titulaires = titulaires;
		this.remplacants = remplacants;
		this.posCur = 0;
	}

	@Override
	public boolean hasNext() {
		return (posCur<titulaires.size()+remplacants.size());
	}

	@Override
	public Joueur next() 
	{
		Joueur j = null;
		if(posCur<titulaires.size()){
			j = titulaires.get(posCur);
		} else {
			j=remplacants.get(posCur - titulaires.size());
		}
		posCur++;
		return j;
	}

}
