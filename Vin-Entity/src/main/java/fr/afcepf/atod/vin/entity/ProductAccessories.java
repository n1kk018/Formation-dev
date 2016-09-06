package fr.afcepf.atod.vin.entity;
import java.io.Serializable;
import java.util.*;
import javax.persistence.Column;
import javax.persistence.Entity;
/**
 * by Roro
 */
@Entity
public class ProductAccessories extends Product implements Serializable {
        
    // -------- Constructors ----------- //
    
    /**
     * Default constructor
     */
    public ProductAccessories() {
    }

    public ProductAccessories(Integer id, String name, Double price, 
            String description, Date createdAt) {
        super(id, name, price, description);
    }

   

        
}