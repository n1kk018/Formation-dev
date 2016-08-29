package fr.afcepf.al28.tp8;

public class SousCalcul  {
	public double calculerRacine(double x) throws IllegalArgumentException {
		if(x<0) {
			throw new IllegalArgumentException("Imppossible de calculer la racine carrée d'un nombre négatif.");
		}
		return Math.sqrt(x);
	}
}
