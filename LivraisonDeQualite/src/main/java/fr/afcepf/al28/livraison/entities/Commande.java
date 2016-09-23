package fr.afcepf.al28.livraison.entities;

import java.io.Serializable;
import java.util.Date;
/**
 * Entité repésentant la commande à préparer.
 * @author stagiaire
 *
 */
import java.util.List;
/**
 * Entité représentant la commande.
 * @author stagiaire
 *
 */
public class Commande implements Serializable {

    /**
     * id de sérialisation.
     */
    private static final long serialVersionUID = -8371973073859647816L;
    /**
     * identifiant cmd.
     */
    private Integer id;
    /**
     * Etat courant de la cmd.
     */
    private String etat;
    /**
     * date de la cmd.
     */
    private Date dateCmd;
    /**
     * {@link Preparateur} de la cmd.
     */
    private Preparateur preparateur;
    /**
     * {@link LigneCommande} de la cmd.
     */
    private List<LigneCommande> lignes;
    /**
     * @param paramId id.
     * @param paramEtat etat.
     * @param paramDateCmd date.
     * @param paramPreparateur preparateur.
     * @param paramLignes lignes.
     */
    public Commande(Integer paramId, String paramEtat, Date paramDateCmd, Preparateur paramPreparateur,
            List<LigneCommande> paramLignes) {
        super();
        id = paramId;
        etat = paramEtat;
        dateCmd = paramDateCmd;
        preparateur = paramPreparateur;
        lignes = paramLignes;
    }
    /**
     * @param paramId id.
     * @param paramEtat etat.
     * @param paramDateCmd date.
     * @param paramPreparateur preparateur.
     */
    public Commande(Integer paramId, String paramEtat, Date paramDateCmd, Preparateur paramPreparateur) {
        super();
        id = paramId;
        etat = paramEtat;
        dateCmd = paramDateCmd;
        preparateur = paramPreparateur;
    }
    /**
     * constructeur par défaut.
     */
    public Commande() {
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
     * @return the etat.
     */
    public String getEtat() {
        return etat;
    }
    /**
     * @param paramEtat the etat to set.
     */
    public void setEtat(String paramEtat) {
        etat = paramEtat;
    }
    /**
     * @return the dateCmd.
     */
    public Date getDateCmd() {
        return dateCmd;
    }
    /**
     * @param paramDateCmd the dateCmd to set.
     */
    public void setDateCmd(Date paramDateCmd) {
        dateCmd = paramDateCmd;
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
