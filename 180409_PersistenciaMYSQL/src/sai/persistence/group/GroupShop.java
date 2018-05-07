/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sai.persistence.group;

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
@Table(name="ps_group_shop")
public class GroupShop implements Serializable {
    @Id
    @Column(name="id_group")
    private int idGroup;
    @Id
    @Column(name="id_shop")
    private int idShop;
    
    protected GroupShop() {}

    public GroupShop(int idGroup, int idShop) {
        this.idGroup = idGroup;
        this.idShop = idShop;
    }

    public int getIdGroup() {
        return idGroup;
    }

    public int getIdShop() {
        return idShop;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.idGroup;
        hash = 89 * hash + this.idShop;
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
        final GroupShop other = (GroupShop) obj;
        if (this.idGroup != other.idGroup) {
            return false;
        }
        if (this.idShop != other.idShop) {
            return false;
        }
        return true;
    }
    
    
    
    
}
