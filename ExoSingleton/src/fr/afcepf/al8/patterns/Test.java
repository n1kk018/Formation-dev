package fr.afcepf.al8.patterns;

public class Test {

	public static void main(String[] args) {
		for (int i = 0; i < 19; i++) {
			MonThread t = new MonThread();
			t.start();
		}
		DistributeurTicket d2 = DistributeurTicket.getInstance();
		System.out.println(d2.getNumero());
		System.out.println(d2.getNumero());
		System.out.println(d2.getNumero());
	}

}
