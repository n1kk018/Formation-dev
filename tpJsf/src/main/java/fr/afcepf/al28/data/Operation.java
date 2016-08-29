package fr.afcepf.al28.data;

import java.util.Date;

public class Operation {
	private String label;
	private Double montant;
	/*private Date date;
	private Long numero;*/
	public Operation() {
		super();
	}
	
	public Operation(String label, Double montant) {
		super();
		this.label = label;
		this.montant = montant;
	}

	public String getLabel() {
		return label;
	}
	
	public void setLabel(String label) {
		this.label = label;
	}
	public Double getMontant() {
		return montant;
	}
	public void setMontant(Double montant) {
		this.montant = montant;
	}
}
