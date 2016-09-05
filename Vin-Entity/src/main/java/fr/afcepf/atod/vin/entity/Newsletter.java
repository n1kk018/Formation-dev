package fr.afcepf.atod.vin.entity;

import java.io.Serializable;
import java.util.Date;
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
 * creation table Newsletter
 */
@Table(name = "Newsletter")
@Entity
public class Newsletter implements Serializable {
    @Transient
    private static final int MAX_SIZE = 50;

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * title
     */
    @Column(name     = "title",
            length   = MAX_SIZE,
            nullable = false)
    private String title;

    /**
     * body
     */
    @Column(name     = "body",
            length   = 4*MAX_SIZE,
            nullable = false)
    private String body;

    /**
     * newsletter created @t
     */
    @Column(name     = "createdAt",            
            nullable = false)
    private Date createdAt;

    /**
     * newsletter update @t
     */
    @Column(name     = "updateAt",            
            nullable = false)
    private Date updatedAt;

    /**
     * newsletter published @t
     */
    @Column(name     = "publishedAt",            
            nullable = false)
    private Date publishedAt;
    
    /**
     *  admin
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idAdmin", 
            nullable = false)
    private Admin admin;

    // ----- Constructors ------//
    
    /**
     * Default constructor
     */
    public Newsletter() {
    }
    /**
     * 
     * @param id
     * @param title
     * @param body
     * @param createdAt
     * @param updatedAt
     * @param publishedAt
     * @param admin 
     */   
    public Newsletter(Integer id, String title, String body, Date createdAt,
                      Date updatedAt, Date publishedAt, Admin admin) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.publishedAt = publishedAt;
        this.admin = admin;
    }

    // ------ getters && setters ------- //
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Date publishedAt) {
        this.publishedAt = publishedAt;
    }
       
}