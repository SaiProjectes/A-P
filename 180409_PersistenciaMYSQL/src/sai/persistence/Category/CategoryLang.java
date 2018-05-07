/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sai.persistence.Category;

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
@Table (name="ps_category_lang")
public class CategoryLang implements Serializable {
    @Id
    @Column(name="id_category")
    private int idCategory;
    @Id
    @Column(name="id_shop")
    private int idShop;
    @Id
    @Column(name="id_lang")
    private int idLang;
    @Column(name="name")
    private String name;
    @Column(name="description")
    private String description;
    @Column(name="link_rewrite")
    private String linkRewrite;
    @Column(name="meta_title")
    private String metaTitle;
    @Column(name="meta_keywords")
    private String metaKeywords;
    @Column(name="meta_description")
    private String metaDesc;
    
    protected CategoryLang () {}

    public CategoryLang(int idCategory, int idShop, int idLang, String name, String description, String linkRewrite, String metaTitle, String metaKeywords, String metaDesc) {
        this.idCategory = idCategory;
        this.idShop = idShop;
        this.idLang = idLang;
        this.name = name;
        this.description = description;
        this.linkRewrite = linkRewrite;
        this.metaTitle = metaTitle;
        this.metaKeywords = metaKeywords;
        this.metaDesc = metaDesc;
    }

    
    
    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public int getIdShop() {
        return idShop;
    }

    public void setIdShop(int idShop) {
        this.idShop = idShop;
    }

    public int getIdLang() {
        return idLang;
    }

    public void setIdLang(int idLang) {
        this.idLang = idLang;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLinkRewrite() {
        return linkRewrite;
    }

    public void setLinkRewrite(String linkRewrite) {
        this.linkRewrite = linkRewrite;
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

    public String getMetaDesc() {
        return metaDesc;
    }

    public void setMetaDesc(String metaDesc) {
        this.metaDesc = metaDesc;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.idCategory;
        hash = 53 * hash + this.idLang;
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
        final CategoryLang other = (CategoryLang) obj;
        if (this.idCategory != other.idCategory) {
            return false;
        }
        if (this.idLang != other.idLang) {
            return false;
        }
        return true;
    }
    
    
}
