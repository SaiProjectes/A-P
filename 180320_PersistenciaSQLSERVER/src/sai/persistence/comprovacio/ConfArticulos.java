/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sai.persistence.comprovacio;

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
@Table(name="dbo.Conf_Articulos")
public class ConfArticulos implements Serializable {
    @Id
    @Column(name="IdArticulo")
    private String idArticulo;
    @Column(name="Pers_Estado")
    private Short estado;
    
    protected ConfArticulos () {}

    public String getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(String idArticulo) {
        this.idArticulo = idArticulo;
    }

    public Short getEstado() {
        return estado;
    }

    public void setEstado(Short estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.idArticulo);
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
        final ConfArticulos other = (ConfArticulos) obj;
        if (!Objects.equals(this.idArticulo, other.idArticulo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ConfArticulos{" + "idArticulo=" + idArticulo + ", estado=" + estado + '}';
    }
    
    
}
