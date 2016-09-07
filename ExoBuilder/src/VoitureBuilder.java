
import java.util.*;

/**
 * 
 */
public abstract class VoitureBuilder {
	
    /**
     * 
     */
    protected Voiture voiture;
    
    public void setVoiture(Voiture voiture)
    {
    	this.voiture = voiture;
    }

    /**
     * 
     */
    public abstract void créerChassis();

    /**
     * 
     */
    public abstract void créerMoteur();

    /**
     * 
     */
    public abstract void créerTransmission();

    /**
     * 
     */
    
}