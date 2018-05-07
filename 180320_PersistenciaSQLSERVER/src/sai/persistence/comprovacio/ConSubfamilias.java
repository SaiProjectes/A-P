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
@Table(name="dbo.con_subfamilias")
public class ConSubfamilias implements Serializable {
    @Id
    @Column(name="codigo")
    private String codigo;
    @Id
    @Column(name="familia")
    private String familia;
    @Column(name="accio")
    private int accio;
    @Id
    @Column(name="data_accio")
    private Date dataAccio;
    
    protected ConSubfamilias () {}

    public String getCodigo() {
        return codigo;
    }

    public String getFamilia() {
        return familia;
    }

    public int getAccio() {
        return accio;
    }

    public Date getDataAccio() {
        return dataAccio;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.codigo);
        hash = 23 * hash + Objects.hashCode(this.familia);
        hash = 23 * hash + Objects.hashCode(this.dataAccio);
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
        final ConSubfamilias other = (ConSubfamilias) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.familia, other.familia)) {
            return false;
        }
        if (!Objects.equals(this.dataAccio, other.dataAccio)) {
            return false;
        }
        return true;
    }
    
    
}
