/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sai.persistence.customer;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author PROGRAMACIO3
 */
@Entity
@Table(name="ps_customer_group")
public class CustomerGroup implements Serializable {
    @Id
    @Column(name="id_customer")
    private int idCustomer;
    @Id
    @Column(name="id_group")
    private int idGroup;

    protected CustomerGroup () {}
    public CustomerGroup(int idCustomer, int idGroup) {
        this.idCustomer = idCustomer;
        this.idGroup = idGroup;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public int getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(int idGroup) {
        this.idGroup = idGroup;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.idCustomer;
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
        final CustomerGroup other = (CustomerGroup) obj;
        if (this.idCustomer != other.idCustomer) {
            return false;
        }
        if (this.idGroup != other.idGroup) {
            return false;
        }
        return true;
    }
    
    
}
