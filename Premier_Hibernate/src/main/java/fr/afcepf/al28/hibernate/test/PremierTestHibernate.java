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
import fr.afcepf.al28.hibernate.entity.Operation;
import fr.afcepf.al28.hibernate.util.HibernateUtil;


public class PremierTestHibernate {
	private static Logger logger = LoggerFactory.getLogger(PremierTestHibernate.class);
	private static Marker fatal = MarkerFactory.getMarker("FATAL");
	
	public static void main(String[] args) {
		logger.info("debut methode");
		Session session = null;
		Transaction tx = null;
		try{
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			/*Personne pers = new Personne(null, "hib", "hib", "102 rue du test", new Date());
			session.save(pers);*/
			//logger.info(pers.getId().toString());
			Personne pers3=(Personne) session.get(Personne.class,3);
			logger.info(pers3.getNom()+ "\t"+pers3.getPrenom());
			pers3.setNom("toto");
			Compte cpt = new Compte(null,"compte 1",pers3);
			session.save(cpt);
			Operation op1 = new Operation(null,1000.0,"Crédit",cpt);
			Operation op2 = new Operation(null,25.25,"Débit",cpt);
			Operation op3 = new Operation(null,1256.15,"Crédit",cpt);
			Operation op4 = new Operation(null,526.58,"Débit",cpt);
			session.save(op1);
			session.save(op2);
			session.save(op3);
			session.save(op4);
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
		logger.info("fin methode");
	}

}
