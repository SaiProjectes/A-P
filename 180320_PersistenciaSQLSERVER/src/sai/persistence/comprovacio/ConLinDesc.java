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
@Table(name="dbo.con_lin_desc")
public class ConLinDesc implements Serializable {
    @Id
    @Column(name="CODIGO")
    private String codigo;
    @Id
    @Column(name="LINEA")
    private int linea;
    @Column(name="ACCIO")
    private int accio;
    @Column(name="DATA_ACCIO")
    private Date dataAccio;
    
    protected ConLinDesc () {}

    public ConLinDesc(String codigo, int linea, int accio, Date dataAccio) {
        this.codigo = codigo;
        this.linea = linea;
        this.accio = accio;
        this.dataAccio = dataAccio;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getLinea() {
        return linea;
    }

    public int getAccio() {
        return accio;
    }

    public Date getDataAccio() {
        return dataAccio;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.codigo);
        hash = 37 * hash + this.linea;
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
        final ConLinDesc other = (ConLinDesc) obj;
        if (this.linea != other.linea) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }
    
    
}
