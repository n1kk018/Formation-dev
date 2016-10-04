package fr.afcepf.al28.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.afcepf.al28.data.TauxTva;
import fr.afcepf.al28.data.Tva;
import fr.afcepf.al28.service.TvaService;

@Component
@Path("/tva")
@Produces("application/json")
@CrossOriginResourceSharing(allowAllOrigins=true)
public class TvaServiceRestAdapter {
    @Autowired // ou @EJB ou @Inject (CDI)
    private TvaService internalTvaService;
    
    @GET
    @Path("/auteur")
    @Produces("text/plain")
    public String getAuteur() {
        return internalTvaService.getAuteur();
    }
    
    @POST
    @Consumes("application/json")
    @Path("/taux/{id}")
    public TauxTva saveOrUpdateTauxTva(@PathParam("id")Long id, TauxTva t){
        System.out.println(t);
        return t;
    }
    
    @GET
    @Path("/calcul")
    public Tva calculerTva(@QueryParam("ht") Double ht, @QueryParam("tauxPct") Double tauxPct) {
        Tva tvaRes = new Tva(ht, tauxPct, ht*tauxPct/100, ht*(1+tauxPct/100));
        return tvaRes;
    }
}
