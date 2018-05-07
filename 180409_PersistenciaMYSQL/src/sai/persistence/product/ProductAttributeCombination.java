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
@Table(name="ps_product_attribute_combination")
public class ProductAttributeCombination implements Serializable {
    @Id
    @Column(name="id_attribute")
    private int idAttribute;
    @Id
    @Column(name="id_product_attribute")
    private int idProductAttribute;
    
    protected ProductAttributeCombination() {}

    public ProductAttributeCombination(int idAttribute, int idProductAttribute) {
        this.idAttribute = idAttribute;
        this.idProductAttribute = idProductAttribute;
    }

    public int getIdAttribute() {
        return idAttribute;
    }

    public int getIdProductAttribute() {
        return idProductAttribute;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.idAttribute;
        hash = 79 * hash + this.idProductAttribute;
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
        final ProductAttributeCombination other = (ProductAttributeCombination) obj;
        if (this.idAttribute != other.idAttribute) {
            return false;
        }
        if (this.idProductAttribute != other.idProductAttribute) {
            return false;
        }
        return true;
    }
    
    
}
