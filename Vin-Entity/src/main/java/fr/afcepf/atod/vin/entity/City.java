package fr.afcepf.atod.vin.entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * by roro
 */
@Entity
@Table(name = "City")
public class City implements Serializable {
    /**
     * max size columns
     */
    @Transient
    private static final int MAX_SIZE = 50;
   
    /**
     * 
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * zipcode
     */
    @Column(name     = "zipcode",
            length   = MAX_SIZE,
            nullable = false)
    private String zipcode;

    /**
     * name
     */
    @Column(name     = "name",
            length   = MAX_SIZE,
            nullable = false)
    private String name;

    /**
     * region
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idRegion", nullable = false)
    private Region region;
    
    /**
     * adress's'
     */
    @OneToMany(mappedBy = "city")
    private Set<Adress> setAdress;
    
    // ------------ constructors ------------// 
    
     /**
     * Default constructor
     */
    public City() {
    }
    /**
     * 
     * @param id
     * @param zipcode
     * @param name
     * @param region 
     */
    public City(Integer id, String zipcode, String name, Region region) {
        this.id = id;
        this.zipcode = zipcode;
        this.name = name;
        this.region = region;
    }
    
    // ------------ getters && setters --------//
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Set<Adress> getSetAdress() {
        return setAdress;
    }

    public void setSetAdress(Set<Adress> setAdress) {
        this.setAdress = setAdress;
    }
    
    
}