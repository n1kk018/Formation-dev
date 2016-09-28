package fr.afcepf.al28.rmi.client;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import fr.afcepf.al28.jeeapp.ejb.api.IServiceDevise;


public class clientRmiApp {

    public static void main(String[] args) {
        try {
            Properties props = new Properties();
            props.put(Context.INITIAL_CONTEXT_FACTORY,
                    "org.jboss.naming.remote.client.InitialContextFactory");
                    props.put(Context.PROVIDER_URL, "remote://localhost:4447");
                    // remote://localhost:4447 for Jboss7.1 , http-remoting://localhost:8080 for wildfly 8,9
                    props.put(Context.SECURITY_PRINCIPAL, "guest"); // username : "admin" , "guest" , "..."
                    props.put(Context.SECURITY_CREDENTIALS, "guest007"); //password : "pwd", "guest007"
                    //avec utilisateur ajouté via la commande JBOSS_7_HOME/bin/add-user
                    //et roles associés admin,guest,.... sur partie "ApplicationRealm" .
                    props.put("jboss.naming.client.ejb.context", true); //indispensable pour accès @Remote
                    Context jndiContext = new InitialContext(props);
                    String jndiName = "jeeapp-ear/jeeapp-ejb-impl/ServiceDeviseBean!fr.afcepf.al28.jeeapp.ejb.api.IServiceDevise";
                    // sans "ejb:" et sans // pour version de jndiName sans jboss-ejb-client.properties et sans
                    // props.setProperty(Context.URL_PKG_PREFIXES,"org.jboss.ejb.client.naming");
                    IServiceDevise ejbDevise = (IServiceDevise) jndiContext.lookup(jndiName);
                    System.out.println("30 euros= " + ejbDevise.convertir(30.0,"EUR","USD") + " dollars");
        }
            catch (NamingException e){
                e.printStackTrace();
            }
    }

}
