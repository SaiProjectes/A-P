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
@Table(name="dbo.Pedidos_Cli_Lineas")
public class PedidoLinea implements Serializable {
    @Id
    @Column(name="IdPedido")
    private int idPedido;
    @Id
    @Column(name="IdLinea")
    private short idLinea;
    @Column(name="IdArticulo")
    private String idArticulo;
    @Column(name="IdArticuloCli")
    private String idArticuloCli;
    @Column(name="IdAlmacen")
    private Short idAlmacen;
    @Column(name="Cantidad")
    private BigDecimal cantidad;
    @Column(name="Precio")
    private BigDecimal precio;
    @Column(name="Precio_EURO")
    private BigDecimal precioEuro;
    @Column(name="PrecioMoneda")
    private BigDecimal precioMoneda;
    @Column(name="Descuento")
    private BigDecimal descuento;
    @Column(name="IdIva")
    private Short idIva;
    @Column(name="IdEstado")
    private Short idEstado;
    @Column(name="IdSituacion")
    private Short idSituacion;
    @Column(name="IdEmbalaje")
    private String idEmbalaje;
    @Column(name="CantidadEmbalaje")
    private BigDecimal cantidadEmbalaje;
    @Column(name="Observaciones")
    private String observaciones;
    @Column(name="Descrip")
    private String descrip;
    @Column(name="Comision")
    private BigDecimal comision;
    @Column(name="IdAlbaran")
    private Integer idAlbaran;
    @Column(name="FechaAlbaran")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaAlbaran;
    @Column(name="IdFactura")
    private Integer idFactura;
    @Column(name="FechaFactura")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaFactura;
    @Column(name="CantidadLotes")
    private BigDecimal cantidadLotes;
    @Column(name="Marca")
    private Integer marca;
    @Column(name="EmbalajeFinal")
    private String embalajeFinal;
    @Column(name="CantidadEmbalajeFinal")
    private BigDecimal cantidadEmbalajeFinal;
    @Column(name="Descrip2")
    private String descrip2;
    @Column(name="PesoNeto")
    private BigDecimal pesoNeto;
    @Column(name="PesoEmbalaje")
    private BigDecimal pesoEmbalaje;
    @Column(name="PesoEmbalajeFinal")
    private BigDecimal pesoEmbalajeFinal;
    @Column(name="Orden")
    private Integer orden;
    @Column(name="TotalComision")
    private Float totalComision;
    @Column(name="Path")
    private String path;
    @Column(name="DtoLP1")
    private BigDecimal dtoLP1;
    @Column(name="DtoLP2")
    private BigDecimal dtoLP2;
    @Column(name="DtoGD")
    private BigDecimal dtoGD;
    @Column(name="DtoMan")
    private BigDecimal dtoMan;
    @Column(name="ConjManual")
    private Short conjManual;
    @Column(name="IdDocPadre")
    private Integer idDocPadre;
    @Column(name="IdFase")
    private Integer idFase;
    @Column(name="IdProyecto_Produccion")
    private Integer idProyectoProduccion;
    @Column(name="CuentaArticulo")
    private String cuentaArticulo;
    @Column(name="TipoUnidadPres")
    private String tipoUnidadPres;
    @Column(name="UnidadesStock")
    private BigDecimal unidadesStock;
    @Column(name="UnidadesPres")
    private BigDecimal unidadesPres;
    @Column(name="Precio_EuroPres")
    private BigDecimal precioEuroPres;
    @Column(name="PrecioMonedaPres")
    private BigDecimal precioMonedaPres;
    @Column(name="IdOrdenCarga")
    private Integer idOrdenCarga;
    @Column(name="IdOferta")
    private Integer idOferta;
    @Column(name="Revision")
    private Short revision;
    @Column(name="IdOfertaLinea")
    private Short idOfertaLinea;
    @Column(name="RefCliente")
    private String refCliente;
    @Column(name="NumPlano")
    private String numPlano;
    @Column(name="IdParte")
    private Integer idParte;
    @Column(name="IdSeguimiento")
    private Integer idSeguimiento;
    @Column(name="IdConceptoCertif")
    private Integer idConceptoCertif;
    @Column(name="NumBultos")
    private Integer numBultos;
    @Column(name="IdTipoOperacion")
    private Short idTipoOperacion;
    @Column(name="IdFacturaCertif")
    private Integer idFacturaCertif;
    @Column(name="UdsCarga")
    private BigDecimal udsCarga;
    @Column(name="IdEmbalaje_Disp")
    private String idEmbalajeDisp;
    @Column(name="IdOrdenRecepcion")
    private Integer idOrdenRecepcion;
    @Column(name="CantRecep")
    private Float cantRecep;
    @Column(name="NumBultosFinal")
    private Integer numBultosFinal;
    @Column(name="DtoLP3")
    private BigDecimal dtoLP3;
    @Column(name="DtoLP3")
    private BigDecimal dtoLP4;
    @Column(name="DtoLP5")
    private BigDecimal dtoLP5;
    @Column(name="UdStockCarga")
    private BigDecimal udStockCarga;
    @Column(name="UdStockRecep")
    private BigDecimal udStockRecep;
    @Column(name="IdMaquina")
    private String idMaquina;
    @Column(name="Total_Euros")
    private BigDecimal totalEuros;
    @Column(name="Total_Moneda")
    private BigDecimal totalMoneda;
    @Column(name="IdMotivoIVAExento")
    private String idMotivoIVAExento;
    @Column(name="IdDoc")
    private Integer idDoc;
    @Column(name="InsertUpdate")
    private Short insertUpdate;
    @Column(name="Usuario")
    private String usuario;
    @Column(name="FechaInsertUpdate")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaInsertUpdate;
    
