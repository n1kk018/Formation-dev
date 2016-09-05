package fr.afcepf.atod.vin.entity;

import java.io.Serializable;
import java.util.*;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * by Roro @RL On netbeans 8.1
 */
@Entity
@Table(name = "User")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class User implements Serializable {
    /**
     * size columns
     */
    @Transient
    private static final int MAX_SIZE = 50;
    /**
     * id
     */
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    protected Integer id;

    /**
     * lastname
     */
    @Column(name     = "lastname",
            length   = MAX_SIZE,
            nullable = false)
    protected  String lastname;

    /**
     * first name
     */
    @Column(name     = "fisrtname",
            length   = MAX_SIZE,
            nullable = false)
    protected  String firstname;

    /**
     * birthdate
     */
    @Column(name     = "birthdate",
            nullable = false)
    protected  Date birthdate;

    /**
     * email
     */
    @Column(name     = "mail",
            length   = MAX_SIZE*2,
            nullable = false)
    protected  String mail;

    /**
     * login
     */
    @Column(name     = "login",
            length   = MAX_SIZE,
            nullable = false)
    protected  String login;

    /**
     * password
     */
     @Column(name    = "password",
            length   = MAX_SIZE,
            nullable = false)
    protected  String password;

    /**
     * phonenumber
     */
     @Column(name    = "phonenumber",
            length   = MAX_SIZE,
            nullable = false)
    protected  String phonenumber;

    /**
     * user account created @
     */
     @Column(name     = "createdAt",
            nullable  = false)
    protected  Date createdAt;

    /**
     * user account updated @
     */
     @Column(name       = "updatedAt",
             nullable   = false)
    protected  Date updatedAt;
   
    /**
     * civility
     */
    @Enumerated(EnumType.STRING)
    protected  Civility civility;

    /**
     * adress
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idAdresse", nullable = false)
    protected  Adress adress;
    
    /**
     * Default constructor
     */
    public User() {
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
     */
    public User(Integer id, String lastname, String firstname, Date birthdate,
                String email, String login, String password, String phonenumber,
                Date createdAt, Date updatedAt, Civility civility, Adress adress) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.birthdate = birthdate;
        this.mail = email;
        this.login = login;
        this.password = password;
        this.phonenumber = phonenumber;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.civility = civility;
        this.adress = adress;
    }
    // --------- getters && setters ------------ //

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
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

    public Civility getCivility() {
        return civility;
    }

    public void setCivility(Civility civility) {
        this.civility = civility;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }
            
}