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
@Table(name="ps_tag")
public class Tag implements Serializable {
    @Id
    @Column(name="id_tag")
    private int idTag;
    @Column(name="id_lang")
    private int idLang;
    @Column(name="name")
    private String name;
    
    protected Tag() {}

    public Tag(int idTag, int idLang, String name) {
        this.idTag = idTag;
        this.idLang = idLang;
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.idTag;
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
        final Tag other = (Tag) obj;
        if (this.idTag != other.idTag) {
            return false;
        }
        return true;
    }
    
    
}
