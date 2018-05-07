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
@Table(name="ps_attribute")
public class Attribute implements Serializable {
    @Id
    @Column(name="id_attribute")
    private int idAttribute;
    @Column(name="id_attribute_group")
    private int idAttributeGroup;
    @Column(name="color")
    private String color;
    @Column(name="position")
    private int position;
    
    protected Attribute() {}

    public Attribute(int idAttribute, int idAttributeGroup, String color, int position) {
        this.idAttribute = idAttribute;
        this.idAttributeGroup = idAttributeGroup;
        this.color = color;
        this.position = position;
    }

    public int getIdAttribute() {
        return idAttribute;
    }


    public int getIdAttributeGroup() {
        return idAttributeGroup;
    }

    public void setIdAttributeGroup(int idAttributeGroup) {
        this.idAttributeGroup = idAttributeGroup;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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
        hash = 47 * hash + this.idAttribute;
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
        final Attribute other = (Attribute) obj;
        if (this.idAttribute != other.idAttribute) {
            return false;
        }
        return true;
    }
    
    
    
}
