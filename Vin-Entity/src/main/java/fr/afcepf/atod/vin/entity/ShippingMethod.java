package fr.afcepf.atod.vin.entity;
import java.util.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 
 */
@Table(name = "ShippingMethod")
@Entity
public class ShippingMethod {
    @Transient
    private static final int MAX_SIZE = 50;   

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * information
     */
    @Column(name     = "information",
            length   = 4*MAX_SIZE,
            nullable = false)
    private String information;
    
    /**
     * orders
     */
    @OneToMany(mappedBy = "shippingMethod")
    private Set<Order> orders;

    // ------------- Constructors --------------//
    
    /**
     * Default constructor
     */
    public ShippingMethod() {
    }
    
    /**
     * 
     * @param id
     * @param information 
     */
    public ShippingMethod(Integer id, String information) {
        this.id = id;
        this.information = information;
    }
    
    // --------------- getters && setters ------------- //

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

}