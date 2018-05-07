/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sai.persistence.ahora;
import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name="dbo.Articulos")
public class Articulo implements Serializable {
    @Id
    @Column(name="IdArticulo")
    private String idArticulo;
    @Column(name="IdNivel")
    private Short idNivel;
    @Column(name="Descrip")
    private String descrip;
    @Column(name="IdEmpresa")
    private Short idEmpresa;
    @Column(name="IdFamilia")
    private String idFamilia;
    @Column(name="Estado")
    private Short estado;
    @Column(name="ModeloArticulo")
    private String modeloArticulo;
    @Column(name="IdMarcaArticulo")
    private Integer idMarcaArticulo;
    
    
    //ecommerce
    @Column(name="ECommerce_Activo")
    private short eActivo;
    @Column(name="ECommerce_PedidoMinimo")
    private BigDecimal ePedidoMinimo;
    @Column(name="ECommerce_MetaTitulo")
    private String eMetaTitulo;
    @Column(name="ECommerce_MetaDescripcion")
    private String eMetaDescripcion;
    @Column(name="ECommerce_MetaKeywords")
    private String eMetaKeywords;
    @Column(name="ECommerce_Descrip")
    private String eDescrip;
    @Column(name="ECommerce_DescripCorta")
    private String eDescripCorta;
    @Column(name="IdDoc")
    private Integer idDoc;
    
    
    protected Articulo () {}
    
    public Integer getIdDoc() {
        return idDoc;
    }

    
    
    
    public String getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(String idArticulo) {
        this.idArticulo = idArticulo;
    }

    public short getIdNivel() {
        return idNivel;
    }

    public void setIdNivel(short idNivel) {
        this.idNivel = idNivel;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public short getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(short idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getIdFamilia() {
        return idFamilia;
    }

    public void setIdFamilia(String idFamilia) {
        this.idFamilia = idFamilia;
    }

    public short getEstado() {
        return estado;
    }

    public void setEstado(short estado) {
        this.estado = estado;
    }

    public String getModeloArticulo() {
        return modeloArticulo;
    }

    public void setModeloArticulo(String modeloArticulo) {
        this.modeloArticulo = modeloArticulo;
    }

    public int getIdMarcaArticulo() {
        return idMarcaArticulo;
    }

    public void setIdMarcaArticulo(int idMarcaArticulo) {
        this.idMarcaArticulo = idMarcaArticulo;
    }

    public short geteActivo() {
        return eActivo;
    }

    public void seteActivo(short eActivo) {
        this.eActivo = eActivo;
    }

    public BigDecimal getePedidoMinimo() {
        return ePedidoMinimo;
    }

    public void setePedidoMinimo(BigDecimal ePedidoMinimo) {
        this.ePedidoMinimo = ePedidoMinimo;
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

    public String geteDescrip() {
        return eDescrip;
    }

    public void seteDescrip(String eDescrip) {
        this.eDescrip = eDescrip;
    }

    public String geteDescripCorta() {
        return eDescripCorta;
    }

    public void seteDescripCorta(String eDescripCorta) {
        this.eDescripCorta = eDescripCorta;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.idArticulo);
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
        final Articulo other = (Articulo) obj;
        if (!Objects.equals(this.idArticulo, other.idArticulo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Articulo{" + "idArticulo=" + idArticulo + ", descrip=" + descrip + ", eActivo=" + eActivo + ", eMetaTitulo=" + eMetaTitulo + ", eMetaDescripcion=" + eMetaDescripcion + '}';
    }
    
    
    
} 
