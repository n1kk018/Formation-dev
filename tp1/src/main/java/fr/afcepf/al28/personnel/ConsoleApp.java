package fr.afcepf.al28.personnel;

public class ConsoleApp {

	public static void main(String[] args) {
		Personnel p = new Personnel();
		Commercial r1 = new Représentant("rep","un",75);
		r1.setCa_mensuel(12000d);
		p.ajouterEmploye(r1);
		Commercial v1 = new Vendeur("vnd","un",42);
		v1.setCa_mensuel(15000d);
		p.ajouterEmploye(v1);
		Productif p1 = new Productif("prod", "un", 36);
		p1.setNb_unités(500);
		p.ajouterEmploye(p1);
		Productif p2 = new ProductifRisque("prod", "deux", 56);
		p2.setNb_unités(500);
		p.ajouterEmploye(p2);
		Manutentionnaire m1 = new Manutentionnaire("manut", "un", 23);
		m1.setNb_heures(175.5f);
		p.ajouterEmploye(m1);
		Manutentionnaire m2 = new ManutRisque("manut", "deux", 29);
		m2.setNb_heures(179f);
		p.ajouterEmploye(m2);
		
		p.calculerSalaires();
		System.out.println(p.salaireMoyen());
	}
	
	

}
