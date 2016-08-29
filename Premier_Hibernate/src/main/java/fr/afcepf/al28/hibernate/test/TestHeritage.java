package fr.afcepf.al28.hibernate.test;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import fr.afcepf.al28.hibernate.entity.Compte;
import fr.afcepf.al28.hibernate.entity.Personne;
import fr.afcepf.al28.hibernate.heritage.Etudiant;
import fr.afcepf.al28.hibernate.heritage.Formateur;
import fr.afcepf.al28.hibernate.util.HibernateUtil;

public class TestHeritage {
	private static Logger logger = LoggerFactory.getLogger(TestHeritage.class);
	private static Marker fatal = MarkerFactory.getMarker("FATAL");
	
	public static void main(String[] args) {
		logger.info("debut methode");
		Session session = null;
		Transaction tx = null;
		try{
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			Formateur f1 = new Formateur(null,"prof","seb","3 rue Danton",new Date(),3500.0);
			Formateur f2 = new Formateur(null,"prof","remy","3 rue Danton",new Date(),2670.0);
			Formateur f3 = new Formateur(null,"prof","paul","3 rue Danton",new Date(),3200.0);
			Etudiant e1 = new Etudiant(null,"etudiant1","etudiant1","3 rue Danton",new Date(),"AL28");
			Etudiant e2 = new Etudiant(null,"etudiant2","etudiant2","3 rue Danton",new Date(),"AL28");
			Etudiant e3 = new Etudiant(null,"etudiant3","etudiant3","3 rue Danton",new Date(),"AL28");
			session.save(f1);
			session.save(f2);
			session.save(f3);
			session.save(e1);
			session.save(e2);
			session.save(e3);
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
