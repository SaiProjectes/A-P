/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sai.persistence.ahora;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author programacio3
 */
@Entity
@Table(name="dbp.Listas_Precios_Cli")
public class ListaPrecio implements Serializable {
    @Id
    @Column(name="IdLista")
    private int idLista;
    @Column(name="Descrip")
    private String descrip;
    @Column(name="DesdeFecha")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date desdeFecha;
    @Column(name="HastaFecha")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date hastaFecha;
    @Column(name="Revision")
    private BigDecimal revision;
    @Column(name="DescripcionRev")
    private String descripcionRev;
    @Column(name="Cerrado")
    private short cerrado;
    @Column(name="ComisionDef")
    private int comisionDef;
    @Column(name="IdMoneda")
    private short idMoneda;
    @Column(name="IdListaPadre")
    private int idListaPadre;
    @Column(name="IdTipo")
    private short idTipo;
    @Column(name="Activa")
    private short activa;
    @Column(name="NumDecimales")
    private short numDecimales;
    @Column(name="PVP")
    private short pvp;
    
    protected ListaPrecio () {}

    public int getIdLista() {
        return idLista;
    }

    public void setIdLista(int idLista) {
        this.idLista = idLista;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public Date getDesdeFecha() {
        return desdeFecha;
    }

    public void setDesdeFecha(Date desdeFecha) {
        this.desdeFecha = desdeFecha;
    }

    public Date getHastaFecha() {
        return hastaFecha;
    }

    public void setHastaFecha(Date hastaFecha) {
        this.hastaFecha = hastaFecha;
    }

    public BigDecimal getRevision() {
        return revision;
    }

    public void setRevision(BigDecimal revision) {
        this.revision = revision;
    }

    public String getDescripcionRev() {
        return descripcionRev;
    }

    public void setDescripcionRev(String descripcionRev) {
        this.descripcionRev = descripcionRev;
    }

    public short getCerrado() {
        return cerrado;
    }

    public void setCerrado(short cerrado) {
        this.cerrado = cerrado;
    }

    public int getComisionDef() {
        return comisionDef;
    }

    public void setComisionDef(int comisionDef) {
        this.comisionDef = comisionDef;
    }

    public short getIdMoneda() {
        return idMoneda;
    }

    public void setIdMoneda(short idMoneda) {
        this.idMoneda = idMoneda;
    }

    public int getIdListaPadre() {
        return idListaPadre;
    }

    public void setIdListaPadre(int idListaPadre) {
        this.idListaPadre = idListaPadre;
    }

    public short getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(short idTipo) {
        this.idTipo = idTipo;
    }

    public short getActiva() {
        return activa;
    }

    public void setActiva(short activa) {
        this.activa = activa;
    }

    public short getNumDecimales() {
        return numDecimales;
    }

    public void setNumDecimales(short numDecimales) {
        this.numDecimales = numDecimales;
    }

    public short getPvp() {
        return pvp;
    }

    public void setPvp(short pvp) {
        this.pvp = pvp;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.idLista;
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
        final ListaPrecio other = (ListaPrecio) obj;
        if (this.idLista != other.idLista) {
            return false;
        }
        return true;
    }
    
    


    
}
