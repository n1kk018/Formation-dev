package fr.afcepf.al28.ria.services;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.afcepf.al28.ria.dao.IDaoChien;
import fr.afcepf.al28.ria.entities.PetitChien;

@Stateless
@Path("premier")
public class Premierservice {
        @EJB
        private IDaoChien dao;
        
        @Path("salut")
        @GET
        @Produces(MediaType.APPLICATION_JSON)
        public String methodeSalut() {
            dao.addChien(new PetitChien(null,"yuki","shiba", new Date()));
            return "salut salut salut";
        }
        
        @Path("chien")
        @GET
        @Produces(MediaType.APPLICATION_JSON)
        public PetitChien methodeChien() {
            return new PetitChien(1,"medor","labrador", new Date());
        }
}
