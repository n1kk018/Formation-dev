package fr.afcepf.al28.jeeapp.web.mbean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.naming.InitialContext;
import javax.naming.NamingException;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import fr.afcepf.al28.jeeapp.ejb.api.IServiceDevise;
import fr.afcepf.al28.jeeapp.entity.Devise;
import fr.afcepf.al28.jeeapp.entity.Pays;

@ManagedBean
@RequestScoped //JSF = sous partie de JEE, deja "provided" par jboss
public class DeviseMbean {
	@EJB //Injection de dépendance (comme @Autowired)
	private IServiceDevise serviceDevise;
	
	private String codeDevise;
	private Devise devise;
	private Logger logger = LoggerFactory.getLogger(DeviseMbean.class);
	private Marker fatal = MarkerFactory.getMarker("FATAL");
	
	@PostConstruct
	protected void iniAfterInjection() {
		//équivalent de l'annotation EJB
		/*InitialContext ic;
		try {
			ic = new InitialContext();
			serviceDevise = (IServiceDevise)ic.lookup("java:global/jeeapp-ear/jeeapp-web/ServiceDeviseBean");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //javax.naming(JNDI)
		*/
		logger.info("Hello world!"+serviceDevise);
	}
	
	private void TestTemporaires() {
		List<Devise> listeDev = serviceDevise.toutesDevises();
		for (Devise devise : listeDev) {
			logger.info("\t"+devise);
			System.out.println("\t"+devise);
		}
		System.out.println("Liste des pays zone euros");
		List<Pays> liste = serviceDevise.listePaysPartageantDevise("EUR");
		for (Pays pays : liste) {
			System.out.println(pays + "\n");
		}
		Double sc = serviceDevise.convertir(50.0, "EUR", "USD");
		System.out.println("50 EUR = "+ sc +" USD");
	}
	public String doRechercheDevise() {
		String suite=null;
		logger.info("\t"+devise);
		TestTemporaires();
		devise = serviceDevise.rechercherDevise(codeDevise);
		return suite;
	}
	public String getCodeDevise() {
		return codeDevise;
	}
	public void setCodeDevise(String codeDevise) {
		this.codeDevise = codeDevise;
	}
	public Devise getDevise() {
		return devise;
	}
	public void setDevise(Devise devise) {
		this.devise = devise;
	}
	
	
}
