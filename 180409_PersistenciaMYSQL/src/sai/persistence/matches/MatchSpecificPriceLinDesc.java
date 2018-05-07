/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sai.persistence.matches;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author PROGRAMACIO3
 */
@Entity
@Table(name="ps_match_specific_price_lindesc")
public class MatchSpecificPriceLinDesc implements Serializable {
    @Column(name="tipus_presta")
    private String tipusPresta;
    @Column(name="id_presta")
    private int idPresta;
    @Id
    @Column(name="id_euro_codigo")
    private String idEuroCodigo;
    @Id
    @Column(name="id_euro_articulo")
    private String idEuroArticulo;
    @Id
    @Column(name="id_euro_familia")
    private String idEuroFamilia;
    @Id
    @Column(name="id_euro_subfamilia")
    private String idEuroSubfamilia;
    @Id
    @Column(name="id_euro_linea")
    private int idEuroLinea;
    
    protected MatchSpecificPriceLinDesc () {}

    public MatchSpecificPriceLinDesc(String tipusPresta, int idPresta, String idEuroCodigo, String idEuroArticulo, String idEuroFamilia, String idEuroSubfamilia, int idEuroLinea) {
        this.tipusPresta = tipusPresta;
        this.idPresta = idPresta;
        this.idEuroCodigo = idEuroCodigo;
        this.idEuroArticulo = idEuroArticulo;
        this.idEuroFamilia = idEuroFamilia;
        this.idEuroSubfamilia = idEuroSubfamilia;
        this.idEuroLinea = idEuroLinea;
    }
    
    
    public String getTipusPresta() {
        return tipusPresta;
    }
    
    public int getIdPresta() {
        return idPresta;
    }

    public void setIdPresta(int idPresta) {
        this.idPresta = idPresta;
    }

    public String getIdEuroCodigo() {
        return idEuroCodigo;
    }

    public void setIdEuroCodigo(String idEuroCodigo) {
        this.idEuroCodigo = idEuroCodigo;
    }

    public String getIdEuroArticulo() {
        return idEuroArticulo;
    }

    public void setIdEuroArticulo(String idEuroArticulo) {
        this.idEuroArticulo = idEuroArticulo;
    }

    public String getIdEuroFamilia() {
        return idEuroFamilia;
    }

    public void setIdEuroFamilia(String idEuroFamilia) {
        this.idEuroFamilia = idEuroFamilia;
    }

    public String getIdEuroSubfamilia() {
        return idEuroSubfamilia;
    }

    public void setIdEuroSubfamilia(String idEuroSubfamilia) {
        this.idEuroSubfamilia = idEuroSubfamilia;
    }

    public int getIdEuroLinea() {
        return idEuroLinea;
    }

    public void setIdEuroLinea(int idEuroLinea) {
        this.idEuroLinea = idEuroLinea;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.idEuroCodigo);
        hash = 41 * hash + Objects.hashCode(this.idEuroArticulo);
        hash = 41 * hash + Objects.hashCode(this.idEuroFamilia);
        hash = 41 * hash + Objects.hashCode(this.idEuroSubfamilia);
        hash = 41 * hash + this.idEuroLinea;
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
        final MatchSpecificPriceLinDesc other = (MatchSpecificPriceLinDesc) obj;
        if (this.idEuroLinea != other.idEuroLinea) {
            return false;
        }
        if (!Objects.equals(this.idEuroCodigo, other.idEuroCodigo)) {
            return false;
        }
        if (!Objects.equals(this.idEuroArticulo, other.idEuroArticulo)) {
            return false;
        }
        if (!Objects.equals(this.idEuroFamilia, other.idEuroFamilia)) {
            return false;
        }
        if (!Objects.equals(this.idEuroSubfamilia, other.idEuroSubfamilia)) {
            return false;
        }
        return true;
    }
    
    
}
