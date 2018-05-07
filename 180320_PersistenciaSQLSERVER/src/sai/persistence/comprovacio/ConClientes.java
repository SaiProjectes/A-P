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
@Table(name="dbo.con_clientes")
public class ConClientes implements Serializable {
    @Id
    @Column(name="codigo")
    private String codigo;
    @Column(name="accio")
    private int accio;
    @Id
    @Column(name="data_accio")
    private Date dataAccio;
    
    protected ConClientes () {}

    public String getCodigo() {
        return codigo;
    }

    public int getAccio() {
        return accio;
    }

    public Date getDataAccio() {
        return dataAccio;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.codigo);
        hash = 47 * hash + Objects.hashCode(this.dataAccio);
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
        final ConClientes other = (ConClientes) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.dataAccio, other.dataAccio)) {
            return false;
        }
        return true;
    }
    
    
}
