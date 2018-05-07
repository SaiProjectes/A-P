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
 * @author programacio3
 */
@Entity
@Table(name="dbo.Clientes_Datos")
public class Cliente implements Serializable {
    private Integer idCompania;
    
    @Id
    @Column(name="IdCliente")
    private String idCliente;
    @Column(name="Cliente")
    private String cliente;
    @Column(name="Direccion")
    private String direccion;
    @Column(name="Ciudad")
    private String ciudad;
    @Column(name="Provincia")
    private String provincia;
    @Column(name="CodPostal")
    private String codPostal;
    @Column(name="Pais")
    private String pais;
    
    @Column(name="IdTipo")
    private Short idTipo;
    @Column(name="IdContacto")
    private Integer idContacto;
    @Column(name="IdContactoA")
    private Integer idContactoA;
    @Column(name="IdContactoF")
    private Integer idContactoF;
    @Column(name="Extension")
    private String extension;
    @Column(name="NumFax")
    private String numFax;
    @Column(name="Web")
    private String web;
    @Column(name="FechaAlta")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaAlta;
    @Column(name="Notas")
    private String notas;
    @Column(name="Nif2")
    private String nif2;
    @Column(name="Padre")
    private String padre;
    @Column(name="Nivel")
    private Short nivel;
    @Column(name="MiCod")
    private String miCod;
    @Column(name="Bloqueado")
    private Short bloqueado;
    @Column(name="RazonSocial")
    private String razonSocial;
    @Column(name="IdContactoCliente")
    private Integer idContactoCliente;
    @Column(name="TipoTransporte")
    private Integer tipoTransporte;
    @Column(name="IdDelegacion")
    private Integer idDelegacion;
    @Column(name="IdPoblacion")
    private Integer idPoblacion;
    @Column(name="IdProvincia")
    private String idProvincia;
    @Column(name="IdPais")
    private String idPais;
    @Column(name="Kmts")
    private BigDecimal kmts;
    @Column(name="IdCalendario")
    private Integer idCalendario;
    @Column(name="IdTipoOtro")
    private Short idTipoOtro;
    @Column(name="IdRelacion")
    private Integer idRelacion;
    @Column(name="RappelsPorPlanta")
    private Short rappelsPorPlanta;
    @Column(name="EsUbicacion")
    private Short esUbicacion;
    @Column(name="Cliente_Contado")
    private Short clienteContado;
    @Column(name="IdMotivoBloqueo")
    private Integer idMotivoBloqueo;
    @Column(name="IdEmpleadoBloqueo")
    private Integer idEmpleadoBloqueo;
    @Column(name="IdContactoG")
    private Integer idContactoG;
    @Column(name="IdDelegacionCli")
    private Integer idDelegacionCli;
    @Column(name="ECommerce_PersonaNombre")
    private String eCommercePersonaNombre;
    @Column(name="ECommerce_PersonaApellidos")
    private String eCommercePersonaApellidos;
    @Column(name="Observaciones")
    private String observaciones;
    @Column(name="ECommerce_Activo")
    private Short eCommerceActivo;
    @Column(name="IdDoc")
    private Integer idDoc;
    @Column(name="InsertUpdate")
    private Short inserUpdate;
    @Column(name="Usuario")
    private String usuario;
    @Column(name="FechaInsertUpdate")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaInsertUpdate;
    
    @Column(name="E_Mail")
    private String email;
    @Column(name="NumTelefono")
    private String numTelefono;
    @Column(name="Nif")
    private String nif;
    
    protected Cliente () {}

    public Cliente(String idCliente, String cliente, String pais, Date fechaAlta, String razonSocial, String idPais, Integer idDoc, String nif) {
        this.idCliente = idCliente;
        this.cliente = cliente;
        this.pais = pais;
        this.fechaAlta = fechaAlta;
        this.razonSocial = razonSocial;
        this.idPais = idPais;
        this.idDoc = idDoc;
        this.nif = nif;
        
        omplirResta();
    }

    public Integer getIdCompania() {
        return idCompania;
    }

