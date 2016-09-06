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
 * by roroab
 */
@Entity
@Table(name = "Region")
public class Region implements Serializable {
    /**
     * useful size columns
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
     * name
     */
    @Column(name     = "name",
            length   = MAX_SIZE,
            nullable = false)
    private String name;

    /**
     * country
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idCountry", nullable = true)
    private Country country;
    
    /**
     * set cities
     */
    @OneToMany(mappedBy = "region")
    private Set<City> cities;
    // -------- Constructors ---------//

    /**
     * Default constructor
     */
    public Region() {
        
    }
    /**
     * 
     * @param id
     * @param name
     * @param country 
     */
    public Region(Integer id, String name, Country country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }
    
    // --------- getters && setters ----//

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Set<City> getCities() {
        return cities;
    }

    public void setCities(Set<City> cities) {
        this.cities = cities;
    }
}