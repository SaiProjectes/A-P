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
@Table(name="ps_match_order")
public class MatchOrder implements Serializable {
    @Id
    @Column(name="id_presta")
    private int idPresta;
    @Column(name="euro_empresa")
    private String euroEmpresa;
    @Column(name="euro_numero")
    private String euroNumero;
    @Column(name="euro_letra")
    private String euroLetra;
    
    protected MatchOrder () {}

    public MatchOrder(int idPresta, String euroEmpresa, String euroNumero, String euroLetra) {
        this.idPresta = idPresta;
        this.euroEmpresa = euroEmpresa;
        this.euroNumero = euroNumero;
        this.euroLetra = euroLetra;
    }

    public int getIdPresta() {
        return idPresta;
    }

    public void setIdPresta(int idPresta) {
        this.idPresta = idPresta;
    }

    public String getEuroEmpresa() {
        return euroEmpresa;
    }

    public void setEuroEmpresa(String euroEmpresa) {
        this.euroEmpresa = euroEmpresa;
    }

    public String getEuroNumero() {
        return euroNumero;
    }

    public void setEuroNumero(String euroNumero) {
        this.euroNumero = euroNumero;
    }

    public String getEuroLetra() {
        return euroLetra;
    }

    public void setEuroLetra(String euroLetra) {
        this.euroLetra = euroLetra;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.euroEmpresa);
        hash = 41 * hash + Objects.hashCode(this.euroNumero);
        hash = 41 * hash + Objects.hashCode(this.euroLetra);
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
        final MatchOrder other = (MatchOrder) obj;
        if (!Objects.equals(this.euroEmpresa, other.euroEmpresa)) {
            return false;
        }
        if (!Objects.equals(this.euroNumero, other.euroNumero)) {
            return false;
        }
        if (!Objects.equals(this.euroLetra, other.euroLetra)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
