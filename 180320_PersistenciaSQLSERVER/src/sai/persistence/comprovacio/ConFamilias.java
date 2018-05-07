/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sai.persistence.comprovacio;

import java.io.Serializable;
import java.util.Date;
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
@Table(name="dbo.con_familias")
public class ConFamilias implements Serializable {
    @Id
    @Column(name="codigo")
    private String codigo;
    @Column(name="accio")
    private int accio;
    @Id
    @Column(name="data_accio")
    private Date data_accio;
    
    protected ConFamilias(){}

    public String getCodigo() {
        return codigo;
    }

    public int getAccio() {
        return accio;
    }

    public Date getData_accio() {
        return data_accio;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + Objects.hashCode(this.codigo);
        hash = 11 * hash + Objects.hashCode(this.data_accio);
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
        final ConFamilias other = (ConFamilias) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.data_accio, other.data_accio)) {
            return false;
        }
        return true;
    }
    
    
}
