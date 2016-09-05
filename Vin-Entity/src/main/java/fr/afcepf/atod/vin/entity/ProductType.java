package fr.afcepf.atod.vin.entity;
import java.io.Serializable;
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
 * by roro
 */
@Table(name = "ProductType")
@Entity
public class ProductType implements Serializable {
    /**
     * columns size
     */
    @Transient
    private static final int MAX_SIZE = 50;
  
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * type
     */
    @Column(name     = "type",
            length   = MAX_SIZE*2,
            nullable = false)
    private String type;
    
    /**
     * products wine
     */
    @OneToMany(mappedBy = "productType")
    private Set<ProductWine> productsWine;
    
    
    
    // ---------- Constructors -----------//
      /**
     * Default constructor
     */
    public ProductType() {
    }
    /**
     * 
     * @param id
     * @param type 
     */
    public ProductType(Integer id, String type) {
        this.id = id;
        this.type = type;
    }
        

    // ----------- Getters && Setters ----------//

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<ProductWine> getProductsWine() {
        return productsWine;
    }

    public void setProductsWine(Set<ProductWine> productsWine) {
        this.productsWine = productsWine;
    }
    
}