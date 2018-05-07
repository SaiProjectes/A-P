/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sai.persistence.tag;

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
@Table(name="ps_product_tag")
public class ProductTag implements Serializable {
    @Id
    @Column(name="id_product")
    private int idProduct;
    @Id
    @Column(name="id_tag")
    private int idTag;
    @Column(name="id_lang")
    private int idLang;
    
    protected ProductTag() {}

    public ProductTag(int idProduct, int idTag, int idLang) {
        this.idProduct = idProduct;
        this.idTag = idTag;
        this.idLang = idLang;
    }

    
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.idProduct;
        hash = 23 * hash + this.idTag;
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
        final ProductTag other = (ProductTag) obj;
        if (this.idProduct != other.idProduct) {
            return false;
        }
        if (this.idTag != other.idTag) {
            return false;
        }
        return true;
    }
    
    
}
