/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sai.persistence.customer;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author PROGRAMACIO3
 */
@Entity
@Table(name="ps_customer")
public class Customer implements Serializable {
    @Id
    @Column(name="id_customer")
    private int idCustomer;
    @Column(name="id_shop_group")
    private int idShopGroup;
    @Column(name="id_shop")
    private int idShop;
    @Column(name="id_gender")
    private int idGender;
    @Column(name="id_default_group")
    private int idDefaultGroup;
    @Column(name="id_risk")
    private int idRisk;
    
    @Column(name="firstname")
    private String firstName;
    @Column(name="lastname")
    private String lastName;
    @Column(name="email")
    private String email;
    @Column(name="passwd")
    private String passwd;
    
    @Column(name="date_add")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateAdd;
    @Column(name="date_upd")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateUpd;
    @Column(name="id_lang")
    private int idLang;
    @Column(name="optin")
    private short optin;
    @Column(name="secure_key")
    private String secureKey;
    @Column(name="active")
    private short active;
    
    protected Customer () {}
    
    public Customer(int idCustomer, int idShop, int idGender, String firstName,String lastName, String email, String passwd) {
        this.idCustomer = idCustomer;
        this.idShop = idShop;
        this.idGender = idGender;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.passwd = passwd;
        omplirResta();
    }

    private void omplirResta() {
        this.idShopGroup = 1;
        this.idDefaultGroup = 1;
        this.idRisk = 0;
        Date n = new Date();
        this.dateAdd = n;
        this.dateUpd = n;
        this.idLang = 1;
        this.optin = 1;
        this.secureKey = "b6bb1f6ce3cfbb310bdf9d2446d8b598";
        this.active = 1;
        
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public int getIdShopGroup() {
        return idShopGroup;
    }

    public void setIdShopGroup(int idShopGroup) {
        this.idShopGroup = idShopGroup;
    }

    public int getIdShop() {
        return idShop;
    }

    public void setIdShop(int idShop) {
        this.idShop = idShop;
    }

    public int getIdGender() {
        return idGender;
    }

    public void setIdGender(int idGender) {
        this.idGender = idGender;
    }

    public int getIdDefaultGroup() {
        return idDefaultGroup;
    }

    public void setIdDefaultGroup(int idDefaultGroup) {
        this.idDefaultGroup = idDefaultGroup;
    }

    public int getIdRisk() {
        return idRisk;
    }

    public void setIdRisk(int idRisk) {
        this.idRisk = idRisk;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public Date getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(Date dateAdd) {
        this.dateAdd = dateAdd;
    }

    public Date getDateUpd() {
        return dateUpd;
    }

    public void setDateUpd(Date dateUpd) {
        this.dateUpd = dateUpd;
    }

    @Override
    public String toString() {
        return "Customer{" + "idCustomer=" + idCustomer + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.idCustomer;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Customer other = (Customer) obj;
        if (this.idCustomer != other.idCustomer) {
            return false;
        }
        return true;
    }
    
    
    
    
    
}
