package fr.afcepf.al28.tp;

public class AvionV2 extends ObjetVolant {
	private Descriptible[] tabElements;
	private int nbElements;
	public final static int TAILLE_MAX;
		
	static{
		TAILLE_MAX=50;
		PLAFOND=22000;
	}

	public AvionV2() {
		super();
		this.nbElements = 0;
		this.tabElements = new Descriptible[TAILLE_MAX];
	}
	
	public void addElement(Descriptible element) {
		this.tabElements[this.nbElements++] = element;
	}
	
	public void afficher() {
		float chargeUtileTotale=0;
		for(int i=0;i<this.nbElements;i++) {
			System.out.println(this.tabElements[i].getDesignation());
			chargeUtileTotale += this.tabElements[i].getPoids();
		}
		System.out.println("chargeUtileTotale = "+chargeUtileTotale+" kgs");
	}

	@Override
	public Integer getPlafond() {
		return PLAFOND;
	}
	
	
}