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
@Table(name="dbo.con_descuen")
public class ConDescuen implements Serializable {
    @Id
    @Column(name="cliente")
    private String cliente;
    @Id
    @Column(name="linea")
    private int linea;
    @Column(name="accio")
    private int accio;
    @Id
    @Column(name="data_accio")
    private Date dataAccio;
    
    protected ConDescuen () {}

    public ConDescuen(String cliente, int linea, int accio, Date dataAccio) {
        this.cliente = cliente;
        this.linea = linea;
        this.accio = accio;
        this.dataAccio = dataAccio;
    }

    public String getCliente() {
        return cliente;
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
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.cliente);
        hash = 71 * hash + this.linea;
        hash = 71 * hash + Objects.hashCode(this.dataAccio);
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
        final ConDescuen other = (ConDescuen) obj;
        if (this.linea != other.linea) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        if (!Objects.equals(this.dataAccio, other.dataAccio)) {
            return false;
        }
        return true;
    }
    
    
}
