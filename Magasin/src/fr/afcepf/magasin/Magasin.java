package fr.afcepf.magasin;

import java.util.ArrayList;
import java.util.List;

import fr.afcepf.magasin.articles.Article;

public class Magasin {
	private List<Article> catalogue = new ArrayList<Article>();
	
	public void ajouter(Article a){
		catalogue.add(a);
	}
	
	
	public void affichercatalogue(){
		for (Article article : catalogue) {
			System.out.println(article);
		}
	}
}
