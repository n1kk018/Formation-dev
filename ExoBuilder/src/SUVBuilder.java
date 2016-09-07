
import java.util.*;

/**
 * 
 */
public class SUVBuilder extends VoitureBuilder {

    /**
     * Default constructor
     */
    public SUVBuilder() {
    }

    /**
     * 
     */
    public void créerChassis() {
        this.voiture.setChassis("Chassis renforcé");
    }

    /**
     * 
     */
    public void créerMoteur() {
        this.voiture.setMoteur("moteur V8 diesel");
    }

    /**
     * 
     */
    public void créerTransmission() {
        this.voiture.setTransmission("intégrale");
    }

}