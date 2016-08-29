package fr.afcepf.al28.hibernate.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import fr.afcepf.al28.hibernate.entity.Compte;
import fr.afcepf.al28.hibernate.entity.Operation;
import fr.afcepf.al28.hibernate.util.HibernateUtil;

public class TestRequetesAssociations {
	private static Logger logger = LoggerFactory.getLogger(TestRequetesAssociations.class);
	private static Marker fatal = MarkerFactory.getMarker("FATAL"); 
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		logger.info("debut methode");
		Session session = null;
		Transaction tx = null;
		try{
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			Query hql = session.createQuery("SELECT op FROM Operation op WHERE op.type='Débit' AND op.compte.pers.id=3");
			List<Operation> result = hql.list();
			for (Operation operation : result) {
				logger.info(operation.toString());
			}
			Query hql2 = session.createQuery("SELECT pers.comptes FROM Personne pers WHERE pers.id=3");
			List<Compte> result2 = hql2.list();
			for (Compte cpt : result2) {
				logger.info(cpt.toString());
			}
			tx.commit();
		}catch (Exception e) {
			logger.error(fatal,"Pb lors de l'exécution du traitement : "+e.getMessage());
			tx.rollback();
		} finally {
			try{
				session.close();
			} catch (Exception e) {
				logger.error(fatal,"Pb de connexion au serveur de données");
			}
			
		}

	}

}
