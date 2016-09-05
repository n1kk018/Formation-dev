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
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * By Roro
 */
@Table(name = "Comment")
@Entity
public class Comment implements Serializable {
    /**
     * use to calculate max size column
     */
    @Transient
    private static final int MAX_SIZE = 50;
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    /**
     * title
     */
    @Column(name     = "title",
            length   = MAX_SIZE,
            nullable = false)
    private String title;

    /**
     * text
     */
    @Column(name     = "text",
            length   = MAX_SIZE*4,
            nullable = false)
    private String text;

    /**
     * validated comment?
     */
    @Column(name     = "isValidated",
            nullable = false)
    private Boolean isValidated;

    /**
     * date
     */
    @Column(name     = "datePublished",
            nullable = false)
    private Date datePublished;

    /**
     * admin
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "idAdmin",
             nullable = false)
    private Admin admin;
    
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idCustomer",
            nullable = false)
    private Customer customer;
    
    // ------------ Constructors ------------ //
    
    /**
     * Default constructor
     */
    public Comment() {
    }
    /**
     * @param Id
     * @param title
     * @param text
     * @param validated
     * @param date
     * @param admin 
     * @param customer 
     */
    public Comment(Integer Id, String title, String text,
                   Boolean validated, Date date, Admin admin, Customer customer) {
        this.Id             = Id;
        this.title          = title;
        this.text           = text;
        this.isValidated    = validated;
        this.datePublished  = date;
        this.admin          = admin;
        this.customer       = customer;
    }
    
    // --------- Getters && Setters --------- //

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Boolean getIsValidated() {
        return isValidated;
    }

    public void setIsValidated(Boolean isValidated) {
        this.isValidated = isValidated;
    }

    public Date getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(Date datePublished) {
        this.datePublished = datePublished;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
     
}