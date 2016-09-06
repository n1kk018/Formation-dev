package fr.afcepf.atod.vin.entity;
import java.io.Serializable;
import java.util.*;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * by roro
 */
@Table(name = "Product")
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Product implements Serializable {
    @Transient
    private static final int MAX_SIZE = 50;
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    /**
     * name
     */
    @Column(name     = "name",
            length   = MAX_SIZE*2,
            nullable = false)
    protected String name;

    /**
     * price
     */
     @Column(name    = "price",
            nullable = false)
    protected Double price;

    /**
     * description
     */
      @Column(name     = "description",
            length   = MAX_SIZE*4,
            nullable = false)
    protected String description;
      
	  /**
	   * created at
	   */
      @Temporal(TemporalType.TIMESTAMP)
      @Column(name="createdAt", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable=false, updatable=false)
	  private Date createdAt;

    /**
     * link order <=> product
     */
    @OneToMany(mappedBy = "product")
    protected Set<OrderDetail> orderDetails;



    /**
     * link product <=> stock
     */
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "product_supplier",
               joinColumns = 
                       {@JoinColumn(name = "id_Product", 
                               nullable  = false, 
                               updatable = false)},
               inverseJoinColumns =
                       {@JoinColumn(name = "id_Supplier")})
           
    protected Set<Supplier> stockSuppliers;

    // -------- Constructors ------------ //
    
     /**
     * Default constructor
     */
    public Product() {
    }    
    /**
     * 
     * @param id
     * @param name
     * @param price
     * @param description 
     */
    public Product(Integer id, String name, Double price, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }
    
        
    // ------- Getters && Setters ---------//

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Set<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }


    public Set<Supplier> getStockSuppliers() {
        return stockSuppliers;
    }

    public void setStockSuppliers(Set<Supplier> stockSuppliers) {
        this.stockSuppliers = stockSuppliers;
    }
        
    public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}    
}