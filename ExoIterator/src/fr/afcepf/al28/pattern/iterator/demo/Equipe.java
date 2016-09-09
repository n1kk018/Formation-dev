package fr.afcepf.al28.pattern.iterator.demo;

import java.util.ArrayList;
import java.util.Iterator;

public class Equipe implements Iterable<Joueur> {
	private String nom;
	private ArrayList<Joueur> titulaires = new ArrayList<Joueur>();
	private ArrayList<Joueur> remplacants = new ArrayList<Joueur>();
	public Equipe() {
		this.nom = "Liverpool";
		this.titulaires.add(new Joueur("bob"));
		this.titulaires.add(new Joueur("miguel"));
		this.titulaires.add(new Joueur("nour"));
		this.titulaires.add(new Joueur("abdel"));
		this.remplacants.add(new Joueur("bob2"));
		this.remplacants.add(new Joueur("miguel2"));
		this.remplacants.add(new Joueur("nour2"));
		this.remplacants.add(new Joueur("abdel2"));
	}
	
	@Override
	public Iterator<Joueur> iterator() {
		return new EquipeIterator(titulaires,remplacants);
	}
}
