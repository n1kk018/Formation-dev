package fr.afcepf.al28.tp;

public class AvionV1 extends ObjetVolant {
	private Personne[] tabElements;
	private int nbElements;
	public final static int TAILLE_MAX;
		
	static{
		TAILLE_MAX=50;
		PLAFOND=10000;
	}

	public AvionV1() {
		super();
		this.nbElements = 0;
		this.tabElements = new Personne[TAILLE_MAX];
	}
	
	public void addElement(Personne element) {
		this.tabElements[this.nbElements++] = element;
	}
	
	public void initialiser() {
		this.addElement(new Personne("Alice",50f,50));
		this.addElement(new Personne("Bob",50f,56));
		this.addElement(new Personne());
		this.addElement(new Employe("Michael",90.5f,82,2550d));
		this.addElement(new Employe());
	}
	
	public void afficher() {
		for(int i=0;i<this.nbElements;i++) {
			System.out.println(this.tabElements[i].getDesignation());
		}
	}

	@Override
	public Integer getPlafond() {
		return PLAFOND;
	}
	
	
}