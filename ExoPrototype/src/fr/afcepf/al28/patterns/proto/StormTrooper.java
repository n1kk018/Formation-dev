package fr.afcepf.al28.patterns.proto;

public class StormTrooper extends Soldier {
	protected int munitions;
	protected int obeissance;
	
	public StormTrooper() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.munitions=42;
		this.numeroSerie=1;
		this.hauteur=180;
		this.largeur=80;
		this.obeissance=99;
		this.poids=75;
		System.out.println("Creation stormtrooper OK");
	}

	@Override
	public String toString() {
		return "StormTrooper [munitions=" + munitions + ", obeissance=" + obeissance + ", numeroSerie=" + numeroSerie
				+ ", poids=" + poids + ", hauteur=" + hauteur + ", largeur=" + largeur + "]";
	}
	
	
}
