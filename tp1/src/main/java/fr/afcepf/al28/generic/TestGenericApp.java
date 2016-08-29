package fr.afcepf.al28.generic;

import fr.afcepf.al28.tp.ConsoleApp;
import fr.afcepf.al28.tp.Personne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestGenericApp {
	
	private static Logger logger = LoggerFactory.getLogger(ConsoleApp.class);

	public static void main(String[] args) {
		PersonneDao personneDao = new PersonneDaoImpl();
		personneDao.insertEntity(new Personne("p1",75f,42));
		personneDao.insertEntity(new Personne("p2",21f,8));
		Personne p3 = new Personne("p3",68f,63);
		personneDao.insertEntity(p3);
		personneDao.insertEntity(new Personne("p4",61f,28));
		personneDao.updateEntity(new Personne("p4",61f,30));
		personneDao.deleteEntity(p3);
		
		for(Personne p : personneDao.recherchePersonnesMajeures()) {
			logger.info(p.toString());
		}

	}

}
