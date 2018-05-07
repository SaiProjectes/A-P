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
@Table(name="ps_match_group_lindesc")
public class MatchGroupLinDesc implements Serializable {
    @Column(name="id_presta_group")
    private int idPrestaGroup;
    @Id
    @Column(name="id_euro_lin_desc")
    private String idEuroLinDesc;
    
    protected MatchGroupLinDesc(){}

    public MatchGroupLinDesc(int idPrestaGroup, String idEuroLinDesc) {
        this.idPrestaGroup = idPrestaGroup;
        this.idEuroLinDesc = idEuroLinDesc;
        
    }

    public int getIdPrestaGroup() {
        return idPrestaGroup;
    }

    public String getIdEuroLinDesc() {
        return idEuroLinDesc;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.idEuroLinDesc);
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
        final MatchGroupLinDesc other = (MatchGroupLinDesc) obj;
        if (!Objects.equals(this.idEuroLinDesc, other.idEuroLinDesc)) {
            return false;
        }
        return true;
    }
    
    
}
