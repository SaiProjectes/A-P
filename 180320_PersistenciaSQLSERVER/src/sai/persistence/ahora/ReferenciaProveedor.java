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
@Table(name="dbo.Prov_Articulos")
public class ReferenciaProveedor implements Serializable {
    @Id
    @Column(name="IdArticulo")
    private String idArticulo;
    @Id
    @Column(name="IdProveedor")
    private String idProveedor;
    @Column(name="IdContacto")
    private Integer idContacto;
    @Column(name="Articulo")
    private String articulo;
    @Column(name="Descrip")
    private String descrip;
    @Column(name="IdEmbalaje")
    private String idEmbalaje;
    @Column(name="Cantidad")
    private BigDecimal cantidad;
    @Column(name="TipoAcabado")
    private String tipoAcabado;
    @Column(name="Precio")
    private BigDecimal precio;
    @Column(name="PrecioEuros")
    private BigDecimal precioEuros;
    @Column(name="Norma")
    private String norma;
    @Column(name="Habitual")
    private Short habitual;
    @Column(name="PlazoAprovisionamiento")
    private Integer plazoAprovisionamiento;
    @Column(name="Preferencialidad")
    private Integer preferencialidad;
    @Column(name="IdAlmacen")
    private Short idAlmacen;
    @Column(name="DiasTransito")
    private Integer diasTransito;
    @Column(name="Muelle")
    private String muelle;
    @Column(name="IdTipoPauta")
    private Integer idTipoPauta;
    @Column(name="PautaIdAlbaranUltimo")
    private Integer pautaIdAlbaranUltimo;
    @Column(name="Estado_Homologacion")
    private Integer estadoHomologacion;
    @Column(name="Fecha_Homologacion")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaHomologacion;
    @Column(name="Usuario_Homologacion")
    private String usuarioHomologacion;
    @Column(name="PedidoOptimo")
    private BigDecimal pedidoOptimo;
    @Column(name="DUN14")
    private String dun14;
    
    protected ReferenciaProveedor () {}

    public String getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(String idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getIdProveidor() {
        return idProveedor;
    }

    public void setIdProveidor(String idProveidor) {
        this.idProveedor = idProveidor;
    }

    public int getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(int idContacto) {
        this.idContacto = idContacto;
    }

    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getIdEmbalaje() {
        return idEmbalaje;
    }

    public void setIdEmbalaje(String idEmbalaje) {
        this.idEmbalaje = idEmbalaje;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public String getTipoAcabado() {
        return tipoAcabado;
    }

    public void setTipoAcabado(String tipoAcabado) {
        this.tipoAcabado = tipoAcabado;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public BigDecimal getPrecioEuros() {
        return precioEuros;
    }

    public void setPrecioEuros(BigDecimal precioEuros) {
        this.precioEuros = precioEuros;
    }

    public String getNorma() {
        return norma;
    }

    public void setNorma(String norma) {
        this.norma = norma;
    }

    public Short getHabitual() {
        return habitual;
    }

    public void setHabitual(Short habitual) {
        this.habitual = habitual;
    }

    public Integer getPlazoAprovisionamiento() {
        return plazoAprovisionamiento;
    }

    public void setPlazoAprovisionamiento(Integer plazoAprovisionamiento) {
        this.plazoAprovisionamiento = plazoAprovisionamiento;
    }

    public Integer getPreferencialidad() {
        return preferencialidad;
    }

    public void setPreferencialidad(Integer preferencialidad) {
        this.preferencialidad = preferencialidad;
    }

    public Short getIdAlmacen() {
        return idAlmacen;
    }

    public void setIdAlmacen(Short idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    public Integer getDiasTransito() {
        return diasTransito;
    }

    public void setDiasTransito(Integer diasTransito) {
        this.diasTransito = diasTransito;
    }

    public String getMuelle() {
        return muelle;
    }

    public void setMuelle(String muelle) {
        this.muelle = muelle;
    }

    public Integer getIdTipoPauta() {
        return idTipoPauta;
    }

    public void setIdTipoPauta(Integer idTipoPauta) {
        this.idTipoPauta = idTipoPauta;
    }

    public Integer getPautaIdAlbaranUltimo() {
        return pautaIdAlbaranUltimo;
    }

    public void setPautaIdAlbaranUltimo(Integer pautaIdAlbaranUltimo) {
        this.pautaIdAlbaranUltimo = pautaIdAlbaranUltimo;
    }

    public Integer getEstadoHomologacion() {
        return estadoHomologacion;
    }

    public void setEstadoHomologacion(Integer estadoHomologacion) {
        this.estadoHomologacion = estadoHomologacion;
    }

    public Date getFechaHomologacion() {
        return fechaHomologacion;
    }

    public void setFechaHomologacion(Date fechaHomologacion) {
        this.fechaHomologacion = fechaHomologacion;
    }

    public String getUsuarioHomologacion() {
        return usuarioHomologacion;
    }

    public void setUsuarioHomologacion(String usuarioHomologacion) {
        this.usuarioHomologacion = usuarioHomologacion;
    }

    public BigDecimal getPedidoOptimo() {
        return pedidoOptimo;
    }

    public void setPedidoOptimo(BigDecimal pedidoOptimo) {
        this.pedidoOptimo = pedidoOptimo;
    }

    public String getDun14() {
        return dun14;
    }

    public void setDun14(String dun14) {
        this.dun14 = dun14;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.idArticulo);
        hash = 53 * hash + Objects.hashCode(this.idProveedor);
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
        final ReferenciaProveedor other = (ReferenciaProveedor) obj;
        if (!Objects.equals(this.idArticulo, other.idArticulo)) {
            return false;
        }
        if (!Objects.equals(this.idProveedor, other.idProveedor)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ReferenciaProveedor{" + "idArticulo=" + idArticulo + ", idProveidor=" + idProveedor + ", articulo=" + articulo + '}';
    }
    
    
}
