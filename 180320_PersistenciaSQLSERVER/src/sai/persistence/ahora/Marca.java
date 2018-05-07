/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sai.persistence.ahora;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author programacio3
 */
@Entity
@Table(name="dbo.PartesMarcasMaquinas")
public class Marca implements Serializable {
    @Id
    @Column(name="IdMarcaMaquina")
    private int idMarca;
    @Column(name="Descrip")
    private String Descrip;
    
    protected Marca () {}

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public String getDescrip() {
        return Descrip;
    }

    public void setDescrip(String Descrip) {
        this.Descrip = Descrip;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.idMarca;
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
        final Marca other = (Marca) obj;
        if (this.idMarca != other.idMarca) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Marca{" + "idMarca=" + idMarca + ", Descrip=" + Descrip + '}';
    }
    
    
}
