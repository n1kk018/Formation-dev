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
@Table(name = "Ordering")
@Entity
public class Order implements Serializable {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * created at
     */
    @Column(name     = "createdAt",
            nullable = false)
    private Date createdAt;

    /**
     * paid at
     */
    @Column(name     = "paidAt",
            nullable = false)
    private Date paidAt;

    
    /**
     * shipping method
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idShippingMethod", nullable = false)
    private ShippingMethod shippingMethod;

    /**
     * customer
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idCustomer", nullable = false)
    private Customer customer;

    /**
     * payment info
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idPaymentInfo",nullable = false)
    private PaymentInfo paymentInfo;
    
    /**
     * details
     */
    @OneToMany(mappedBy = "order")
    private  Set<OrderDetail> ordersDetail;

    
    // ------------ Constructors  ----------------// 

     /**
     * Default constructor
     */
    public Order() {
    }

    public Order(Integer id, Date createdAt, Date paidAt,
            ShippingMethod shippingMethod, Customer customer,
            PaymentInfo paymentInfo) {
        this.id = id;
        this.createdAt = createdAt;
        this.paidAt = paidAt;
        this.shippingMethod = shippingMethod;
        this.customer = customer;
        this.paymentInfo = paymentInfo;
    }
    
    
    // ----------- Getters && Setters -----------//

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getPaidAt() {
        return paidAt;
    }

    public void setPaidAt(Date paidAt) {
        this.paidAt = paidAt;
    }

    public ShippingMethod getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(ShippingMethod shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public PaymentInfo getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(PaymentInfo paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public Set<OrderDetail> getOrdersDetail() {
        return ordersDetail;
    }

    public void setOrdersDetail(Set<OrderDetail> ordersDetail) {
        this.ordersDetail = ordersDetail;
    }
    
}