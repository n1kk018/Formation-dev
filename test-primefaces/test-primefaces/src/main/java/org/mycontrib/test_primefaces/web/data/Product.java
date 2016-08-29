package org.mycontrib.test_primefaces.web.data;

public class Product {
	
	private Long number;
	private String label;
	private Double prix;
	private String caracteristiques;
	
	
	public Product() {
		super();
	}
	public Product(Long number, String label, Double prix,
			String caracteristiques) {
		super();
		this.number = number;
		this.label = label;
		this.prix = prix;
		this.caracteristiques = caracteristiques;
	}
	@Override
	public String toString() {
		return "Product [number=" + number + ", label=" + label + ", prix="
				+ prix + ", caracteristiques=" + caracteristiques + "]";
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
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	public String getCaracteristiques() {
		return caracteristiques;
	}
	public void setCaracteristiques(String caracteristiques) {
		this.caracteristiques = caracteristiques;
	}
	
	

}
