package fr.afcepf.al8.patterns;

public class MonThread extends Thread
{
	public void run() {
		DistributeurTicket d1 = DistributeurTicket.getInstance();
		System.out.println(d1.getNumero());
		System.out.println(d1.getNumero());
		System.out.println(d1.getNumero());
	}
}
