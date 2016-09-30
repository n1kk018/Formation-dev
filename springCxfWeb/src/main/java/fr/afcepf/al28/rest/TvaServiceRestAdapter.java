package fr.afcepf.al28.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.afcepf.al28.data.Tva;
import fr.afcepf.al28.service.TvaService;

@Component
@Path("tva")
@Produces("application/json")
public class TvaServiceRestAdapter {
    @Autowired // ou @EJB ou @Inject (CDI)
    private TvaService internalTvaService;
    
    @GET
    @Path("/auteur")
    @Produces("text/plain")
    public String getAuteur() {
        return internalTvaService.getAuteur();
    }
    
    @GET
    @Path("/calcul")
    public Tva calculerTva(@QueryParam("ht") Double ht, @QueryParam("tauxPct") Double tauxPct) {
        Tva tvaRes = new Tva(ht, tauxPct, ht*tauxPct/100, ht*(1+tauxPct/100));
        return tvaRes;
    }
}
