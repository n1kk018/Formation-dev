package fr.afcepf.al28.jeeapp.web.mbean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

import fr.afcepf.al28.jeeapp.ejb.api.IServiceDevise;
import fr.afcepf.al28.jeeapp.ejb.dto.DeviseDTO;
import fr.afcepf.al28.jeeapp.ejb.dto.PaysDTO;

@ManagedBean
@RequestScoped //JSF = sous partie de JEE, deja "provided" par jboss
public class DeviseMbean {
	@EJB //Injection de dépendance (comme @Autowired)
	private IServiceDevise serviceDevise;
	
	private String codeDevise;
	private DeviseDTO devise;
	
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
	}
	
	private void TestTemporaires() {
		List<DeviseDTO> listeDev = serviceDevise.toutesDevises();
		for (DeviseDTO devise : listeDev) {
			System.out.println("\t"+devise);
		}
		System.out.println("Liste des pays zone euros");
		List<PaysDTO> liste = serviceDevise.listePaysPartageantDevise("EUR");
		for (PaysDTO pays : liste) {
			System.out.println(pays + "\n");
		}
		Double sc = serviceDevise.convertir(50.0, "EUR", "USD");
		System.out.println("50 EUR = "+ sc +" USD");
	}
	public String doRechercheDevise() {
		String suite=null;
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
	public DeviseDTO getDevise() {
		return devise;
	}
}
