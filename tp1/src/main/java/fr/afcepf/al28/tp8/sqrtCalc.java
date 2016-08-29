package fr.afcepf.al28.tp8;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class sqrtCalc {
	private static Logger logger = LoggerFactory.getLogger(sqrtCalc.class);
	
	public static void main(String[] args) {
		try {
			CalculIntermediaire calculatrice = new CalculIntermediaire();
			logger.info("Racine carrée de " + Double.parseDouble(args[0]) + " est égale à " + calculatrice.calculerRacineIntermediaire(Double.parseDouble(args[0])));
		} catch (NumberFormatException e1) {
			logger.error("Argument non numérique");
		} catch (ArrayIndexOutOfBoundsException e2) {
			logger.error("Argument manquant");
		} catch (MyArithmeticException e3) {
			logger.error(e3.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}
}
