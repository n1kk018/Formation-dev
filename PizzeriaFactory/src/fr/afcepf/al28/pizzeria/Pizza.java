package fr.afcepf.al28.pizzeria;

public class Pizza 
{
	Pate pate;
	boolean estCuite=false;
	Garniture garniture;
	
	public void Cuire() 
	{
		estCuite=true;
		System.out.println("Cuisson de la pizza");
	}

	public Pate getPate() 
	{
		return pate;
	}

	public void setPate(Pate pate) 
	{
		System.out.println("Pate : " + pate);
		this.pate = pate;
	}

	public Garniture getGarniture() 
	{
		return garniture;
	}

	public void setGarniture(Garniture garniture) 
	{
		System.out.println("Garniture : "+garniture);
		this.garniture = garniture;
	}
}
