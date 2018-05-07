/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sai.persistence.ahora;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
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
@Table(name="dbo.Listas_Precios_Cli_Art")
public class ListaPrecioArt implements Serializable {
    @Id
    @Column(name="IdLista")
    private int idLista;
    @Id
    @Column(name="IdArticulo")
    private String idArticulo;
    @Id
    @Column(name="DesdeUnidades")
    private BigDecimal desdeUnidades;
    @Id
    @Column(name="DesdeFecha")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date desdeFecha;
    @Column(name="UnidadMinima")
    private int unidadMinima;
    @Column(name="IdTipoUnidad")
    private String idTipoUnidad;
    @Column(name="Precio")
    private BigDecimal precio;
    @Column(name="Comision")
    private BigDecimal comision;
    @Column(name="Porcentaje")
    private BigDecimal porcentaje;
    @Column(name="Actualizar")
    private short actualizar;
    @Column(name="PrecioNeto")
    private short precioNeto;
    @Column(name="Descuento1")
    private BigDecimal descuento1;
    @Column(name="Descuento2")
    private BigDecimal descuento2;
    @Column(name="FechaHasta")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaHasta;
    @Column(name="Descuento3")
    private BigDecimal descuento3;
    @Column(name="Descuento4")
    private BigDecimal descuento4;
    @Column(name="Descuento5")
    private BigDecimal descuento5;
    
    
    protected ListaPrecioArt () {}

    public int getIdLista() {
        return idLista;
    }

    public void setIdLista(int idLista) {
        this.idLista = idLista;
    }

    public String getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(String idArticulo) {
        this.idArticulo = idArticulo;
    }

    public BigDecimal getDesdeUnidades() {
        return desdeUnidades;
    }

    public void setDesdeUnidades(BigDecimal desdeUnidades) {
        this.desdeUnidades = desdeUnidades;
    }

    public Date getDesdeFecha() {
        return desdeFecha;
    }

    public void setDesdeFecha(Date desdeFecha) {
        this.desdeFecha = desdeFecha;
    }

    public int getUnidadMinima() {
        return unidadMinima;
    }

    public void setUnidadMinima(int unidadMinima) {
        this.unidadMinima = unidadMinima;
    }

    public String getIdTipoUnidad() {
        return idTipoUnidad;
    }

    public void setIdTipoUnidad(String idTipoUnidad) {
        this.idTipoUnidad = idTipoUnidad;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public BigDecimal getComision() {
        return comision;
    }

    public void setComision(BigDecimal comision) {
        this.comision = comision;
    }

    public BigDecimal getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(BigDecimal porcentaje) {
        this.porcentaje = porcentaje;
    }

    public short getActualizar() {
        return actualizar;
    }

    public void setActualizar(short actualizar) {
        this.actualizar = actualizar;
    }

    public short getPrecioNeto() {
        return precioNeto;
    }

    public void setPrecioNeto(short precioNeto) {
        this.precioNeto = precioNeto;
    }

    public BigDecimal getDescuento1() {
        return descuento1;
    }

    public void setDescuento1(BigDecimal descuento1) {
        this.descuento1 = descuento1;
    }

    public BigDecimal getDescuento2() {
        return descuento2;
    }

    public void setDescuento2(BigDecimal descuento2) {
        this.descuento2 = descuento2;
    }

    public Date getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public BigDecimal getDescuento3() {
        return descuento3;
    }

    public void setDescuento3(BigDecimal descuento3) {
        this.descuento3 = descuento3;
    }

    public BigDecimal getDescuento4() {
        return descuento4;
    }

    public void setDescuento4(BigDecimal descuento4) {
        this.descuento4 = descuento4;
    }

    public BigDecimal getDescuento5() {
        return descuento5;
    }

    public void setDescuento5(BigDecimal descuento5) {
        this.descuento5 = descuento5;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + this.idLista;
        hash = 73 * hash + Objects.hashCode(this.idArticulo);
        hash = 73 * hash + Objects.hashCode(this.desdeUnidades);
        hash = 73 * hash + Objects.hashCode(this.desdeFecha);
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
        final ListaPrecioArt other = (ListaPrecioArt) obj;
        if (this.idLista != other.idLista) {
            return false;
        }
        if (!Objects.equals(this.idArticulo, other.idArticulo)) {
            return false;
        }
        if (!Objects.equals(this.desdeUnidades, other.desdeUnidades)) {
            return false;
        }
        if (!Objects.equals(this.desdeFecha, other.desdeFecha)) {
            return false;
        }
        return true;
    }

    
}