    protected PedidoLinea () {}

    public PedidoLinea(int idPedido, short idLinea, String idArticulo, Short idAlmacen, BigDecimal cantidad, BigDecimal precioEuro, BigDecimal precioMoneda, BigDecimal descuento, String descrip, Integer orden, BigDecimal precioEuroPres, BigDecimal precioMonedaPres, Integer numBultos, BigDecimal totalEuros, BigDecimal totalMoneda, Integer idDoc, String usuario, Date fechaInsertUpdate) {
        this.idPedido = idPedido;
        this.idLinea = idLinea;
        this.idArticulo = idArticulo;
        this.idAlmacen = idAlmacen;
        this.cantidad = cantidad;
        this.precioEuro = precioEuro;
        this.precioMoneda = precioMoneda;
        this.descuento = descuento;
        this.descrip = descrip;
        this.orden = orden;
        this.precioEuroPres = precioEuroPres;
        this.precioMonedaPres = precioMonedaPres;
        this.numBultos = numBultos;
        this.totalEuros = totalEuros;
        this.totalMoneda = totalMoneda;
        this.idDoc = idDoc;
        this.usuario = usuario;
        this.fechaInsertUpdate = fechaInsertUpdate;
        
        omplirResta();
    }

    
    
    
    
    
    
    @Override
    public String toString() {
        return "PedidoLinea{" + "idPedido=" + idPedido + ", idLinea=" + idLinea + ", idArticulo=" + idArticulo + ", precio=" + precio + '}';
    }
    
    
    
    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public short getIdLinea() {
        return idLinea;
    }

    public void setIdLinea(short idLinea) {
        this.idLinea = idLinea;
    }

