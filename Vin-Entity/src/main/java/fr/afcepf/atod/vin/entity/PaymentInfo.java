package fr.afcepf.atod.vin.entity;
import java.io.Serializable;
import java.util.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * by roro
 */
@Table(name = "PaymentInfo")
@Entity
public class PaymentInfo implements Serializable {

    @Transient
    private static final int MAX_SIZE = 50;

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * payment method
     */
    @Column(name     = "paymentMethod",
            length   = MAX_SIZE*4,
            nullable = false)
    private String paymentMethod;

    @OneToMany(mappedBy = "paymentInfo")
    private Set<Order> orders;
    
    // ------ Constructors -------- //
    
    /**
     * Default constructor
     */
    public PaymentInfo() {
    }
    /**
     * 
     * @param id
     * @param paymentMethod 
     */
      public PaymentInfo(Integer id, String paymentMethod) {
        this.id = id;
        this.paymentMethod = paymentMethod;
    }
    // ------ Getters && Setters ---------//

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

  

}