package fr.afcepf.al28.rmi.serv.data;

import java.io.Serializable;

public class Meteo implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Double temperature;
    private String temps; //"beau","nuageux"
    
    /**
     * 
     */
    public Meteo() {
        super();
    }
    /**
     * @param paramTemperature
     * @param paramTemps
     */
    public Meteo(Double paramTemperature, String paramTemps) {
        super();
        temperature = paramTemperature;
        temps = paramTemps;
    }
    /**
     * @return the temperature
     */
    public Double getTemperature() {
        return temperature;
    }
    /**
     * @param paramTemperature the temperature to set
     */
    public void setTemperature(Double paramTemperature) {
        temperature = paramTemperature;
    }
    /**
     * @return the temps
     */
    public String getTemps() {
        return temps;
    }
    /**
     * @param paramTemps the temps to set
     */
    public void setTemps(String paramTemps) {
        temps = paramTemps;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Meteo [temperature=" + temperature + ", temps=" + temps + "]";
    }
}
