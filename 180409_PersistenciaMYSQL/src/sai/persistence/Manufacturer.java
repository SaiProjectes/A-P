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
import javax.persistence.TemporalType;

/**
 *
 * @author PROGRAMACIO3
 */
@Entity
@Table(name="ps_manufacturer")
public class Manufacturer implements Serializable {
    @Id
    @Column(name="id_manufacturer")
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="date_add")
    @Temporal(TemporalType.DATE)
    private Date dateAdd;
    @Column(name="date_upd")
    @Temporal(TemporalType.DATE)
    private Date dateUpd;
    @Column(name="active")
    private short active;

    
    protected Manufacturer () {}
    
    public Manufacturer(int id, String name, Date dateAdd, Date dateUpd, short active) {
        this.id = id;
        this.name = name;
        this.dateAdd = dateAdd;
        this.dateUpd = dateUpd;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return "Manufacturer{" + "id=" + id + ", name=" + name + ", dateAdd=" + dateAdd + ", dateUpd=" + dateUpd + ", active=" + active + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.id;
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
        final Manufacturer other = (Manufacturer) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
    
}
