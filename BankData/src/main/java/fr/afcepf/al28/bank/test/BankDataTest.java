package fr.afcepf.al28.bank.test;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.afcepf.al28.bank.dao.impl.IDaoCompte;
import fr.afcepf.al28.bank.dao.impl.IDaoOperation;
import fr.afcepf.al28.bank.dao.impl.IDaoUtilisateur;
import fr.afcepf.al28.bank.entity.Client;
import fr.afcepf.al28.bank.entity.Compte;
import fr.afcepf.al28.bank.entity.Credit;
import fr.afcepf.al28.bank.entity.Debit;
import fr.afcepf.al28.bank.entity.Utilisateur;

public class BankDataTest {
	private static Logger logger = LoggerFactory.getLogger(BankDataTest.class);
	private static Marker fatal = MarkerFactory.getMarker("FATAL");

	public static void main(String[] args) {
		BeanFactory bf = new ClassPathXmlApplicationContext("classpath:springData.xml");
		IDaoUtilisateur dao = bf.getBean(IDaoUtilisateur.class);
		Utilisateur u = dao.insert(new Client(null,"Sto","nikko","test","nicolastorero@gmail.com","test"));
		logger.info("*Client ajouté -->"+u);
		IDaoCompte daoc = bf.getBean(IDaoCompte.class);
		Compte cp1 = daoc.insert(new Compte(null,"Compte1",u));
		Compte cp2 = daoc.insert(new Compte(null,"Compte2",u));
		logger.info("*Compte ajouté -->"+cp1);
		logger.info("*Compte ajouté -->"+cp2);
		IDaoOperation daoop = bf.getBean(IDaoOperation.class);
		logger.info("*Credit ajouté -->"+daoop.insert(new Credit(null,new Date(),300.0,"Credit1",cp1)));
		logger.info("*Debit ajouté -->"+daoop.insert(new Debit(null,new Date(),100.0,"Debit1",cp1)));
		logger.info("Virement -->"+daoop.doTransfer(cp1, 100.0, cp2));
	}

}
