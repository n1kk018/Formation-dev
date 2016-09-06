package fr.afcepf.atod.vin.entity;
import java.io.Serializable;
import java.util.*;
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
@Table(name = "Adress")
public class Adress implements Serializable {
    /**
     * size max columns
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
     * street
     */
    @Column(name       = "street",
            length     = MAX_SIZE*2,
            nullable   = false)
    private String street;

    /**
     * number
     */
    @Column(name     = "number",
            length   = MAX_SIZE,
            nullable = false)
    private String number;

    /**
     * billing
     */
     @Column(name    = "billing",
            nullable = false)
    private boolean billing;

    /**
     * city
     */
     @ManyToOne(cascade = CascadeType.ALL)
     @JoinColumn(name = "idCity", nullable = false)
    private City city;
    
     /**
      * users
      */
     @OneToMany(mappedBy = "adress")
     private Set<User> users;
     
     // ---------- constructors ----------- //
     
     /**
     * Default constructor
     */
    public Adress() {
    }

    public Adress(Integer id, String street, String number,
                  boolean billing, City city) {
        this.id = id;
        this.street = street;
        this.number = number;
        this.billing = billing;
        this.city = city;
    }
        
    // ------------ getters && setters -------- //

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public boolean isBilling() {
        return billing;
    }

    public void setBilling(boolean billing) {
        this.billing = billing;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }    
    
}