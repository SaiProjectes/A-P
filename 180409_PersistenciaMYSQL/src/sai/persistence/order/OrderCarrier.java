/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sai.persistence.order;

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
@Table(name="ps_order_carrier")
public class OrderCarrier implements Serializable {
    @Id
    @Column(name="id_order_carrier")
    private int idOrderCarrier;
    @Column(name="id_order")
    private int idOrder;
    @Column(name="id_carrier")
    private int idCarrier;
    @Column(name="date_add")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateAdd;
    
    
    protected OrderCarrier () {}

    public OrderCarrier(int idOrderCarrier, int idOrder, int idCarrier) {
        this.idOrderCarrier = idOrderCarrier;
        this.idOrder = idOrder;
        this.idCarrier = idCarrier;
    }

    public int getIdOrderCarrier() {
        return idOrderCarrier;
    }

    public void setIdOrderCarrier(int idOrderCarrier) {
        this.idOrderCarrier = idOrderCarrier;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdCarrier() {
        return idCarrier;
    }

    public void setIdCarrier(int idCarrier) {
        this.idCarrier = idCarrier;
    }

    public Date getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(Date dateAdd) {
        this.dateAdd = dateAdd;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + this.idOrderCarrier;
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
        final OrderCarrier other = (OrderCarrier) obj;
        if (this.idOrderCarrier != other.idOrderCarrier) {
            return false;
        }
        return true;
    }
    
    
    
}
