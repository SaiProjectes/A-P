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
@Table(name="dbo.Pedidos_Cli_Cabecera")
public class Pedido implements Serializable {
    @Id
    @Column(name="IdPedido")
    private int idPedido;
    @Column(name="IdEmpresa")
    private Short idEmpresa;
    @Column(name="AñoNum")
    private Integer anoNum;
    @Column(name="SeriePedido")
    private Integer seriePedido;
    @Column(name="NumPedido")
    private Integer numPedido;
    @Column(name="Fecha")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    @Column(name="IdCliente")
    private String idCliente;
    @Column(name="Origen")
    private String origen;
    @Column(name="IdPedidoCli")
    private String idPedidoCli;
    @Column(name="IdContacto")
    private Integer idContacto;
    @Column(name="IdContactoA")
    private Integer idContactoA;
    @Column(name="IdContactoF")
    private Integer idContactoF;
    @Column(name="DescripcionPed")
    private String descripcionPed;
    @Column(name="IdLista")
    private Integer idLista;
    @Column(name="IdListaRevision")
    private BigDecimal idListaRevision;
    @Column(name="IdEmpleado")
    private Integer idEmpleado;
    @Column(name="IdDepartamento")
    private Short idDepartamento;
    @Column(name="IdTransportista")
    private String idTransportista;
    @Column(name="IdMoneda")
    private Short idMoneda;
    @Column(name="FormaPago")
    private Integer formaPago;
    @Column(name="Descuento")
    private BigDecimal descuento;
    @Column(name="ProntoPago")
    private BigDecimal prontoPago;
    @Column(name="IdPortes")
    private String idPortes;
    @Column(name="IdIva")
    private Short idIva;
    @Column(name="IdEstado")
    private Short idEstado;
    @Column(name="IdSituacion")
    private Short idSituacion;
    @Column(name="FechaSalida")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaSalida;
    @Column(name="Observaciones")
    private String observaciones;
    @Column(name="Comision")
    private BigDecimal comision;
    @Column(name="Cambio")
    private BigDecimal cambio;
    @Column(name="CambioEuros")
    private BigDecimal cambioEuros;
    @Column(name="CambioBloqueado")
    private Short cambioBloqueado;
    @Column(name="Representante")
    private Integer representante;
    @Column(name="IdCentroCoste")
    private String idCentroCoste;
    @Column(name="IdProyecto")
    private String idProyecto;
    @Column(name="IdOferta")
    private Integer idOferta;
    @Column(name="Revision")
    private Short revision;
    @Column(name="Inmovilizado")
    private Short inmovilizado;
    @Column(name="Regerencia")
    private String referencia;
    @Column(name="RecogidaPorCli")
    private Short recogidaPorCli;
    @Column(name="ContactoLlamada")
    private String contactoLlamada;
    @Column(name="Hora")
    private String hora;
    @Column(name="HoraSalida")
    private String horaSalida;
    @Column(name="IdTipoPedido")
    private Integer idTipoPedido;
    @Column(name="RecEquivalencia")
    private Short recEquivalencia;
    @Column(name="Bloqueado")
    private Short bloqueado;
    @Column(name="IdMotivoBloqueo")
    private Integer idMotivoBloqueo;
    @Column(name="IdApertura")
    private Integer idApertura;
    @Column(name="IdPedidoOrigen")
    private Integer idPedidoOrigen;
    @Column(name="NoCalcularPromo")
    private Short noCalcularPromo;
    @Column(name="ECommerce")
    private Short eCommerce;
    @Column(name="IdDoc")
    private Integer idDoc;
    @Column(name="InsertUpdate")
    private Short insertUpdate;
    @Column(name="Usuario")
    private String usuario;
    @Column(name="FechaInsertUpdate")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaInsertUpdate;
    
    protected Pedido () {}

