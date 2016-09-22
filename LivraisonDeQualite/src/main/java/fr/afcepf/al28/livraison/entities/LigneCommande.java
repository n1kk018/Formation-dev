package fr.afcepf.al28.livraison.entities;

import java.io.Serializable;
/**
 * Entité repésentant une ligne dans une commande.
 * @author stagiaire
 *
 */
public class LigneCommande implements Serializable {

    /**
     * numéro de version por la sérialisation.
     */
    private static final long serialVersionUID = 4250437708236534810L;
    /**
     * identifiant de la ligne.
     */
    private Integer id;
    /**
     * quantité du produit.
     */
    private Integer qte;
    /**
     * produit associé a la ligne.
     */
    private Produit produit;
    /**
     * commande contenat la ligne.
     */
    private Commande cmd;
    /**
     * @param paramId id.
     * @param paramQte qte.
     * @param paramProduit produit.
     * @param paramCmd commande.
     */
    public LigneCommande(Integer paramId, Integer paramQte, Produit paramProduit, Commande paramCmd) {
        super();
        id = paramId;
        qte = paramQte;
        produit = paramProduit;
        cmd = paramCmd;
    }
    /**
     * constructeur par défaut.
     */
    public LigneCommande() {
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
     * @return the qte.
     */
    public Integer getQte() {
        return qte;
    }
    /**
     * @param paramQte the qte to set.
     */
    public void setQte(Integer paramQte) {
        qte = paramQte;
    }
    /**
     * @return the produit.
     */
    public Produit getProduit() {
        return produit;
    }
    /**
     * @param paramProduit the produit to set.
     */
    public void setProduit(Produit paramProduit) {
        produit = paramProduit;
    }
    /**
     * @return the cmd.
     */
    public Commande getCmd() {
        return cmd;
    }
    /**
     * @param paramCmd the cmd to set.
     */
    public void setCmd(Commande paramCmd) {
        cmd = paramCmd;
    }
}
