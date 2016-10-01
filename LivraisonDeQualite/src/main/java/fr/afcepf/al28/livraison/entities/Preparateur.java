package fr.afcepf.al28.livraison.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entité représentant le préparateur de commandes.
 * @author stagiaire
 *
 */
@Entity
@Table(name = "preparateur")
public class Preparateur implements Serializable {

    /**
     * id de sérialisation.
     */
    private static final long serialVersionUID = -365073514262865327L;
    /**
     * id unique.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_preparateur")
    private Integer id;
    /**
     * nom.
     */
    @Column(name = "nom_preparateur", nullable = false, length = 45)
    private String nom;
    /**
     * login.
     */
    @Column(name = "login_preparateur", nullable = false, length = 45)
    private String login;
    /**
     * mdp.
     */
    @Column(name = "password_preparateur", nullable = false, length = 45)
    private String mdp;
    /**
     * listes des {@link Commande} preparees .
     */
    @Transient
    private List<Commande> commandesPreparees;
    /**
     * liste des {@link Livraison} creees.
     */
    @Transient
    private List<Livraison> livraisonCreees;
    /**
     * @param paramId id.
     * @param paramNom nom.
     * @param paramLogin login.
     * @param paramMdp mdp.
     */
    public Preparateur(Integer paramId, String paramNom, String paramLogin, String paramMdp) {
        super();
        id = paramId;
        nom = paramNom;
        login = paramLogin;
        mdp = paramMdp;
    }
    /**
     * @param paramId id.
     * @param paramNom nom.
     * @param paramLogin login.
     * @param paramMdp mdp.
     * @param paramCommandesPreparees commandes préparées.
     * @param paramLivraisonCreees livraisons créées.
     */
    public Preparateur(Integer paramId, String paramNom, String paramLogin, String paramMdp,
            List<Commande> paramCommandesPreparees, List<Livraison> paramLivraisonCreees) {
        super();
        id = paramId;
        nom = paramNom;
        login = paramLogin;
        mdp = paramMdp;
        commandesPreparees = paramCommandesPreparees;
        livraisonCreees = paramLivraisonCreees;
    }
    /**
     * constructeur par défaut.
     */
    public Preparateur() {
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
     * @return the login.
     */
    public String getLogin() {
        return login;
    }
    /**
     * @param paramLogin the login to set.
     */
    public void setLogin(String paramLogin) {
        login = paramLogin;
    }
    /**
     * @return the mdp.
     */
    public String getMdp() {
        return mdp;
    }
    /**
     * @param paramMdp the mdp to set.
     */
    public void setMdp(String paramMdp) {
        mdp = paramMdp;
    }
    /**
     * @return the commandesPreparees.
     */
    public List<Commande> getCommandesPreparees() {
        return commandesPreparees;
    }
    /**
     * @param paramCommandesPreparees the commandesPreparees to set.
     */
    public void setCommandesPreparees(List<Commande> paramCommandesPreparees) {
        commandesPreparees = paramCommandesPreparees;
    }
    /**
     * @return the livraisonCreees.
     */
    public List<Livraison> getLivraisonCreees() {
        return livraisonCreees;
    }
    /**
     * @param paramLivraisonCreees the livraisonCreees to set.
     */
    public void setLivraisonCreees(List<Livraison> paramLivraisonCreees) {
        livraisonCreees = paramLivraisonCreees;
    }
}
