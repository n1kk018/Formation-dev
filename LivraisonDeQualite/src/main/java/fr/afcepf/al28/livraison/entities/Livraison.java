package fr.afcepf.al28.livraison.entities;

import java.io.Serializable;
import java.util.Date;
/**
 * Entité représentnat la livraison.
 * @author stagiaire
 *
 */
public class Livraison implements Serializable {

    /**
     * id de sérialisation.
     */
    private static final long serialVersionUID = 6212921658933961616L;
    /**
     * identifitant cmd.
     */
    private Integer id;
    /**
     * date départ de la commande.
     */
    private Date dateDepart;
    /**
     * date d'arrivée de la commande.
     */
    private Date dateArrivee;
    /**
     * {@link Preparateur} de la commande.
     */
    private Preparateur preparateur;
    /**
     * {@link Livreur} de la commande.
     */
    private Livreur livreur;
    /**
     * {@link Commande} .
     */
    private Commande cmd;

    /**
     * @param paramId id.
     * @param paramDateDepart date départ.
     * @param paramDateArrivee date arrivée.
     * @param paramPreparateur preparateur.
     * @param paramLivreur livreur.
     */
    public Livraison(Integer paramId, Date paramDateDepart, Date paramDateArrivee, Preparateur paramPreparateur,
            Livreur paramLivreur) {
        super();
        id = paramId;
        dateDepart = paramDateDepart;
        dateArrivee = paramDateArrivee;
        preparateur = paramPreparateur;
        livreur = paramLivreur;
    }
    /**
     * @param paramId id.
     * @param paramDateDepart date départ.
     * @param paramDateArrivee date arrivée.
     * @param paramPreparateur preparateur.
     * @param paramLivreur livreur.
     * @param paramCmd cmd.
     */
    public Livraison(Integer paramId, Date paramDateDepart, Date paramDateArrivee, Preparateur paramPreparateur,
            Livreur paramLivreur, Commande paramCmd) {
        super();
        id = paramId;
        dateDepart = paramDateDepart;
        dateArrivee = paramDateArrivee;
        preparateur = paramPreparateur;
        livreur = paramLivreur;
        cmd = paramCmd;
    }

    /**
     * constructur par défaut.
     */
    public Livraison() {
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
     * @return the dateDépart.
     */
    public Date getDateDepart() {
        return dateDepart;
    }
    /**
     * @param paramDateDepart the dateDepart to set.
     */
    public void setDateDepart(Date paramDateDepart) {
        dateDepart = paramDateDepart;
    }
    /**
     * @return the dateArrivee.
     */
    public Date getDateArrivee() {
        return dateArrivee;
    }
    /**
     * @param paramDateArrivee the dateArrivee to set.
     */
    public void setDateArrivee(Date paramDateArrivee) {
        dateArrivee = paramDateArrivee;
    }
    /**
     * @return the preparateur.
     */
    public Preparateur getPreparateur() {
        return preparateur;
    }
    /**
     * @param paramPreparateur the preparateur to set.
     */
    public void setPreparateur(Preparateur paramPreparateur) {
        preparateur = paramPreparateur;
    }
    /**
     * @return the livreur.
     */
    public Livreur getLivreur() {
        return livreur;
    }
    /**
     * @param paramLivreur the livreur to set.
     */
    public void setLivreur(Livreur paramLivreur) {
        livreur = paramLivreur;
    }
    /**
     * @return the cmd
     */
    public Commande getCmd() {
        return cmd;
    }
    /**
     * @param paramCmd the cmd to set
     */
    public void setCmd(Commande paramCmd) {
        cmd = paramCmd;
    }
}
