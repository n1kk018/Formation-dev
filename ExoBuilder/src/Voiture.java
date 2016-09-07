
import java.util.*;

/**
 * 
 */
public class Voiture {

    /**
     * Default constructor
     */
    protected Voiture() {
    }

    /**
     * 
     */
    private String chassis;

    /**
     * 
     */
    private String moteur;

    /**
     * 
     */
    private String transmission;

	public String getChassis() {
		return chassis;
	}

	public void setChassis(String chassis) {
		this.chassis = chassis;
	}

	public String getMoteur() {
		return moteur;
	}

	public void setMoteur(String moteur) {
		this.moteur = moteur;
	}

	public String getTransmission() {
		return transmission;
	}

	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}

	@Override
	public String toString() {
		return "Voiture [chassis=" + chassis + ", moteur=" + moteur + ", transmission=" + transmission + "]";
	}

    
}