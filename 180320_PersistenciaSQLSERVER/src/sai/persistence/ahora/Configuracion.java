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
@Table(name="dbo.Ceesi_configuracion")
public class Configuracion implements Serializable {
    @Id
    @Column(name="Parametro")
    private String parametro;
    @Id
    @Column(name="IdDelegacion")
    private int idDelegacion;
    @Column(name="Valor")
    private String valor;
    @Column(name="Clasificacion1")
    private String clasificacion1;
    @Column(name="Clasificacion2")
    private String clasificacion2;
    @Column(name="Descrip")
    private String descrip;
    @Column(name="Observaciones")
    private String observaciones;
    @Column(name="Version")
    private String version;
    @Column(name="Multidelegacion")
    private Short multidelegacion;
    @Column(name="Objeto")
    private String objeto;
    @Column(name="ParametroPadre")
    private String parametroPadre;
    @Column(name="Idclasificacion")
    private String idClasificacion;
    @Column(name="Nousar")
    private Short nousar;
    @Column(name="Basico")
    private Short basico;
    @Column(name="TPV")
    private Short tpv;
    @Column(name="Conf")
    private Short conf;
    @Column(name="Obliga")
    private Short obliga;
    @Column(name="Orden")
    private Integer orden;
    @Column(name="Etiqueta_conf")
    private String etiquetaConf;
    @Column(name="IdPanel_Conf")
    private Integer idPanelConf;
    
    protected Configuracion () {}

    public String getParametro() {
        return parametro;
    }

    public void setParametro(String parametro) {
        this.parametro = parametro;
    }

    public int getIdDelegacion() {
        return idDelegacion;
    }

    public void setIdDelegacion(int idDelegacion) {
        this.idDelegacion = idDelegacion;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getClasificacion1() {
        return clasificacion1;
    }

    public void setClasificacion1(String clasificacion1) {
        this.clasificacion1 = clasificacion1;
    }

    public String getClasificacion2() {
        return clasificacion2;
    }

    public void setClasificacion2(String clasificacion2) {
        this.clasificacion2 = clasificacion2;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Short getMultidelegacion() {
        return multidelegacion;
    }

    public void setMultidelegacion(Short multidelegacion) {
        this.multidelegacion = multidelegacion;
    }

    public String getObjeto() {
        return objeto;
    }

    public void setObjeto(String objeto) {
        this.objeto = objeto;
    }

    public String getParametroPadre() {
        return parametroPadre;
    }

    public void setParametroPadre(String parametroPadre) {
        this.parametroPadre = parametroPadre;
    }

    public String getIdClasificacion() {
        return idClasificacion;
    }

    public void setIdClasificacion(String idClasificacion) {
        this.idClasificacion = idClasificacion;
    }

    public Short getNousar() {
        return nousar;
    }

    public void setNousar(Short nousar) {
        this.nousar = nousar;
    }

    public Short getBasico() {
        return basico;
    }

    public void setBasico(Short basico) {
        this.basico = basico;
    }

    public Short getTpv() {
        return tpv;
    }

    public void setTpv(Short tpv) {
        this.tpv = tpv;
    }

    public Short getConf() {
        return conf;
    }

    public void setConf(Short conf) {
        this.conf = conf;
    }

    public Short getObliga() {
        return obliga;
    }

    public void setObliga(Short obliga) {
        this.obliga = obliga;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public String getEtiquetaConf() {
        return etiquetaConf;
    }

    public void setEtiquetaConf(String etiquetaConf) {
        this.etiquetaConf = etiquetaConf;
    }

    public Integer getIdPanelConf() {
        return idPanelConf;
    }

    public void setIdPanelConf(Integer idPanelConf) {
        this.idPanelConf = idPanelConf;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.parametro);
        hash = 31 * hash + this.idDelegacion;
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
        final Configuracion other = (Configuracion) obj;
        if (this.idDelegacion != other.idDelegacion) {
            return false;
        }
        if (!Objects.equals(this.parametro, other.parametro)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Configuracion{" + "parametro=" + parametro + ", valor=" + valor + '}';
    }
    
    
    
}
