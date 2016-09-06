package fr.afcepf.atod.vin.entity;
import java.io.Serializable;
import java.util.*;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

/**
 * by roro
 */
@Entity
public class ProductWine extends Product implements Serializable {
    /**
     * size columns
     */
    @Transient
    private static final int MAX_SIZE = 50;
  
    /**
     * appellation
     */
    @Column(name     = "appellation",
            length   = MAX_SIZE,
            nullable = true)
    private String appellation;

    /**
     * vintage
     */
    @Column(name     = "vintage",
            length   = MAX_SIZE,
            nullable = true)
    private Integer vintage;

    /**
     * product type
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idProductType", nullable = true)
    private ProductType productType;

    /**
     * varietal
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idProductVarietal", nullable = true)
    private ProductVarietal productVarietal;

    /**
     * region
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idRegion", nullable = true)
    private Region region;
    
    
    // --------- Constructors ---------- //
    
    /**
     * Default constructor
     */
    public ProductWine() {
    }
    
    /**
     * 
     * @param id
     * @param name
     * @param price
     * @param description
     * @param appellation
     * @param vintage
     * @param productType
     * @param productVarietal
     * @param region 
     */
    public ProductWine(Integer id, String name, Double price,
                       String description, String appellation, Integer vintage, 
                       ProductType productType, ProductVarietal productVarietal,
                       Region region) {
        super(id, name, price, description);
        this.appellation = appellation;
        this.vintage = vintage;
        this.productType = productType;
        this.productVarietal = productVarietal;
        this.region = region;
    }
        
    // ------- Getters && Setters --------//

    public String getAppellation() {
        return appellation;
    }

    public void setAppellation(String appellation) {
        this.appellation = appellation;
    }

    public Integer getVintage() {
        return vintage;
    }

    public void setVintage(Integer vintage) {
        this.vintage = vintage;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public ProductVarietal getProductVarietal() {
        return productVarietal;
    }

    public void setProductVarietal(ProductVarietal productVarietal) {
        this.productVarietal = productVarietal;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }    
    
}