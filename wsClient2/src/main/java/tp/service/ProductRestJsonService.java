package tp.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import tp.data.Product;
@Produces("application/json")
@Consumes("application/json")
//pas de @Path ici sur une interface (JAX-RS2)
public interface ProductRestJsonService {

	
	@GET
	@Path("/{id}")
	public abstract Product getProductById(@PathParam("id")Long id);

	@GET
	@Path("/")
	public abstract List<Product> getProductsByCriteria(@QueryParam(value="maxPrice")Float maxPrice);

	@PUT
	@Path("/{id}")
	public abstract Product updateProduct(@PathParam("id")Long id, Product p);

	@POST
	@Path("/{id}")
	//par defaut , l'objet p est passe comme un seul bloc (en mode json) dans le corps/body de la requete
	//exemple:  { id: 1 , name='xxx' , label='yyy' , ...} 
	//POST --> save/create or saveOrUpdate
	public abstract Product saveOrUpdateProduct(@PathParam("id")Long id, Product p);

	@DELETE
	@Path("/{id}")
	public abstract Response deleteProduct(@PathParam("id")Long id);

}

//NB: bien que les annotations JAX-RS placees sur l'interface (JAX-RS2 , JEE7) puissent être héritées
//par la classe d'implementation , il est preconsine (à court/moyen terme) de replacer
//celles-ci sur la classe d'implementation (pour une compatibilité avec JEE6).