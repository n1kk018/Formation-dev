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
import fr.afcepf.al28.hibernate.entity.Personne;
import fr.afcepf.al28.hibernate.util.HibernateUtil;

public class TestRequetes {
private static Logger logger = LoggerFactory.getLogger(TestAssociations.class);
private static Marker fatal = MarkerFactory.getMarker("FATAL"); 
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		logger.info("debut methode");
		Session session = null;
		Transaction tx = null;
		try{
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			/*Query sql =session.createSQLQuery("select id,nom,prenom,adresse,naissance from personne");
			List<Object[]> result = sql.list();
			for(Object[] obj:result){
				logger.info(obj[0]+"\t"+obj[1]+"\t"+obj[2]);				
			}*/
			logger.info("--- HQL ---");
			Query hql = session.createQuery("SELECT p FROM Personne p WHERE p.nom=:name")
								.setParameter("name", "toto");
			List<Personne> result2 = hql.list();
			for (Personne p:result2) {
				logger.info(p.toString());
				for(Compte cpt:p.getComptes()){
					logger.info("\t\t"+cpt.toString());
					for(Operation op:cpt.getOperations()){
						logger.info("\t\t"+op.toString());
					}
				}
			}
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
