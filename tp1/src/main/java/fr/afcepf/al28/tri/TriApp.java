package fr.afcepf.al28.tri;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.afcepf.al28.tp.ConsoleApp;
import fr.afcepf.al28.tp.Personne;

public class TriApp {
	
	private static Logger logger = LoggerFactory.getLogger(ConsoleApp.class);

	public static void main(String[] args) {
		(new TriApp()).testTri();
	}
	
	private void testTri() {
		List<Personne> listeP = new ArrayList<Personne>();
		listeP.add(new Personne("bb",78f,5));	
		listeP.add(new Personne("aa",72f,25));
		listeP.add(new Personne("zz",74f,35));
		listeP.add(new Personne("dd",96f,45));
		/*classe anonyme new Comparator<Personne>(){
		@Override
		public int compare(Personne o1, Personne o2) {
			return o1.getAge()-o2.getAge();
		}
		});*/
		logger.info("Tri par age");
		Collections.sort(listeP,(p1, p2)->p1.getAge()-p2.getAge()); 
		for (Personne personne : listeP) {
			logger.info(personne.toString());
		}
		logger.info("Tri par poids");
		Collections.sort(listeP,(p1, p2)->(int)(p1.getPoids()-p2.getPoids())); 
		for (Personne personne : listeP) {
			logger.info(personne.toString());
		}
		logger.info("Filtrage des personnes majeures");
		listeP.stream().filter((p)->p.getAge()>=18)
					   .forEach((p)->logger.info(p.toString()));
	}
	
	/*private class ComparatorPersSelonAge implements Comparator<Personne> {
		@Override
		public int compare(Personne o1, Personne o2) {
			return o1.getAge()-o2.getAge();
		}
	}*/
}

