package fr.afcepf.atod.vin.entity;
import java.io.Serializable;
import java.util.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * by roro
 */
@Entity
public class Customer extends User implements Serializable {

    /**
     * activated
     */
    @Column(name     = "ativated",
            nullable = true)
    private Boolean activated;
    
    
    /**
     * comments
     */
    @OneToMany(mappedBy = "customer")
    private Set<Comment> comments;

    
    /**
     * orders
     */
    @OneToMany(mappedBy = "customer")
    private Set<Order> orders;
    
    // ------------- constructors ---------------- //
    /**
     * Default constructor
     */
    public Customer() {
        
    }

    /**
     * 
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
     * @param civility
     * @param adress
     * @param activated 
     */
    public Customer(Integer id, String lastname, 
                    String firstname, Date birthdate, String email,
                    String login, String password, String phonenumber,
                    Date createdAt, Date updatedAt, Civility civility,
                    Adress adress, Boolean activated ) {
        super(id, lastname, firstname, birthdate, email, login, password,
               phonenumber, createdAt, updatedAt, civility, adress);
        this.activated = activated;
    }
    
    // ------------ Getters && setters --------------//

    public Boolean getActivated() {
        return activated;
    }

    public void setActivated(Boolean activated) {
        this.activated = activated;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
        
}