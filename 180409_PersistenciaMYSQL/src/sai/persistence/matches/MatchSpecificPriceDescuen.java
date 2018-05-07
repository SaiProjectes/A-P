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
@Table(name="ps_match_specific_price_descuen")
public class MatchSpecificPriceDescuen implements Serializable {
    @Id
    @Column(name="id_presta")
    private int idPresta;
    @Id
    @Column(name="id_euro_cliente")
    private String idEuroCliente;
    @Id
    @Column(name="id_euro_linea")
    private int idEuroLinea;
    
    protected MatchSpecificPriceDescuen () {}

    public MatchSpecificPriceDescuen(int idPresta, String idEuroCliente, int idEuroLinea) {
        this.idPresta = idPresta;
        this.idEuroCliente = idEuroCliente;
        this.idEuroLinea = idEuroLinea;
    }

    public int getIdPresta() {
        return idPresta;
    }

    public void setIdPresta(int idPresta) {
        this.idPresta = idPresta;
    }

    public String getIdEuroCliente() {
        return idEuroCliente;
    }

    public void setIdEuroCliente(String idEuroCliente) {
        this.idEuroCliente = idEuroCliente;
    }

    public int getIdEuroLinea() {
        return idEuroLinea;
    }

    public void setIdEuroLinea(int idEuroLinea) {
        this.idEuroLinea = idEuroLinea;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.idPresta;
        hash = 29 * hash + Objects.hashCode(this.idEuroCliente);
        hash = 29 * hash + this.idEuroLinea;
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
        final MatchSpecificPriceDescuen other = (MatchSpecificPriceDescuen) obj;
        if (this.idPresta != other.idPresta) {
            return false;
        }
        if (this.idEuroLinea != other.idEuroLinea) {
            return false;
        }
        if (!Objects.equals(this.idEuroCliente, other.idEuroCliente)) {
            return false;
        }
        return true;
    }

    
    
    
    
}
