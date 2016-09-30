package fr.afcepf.al28.rmi.client;

import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import fr.afcepf.al28.jeeapp.ejb.api.IServiceDevise;
import fr.afcepf.al28.jeeapp.ejb.dto.DeviseDTO;
import fr.afcepf.al28.jeeapp.ejb.dto.PaysDTO;


public class clientRmiApp {

    public static void main(String[] args) {     
        try {
            Properties props = new Properties();
            props.put(Context.INITIAL_CONTEXT_FACTORY,"org.jboss.naming.remote.client.InitialContextFactory");
            props.put(Context.PROVIDER_URL, "remote://localhost:4447");
            // remote://localhost:4447 for Jboss7.1 , http-remoting://localhost:8080 for wildfly 8,9
            props.put(Context.SECURITY_PRINCIPAL, "nikko"); // username : "admin" , "guest" , "..."
            props.put(Context.SECURITY_CREDENTIALS, "%Nikko12"); //password : "pwd", "guest007"
            //avec utilisateur ajouté via la commande JBOSS_7_HOME/bin/add-user
            //et roles associés admin,guest,.... sur partie "ApplicationRealm" .
            props.put("jboss.naming.client.ejb.context", true); //indispensable pour accès @Remote
            Context jndiContext = new InitialContext(props);
            String jndiName = "jeeapp-ear/jeeapp-ejb-impl/ServiceDeviseBean!fr.afcepf.al28.jeeapp.ejb.api.IServiceDevise";
            // sans "ejb:" et sans // pour version de jndiName sans jboss-ejb-client.properties et sans
            // props.setProperty(Context.URL_PKG_PREFIXES,"org.jboss.ejb.client.naming");
            IServiceDevise ejbDevise = (IServiceDevise) jndiContext.lookup(jndiName);
            System.out.println("30 euros= " + ejbDevise.convertir(30.0,"EUR","USD") + " dollars");
            System.out.println(ejbDevise.rechercherDevise("JPY"));
            List<DeviseDTO> list = ejbDevise.toutesDevises();
            System.out.println("Toutes les devises : ");
            for (DeviseDTO deviseDTO : list) {
                System.out.println(deviseDTO);
            }
            List<PaysDTO> list2 = ejbDevise.listePaysPartageantDevise("EUR");
            System.out.println("Tous les pays en euros: ");
            for (PaysDTO paysDTO : list2) {
                System.out.println(paysDTO);
            }    
        }
        catch (NamingException e){
            e.printStackTrace();
        }
    }

}
