/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sai.persistence.group;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author PROGRAMACIO3
 */
@Entity
@Table(name="ps_group")
public class Group implements Serializable {
    @Id
    @Column(name="id_group")
    private int idGroup;
    @Column(name="reduction")
    private BigDecimal reduction;
    @Column(name="price_display_method")
    private int priceDisplayMethod;
    @Column(name="show_prices")
    private short show_prices;
    @Column(name="date_add")
    private Date dateAdd;
    @Column(name="date_upd")
    private Date dateUpd;
    
    protected Group () {}

    public int getIdGroup() {
        return idGroup;
    }

    public BigDecimal getReduction() {
        return reduction;
    }

    public int getPriceDisplayMethod() {
        return priceDisplayMethod;
    }

    public short getShow_prices() {
        return show_prices;
    }

    public Date getDateAdd() {
        return dateAdd;
    }

    public Date getDateUpd() {
        return dateUpd;
    }

    public Group(int idGroup, BigDecimal reduction, int priceDisplayMethod, short show_prices) {
        this.idGroup = idGroup;
        this.reduction = reduction;
        this.priceDisplayMethod = priceDisplayMethod;
        this.show_prices = show_prices;
        Date now = new Date();
        this.dateAdd = now;
        this.dateUpd = now;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.idGroup;
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
        final Group other = (Group) obj;
        if (this.idGroup != other.idGroup) {
            return false;
        }
        return true;
    }
    
    
    
    
}
