/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sai.persistence.product;

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
@Table(name="ps_accessory")
public class Accessory implements Serializable {
    @Id
    @Column(name="id_product_1")
    private int product1;
    @Id
    @Column(name="id_product_2")
    private int product2;

    public Accessory(int product1, int product2) {
        this.product1 = product1;
        this.product2 = product2;
    }
    
    
    
    protected Accessory () {}

    public int getProduct1() {
        return product1;
    }

    public void setProduct1(int product1) {
        this.product1 = product1;
    }

    public int getProduct2() {
        return product2;
    }

    public void setProduct2(int product2) {
        this.product2 = product2;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + this.product1;
        hash = 71 * hash + this.product2;
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
        final Accessory other = (Accessory) obj;
        if (this.product1 != other.product1) {
            return false;
        }
        if (this.product2 != other.product2) {
            return false;
        }
        return true;
    }
    
    
    
}
