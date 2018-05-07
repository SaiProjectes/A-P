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
@Table(name="ps_tag_count")
public class TagCount implements Serializable {
    @Id
    @Column(name="id_group")
    private int idGroup;
    @Id
    @Column(name="id_tag")
    private int idTag;
    @Column(name="id_lang")
    private int idLang;
    @Column(name="id_shop")
    private int idShop;
    @Column(name="counter")
    private int counter;
    
    protected TagCount () {}

    public TagCount(int idGroup, int idTag, int idLang, int idShop, int counter) {
        this.idGroup = idGroup;
        this.idTag = idTag;
        this.idLang = idLang;
        this.idShop = idShop;
        this.counter = counter;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.idGroup;
        hash = 17 * hash + this.idTag;
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
        final TagCount other = (TagCount) obj;
        if (this.idGroup != other.idGroup) {
            return false;
        }
        if (this.idTag != other.idTag) {
            return false;
        }
        return true;
    }
    
    
}
