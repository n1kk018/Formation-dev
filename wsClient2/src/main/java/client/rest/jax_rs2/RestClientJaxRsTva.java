package client.rest.jax_rs2;

import java.io.IOException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.jackson.JacksonFeature;

import com.fasterxml.jackson.databind.ObjectMapper;

import tp.data.Product;
import tp.data.Tva;

public class RestClientJaxRsTva {

	public static void main(String[] args) {
		basicTest();
	}
	
	
	
	
	public static void basicTest(){	
		Client jaxrs2client = ClientBuilder.newClient().register(JacksonFeature.class);
	
		String calculTvaRestUrl = "http://localhost:8080/springCxfWeb/services/rest/tva"; 
		double ht=200.0 , tauxPct=20.0;
		System.out.println("appel de " + calculTvaRestUrl +"/calcul?ht=200&tauxPct=20");
		WebTarget calculTvaTarget = jaxrs2client.target(calculTvaRestUrl)
				                               .path("calcul")
				                               .queryParam("ht", ht)
				                               .queryParam("tauxPct", tauxPct);
		//String resAsString = calculTvaTarget.request(MediaType.APPLICATION_JSON_TYPE).get().readEntity(String.class);
	    Tva resAsJavaObj = calculTvaTarget.request(MediaType.APPLICATION_JSON_TYPE).get().readEntity(Tva.class);

		//System.out.println("\t res=" + resAsString);
	    System.out.println("\t res=" + resAsJavaObj);
		
		/*ObjectMapper mapperJavaJson = new ObjectMapper();
		try {
            Tva tvaObj = mapperJavaJson.readValue(resAsString, Tva.class);
            System.out.println("res java" + tvaObj.toString());
        } catch (IOException paramE) {
            // TODO Auto-generated catch block
            paramE.printStackTrace();
        }*/
	}

}

/*
 * MediaType.APPLICATION_JSON is "application/json" as String , MediaType.APPLICATION_JSON_TYPE is same value as MediaType
 */
