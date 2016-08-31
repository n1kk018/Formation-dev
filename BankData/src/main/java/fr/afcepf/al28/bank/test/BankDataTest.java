package fr.afcepf.al28.bank.test;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.afcepf.al28.bank.dao.IDaoCompte;
import fr.afcepf.al28.bank.dao.IDaoUtilisateur;
import fr.afcepf.al28.bank.dao.IDaoOperation;
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
		Utilisateur u = dao.ajouter(new Client(null,"Sto","nikko","test","nicolastorero@gmail.com","test"));
		logger.info("*Client ajouté -->"+u);
		IDaoCompte daoc = bf.getBean(IDaoCompte.class);
		Compte cp = daoc.ajouter(new Compte(null,"Compte1",u));
		logger.info("*Compte ajouté -->"+cp);
		IDaoOperation daoop = bf.getBean(IDaoOperation.class);
		logger.info("*Credit ajouté -->"+daoop.ajouter(new Credit(null,new Date(),300.0,"Credit1",cp)));
		logger.info("*Debit ajouté -->"+daoop.ajouter(new Debit(null,new Date(),100.0,"Debit1",cp)));
		/*List<Personne> liste = dao.rechercheParNom("");
		for (Personne personne : liste) {
			logger.info("id:"+personne.getId()+"\tnom:"+personne.getNom());
			if(personne.getComptes()!=null) {
				for (Compte compte : personne.getComptes()) {
					logger.info("\t\t"+compte.getLibelle());
				}
			}
		}*/
		
		//logger.info("Id objet Personne supprimé -->"+dao.supprimer(liste.get(0)));
	}

}
