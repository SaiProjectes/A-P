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
@Table(name="ps_manufacturer_shop")
public class ManufacturerShop implements Serializable {
    @Id
    @Column(name="id_manufacturer")
    private int idManufacturer;
    @Id
    @Column(name="id_shop")
    private int idShop;
    
    protected ManufacturerShop () {}

    public ManufacturerShop(int idManufacturer, int idShop) {
        this.idManufacturer = idManufacturer;
        this.idShop = idShop;
    }

    public int getIdManufacturer() {
        return idManufacturer;
    }

    public void setIdManufacturer(int idManufacturer) {
        this.idManufacturer = idManufacturer;
    }

    public int getIdShop() {
        return idShop;
    }

    public void setIdShop(int idShop) {
        this.idShop = idShop;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + this.idManufacturer;
        hash = 61 * hash + this.idShop;
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
        final ManufacturerShop other = (ManufacturerShop) obj;
        if (this.idManufacturer != other.idManufacturer) {
            return false;
        }
        if (this.idShop != other.idShop) {
            return false;
        }
        return true;
    }
    
    
}
