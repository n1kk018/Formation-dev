package fr.afcepf.al28.data;

public class Tva {
    private Double ht;
    private Double tauxPct;
    private Double tva;
    private Double ttc;
    /**
     * @param paramHt
     * @param paramTauxPct
     * @param paramTva
     * @param paramTtc
     */
    public Tva(Double paramHt, Double paramTauxPct, Double paramTva, Double paramTtc) {
        super();
        ht = paramHt;
        tauxPct = paramTauxPct;
        tva = paramTva;
        ttc = paramTtc;
    }
    /**
     * 
     */
    public Tva() {
        super();
    }
    /**
     * @return the ht
     */
    public Double getHt() {
        return ht;
    }
    /**
     * @param paramHt the ht to set
     */
    public void setHt(Double paramHt) {
        ht = paramHt;
    }
    /**
     * @return the tauxPct
     */
    public Double getTauxPct() {
        return tauxPct;
    }
    /**
     * @param paramTauxPct the tauxPct to set
     */
    public void setTauxPct(Double paramTauxPct) {
        tauxPct = paramTauxPct;
    }
    /**
     * @return the tva
     */
    public Double getTva() {
        return tva;
    }
    /**
     * @param paramTva the tva to set
     */
    public void setTva(Double paramTva) {
        tva = paramTva;
    }
    /**
     * @return the ttc
     */
    public Double getTtc() {
        return ttc;
    }
    /**
     * @param paramTtc the ttc to set
     */
    public void setTtc(Double paramTtc) {
        ttc = paramTtc;
    }
    
    
}
