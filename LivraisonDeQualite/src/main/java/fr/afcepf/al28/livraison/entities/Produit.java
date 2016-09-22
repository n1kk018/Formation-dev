package fr.afcepf.al28.livraison.entities;

import java.io.Serializable;
import java.util.List;

/**
 * Entité repésentant le Produit d'une commande.
 * @author stagiaire
 *
 */
public class Produit implements Serializable {
    /**
     * numéro de version por la sérialisation.
     */
    private static final long serialVersionUID = -3131129118537484257L;
    /**
     * identifiant unique du produit.
     */
    private Integer id;
    /**
     * nom du produit.
     */
    private String nom;
    /**
     * prix du produit.
     */
    private Float prix;
    /**
     * lignes de commande contenant produit. OneToMany
     */
    private List<LigneCommande> lignes;
    /**
     * @param paramId id.
     * @param paramNom nom.
     * @param paramPrix prix.
     */
    public Produit(Integer paramId, String paramNom, Float paramPrix) {
        super();
        id = paramId;
        nom = paramNom;
        prix = paramPrix;
    }
    /**
     * constructeur par défaut.
     */
    public Produit() {
        super();
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
     * @return the prix
     */
    public Float getPrix() {
        return prix;
    }
    /**
     * @param paramPrix the prix to set
     */
    public void setPrix(Float paramPrix) {
        prix = paramPrix;
    }
    /**
     * @return the lignes.
     */
    public List<LigneCommande> getLignes() {
        return lignes;
    }
    /**
     * @param paramLignes the lignes to set.
     */
    public void setLignes(List<LigneCommande> paramLignes) {
        lignes = paramLignes;
    }
}
