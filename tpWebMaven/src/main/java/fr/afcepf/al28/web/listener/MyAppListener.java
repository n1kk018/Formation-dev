package fr.afcepf.al28.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class MyAppListener
 *
 */
@WebListener
public class MyAppListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public MyAppListener() {
        // TODO Auto-generated constructor stub
    }

	public void contextInitialized(ServletContextEvent e) {
		// initialisation au chargement/démarrage de l'application WEB
		ServletContext application = e.getServletContext();
		Integer objCompteur = new Integer(1);
		application.setAttribute("compteur", objCompteur);
	}

	public void contextDestroyed(ServletContextEvent e) {
		// terminaison lors de l'arrêt de l'application WEB
		ServletContext application = e.getServletContext();
		Integer objCompteur = (Integer) application.getAttribute("compteur");
		System.out.println("compteur:" + objCompteur.intValue());
	}

}
