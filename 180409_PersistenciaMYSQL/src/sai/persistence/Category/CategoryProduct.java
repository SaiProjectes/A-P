/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sai.persistence.Category;

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
@Table(name="ps_category_product")
public class CategoryProduct implements Serializable {
    @Id
    @Column(name="id_category")
    private int idCategory;
    @Id
    @Column(name="id_product")
    private int idProduct;
    @Column(name="position")
    private int position;
    
    protected CategoryProduct () {}

    public CategoryProduct(int idCategory, int idProduct, int position) {
        this.idCategory = idCategory;
        this.idProduct = idProduct;
        this.position = position;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.idCategory;
        hash = 89 * hash + this.idProduct;
        hash = 89 * hash + this.position;
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
        final CategoryProduct other = (CategoryProduct) obj;
        if (this.idCategory != other.idCategory) {
            return false;
        }
        if (this.idProduct != other.idProduct) {
            return false;
        }
        if (this.position != other.position) {
            return false;
        }
        return true;
    }
    
    
    
}
