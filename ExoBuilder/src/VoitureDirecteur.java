
import java.util.*;

/**
 * 
 */
public class VoitureDirecteur {

    /**
     * Default constructor
     */
    public VoitureDirecteur() {
    }


    /**
     * @param vb 
     * @return
     */
    public Voiture construire(VoitureBuilder vb) {
        Voiture v = new Voiture();
        vb.setVoiture(v);
        
        vb.créerChassis();
        vb.créerMoteur();
        vb.créerTransmission();
        
        return v;
    }

}