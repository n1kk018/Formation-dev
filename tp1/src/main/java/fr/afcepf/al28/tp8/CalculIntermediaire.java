package fr.afcepf.al28.tp8;

public class CalculIntermediaire {
	public double calculerRacineIntermediaire(double x) throws MyArithmeticException {
		SousCalcul calculatrice = new SousCalcul();
		double res =0;
		try {
			res=calculatrice.calculerRacine(x);;
		} catch (IllegalArgumentException e) {
			System.out.println("IllegalArgumentException raised");
			throw new MyArithmeticException(e.getMessage());
		}
		return res;
	}
}
