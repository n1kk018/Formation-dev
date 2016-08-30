package fr.afcepf.al28.hibernate.test;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.afcepf.al28.hibernate.dao.IDaoPersonne;
import fr.afcepf.al28.hibernate.entity.Personne;
import fr.afcepf.al28.hibernate.entity.Compte;

public class SpringHibernateTest {
	private static Logger logger = LoggerFactory.getLogger(SpringHibernateTest.class);
	private static Marker fatal = MarkerFactory.getMarker("FATAL");

	public static void main(String[] args) {
		BeanFactory bf = new ClassPathXmlApplicationContext("classpath:spring.xml");
		IDaoPersonne dao = bf.getBean(IDaoPersonne.class);
		//logger.info("Objet Personne ajouté -->"+dao.ajouter(new Personne(null, "Storero", "Nicolas", "73 avenue de la république", new Date())));
		List<Personne> liste = dao.rechercheParNom("");
		for (Personne personne : liste) {
			logger.info("id:"+personne.getId()+"\tnom:"+personne.getNom());
			if(personne.getComptes()!=null) {
				for (Compte compte : personne.getComptes()) {
					logger.info("\t\t"+compte.getLibelle());
				}
			}
		}
		
		//logger.info("Id objet Personne supprimé -->"+dao.supprimer(liste.get(0)));
	}

}
