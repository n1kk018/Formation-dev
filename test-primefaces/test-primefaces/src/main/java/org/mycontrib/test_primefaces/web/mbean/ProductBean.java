package org.mycontrib.test_primefaces.web.mbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;

import org.mycontrib.test_primefaces.web.data.Categorie;
import org.mycontrib.test_primefaces.web.data.Product;

@ManagedBean
@SessionScoped
public class ProductBean {
	
	private List<Categorie> categories = new ArrayList<Categorie>();
	private List<Product> products = null; //of selectedCat
	
	private Long selectedProdNum = null; //produit courant
	private Product selectedProd = null;
	
	private Long selectedCatNum = null; //categorie courante
	private Categorie selectedCat = null;
	
	private Product chooseProd = null; //a ajouter dans un panier par exemple
	
	private void setSelectCatAndProductListFromSelectedCatNum(){
		this.selectedCat=null;
		for(Categorie c : this.categories){
			if(c.getNumber().equals(selectedCatNum)){
				this.selectedCat=c; 
				this.products = c.getProducts();
				this.selectedProd=null;
				break;
			}
		}
	}
	
	private void setSelectProdFromNum(){
		this.selectedProd=null;
		for(Product p : this.selectedCat.getProducts()){
			if(p.getNumber().equals(selectedProdNum)){
				this.selectedProd=p;
				break;
			}
		}
	}
	
	//categorie ListBox valueChangeListener:
	public void onCategorieChange(ValueChangeEvent event){
		if(event != null){
			Object selValue = event.getNewValue();
			if(selValue!=null){
				selectedCatNum = (Long) selValue;
				setSelectCatAndProductListFromSelectedCatNum();
			}
		}
	}
	//products ListBox valueChangeListener:
	public void onProductChange(ValueChangeEvent event){
		if(event != null){
			Object selValue = event.getNewValue();
			if(selValue!=null){
				selectedProdNum = (Long) selValue;
				setSelectProdFromNum();
			}
		}
	}
	
	//commandButton action:
	public String doSelection(){
		chooseProd=selectedProd;
		return null;
	}
	
	public ProductBean(){
		Categorie c1 = new Categorie(1L, "livres");
		c1.addProduct(new Product(1L, "livre1", 20.1, "auteur=xxx1 , editeur=yyy1"));
		c1.addProduct(new Product(2L, "livre2", 30.2, "auteur=xxx2 , editeur=yyy2"));
		c1.addProduct(new Product(3L, "livre3", 15.8, "auteur=xxx3 , editeur=yyy3"));
		this.categories.add(c1);
		
		Categorie c2 = new Categorie(2L, "CD");
		c2.addProduct(new Product(101L, "CD1", 12.8, "musique=xxx1 , interprete=yyy1"));
		c2.addProduct(new Product(102L, "CD2", 19.2, "musique=xxx2 , interprete=yyy2"));
		c2.addProduct(new Product(103L, "CD3", 30.5, "musique=xxx3 , interprete=yyy3"));
		this.categories.add(c2);
		
		Categorie c3 = new Categorie(3L, "Film (DVD)");
		c3.addProduct(new Product(201L, "film1", 22.8, "producteur=xxx1 , acteur=yyy1"));
		c3.addProduct(new Product(202L, "film2", 14.2, "producteur=xxx2 , acteur=yyy2"));
		c3.addProduct(new Product(203L, "film3", 8.5, "producteur=xxx3 , acteur=yyy3"));
		this.categories.add(c3);
	}

	public List<Categorie> getCategories() {
		return categories;
	}

	public void setCategories(List<Categorie> categories) {
		this.categories = categories;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product getSelectedProd() {
		return selectedProd;
	}

	public void setSelectedProd(Product selectedProd) {
		this.selectedProd = selectedProd;
	}

	public Categorie getSelectedCat() {
		return selectedCat;
	}

	public void setSelectedCat(Categorie selectedCat) {
		this.selectedCat = selectedCat;
	}
	
	public Long getSelectedCatNum() {
		return selectedCatNum;
	}

	public void setSelectedCatNum(Long selectedCatNum) {
		this.selectedCatNum = selectedCatNum;
	}

	public Long getSelectedProdNum() {
		return selectedProdNum;
	}

	public void setSelectedProdNum(Long selectedProdNum) {
		this.selectedProdNum = selectedProdNum;
	}

	public Product getChooseProd() {
		return chooseProd;
	}

	public void setChooseProd(Product chooseProd) {
		this.chooseProd = chooseProd;
	}
	
	
	
}
