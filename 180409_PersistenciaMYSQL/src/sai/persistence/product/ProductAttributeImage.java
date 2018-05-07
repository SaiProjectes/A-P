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
@Table(name="ps_product_attribute_image")
public class ProductAttributeImage implements Serializable {
    //
    @Id
    @Column(name="id_product_attribute")
    private int idProductAttribute;
    @Id
    @Column(name="id_image")
    private int idImage;
    
    protected ProductAttributeImage (){}

    public ProductAttributeImage(int idProductAttribute, int idImage) {
        this.idProductAttribute = idProductAttribute;
        this.idImage = idImage;
    }

    public int getIdProductAttribute() {
        return idProductAttribute;
    }

    public int getIdImage() {
        return idImage;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.idProductAttribute;
        hash = 67 * hash + this.idImage;
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
        final ProductAttributeImage other = (ProductAttributeImage) obj;
        if (this.idProductAttribute != other.idProductAttribute) {
            return false;
        }
        if (this.idImage != other.idImage) {
            return false;
        }
        return true;
    }
    
    
}
