package fr.afcepf.al28.ria.entities;

import java.io.Serializable;

import java.util.Date;

import javax.ejb.Local;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PetitChien implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private String race;
    private Date date_naissance;
    /**
     * 
     */
    public PetitChien() {
        super();
    }
    /**
     * @param paramId
     * @param paramNom
     * @param paramRace
     * @param paramDate_naissance
     */
    public PetitChien(Integer paramId, String paramNom, String paramRace, Date paramDate_naissance) {
        super();
        id = paramId;
        nom = paramNom;
        race = paramRace;
        date_naissance = paramDate_naissance;
    }
    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }
    /**
     * @param paramId the id to set
     */
    public void setId(Integer paramId) {
        id = paramId;
    }
    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }
    /**
     * @param paramNom the nom to set
     */
    public void setNom(String paramNom) {
        nom = paramNom;
    }
    /**
     * @return the race
     */
    public String getRace() {
        return race;
    }
    /**
     * @param paramRace the race to set
     */
    public void setRace(String paramRace) {
        race = paramRace;
    }
    /**
     * @return the date_naissance
     */
    public Date getDate_naissance() {
        return date_naissance;
    }
    /**
     * @param paramDate_naissance the date_naissance to set
     */
    public void setDate_naissance(Date paramDate_naissance) {
        date_naissance = paramDate_naissance;
    }
    
    
}
