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
@Table(name="dbo.Articulos_Stock")
public class Stock implements Serializable {
    @Id
    @Column(name="IdArticulo")
    private String idArticulo;
    @Id
    @Column(name="IdAlmacen")
    private Short idAlmacen;
    @Column(name="Stock")
    private BigDecimal stock;
    @Column(name="FechaUltEnt")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaUltEnt;
    @Column(name="FechaUltSal")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaUltSal;
    @Column(name="StockAnterior")
    private BigDecimal stockAnterior;
    @Column(name="StockMinimo")
    private BigDecimal stockMinimo;
    @Column(name="StockMaximo")
    private BigDecimal stockMaximo;
    @Column(name="StockReservado")
    private BigDecimal stockReservado;
    @Column(name="StockPedido")
    private BigDecimal stockPedido;
    @Column(name="UnidadesStock")
    private BigDecimal unidadesStock;
    @Column(name="UnidadesStockAnterior")
    private BigDecimal unidadesStockAnterior;
    @Column(name="UnidadesStockMinimo")
    private BigDecimal unidadesStockMinimo;
    @Column(name="UnidadesStockMaximo")
    private BigDecimal unidadesStockMaximo;
    @Column(name="UnidadesStockReservado")
    private BigDecimal unidadesStockReservado;
    @Column(name="UnidadesStockPedido")
    private BigDecimal unidadesStockPedido;
    
    protected Stock () {}

    public String getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(String idArticulo) {
        this.idArticulo = idArticulo;
    }

    public Short getIdAlmacen() {
        return idAlmacen;
    }

    public void setIdAlmacen(Short idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    public BigDecimal getStock() {
        return stock;
    }

    public void setStock(BigDecimal stock) {
        this.stock = stock;
    }

    public Date getFechaUltEnt() {
        return fechaUltEnt;
    }

    public void setFechaUltEnt(Date fechaUltEnt) {
        this.fechaUltEnt = fechaUltEnt;
    }

    public Date getFechaUltSal() {
        return fechaUltSal;
    }

    public void setFechaUltSal(Date fechaUltSal) {
        this.fechaUltSal = fechaUltSal;
    }

    public BigDecimal getStockAnterior() {
        return stockAnterior;
    }

    public void setStockAnterior(BigDecimal stockAnterior) {
        this.stockAnterior = stockAnterior;
    }

    public BigDecimal getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(BigDecimal stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public BigDecimal getStockMaximo() {
        return stockMaximo;
    }

    public void setStockMaximo(BigDecimal stockMaximo) {
        this.stockMaximo = stockMaximo;
    }

    public BigDecimal getStockReservado() {
        return stockReservado;
    }

    public void setStockReservado(BigDecimal stockReservado) {
        this.stockReservado = stockReservado;
    }

    public BigDecimal getStockPedido() {
        return stockPedido;
    }

    public void setStockPedido(BigDecimal stockPedido) {
        this.stockPedido = stockPedido;
    }

    public BigDecimal getUnidadesStock() {
        return unidadesStock;
    }

    public void setUnidadesStock(BigDecimal unidadesStock) {
        this.unidadesStock = unidadesStock;
    }

    public BigDecimal getUnidadesStockAnterior() {
        return unidadesStockAnterior;
    }

    public void setUnidadesStockAnterior(BigDecimal unidadesStockAnterior) {
        this.unidadesStockAnterior = unidadesStockAnterior;
    }

    public BigDecimal getUnidadesStockMinimo() {
        return unidadesStockMinimo;
    }

    public void setUnidadesStockMinimo(BigDecimal unidadesStockMinimo) {
        this.unidadesStockMinimo = unidadesStockMinimo;
    }

    public BigDecimal getUnidadesStockMaximo() {
        return unidadesStockMaximo;
    }

    public void setUnidadesStockMaximo(BigDecimal unidadesStockMaximo) {
        this.unidadesStockMaximo = unidadesStockMaximo;
    }

    public BigDecimal getUnidadesStockReservado() {
        return unidadesStockReservado;
    }

    public void setUnidadesStockReservado(BigDecimal unidadesStockReservado) {
        this.unidadesStockReservado = unidadesStockReservado;
    }

    public BigDecimal getUnidadesStockPedido() {
        return unidadesStockPedido;
    }

    public void setUnidadesStockPedido(BigDecimal unidadesStockPedido) {
        this.unidadesStockPedido = unidadesStockPedido;
    }

    @Override
    public String toString() {
        return "Stock{" + "idArticulo=" + idArticulo + ", idAlmacen=" + idAlmacen + ", stock=" + stock + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.idArticulo);
        hash = 23 * hash + Objects.hashCode(this.idAlmacen);
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
        final Stock other = (Stock) obj;
        if (!Objects.equals(this.idArticulo, other.idArticulo)) {
            return false;
        }
        if (!Objects.equals(this.idAlmacen, other.idAlmacen)) {
            return false;
        }
        return true;
    }
    
    
    
}
