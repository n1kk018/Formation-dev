package fr.afcepf.atod.vin.entity;

import java.io.Serializable;
import java.util.*;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
/**
 * by roro
 */
@Entity
public class Admin extends User implements Serializable {

   
    /**
     * bi directionnalite
     */
    @OneToMany(mappedBy = "admin")      
    private Set<SpecialEvent> events;

    /**
     * bi directionnalite
     */
    @OneToMany(mappedBy = "admin")
    private Set<Comment> comments;

    /**
     * bi directionnalite
     */
    @OneToMany(mappedBy = "admin")
    private Set<Newsletter> news;

    
    
     // ------- Constructors ------ //
    /**
     * Default constructor
     */
    public Admin() {
        
    }
    
    /**
     * @param id
     * @param lastname
     * @param firstname
     * @param birthdate
     * @param email
     * @param login
     * @param password
     * @param phonenumber
     * @param createdAt
     * @param updatedAt
     * @param label
     * @param adress 
     */
    public Admin(Integer id, String lastname, String firstname,
            Date birthdate, String email, String login, String password,
            String phonenumber, Date createdAt, Date updatedAt, 
            Civility label, Adress adress) {
        super(id, lastname, firstname, birthdate, email, login, password,
                phonenumber, createdAt, updatedAt, label, adress);
    }

    // -------- getters && setters -------- //

    public Set<SpecialEvent> getEvents() {
        return events;
    }

    public void setEvents(Set<SpecialEvent> events) {
        this.events = events;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public Set<Newsletter> getNews() {
        return news;
    }

    public void setNews(Set<Newsletter> news) {
        this.news = news;
    }
    
}