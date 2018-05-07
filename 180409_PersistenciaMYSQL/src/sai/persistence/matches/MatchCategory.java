/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sai.persistence.matches;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author PROGRAMACIO3
 */
@Entity
@Table(name="ps_match_category")
public class MatchCategory implements Serializable {
    @Column(name="id_presta")
    private int idPresta;
    @Id
    @Column(name="id_euro")
    private String idEuro;
    @Column(name="is_subfamily")
    private boolean isSubfamily;
    
    protected MatchCategory () {}

    public MatchCategory(int idPresta, String idEuro, boolean isSubfamily) {
        this.idPresta = idPresta;
        this.idEuro = idEuro;
        this.isSubfamily = isSubfamily;
    }

    public int getIdPresta() {
        return idPresta;
    }

    public void setIdPresta(int idPresta) {
        this.idPresta = idPresta;
    }

    public String getIdEuro() {
        return idEuro;
    }

    public void setIdEuro(String idEuro) {
        this.idEuro = idEuro;
    }

    public boolean isIsSubfamily() {
        return isSubfamily;
    }

    public void setIsSubfamily(boolean isSubfamily) {
        this.isSubfamily = isSubfamily;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.idEuro);
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
        final MatchCategory other = (MatchCategory) obj;
        if (!Objects.equals(this.idEuro, other.idEuro)) {
            return false;
        }
        return true;
    }
    
    
}
