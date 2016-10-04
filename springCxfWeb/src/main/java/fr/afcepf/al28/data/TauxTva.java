package fr.afcepf.al28.data;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TauxTva implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String nom;
    private Double taux;
    /**
     * 
     */
    public TauxTva() {
        super();
    }
    /**
     * @param paramNom
     * @param paramTaux
     */
    public TauxTva(String paramNom, Double paramTaux) {
        super();
        nom = paramNom;
        taux = paramTaux;
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
     * @return the taux
     */
    public Double getTaux() {
        return taux;
    }
    /**
     * @param paramTaux the taux to set
     */
    public void setTaux(Double paramTaux) {
        taux = paramTaux;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "TauxTva [nom=" + nom + ", taux=" + taux + "]";
    }
}
