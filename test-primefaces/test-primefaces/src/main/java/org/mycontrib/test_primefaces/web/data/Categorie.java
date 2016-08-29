package org.mycontrib.test_primefaces.web.data;

import java.util.ArrayList;
import java.util.List;

public class Categorie {
	
	private Long number;
	private String label;
	private List<Product> products = new ArrayList<Product>();
	
	public Categorie() {
		super();
	}
	public Categorie(Long number, String label) {
		super();
		this.number = number;
		this.label = label;
	}
	
	public void addProduct(Product p){
		this.products.add(p);
	}
	public Long getNumber() {
		return number;
	}
	public void setNumber(Long number) {
		this.number = number;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	

}