    public String getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(String idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getIdArticuloCli() {
        return idArticuloCli;
    }

    public void setIdArticuloCli(String idArticuloCli) {
        this.idArticuloCli = idArticuloCli;
    }

    public Short getIdAlmacen() {
        return idAlmacen;
    }

    public void setIdAlmacen(Short idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public BigDecimal getPrecioEuro() {
        return precioEuro;
    }

    public void setPrecioEuro(BigDecimal precioEuro) {
        this.precioEuro = precioEuro;
    }

    public BigDecimal getPrecioMoneda() {
        return precioMoneda;
    }

    public void setPrecioMoneda(BigDecimal precioMoneda) {
        this.precioMoneda = precioMoneda;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    public Short getIdIva() {
        return idIva;
    }

    public void setIdIva(Short idIva) {
        this.idIva = idIva;
    }

    public Short getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Short idEstado) {
        this.idEstado = idEstado;
    }

    public Short getIdSituacion() {
        return idSituacion;
    }

    public void setIdSituacion(Short idSituacion) {
        this.idSituacion = idSituacion;
    }

    public String getIdEmbalaje() {
        return idEmbalaje;
    }

    public void setIdEmbalaje(String idEmbalaje) {
        this.idEmbalaje = idEmbalaje;
    }

    public BigDecimal getCantidadEmbalaje() {
        return cantidadEmbalaje;
    }

    public void setCantidadEmbalaje(BigDecimal cantidadEmbalaje) {
        this.cantidadEmbalaje = cantidadEmbalaje;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public BigDecimal getComision() {
        return comision;
    }

    public void setComision(BigDecimal comision) {
        this.comision = comision;
    }

    public Integer getIdAlbaran() {
        return idAlbaran;
    }

    public void setIdAlbaran(Integer idAlbaran) {
        this.idAlbaran = idAlbaran;
    }

    public Date getFechaAlbaran() {
        return fechaAlbaran;
    }

    public void setFechaAlbaran(Date fechaAlbaran) {
        this.fechaAlbaran = fechaAlbaran;
    }

    public Integer getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public Date getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public BigDecimal getCantidadLotes() {
        return cantidadLotes;
    }

    public void setCantidadLotes(BigDecimal cantidadLotes) {
        this.cantidadLotes = cantidadLotes;
    }

    public Integer getMarca() {
        return marca;
    }

    public void setMarca(Integer marca) {
        this.marca = marca;
    }

    public String getEmbalajeFinal() {
        return embalajeFinal;
    }

    public void setEmbalajeFinal(String embalajeFinal) {
        this.embalajeFinal = embalajeFinal;
    }

    public BigDecimal getCantidadEmbalajeFinal() {
        return cantidadEmbalajeFinal;
    }

    public void setCantidadEmbalajeFinal(BigDecimal cantidadEmbalajeFinal) {
        this.cantidadEmbalajeFinal = cantidadEmbalajeFinal;
    }

    public String getDescrip2() {
        return descrip2;
    }

    public void setDescrip2(String descrip2) {
        this.descrip2 = descrip2;
    }

    public BigDecimal getPesoNeto() {
        return pesoNeto;
    }

    public void setPesoNeto(BigDecimal pesoNeto) {
        this.pesoNeto = pesoNeto;
    }

    public BigDecimal getPesoEmbalaje() {
        return pesoEmbalaje;
    }

    public void setPesoEmbalaje(BigDecimal pesoEmbalaje) {
        this.pesoEmbalaje = pesoEmbalaje;
    }

    public BigDecimal getPesoEmbalajeFinal() {
        return pesoEmbalajeFinal;
    }

    public void setPesoEmbalajeFinal(BigDecimal pesoEmbalajeFinal) {
        this.pesoEmbalajeFinal = pesoEmbalajeFinal;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public Float getTotalComision() {
        return totalComision;
    }

    public void setTotalComision(Float totalComision) {
        this.totalComision = totalComision;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public BigDecimal getDtoLP1() {
        return dtoLP1;
    }

    public void setDtoLP1(BigDecimal dtoLP1) {
        this.dtoLP1 = dtoLP1;
    }

    public BigDecimal getDtoLP2() {
        return dtoLP2;
    }

    public void setDtoLP2(BigDecimal dtoLP2) {
        this.dtoLP2 = dtoLP2;
    }

    public BigDecimal getDtoGD() {
        return dtoGD;
    }

    public void setDtoGD(BigDecimal dtoGD) {
        this.dtoGD = dtoGD;
    }

    public BigDecimal getDtoMan() {
        return dtoMan;
    }

    public void setDtoMan(BigDecimal dtoMan) {
        this.dtoMan = dtoMan;
    }

    public Short getConjManual() {
        return conjManual;
    }

    public void setConjManual(Short conjManual) {
        this.conjManual = conjManual;
    }

    public Integer getIdDocPadre() {
        return idDocPadre;
    }

    public void setIdDocPadre(Integer idDocPadre) {
        this.idDocPadre = idDocPadre;
    }

    public Integer getIdFase() {
        return idFase;
    }

    public void setIdFase(Integer idFase) {
        this.idFase = idFase;
    }

    public Integer getIdProyectoProduccion() {
        return idProyectoProduccion;
    }

    public void setIdProyectoProduccion(Integer idProyectoProduccion) {
        this.idProyectoProduccion = idProyectoProduccion;
    }

    public String getCuentaArticulo() {
        return cuentaArticulo;
    }

    public void setCuentaArticulo(String cuentaArticulo) {
        this.cuentaArticulo = cuentaArticulo;
    }

    public String getTipoUnidadPres() {
        return tipoUnidadPres;
    }

    public void setTipoUnidadPres(String tipoUnidadPres) {
        this.tipoUnidadPres = tipoUnidadPres;
    }

    public BigDecimal getUnidadesStock() {
        return unidadesStock;
    }

    public void setUnidadesStock(BigDecimal unidadesStock) {
        this.unidadesStock = unidadesStock;
    }

    public BigDecimal getUnidadesPres() {
        return unidadesPres;
    }

    public void setUnidadesPres(BigDecimal unidadesPres) {
        this.unidadesPres = unidadesPres;
    }

    public BigDecimal getPrecioEuroPres() {
        return precioEuroPres;
    }

    public void setPrecioEuroPres(BigDecimal precioEuroPres) {
        this.precioEuroPres = precioEuroPres;
    }

    public BigDecimal getPrecioMonedaPres() {
        return precioMonedaPres;
    }

    public void setPrecioMonedaPres(BigDecimal precioMonedaPres) {
        this.precioMonedaPres = precioMonedaPres;
    }

    public Integer getIdOrdenCarga() {
        return idOrdenCarga;
    }

    public void setIdOrdenCarga(Integer idOrdenCarga) {
        this.idOrdenCarga = idOrdenCarga;
    }

    public Integer getIdOferta() {
        return idOferta;
    }

    public void setIdOferta(Integer idOferta) {
        this.idOferta = idOferta;
    }

    public Short getRevision() {
        return revision;
    }

    public void setRevision(Short revision) {
        this.revision = revision;
    }

    public Short getIdOfertaLinea() {
        return idOfertaLinea;
    }

    public void setIdOfertaLinea(Short idOfertaLinea) {
        this.idOfertaLinea = idOfertaLinea;
    }

    public String getRefCliente() {
        return refCliente;
    }

    public void setRefCliente(String refCliente) {
        this.refCliente = refCliente;
    }

    public String getNumPlano() {
        return numPlano;
    }

    public void setNumPlano(String numPlano) {
        this.numPlano = numPlano;
    }

    public Integer getIdParte() {
        return idParte;
    }

    public void setIdParte(Integer idParte) {
        this.idParte = idParte;
    }

    public Integer getIdSeguimiento() {
        return idSeguimiento;
    }

    public void setIdSeguimiento(Integer idSeguimiento) {
        this.idSeguimiento = idSeguimiento;
    }

    public Integer getIdConceptoCertif() {
        return idConceptoCertif;
    }

    public void setIdConceptoCertif(Integer idConceptoCertif) {
        this.idConceptoCertif = idConceptoCertif;
    }

    public Integer getNumBultos() {
        return numBultos;
    }

    public void setNumBultos(Integer numBultos) {
        this.numBultos = numBultos;
    }

    public Short getIdTipoOperacion() {
        return idTipoOperacion;
    }

    public void setIdTipoOperacion(Short idTipoOperacion) {
        this.idTipoOperacion = idTipoOperacion;
    }

    public Integer getIdFacturaCertif() {
        return idFacturaCertif;
    }

    public void setIdFacturaCertif(Integer idFacturaCertif) {
        this.idFacturaCertif = idFacturaCertif;
    }

    public BigDecimal getUdsCarga() {
        return udsCarga;
    }

    public void setUdsCarga(BigDecimal udsCarga) {
        this.udsCarga = udsCarga;
    }

    public String getIdEmbalajeDisp() {
        return idEmbalajeDisp;
    }

    public void setIdEmbalajeDisp(String idEmbalajeDisp) {
        this.idEmbalajeDisp = idEmbalajeDisp;
    }

    public Integer getIdOrdenRecepcion() {
        return idOrdenRecepcion;
    }

    public void setIdOrdenRecepcion(Integer idOrdenRecepcion) {
        this.idOrdenRecepcion = idOrdenRecepcion;
    }

    public Float getCantRecep() {
        return cantRecep;
    }

    public void setCantRecep(Float cantRecep) {
        this.cantRecep = cantRecep;
    }

    public Integer getNumBultosFinal() {
        return numBultosFinal;
    }

    public void setNumBultosFinal(Integer numBultosFinal) {
        this.numBultosFinal = numBultosFinal;
    }

    public BigDecimal getDtoLP3() {
        return dtoLP3;
    }

    public void setDtoLP3(BigDecimal dtoLP3) {
        this.dtoLP3 = dtoLP3;
    }

    public BigDecimal getDtoLP4() {
        return dtoLP4;
    }

    public void setDtoLP4(BigDecimal dtoLP4) {
        this.dtoLP4 = dtoLP4;
    }

    public BigDecimal getDtoLP5() {
        return dtoLP5;
    }

    public void setDtoLP5(BigDecimal dtoLP5) {
        this.dtoLP5 = dtoLP5;
    }

    public BigDecimal getUdStockCarga() {
        return udStockCarga;
    }

    public void setUdStockCarga(BigDecimal udStockCarga) {
        this.udStockCarga = udStockCarga;
    }

    public BigDecimal getUdStockRecep() {
        return udStockRecep;
    }

    public void setUdStockRecep(BigDecimal udStockRecep) {
        this.udStockRecep = udStockRecep;
    }

    public String getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(String idMaquina) {
        this.idMaquina = idMaquina;
    }

    public BigDecimal getTotalEuros() {
        return totalEuros;
    }

    public void setTotalEuros(BigDecimal totalEuros) {
        this.totalEuros = totalEuros;
    }

    public BigDecimal getTotalMoneda() {
        return totalMoneda;
    }

    public void setTotalMoneda(BigDecimal totalMoneda) {
        this.totalMoneda = totalMoneda;
    }

    public String getIdMotivoIVAExento() {
        return idMotivoIVAExento;
    }

    public void setIdMotivoIVAExento(String idMotivoIVAExento) {
        this.idMotivoIVAExento = idMotivoIVAExento;
    }

    public Integer getIdDoc() {
        return idDoc;
    }

    public void setIdDoc(Integer idDoc) {
        this.idDoc = idDoc;
    }

    public Short getInsertUpdate() {
        return insertUpdate;
    }

    public void setInsertUpdate(Short insertUpdate) {
        this.insertUpdate = insertUpdate;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Date getFechaInsertUpdate() {
        return fechaInsertUpdate;
    }

    public void setFechaInsertUpdate(Date fechaInsertUpdate) {
        this.fechaInsertUpdate = fechaInsertUpdate;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.idPedido;
        hash = 29 * hash + this.idLinea;
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
        final PedidoLinea other = (PedidoLinea) obj;
        if (this.idPedido != other.idPedido) {
            return false;
        }
        if (this.idLinea != other.idLinea) {
            return false;
        }
        return true;
    }

    private void omplirResta() {
        this.idArticuloCli = null;
        this.precio = BigDecimal.ZERO;
        this.idIva = 0;
        this.idEstado = 0;
        this.idSituacion = 0;
        this.idEmbalaje = null;
        this.cantidadEmbalaje = BigDecimal.ONE;
        this.observaciones = null;
        this.comision = BigDecimal.ZERO;
        this.idAlbaran = null;
        this.fechaAlbaran = null;
        this.idFactura = null;
        this.fechaFactura = null;
        this.cantidadLotes = BigDecimal.ZERO;
        this.marca = null;
        this.embalajeFinal = null;
        this.cantidadEmbalajeFinal = BigDecimal.ONE;
        this.descrip2 = null;
        this.pesoNeto = BigDecimal.ZERO;
        this.pesoEmbalaje = BigDecimal.ZERO;
        this.pesoEmbalajeFinal = BigDecimal.ZERO;
        this.totalComision = 0.0f;
        this.path = null;
        this.dtoLP1 = BigDecimal.ZERO;
        this.dtoLP2 = BigDecimal.ZERO;
        this.dtoLP3 = BigDecimal.ZERO;
        this.dtoGD = BigDecimal.ZERO;
        this.dtoMan = BigDecimal.ZERO;
        this.conjManual = 0;
        this.idDocPadre = null;
        this.idFase = null;
        this.idProyectoProduccion = null;
        this.cuentaArticulo = null;
        this.tipoUnidadPres = null;
        this.unidadesStock = BigDecimal.ZERO;
        this.unidadesPres = BigDecimal.ZERO;
        this.idOrdenCarga = null;
        this.idOferta = 0;
        this.revision = null;
        this.idOfertaLinea = 0;
        this.refCliente = null;
        this.numPlano = null;
        this.idParte = null;
        this.idSeguimiento = null;
        this.idConceptoCertif = null;
        this.idTipoOperacion = null;
        this.idFacturaCertif = 0;
        this.udsCarga = BigDecimal.ZERO;
        this.idEmbalajeDisp = null;
        this.idOrdenRecepcion = null;
        this.cantRecep = 0f;
        this.numBultosFinal = 0;
        this.dtoLP4 = BigDecimal.ZERO;
        this.dtoLP5 = BigDecimal.ZERO;
        this.udStockCarga = BigDecimal.ZERO;
        this.udStockRecep = BigDecimal.ZERO;
        this.idMaquina = null;
        this.idMotivoIVAExento = null;
        this.insertUpdate = 0;
        
    }
    
    
}
