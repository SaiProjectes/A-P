/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sai.persistence;

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
@Table(name="ps_supplier")
public class Supplier implements Serializable {
    @Id
    @Column(name="id_supplier")
    private int idSupplier;
    @Column(name="name")
    private String name;
    @Column(name="date_add")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateAdd;
    @Column(name="date_upd")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateUpd;
    @Column(name="active")
    private short active;
    
    protected Supplier () {}

    public Supplier(int idSupplier, String name, Date dateAdd, Date dateUpd, short active) {
        this.idSupplier = idSupplier;
        this.name = name;
        this.dateAdd = dateAdd;
        this.dateUpd = dateUpd;
        this.active = active;
    }

    public int getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(int idSupplier) {
        this.idSupplier = idSupplier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public short getActive() {
        return active;
    }

    public void setActive(short active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Supplier{" + "idSupplier=" + idSupplier + ", name=" + name + ", dateAdd=" + dateAdd + ", active=" + active + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.idSupplier;
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
        final Supplier other = (Supplier) obj;
        if (this.idSupplier != other.idSupplier) {
            return false;
        }
        return true;
    }
    
    
    
}
