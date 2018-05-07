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
@Table(name="ps_category_shop")
public class CategoryShop implements Serializable {
    @Id
    @Column(name="id_category")
    private int idCategory;
    @Id
    @Column(name="id_shop")
    private int idShop;
    @Column(name="position")
    private int position;
    
    protected CategoryShop(){}

    public CategoryShop(int idCategory, int idShop, int position) {
        this.idCategory = idCategory;
        this.idShop = idShop;
        this.position = position;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public int getIdShop() {
        return idShop;
    }

    public void setIdShop(int idShop) {
        this.idShop = idShop;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "CategoryShop{" + "idCategory=" + idCategory + ", idShop=" + idShop + ", position=" + position + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.idCategory;
        hash = 17 * hash + this.idShop;
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
        final CategoryShop other = (CategoryShop) obj;
        if (this.idCategory != other.idCategory) {
            return false;
        }
        if (this.idShop != other.idShop) {
            return false;
        }
        return true;
    }
    
    
    
    
}
