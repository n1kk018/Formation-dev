package fr.afcepf.al28.tp;

import java.io.Serializable;

public class Bagage implements Descriptible,Serializable {
	private static final long serialVersionUID = 1L;
	private Float poids;
	private String label;
	private Integer volume;
	
	public Bagage(Float poids, String label, Integer volume) {
		super();
		this.poids = poids;
		this.label = label;
		this.volume = volume;
	}

	@Override
	public String getDesignation() {
		return this.toString();
		
	}

	@Override
	public Float getPoids() {
		return this.poids;
	}
	
	public Integer getVolume() {
		return volume;
	}

	public void setVolume(Integer volume) {
		this.volume = volume;
	}
	
	public String toString() {
		return "Bagage [label=" + this.label + ", poids=" + this.poids + " kgs, age=" + this.volume + " L]";
		
	}

}
