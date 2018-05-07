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
@Table(name="ps_group_lang")
public class GroupLang implements Serializable {
    @Id
    @Column(name="id_group")
    private int idGroup;
    @Id
    @Column(name="id_lang")
    private int idLang;
    @Column(name="name")
    private String name;
    
    protected GroupLang () {}

    public GroupLang(int idGroup, int idLang, String name) {
        this.idGroup = idGroup;
        this.idLang = idLang;
        this.name = name;
    }

    public int getIdGroup() {
        return idGroup;
    }

    public int getIdLang() {
        return idLang;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.idGroup;
        hash = 97 * hash + this.idLang;
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
        final GroupLang other = (GroupLang) obj;
        if (this.idGroup != other.idGroup) {
            return false;
        }
        if (this.idLang != other.idLang) {
            return false;
        }
        return true;
    }
    
    
}
