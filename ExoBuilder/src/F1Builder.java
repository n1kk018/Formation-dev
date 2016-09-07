
import java.util.*;

/**
 * 
 */
public class F1Builder extends VoitureBuilder {

    /**
     * Default constructor
     */
    public F1Builder() {
    }

    /**
     * 
     */
    public void créerChassis() {
        this.voiture.setChassis("Chassis de compet");
    }

    /**
     * 
     */
    public void créerMoteur() {
        this.voiture.setMoteur("V6 hybride turbo");
    }

    /**
     * 
     */
    public void créerTransmission() {
        this.voiture.setTransmission("propulsion");
    }

}