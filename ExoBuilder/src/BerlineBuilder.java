
import java.util.*;

/**
 * 
 */
public class BerlineBuilder extends VoitureBuilder {

    /**
     * Default constructor
     */
    public BerlineBuilder() {
    }

    /**
     * 
     */
    public void créerChassis() {
        this.voiture.setChassis("Chassis de base");
    }

    /**
     * 
     */
    public void créerMoteur() {
        this.voiture.setMoteur("moteur 16 soupapes");
    }

    /**
     * 
     */
    public void créerTransmission() {
        this.voiture.setTransmission("traction");
    }

    

}