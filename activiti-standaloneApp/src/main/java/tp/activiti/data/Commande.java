package tp.activiti.data;

import java.io.Serializable;

public class Commande implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private double prixTotalHt;
    private double prixTotalTtc;
    
    
    /**
     * 
     */
    public Commande() {
        super();
    }
    
    
    /**
     * @param paramPrixTotalHt
     * @param paramPrixTotalTtc
     */
    public Commande(double paramPrixTotalHt, double paramPrixTotalTtc) {
        super();
        prixTotalHt = paramPrixTotalHt;
        prixTotalTtc = paramPrixTotalTtc;
    }


    /**
     * @return the prixTotalHt
     */
    public double getPrixTotalHt() {
        return prixTotalHt;
    }
    /**
     * @param paramPrixTotalHt the prixTotalHt to set
     */
    public void setPrixTotalHt(double paramPrixTotalHt) {
        prixTotalHt = paramPrixTotalHt;
    }
    /**
     * @return the prixTotalTtc
     */
    public double getPrixTotalTtc() {
        return prixTotalTtc;
    }
    /**
     * @param paramPrixTotalTtc the prixTotalTtc to set
     */
    public void setPrixTotalTtc(double paramPrixTotalTtc) {
        prixTotalTtc = paramPrixTotalTtc;
    }
    
    
    
}
