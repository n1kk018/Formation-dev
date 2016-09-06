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
 * 
 */
@Table(name = "SpecialEvent")
@Entity
public class SpecialEvent implements Serializable {
    @Transient
    private static final int MAX_SIZE = 50;
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     *  title
     */
    @Column(name        = "Title", 
            length      = MAX_SIZE, 
            nullable    = false)
    private String title;

    /**
     * begining event
     */
    @Column(name     = "startDate", 
            nullable = false)
    private Date startDate;

    /**
     * end event
     */
    @Column(name     = "endDate", 
            nullable = false)
    private Date endDate;

    /**
     * event: created @
     */
    @Column(name     = "createdDate", 
            nullable = false)
    private Date createdAt;

    /**
     * 
     */
    @Column(name     = "description",
            length   = MAX_SIZE*3,
            nullable = false)
    private String description;

    /**
     * 
     */
    @Column(name     = "activated", 
            nullable = false)
    private Boolean activated;
    /**
     *   admin  
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idAdmin", nullable = false)
    private Admin admin;
    
    // ------- constructeurs -------//
    
    /**
     * Default constructor
     */
    public SpecialEvent() {
    }
    /**
     * 
     * @param id
     * @param Title
     * @param startDate
     * @param endDate
     * @param createdAt
     * @param description
     * @param activated
     * @param admin 
     */
    public SpecialEvent(Integer id, String Title, Date startDate, 
                        Date endDate, Date createdAt, String description,
                        Boolean activated, Admin admin) {
        this.id = id;
        this.title = Title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.createdAt = createdAt;
        this.description = description;
        this.activated = activated;
        this.admin = admin;
    }
    
    

    // ------- Getters et setters -------//

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String Title) {
        this.title = Title;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getActivated() {
        return activated;
    }

    public void setActivated(Boolean activated) {
        this.activated = activated;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
}