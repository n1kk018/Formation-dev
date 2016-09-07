
public class Test {

	public static void main(String[] args) {
		VoitureDirecteur dirlo = new VoitureDirecteur();
		Voiture v1 = dirlo.construire(new F1Builder());
		Voiture v2 = dirlo.construire(new BerlineBuilder());
		Voiture v3 = dirlo.construire(new SUVBuilder());
		Voiture v4 = dirlo.construire(new BerlineBuilder());
		System.out.println(v1);
		System.out.println(v2);
		System.out.println(v3);
		System.out.println(v4);
	}

}
