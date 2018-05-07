/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sai.persistence;

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
@Table(name="ps_supplier_shop")
public class SupplierShop implements Serializable {
    @Id
    @Column(name="id_supplier")
    private int idSupplier;
    @Id
    @Column(name="id_shop")
    private int idShop;
    
    protected SupplierShop(){}

    public SupplierShop(int idSupplier, int idShop) {
        this.idSupplier = idSupplier;
        this.idShop = idShop;
    }

    public int getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(int idSupplier) {
        this.idSupplier = idSupplier;
    }

    public int getIdShop() {
        return idShop;
    }

    public void setIdShop(int idShop) {
        this.idShop = idShop;
    }

    @Override
    public String toString() {
        return "SupplierShop{" + "idSupplier=" + idSupplier + ", idShop=" + idShop + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.idSupplier;
        hash = 37 * hash + this.idShop;
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
        final SupplierShop other = (SupplierShop) obj;
        if (this.idSupplier != other.idSupplier) {
            return false;
        }
        if (this.idShop != other.idShop) {
            return false;
        }
        return true;
    }
    
    
    
}
