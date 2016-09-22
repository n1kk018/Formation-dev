package fr.afcepf.al28.livraison.entities;

import java.io.Serializable;
/**
 * Entité représentant le livreur de commandes.
 * @author stagiaire
 *
 */
public class Livreur implements Serializable {

    /**
     * id de sérialisation.
     */
    private static final long serialVersionUID = -5703813021289131732L;
    /**
     * identifiant unique.
     */
    private Integer id;
    /**
     * nom du {@link Livreur}.
     */
    private String nom;
    /**
     * prenom du {@link Livreur}.
     */
    private String prenom;
    /**
     * @param paramId id.
     * @param paramNom nom.
     * @param paramPrenom prenom.
     */
    public Livreur(Integer paramId, String paramNom, String paramPrenom) {
        super();
        id = paramId;
        nom = paramNom;
        prenom = paramPrenom;
    }
    /**
     * constructeur par défaut.
     */
    public Livreur() {
        super();
    }
    /**
     * @return the id.
     */
    public Integer getId() {
        return id;
    }
    /**
     * @param paramId the id to set.
     */
    public void setId(Integer paramId) {
        id = paramId;
    }
    /**
     * @return the nom.
     */
    public String getNom() {
        return nom;
    }
    /**
     * @param paramNom the nom to set.
     */
    public void setNom(String paramNom) {
        nom = paramNom;
    }
    /**
     * @return the prenom.
     */
    public String getPrenom() {
        return prenom;
    }
    /**
     * @param paramPrenom the prenom to set.
     */
    public void setPrenom(String paramPrenom) {
        prenom = paramPrenom;
    }
}
