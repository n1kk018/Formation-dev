package fr.afcepf.al28.ria.services;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.afcepf.al28.ria.dao.IDaoChien;
import fr.afcepf.al28.ria.entities.PetitChien;

@Stateless
@Path("chien")
@Produces(MediaType.APPLICATION_JSON)
public class ChienService {
    @EJB
    private IDaoChien dao;
    
    @Path("all")
    @GET
    public List<PetitChien> obtenirChiens() {
        return dao.getAllChiens();
    }
    
    @Path("id/{id}")
    @GET
    public PetitChien obtenirChien(@PathParam("id") Integer id) {
        return dao.findById(id);
    }
    
    @Path("add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Boolean ajouterChien(PetitChien chien) {
        dao.addChien(chien);
        return true;
    }
    
    @Path("del/{id}")
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    public Boolean supprimerChien(@PathParam("id") Integer id) {
         dao.deleteChien(id);
         return true;
    }
}