    public void setIdCompania(Integer idCompania) {
        this.idCompania = idCompania;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Short getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Short idTipo) {
        this.idTipo = idTipo;
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

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getNumFax() {
        return numFax;
    }

    public void setNumFax(String numFax) {
        this.numFax = numFax;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public String getNif2() {
        return nif2;
    }

    public void setNif2(String nif2) {
        this.nif2 = nif2;
    }

    public String getPadre() {
        return padre;
    }

    public void setPadre(String padre) {
        this.padre = padre;
    }

    public Short getNivel() {
        return nivel;
    }

    public void setNivel(Short nivel) {
        this.nivel = nivel;
    }

    public String getMiCod() {
        return miCod;
    }

    public void setMiCod(String miCod) {
        this.miCod = miCod;
    }

    public Short getBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(Short bloqueado) {
        this.bloqueado = bloqueado;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public Integer getIdContactoCliente() {
        return idContactoCliente;
    }

    public void setIdContactoCliente(Integer idContactoCliente) {
        this.idContactoCliente = idContactoCliente;
    }

    public Integer getTipoTransporte() {
        return tipoTransporte;
    }

    public void setTipoTransporte(Integer tipoTransporte) {
        this.tipoTransporte = tipoTransporte;
    }

    public Integer getIdDelegacion() {
        return idDelegacion;
    }

    public void setIdDelegacion(Integer idDelegacion) {
        this.idDelegacion = idDelegacion;
    }

    public Integer getIdPoblacion() {
        return idPoblacion;
    }

    public void setIdPoblacion(Integer idPoblacion) {
        this.idPoblacion = idPoblacion;
    }

    public String getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(String idProvincia) {
        this.idProvincia = idProvincia;
    }

    public String getIdPais() {
        return idPais;
    }

    public void setIdPais(String idPais) {
        this.idPais = idPais;
    }

    public BigDecimal getKmts() {
        return kmts;
    }

    public void setKmts(BigDecimal kmts) {
        this.kmts = kmts;
    }

    public Integer getIdCalendario() {
        return idCalendario;
    }

    public void setIdCalendario(Integer idCalendario) {
        this.idCalendario = idCalendario;
    }

    public Short getIdTipoOtro() {
        return idTipoOtro;
    }

    public void setIdTipoOtro(Short idTipoOtro) {
        this.idTipoOtro = idTipoOtro;
    }

    public Integer getIdRelacion() {
        return idRelacion;
    }

    public void setIdRelacion(Integer idRelacion) {
        this.idRelacion = idRelacion;
    }

    public Short getRappelsPorPlanta() {
        return rappelsPorPlanta;
    }

    public void setRappelsPorPlanta(Short rappelsPorPlanta) {
        this.rappelsPorPlanta = rappelsPorPlanta;
    }

    public Short getEsUbicacion() {
        return esUbicacion;
    }

    public void setEsUbicacion(Short esUbicacion) {
        this.esUbicacion = esUbicacion;
    }

    public Short getClienteContado() {
        return clienteContado;
    }

    public void setClienteContado(Short clienteContado) {
        this.clienteContado = clienteContado;
    }

    public Integer getIdMotivoBloqueo() {
        return idMotivoBloqueo;
    }

    public void setIdMotivoBloqueo(Integer idMotivoBloqueo) {
        this.idMotivoBloqueo = idMotivoBloqueo;
    }

    public Integer getIdEmpleadoBloqueo() {
        return idEmpleadoBloqueo;
    }

    public void setIdEmpleadoBloqueo(Integer idEmpleadoBloqueo) {
        this.idEmpleadoBloqueo = idEmpleadoBloqueo;
    }

    public Integer getIdContactoG() {
        return idContactoG;
    }

    public void setIdContactoG(Integer idContactoG) {
        this.idContactoG = idContactoG;
    }

    public Integer getIdDelegacionCli() {
        return idDelegacionCli;
    }

    public void setIdDelegacionCli(Integer idDelegacionCli) {
        this.idDelegacionCli = idDelegacionCli;
    }

    public String geteCommercePersonaNombre() {
        return eCommercePersonaNombre;
    }

    public void seteCommercePersonaNombre(String eCommercePersonaNombre) {
        this.eCommercePersonaNombre = eCommercePersonaNombre;
    }

    public String geteCommercePersonaApellidos() {
        return eCommercePersonaApellidos;
    }

    public void seteCommercePersonaApellidos(String eCommercePersonaApellidos) {
        this.eCommercePersonaApellidos = eCommercePersonaApellidos;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Short geteCommerceActivo() {
        return eCommerceActivo;
    }

    public void seteCommerceActivo(Short eCommerceActivo) {
        this.eCommerceActivo = eCommerceActivo;
    }

    public Integer getIdDoc() {
        return idDoc;
    }

    public void setIdDoc(Integer idDoc) {
        this.idDoc = idDoc;
    }

    public Short getInserUpdate() {
        return inserUpdate;
    }

    public void setInserUpdate(Short inserUpdate) {
        this.inserUpdate = inserUpdate;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(String numTelefono) {
        this.numTelefono = numTelefono;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.idCliente);
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
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.idCliente, other.idCliente)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", cliente=" + cliente + '}';
    }

    private void omplirResta() {
        this.idCompania = 0;
        this.direccion = null;
        this.ciudad = null;
        this.provincia = null;
        this.codPostal = null;
        this.idTipo = 0;
        this.idContacto = 0;
        this.idContactoA = 0;
        this.idContactoF = 0;
        this.numTelefono = null;
        this.numFax = null;
        this.email = null;
        this.web = null;
        this.notas = null;
        this.nif2 = null;
        this.padre = null;
        this.nivel = 0;
        this.miCod = null;
        this.bloqueado = 0;
        this.tipoTransporte = 0;
        this.idDelegacion = -1;
        this.idPoblacion = null;
        this.idProvincia = null;
        this.kmts = BigDecimal.ZERO;
        this.idCalendario = null;
        this.idTipoOtro = 0;
        this.idRelacion = null;
        this.rappelsPorPlanta = 0;
        this.esUbicacion = 0;
        this.clienteContado = 0;
        this.idMotivoBloqueo = null;
        this.idEmpleadoBloqueo = null;
        this.idDelegacionCli = 0;
        this.eCommercePersonaNombre = null;
        this.eCommercePersonaApellidos = null;
        this.observaciones = null;
        this.eCommerceActivo = 1;
        this.inserUpdate = 0;
        this.usuario = "ahora";
    }
    
    
}
