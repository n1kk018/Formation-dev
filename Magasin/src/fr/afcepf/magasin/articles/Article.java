package fr.afcepf.magasin.articles;
public class Article {
	private Float prix;
	private String modele;
	public Article(Float prix, String modele) {
		super();
		this.prix = prix;
		this.modele = modele;
	}
	
	public Float getPrix() {
		return prix;
	}

	public void setPrix(Float prix) {
		this.prix = prix;
	}

	public String getModele() {
		return modele;
	}
	public void setModele(String modele) {
		this.modele = modele;
	}
	@Override
	public String toString() {
		return "Article [prix=" + prix + ", modele=" + modele + "]";
	}
	
	
}