    public Pedido(int idPedido, Short idEmpresa, Integer anoNum, Integer seriePedido, Integer numPedido, Date fecha, String idCliente, Integer idContacto, Integer idContactoA, Integer idContactoF, Integer idLista, Integer idEmpleado, Short idDepartamento, Integer formaPago, BigDecimal descuento, Date fechaSalida, Integer representante, Short eCommerce, Integer idDoc, String usuario, Date fechaInsertUpdate) {
        this.idPedido = idPedido;
        this.idEmpresa = idEmpresa;
        this.anoNum = anoNum;
        this.seriePedido = seriePedido;
        this.numPedido = numPedido;
        this.fecha = fecha;
        this.idCliente = idCliente;
        this.idContacto = idContacto;
        this.idContactoA = idContactoA;
        this.idContactoF = idContactoF;
        this.idLista = idLista;
        this.idEmpleado = idEmpleado;
        this.idDepartamento = idDepartamento;
        this.formaPago = formaPago;
        this.descuento = descuento;
        this.fechaSalida = fechaSalida;
        this.representante = representante;
        this.eCommerce = eCommerce;
        this.idDoc = idDoc;
        this.usuario = usuario;
        this.fechaInsertUpdate = fechaInsertUpdate;
        
        omplirResta();
        
    }

    
    
    
    
    
    
    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Short getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Short idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Integer getAnoNum() {
        return anoNum;
    }

    public void setAnoNum(Integer anoNum) {
        this.anoNum = anoNum;
    }

    public Integer getSeriePedido() {
        return seriePedido;
    }

    public void setSeriePedido(Integer seriePedido) {
        this.seriePedido = seriePedido;
    }

