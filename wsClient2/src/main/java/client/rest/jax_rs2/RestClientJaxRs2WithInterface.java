package client.rest.jax_rs2;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.jersey.client.proxy.WebResourceFactory;
import org.glassfish.jersey.jackson.JacksonFeature;

import tp.data.Product;
import tp.service.ProductRestJsonService;

public class RestClientJaxRs2WithInterface {

	public static void main(String[] args) {
		
		testJsonProductRestWsWithInterface();
	}
	
	public static void testJsonProductRestWsWithInterface(){
		Client jaxrs2client = ClientBuilder.newClient()
				             .register(JacksonFeature.class);
		WebTarget productsTarget = jaxrs2client.target("http://localhost:8080/wsCalculateur/services/rest/json/products");
		Long pk=null;
		Product savedProd =null;
		
		// create a new client proxy for the ProductRestJsonService
		ProductRestJsonService productRestJsonProxyService = WebResourceFactory.newResource(ProductRestJsonService.class, productsTarget);
	
		Product prod1 = productRestJsonProxyService.getProductById(1L); 
		System.out.println("prod1 (retreived by getProductById):" + prod1.toString());
		
		//Test creation/insert:
		Product newProd = new Product(null,"prodXy","prod Xy with good features",12.89f);//tp.data
		savedProd = productRestJsonProxyService.saveOrUpdateProduct(0L, newProd); //0L for new product to saved
		pk=savedProd.getId();
		System.out.println("new product saved : " + savedProd);
		//Test update:
		savedProd.setLabel("*** new label ***");
		Product updatedProd = productRestJsonProxyService.saveOrUpdateProduct(pk, savedProd);
		System.out.println("new updated label of product = \n\t" + updatedProd.getLabel());
		
		//Test delete:
		System.out.println("status of suppression/delete : " +productRestJsonProxyService.deleteProduct(pk).toString());
		
		//Test getProductsByCriteria (cheap Product):
		List<Product> listProd =  productRestJsonProxyService.getProductsByCriteria(323.0f);
		System.out.println("liste des produits à moins de 323 euros:\n");
		for(Product prod : listProd){
			System.out.println("\t" + prod);
		}
		
				
		}

}
