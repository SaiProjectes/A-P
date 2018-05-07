/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sai.persistence;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author PROGRAMACIO3
 */
@Entity
@Table(name="ps_supplier_lang")
public class SupplierLang implements Serializable {
    @Id
    @Column(name="id_supplier")
    private int idSupplier;
    @Id
    @Column(name="id_lang")
    private int idLang;
    @Column(name="description")
    private String description;
    @Column(name="meta_title")
    private String metaTitle;
    @Column(name="meta_keywords")
    private String metaKeywords;
    @Column(name="meta_description")
    private String metaDescription;
    
    protected SupplierLang () {}

    public SupplierLang(int idSupplier, int idLang, String description, String metaTitle, String metaKeywords, String metaDescription) {
        this.idSupplier = idSupplier;
        this.idLang = idLang;
        this.description = description;
        this.metaTitle = metaTitle;
        this.metaKeywords = metaKeywords;
        this.metaDescription = metaDescription;
    }

    public int getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(int idSupplier) {
        this.idSupplier = idSupplier;
    }

    public int getIdLang() {
        return idLang;
    }

    public void setIdLang(int idLang) {
        this.idLang = idLang;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMetaTitle() {
        return metaTitle;
    }

    public void setMetaTitle(String metaTitle) {
        this.metaTitle = metaTitle;
    }

    public String getMetaKeywords() {
        return metaKeywords;
    }

    public void setMetaKeywords(String metaKeywords) {
        this.metaKeywords = metaKeywords;
    }

    public String getMetaDescription() {
        return metaDescription;
    }

    public void setMetaDescription(String metaDescription) {
        this.metaDescription = metaDescription;
    }

    @Override
    public String toString() {
        return "SupplierLang{" + "idSupplier=" + idSupplier + ", idLang=" + idLang + ", description=" + description + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.idSupplier;
        hash = 79 * hash + this.idLang;
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
        final SupplierLang other = (SupplierLang) obj;
        if (this.idSupplier != other.idSupplier) {
            return false;
        }
        if (this.idLang != other.idLang) {
            return false;
        }
        return true;
    }
    
    
    
}
