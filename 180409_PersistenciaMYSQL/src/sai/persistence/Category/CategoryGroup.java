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
@Table(name="ps_category_group")
public class CategoryGroup implements Serializable {
    @Id
    @Column(name="id_category")
    private int idCategory;
    @Id
    @Column(name="id_group")
    private int idGroup;
    
    protected CategoryGroup () {}

    public CategoryGroup(int idCategory, int idGroup) {
        this.idCategory = idCategory;
        this.idGroup = idGroup;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public int getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(int idGroup) {
        this.idGroup = idGroup;
    }

    @Override
    public String toString() {
        return "CategoryGroup{" + "idCategory=" + idCategory + ", idGroup=" + idGroup + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.idCategory;
        hash = 71 * hash + this.idGroup;
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
        final CategoryGroup other = (CategoryGroup) obj;
        if (this.idCategory != other.idCategory) {
            return false;
        }
        if (this.idGroup != other.idGroup) {
            return false;
        }
        return true;
    }
    
    
    
}
