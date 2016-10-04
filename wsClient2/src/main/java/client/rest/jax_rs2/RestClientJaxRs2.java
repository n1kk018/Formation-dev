package client.rest.jax_rs2;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.jackson.JacksonFeature;

import tp.data.Product;

public class RestClientJaxRs2 {

	public static void main(String[] args) {
		basicTest();
		testJsonProductRestWs();
	}
	
	public static void testJsonProductRestWs(){
		Client jaxrs2client = ClientBuilder.newClient()
				             .register(JacksonFeature.class);
		WebTarget productsTarget = jaxrs2client.target("http://localhost:8080/wsCalculateur/services/rest/json/products");
		Long pk=null;
		Product savedProd =null;
		
		//Test creation/insert:
		Product newProd = new Product(null,"prodXy","prod Xy with good features",12.89f);//tp.data
		Response responseSaveNewProduct = productsTarget
				.path("/0") //for "POST" as "save new /insert" (not "update")
				.request(MediaType.APPLICATION_JSON_TYPE)
				.post(Entity.entity(newProd, MediaType.APPLICATION_JSON_TYPE) );
		if(responseSaveNewProduct.getStatus()==200){
			//OK:
			//String savedProductAsJsonString = responseSaveNewProduct.readEntity(String.class);
			savedProd = responseSaveNewProduct.readEntity(Product.class);
			pk=savedProd.getId();
			System.out.println("(saved) new product with auto_incremented pk =  " + pk
			                   + "\n\t " + savedProd.toString());
		}else{
			System.err.println(responseSaveNewProduct);
		}
		
		
		// test "retreive all" (with new one):
		Invocation.Builder productsInvocationBuilder = productsTarget.request(MediaType.APPLICATION_JSON_TYPE);
		Response responseAllProducts = productsInvocationBuilder.get();
		if(responseAllProducts.getStatus()==200){
			//OK:
			System.out.println("All products as (json) string =\n\t " + responseAllProducts.readEntity(String.class));
		}
		

		//Test update:
		savedProd.setLabel("*** new label ***");
		Product updatedProd = productsTarget.path(String.valueOf(pk)).request(MediaType.APPLICATION_JSON_TYPE)
		              .post(Entity.entity(savedProd,MediaType.APPLICATION_JSON_TYPE),Product.class);
		System.out.println("new updated label of product = \n\t" + updatedProd.getLabel());
		
		//Test delete:
		System.out.println("status of suppression/delete : \n\t " + productsTarget.path(String.valueOf(pk)).request().delete().toString());
		
		//Test failure of getByPrimaryKey (to verify delete):
		if(productsTarget.path(String.valueOf(pk)).request(MediaType.APPLICATION_JSON_TYPE).get().getStatus()==204){
			System.out.println("produit bien supprimé");
		}
		
	}
	
	
	public static void basicTest(){	
		Client jaxrs2client = ClientBuilder.newClient();
		WebTarget allDevisesJsonTarget = jaxrs2client.target("http://localhost:8080/wsCalculateur/services/rest/devises").path("allJson");
		String resultString = allDevisesJsonTarget.request().get(String.class);
		System.out.println("liste des devises:\n\t " +resultString);
		
		
		String calculateurRestUrl = "http://localhost:8080/wsCalculateur/services/rest/calculateur"; 
		double a=5.0 , b=6.0;
		System.out.println("appel de " + calculateurRestUrl +"/addition?a=5&b=6");
		WebTarget additionTarget = jaxrs2client.target(calculateurRestUrl)
				                               .path("addition")
				                               .queryParam("a", a)
				                               .queryParam("b", b);
		double resAdd = Double.parseDouble(additionTarget.request(MediaType.TEXT_PLAIN_TYPE).get().readEntity(String.class));
		System.out.println("\t 5+6=" + resAdd);
		
		
		String euroToFrancRestUrl="http://localhost:8080/wsCalculateur/services/rest/devises/euroToFranc" ;
		double sommeEuro= 15.0;
		System.out.println("appel de " + euroToFrancRestUrl +"/15");
		WebTarget euroToFrancTarget = jaxrs2client.target(euroToFrancRestUrl)
				                                  .path(String.valueOf(sommeEuro));
		double sommeFranc = Double.parseDouble(euroToFrancTarget.request(MediaType.TEXT_PLAIN_TYPE).get().readEntity(String.class));
		System.out.println("\t 15 euros =" + sommeFranc + "francs");
	}

}

/*
 * MediaType.APPLICATION_JSON is "application/json" as String , MediaType.APPLICATION_JSON_TYPE is same value as MediaType
 */
