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
 * @author programacio3
 */
@Entity
@Table(name="ps_match_manufacturer")
public class MatchManufacturer implements Serializable {
    @Column(name="id_presta")
    private int idPresta;
    @Id
    @Column(name="id_euro")
    private Integer idEuro;
    
    protected MatchManufacturer (){}

    public int getIdPresta() {
        return idPresta;
    }

    public void setIdPresta(int idPresta) {
        this.idPresta = idPresta;
    }

    public Integer getIdEuro() {
        return idEuro;
    }

    public void setIdEuro(Integer idEuro) {
        this.idEuro = idEuro;
    }

    public MatchManufacturer(int idPresta, Integer idEuro) {
        this.idPresta = idPresta;
        this.idEuro = idEuro;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.idEuro);
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
        final MatchManufacturer other = (MatchManufacturer) obj;
        if (!Objects.equals(this.idEuro, other.idEuro)) {
            return false;
        }
        return true;
    }
    
    
}
