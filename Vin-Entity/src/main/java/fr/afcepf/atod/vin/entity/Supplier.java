package fr.afcepf.atod.vin.entity;
import java.io.Serializable;
import java.util.*;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * by roro
 */
@Table(name = "Supplier")
@Entity
public class Supplier implements Serializable{
    /**
     * size columns
     */
    @Transient
    private static final int MAX_SIZE  = 50;
   
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * name
     */
    @Column(name     = "companyName",
            length   = MAX_SIZE*2,
            nullable =  false)
    private String companyName;

    /**
     * phone
     */
    @Column(name     = "phoneNumber",
            length   = MAX_SIZE,
            nullable = false)
    private String phoneNumber;

    /**
     * mail
     */
    @Column(name     = "mail",
            length   = MAX_SIZE,
            nullable = false)
    private String mail;

    /**
     * created @t
     */
    @Column(name     = "createdAt",
            nullable = false)
    private Date createdAt;

    /**
     * products
     */
    @ManyToMany(cascade = CascadeType.ALL,
                mappedBy = "stockSuppliers")
    private Set<Product> stockProducts;
    
    // ---------- Constructors ----------//
    
     /**
     * Default constructor
     */
    public Supplier() {
    }
    /**
     * 
     * @param id
     * @param companyName
     * @param phoneNumber
     * @param mail
     * @param createdAt 
     */
    public Supplier(Integer id, String companyName, String phoneNumber,
            String mail, Date createdAt) {
        this.id = id;
        this.companyName = companyName;
        this.phoneNumber = phoneNumber;
        this.mail = mail;
        this.createdAt = createdAt;
    }
    
    // -------- Getters && Setters ------//

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Set<Product> getStockProducts() {
        return stockProducts;
    }

    public void setStockProducts(Set<Product> stockProducts) {
        this.stockProducts = stockProducts;
    }
    
    
}