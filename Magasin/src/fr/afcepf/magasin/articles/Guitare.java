package fr.afcepf.magasin.articles;
public class Guitare extends Article{
	private String marque;

	public Guitare(Float prix, String modele, String marque) {
		super(prix, modele);
		this.marque = marque;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	@Override
	public String toString() {
		return "Guitare [marque=" + marque + ", prix=" + getPrix() + ", modele=" + getModele()+ "]";
	}

	
	
}
