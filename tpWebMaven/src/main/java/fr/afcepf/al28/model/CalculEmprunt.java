package fr.afcepf.al28.model;
import java.text.DecimalFormat;

public class CalculEmprunt {
	private Double montant;
	private Integer duree;
	private Double taux;
	
	private String mensualite;
	
	private String msg=""; //éventuel msg d'erreur
	
	public void calculerMensualite() {
		if(this.taux!=null && this.taux > 0){
			Double tauxMensuel = (this.taux/100)/12.0;
			int nbMois = this.duree*12;
			Double mensualite = this.montant*tauxMensuel / (1 - Math.pow(1 + tauxMensuel, -nbMois));
			DecimalFormat df = new DecimalFormat("0.00");
			this.mensualite = df.format(mensualite);
		}
	}
	
	public String getMensualite() {
		return mensualite;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getMsgHtml() {
		return "<p class=\"error\">"+this.msg+"</p>";
	}
	public Double getMontant() {
		return montant;
	}
	public void setMontant(Double montant) {
		this.montant = montant;
	}
	public Integer getDuree() {
		return duree;
	}
	public void setDuree(Integer duree) {
		this.duree = duree;
	}
	public Double getTaux() {
		return taux;
	}
	public void setTaux(Double taux) {
		this.taux = taux;
	}
}
