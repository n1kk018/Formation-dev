package fr.afcepf.al28.hibernate.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import fr.afcepf.al28.hibernate.entity.Compte;
import fr.afcepf.al28.hibernate.entity.Personne;
import fr.afcepf.al28.hibernate.util.HibernateUtil;

public class TestAssociations {
	private static Logger logger = LoggerFactory.getLogger(TestAssociations.class);
	private static Marker fatal = MarkerFactory.getMarker("FATAL");
	
	public static void main(String[] args) {
		logger.info("debut methode");
		Session session = null;
		Transaction tx = null;
		try{
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			Compte compte = (Compte) session.get(Compte.class, 1);
			logger.info(compte.toString());
			Personne pers = compte.getPers();
			logger.info(pers.toString());
			tx.commit();
		}catch (HibernateException e) {
			logger.error(fatal,"Pb lors de l'exécution du traitement : "+e.getMessage());
			tx.rollback();
		} finally {
			try{
				session.close();
			} catch (HibernateException e) {
				logger.error(fatal,"Pb de connexion au serveur de données");
			}
			
		}
	}

}
