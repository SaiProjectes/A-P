/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sai.persistence.ahora;

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
@Table(name="dbo.Objetos_Imagenes")
public class ObjetoImagen implements Serializable {
    @Id 
    @Column(name="Objeto")
    private String objeto;
    @Id 
    @Column(name="NombreFichero")
    private String nombreFichero;
    @Id 
    @Column(name="IdDocObjeto")
    private int idDocObjeto;
    @Column(name="Descrip")
    private String descrip;
    @Column(name="Tipo")
    private String tipo;
    @Column(name="Principal")
    private Short principal;
    @Column(name="Orden")
    private Integer orden;
    @Column(name="IdClasificacion")
    private Integer idClasificacion;
    
    protected ObjetoImagen () {}

    public String getObjeto() {
        return objeto;
    }

    public void setObjeto(String objeto) {
        this.objeto = objeto;
    }

    public String getNombreFichero() {
        return nombreFichero;
    }

    public void setNombreFichero(String nombreFichero) {
        this.nombreFichero = nombreFichero;
    }

    public int getIdDocObjeto() {
        return idDocObjeto;
    }

    public void setIdDocObjeto(int idDocObjeto) {
        this.idDocObjeto = idDocObjeto;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Short getPrincipal() {
        return principal;
    }

    public void setPrincipal(Short principal) {
        this.principal = principal;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public Integer getIdClasificacion() {
        return idClasificacion;
    }

    public void setIdClasificacion(Integer idClasificacion) {
        this.idClasificacion = idClasificacion;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.objeto);
        hash = 89 * hash + Objects.hashCode(this.nombreFichero);
        hash = 89 * hash + this.idDocObjeto;
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
        final ObjetoImagen other = (ObjetoImagen) obj;
        if (this.idDocObjeto != other.idDocObjeto) {
            return false;
        }
        if (!Objects.equals(this.objeto, other.objeto)) {
            return false;
        }
        if (!Objects.equals(this.nombreFichero, other.nombreFichero)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
