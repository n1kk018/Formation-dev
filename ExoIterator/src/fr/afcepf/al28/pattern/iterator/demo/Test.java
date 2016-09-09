package fr.afcepf.al28.pattern.iterator.demo;

public class Test {

	public static void main(String[] args) {
		Equipe e = new Equipe();
		for (Joueur joueur : e) {
			System.out.println(joueur.toString());
		}

	}

}
