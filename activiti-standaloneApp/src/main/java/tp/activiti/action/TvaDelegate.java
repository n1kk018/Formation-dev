package tp.activiti.action;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.activiti.engine.delegate.DelegateExecution;
import org.glassfish.jersey.jackson.JacksonFeature;

import tp.activiti.data.Commande;
import tp.activiti.data.Tva;

public class TvaDelegate {
    public void doTvaAction(DelegateExecution execution) {
        Client jaxrs2client = ClientBuilder.newClient().register(JacksonFeature.class);
        Commande c = (Commande) execution.getVariable("commande");
        String calculTvaRestUrl = "http://localhost:8080/springCxfWeb/services/rest/tva"; 
        double ht=c.getPrixTotalHt(), tauxPct=20.0;
        System.out.println("appel de " + calculTvaRestUrl +"/calcul?ht=200&tauxPct=20");
        WebTarget calculTvaTarget = jaxrs2client.target(calculTvaRestUrl)
                                               .path("calcul")
                                               .queryParam("ht", ht)
                                               .queryParam("tauxPct", tauxPct);
        Tva resAsJavaObj = calculTvaTarget.request(MediaType.APPLICATION_JSON_TYPE).get().readEntity(Tva.class);
        System.out.println("\t res="+ resAsJavaObj.toString());
        c.setPrixTotalTtc(resAsJavaObj.getTtc());
    }

}