    public Integer getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(Integer numPedido) {
        this.numPedido = numPedido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getIdPedidoCli() {
        return idPedidoCli;
    }

    public void setIdPedidoCli(String idPedidoCli) {
        this.idPedidoCli = idPedidoCli;
    }

    public Integer getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(Integer idContacto) {
        this.idContacto = idContacto;
    }

    public Integer getIdContactoA() {
        return idContactoA;
    }

    public void setIdContactoA(Integer idContactoA) {
        this.idContactoA = idContactoA;
    }

    public Integer getIdContactoF() {
        return idContactoF;
    }

    public void setIdContactoF(Integer idContactoF) {
        this.idContactoF = idContactoF;
    }

    public String getDescripcionPed() {
        return descripcionPed;
    }

    public void setDescripcionPed(String descripcionPed) {
        this.descripcionPed = descripcionPed;
    }

    public Integer getIdLista() {
        return idLista;
    }

    public void setIdLista(Integer idLista) {
        this.idLista = idLista;
    }

    public BigDecimal getIdListaRevision() {
        return idListaRevision;
    }

    public void setIdListaRevision(BigDecimal idListaRevision) {
        this.idListaRevision = idListaRevision;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Short getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Short idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getIdTransportista() {
        return idTransportista;
    }

    public void setIdTransportista(String idTransportista) {
        this.idTransportista = idTransportista;
    }

    public Short getIdMoneda() {
        return idMoneda;
    }

    public void setIdMoneda(Short idMoneda) {
        this.idMoneda = idMoneda;
    }

    public Integer getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(Integer formaPago) {
        this.formaPago = formaPago;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    public BigDecimal getProntoPago() {
        return prontoPago;
    }

    public void setProntoPago(BigDecimal prontoPago) {
        this.prontoPago = prontoPago;
    }

    public String getIdPortes() {
        return idPortes;
    }

    public void setIdPortes(String idPortes) {
        this.idPortes = idPortes;
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

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public BigDecimal getComision() {
        return comision;
    }

    public void setComision(BigDecimal comision) {
        this.comision = comision;
    }

    public BigDecimal getCambio() {
        return cambio;
    }

    public void setCambio(BigDecimal cambio) {
        this.cambio = cambio;
    }

    public BigDecimal getCambioEuros() {
        return cambioEuros;
    }

    public void setCambioEuros(BigDecimal cambioEuros) {
        this.cambioEuros = cambioEuros;
    }

    public Short getCambioBloqueado() {
        return cambioBloqueado;
    }

    public void setCambioBloqueado(Short cambioBloqueado) {
        this.cambioBloqueado = cambioBloqueado;
    }

    public Integer getRepresentante() {
        return representante;
    }

    public void setRepresentante(Integer representante) {
        this.representante = representante;
    }

    public String getIdCentroCoste() {
        return idCentroCoste;
    }

    public void setIdCentroCoste(String idCentroCoste) {
        this.idCentroCoste = idCentroCoste;
    }

    public String getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(String idProyecto) {
        this.idProyecto = idProyecto;
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

    public Short getInmovilizado() {
        return inmovilizado;
    }

    public void setInmovilizado(Short inmovilizado) {
        this.inmovilizado = inmovilizado;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Short getRecogidaPorCli() {
        return recogidaPorCli;
    }

    public void setRecogidaPorCli(Short recogidaPorCli) {
        this.recogidaPorCli = recogidaPorCli;
    }

    public String getContactoLlamada() {
        return contactoLlamada;
    }

    public void setContactoLlamada(String contactoLlamada) {
        this.contactoLlamada = contactoLlamada;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public Integer getIdTipoPedido() {
        return idTipoPedido;
    }

    public void setIdTipoPedido(Integer idTipoPedido) {
        this.idTipoPedido = idTipoPedido;
    }

    public Short getRecEquivalencia() {
        return recEquivalencia;
    }

    public void setRecEquivalencia(Short recEquivalencia) {
        this.recEquivalencia = recEquivalencia;
    }

    public Short getBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(Short bloqueado) {
        this.bloqueado = bloqueado;
    }

    public Integer getIdMotivoBloqueo() {
        return idMotivoBloqueo;
    }

    public void setIdMotivoBloqueo(Integer idMotivoBloqueo) {
        this.idMotivoBloqueo = idMotivoBloqueo;
    }

    public Integer getIdApertura() {
        return idApertura;
    }

    public void setIdApertura(Integer idApertura) {
        this.idApertura = idApertura;
    }

    public Integer getIdPedidoOrigen() {
        return idPedidoOrigen;
    }

    public void setIdPedidoOrigen(Integer idPedidoOrigen) {
        this.idPedidoOrigen = idPedidoOrigen;
    }

    public Short getNoCalcularPromo() {
        return noCalcularPromo;
    }

    public void setNoCalcularPromo(Short noCalcularPromo) {
        this.noCalcularPromo = noCalcularPromo;
    }

    public Short geteCommerce() {
        return eCommerce;
    }

    public void seteCommerce(Short eCommerce) {
        this.eCommerce = eCommerce;
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
        int hash = 7;
        hash = 97 * hash + this.idPedido;
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
        final Pedido other = (Pedido) obj;
        if (this.idPedido != other.idPedido) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pedido{" + "idPedido=" + idPedido + ", fecha=" + fecha + ", idCliente=" + idCliente + '}';
    }

    private void omplirResta() {
        this.origen = null;
        this.idPedidoCli = null;
        this.idListaRevision = BigDecimal.valueOf(1.0);
        this.idTransportista = null;
        this.idMoneda = 1;
        this.idPortes = "D";
        this.idIva = 0;
        this.idEstado = 0;
        this.idSituacion = 0;
        this.observaciones = null;
        this.comision = BigDecimal.ZERO;
        this.cambio = BigDecimal.ZERO;
        this.cambioEuros = BigDecimal.ZERO;
        this.cambioBloqueado = 0;
        this.idCentroCoste = null;
        this.idProyecto = null;
        this.idOferta = null;
        this.revision = null;
        this.inmovilizado = 0;
        this.referencia = "0";
        this.recogidaPorCli = 0;
        this.contactoLlamada = null;
        this.hora = null;
        this.horaSalida = null;
        this.idTipoPedido = 0;
        this.recEquivalencia = 0;
        this.bloqueado = 0;
        this.idMotivoBloqueo = null;
        this.idApertura = null;
        this.idPedidoOrigen = 0;
        this.noCalcularPromo = 0;
        this.insertUpdate = 0;
    
    }
    
    
    
    
    
}
