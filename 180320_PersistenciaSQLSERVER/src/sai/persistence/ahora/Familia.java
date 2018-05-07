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
@Table(name="dbo.Articulos_Familias")
public class Familia implements Serializable {
    @Id
    @Column(name="IdFamilia")
    private String idFamilia;
    @Column(name="Descrip")
    private String descrip;
    @Column(name="IdFamiliaPadre")
    private String idFamiliaPadre;
    @Column(name="UltimoNivel")
    private short ultimoNivel;
    @Column(name="NumeroNivel")
    private short numeroNivel;
    
    //ecommerce
    @Column(name="ECommerce_Activo")
    private short eActivo;
    @Column(name="ECommerce_Descrip")
    private String eDescrip;
    @Column(name="ECommerce_MetaTitulo")
    private String eMetaTitulo;
    @Column(name="ECommerce_MetaDescripcion")
    private String eMetaDescripcion;
    @Column(name="ECommerce_MetaKeywords")
    private String eMetaKeywords;
    
    protected Familia () {}

    public String getIdFamilia() {
        return idFamilia;
    }

    public void setIdFamilia(String idFamilia) {
        this.idFamilia = idFamilia;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getIdFamiliaPadre() {
        return idFamiliaPadre;
    }

    public void setIdFamiliaPadre(String idFamiliaPadre) {
        this.idFamiliaPadre = idFamiliaPadre;
    }

    public short getUltimoNivel() {
        return ultimoNivel;
    }

    public void setUltimoNivel(short ultimoNivel) {
        this.ultimoNivel = ultimoNivel;
    }

    public short getNumeroNivel() {
        return numeroNivel;
    }

    public void setNumeroNivel(short numeroNivel) {
        this.numeroNivel = numeroNivel;
    }

    public short geteActivo() {
        return eActivo;
    }

    public void seteActivo(short eActivo) {
        this.eActivo = eActivo;
    }

    public String geteDescrip() {
        return eDescrip;
    }

    public void seteDescrip(String eDescrip) {
        this.eDescrip = eDescrip;
    }

    public String geteMetaTitulo() {
        return eMetaTitulo;
    }

    public void seteMetaTitulo(String eMetaTitulo) {
        this.eMetaTitulo = eMetaTitulo;
    }

    public String geteMetaDescripcion() {
        return eMetaDescripcion;
    }

    public void seteMetaDescripcion(String eMetaDescripcion) {
        this.eMetaDescripcion = eMetaDescripcion;
    }

    public String geteMetaKeywords() {
        return eMetaKeywords;
    }

    public void seteMetaKeywords(String eMetaKeywords) {
        this.eMetaKeywords = eMetaKeywords;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.idFamilia);
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
        final Familia other = (Familia) obj;
        if (!Objects.equals(this.idFamilia, other.idFamilia)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Familia{" + "idFamilia=" + idFamilia + ", descrip=" + descrip + ", eActivo=" + eActivo + ", eDescrip=" + eDescrip + '}';
    }
    
    
    
    
}
