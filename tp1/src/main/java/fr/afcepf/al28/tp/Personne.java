package fr.afcepf.al28.tp;

import java.io.Serializable;

import fr.afcepf.al28.reflection.MyId;

public class Personne implements Descriptible, Comparable<Personne>, Serializable {
	private static final long serialVersionUID = 1L;
	//attributs
	
	@MyId
	private String nom;
	private Float poids;
	private Integer age;
	private static int nbInstances=0;
		
	//constructeurs
	public Personne() {
		nbInstances++;
		this.nom = "john doe";
		this.poids = 100f;
		this.age = 55;
	}
	
	public Personne(String nom, Float poids, Integer age) {
		nbInstances++;
		this.nom = nom;
		this.poids = poids;
		this.age = age;
	}
	
	//accesseurs
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Float getPoids() {
		return poids;
	}
	public void setPoids(Float poids) {
		this.poids = poids;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	//m�thodes
	public static int getNbInstances() {
		return nbInstances;
	}
	

	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", poids=" + poids + ", age=" + age + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((poids == null) ? 0 : poids.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Personne other = (Personne) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (poids == null) {
			if (other.poids != null)
				return false;
		} else if (!poids.equals(other.poids))
			return false;
		return true;
	}
	
	@Override
	protected void finalize() {
		nbInstances--;
	}

	@Override
	public String getDesignation() {
		return this.toString();
	}

	@Override
	public int compareTo(Personne o) {
		return this.getNom().compareTo(o.getNom());
	}
	
}
