/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sai.persistence.product;

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
@Table(name="ps_product_lang")
public class ProductLang implements Serializable {
    @Id
    @Column(name="id_product")
    private int idProduct;
    @Id
    @Column(name="id_shop")
    private int idShop;
    @Id
    @Column(name="id_lang")
    private int idLang;
    @Column(name="description")
    private String description;
    @Column(name="description_short")
    private String descriptionShort;
    @Column(name="link_rewrite")
    private String linkRewrite;
    @Column(name="meta_description")
    private String metaDescription;
    @Column(name="meta_keywords")
    private String metaKeywords;
    @Column(name="meta_title")
    private String metaTitle;
    @Column(name="name")
    private String name;
    @Column(name="available_now")
    private String availableNow;
    @Column(name="available_later")
    private String availableLater;
    
    protected ProductLang () {}

    public ProductLang(int idProduct, int idShop, int idLang, String description, String descriptionShort, String linkRewrite, String metaDescription, String metaKeywords, String metaTitle, String name, String availableNow, String availableLater) {
        this.idProduct = idProduct;
        this.idShop = idShop;
        this.idLang = idLang;
        this.description = description;
        this.descriptionShort = descriptionShort;
        this.linkRewrite = descriptionShort;
        this.metaDescription = metaDescription;
        this.metaKeywords = metaKeywords;
        this.metaTitle = metaTitle;
        this.name = name;
        this.availableNow = availableNow;
        this.availableLater = availableLater;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescriptionShort() {
        return descriptionShort;
    }

    public void setDescriptionShort(String descriptionShort) {
        this.descriptionShort = descriptionShort;
    }

    public String getLinkRewrite() {
        return linkRewrite;
    }

    public void setLinkRewrite(String linkRewrite) {
        this.linkRewrite = linkRewrite;
    }

    public String getMetaDescription() {
        return metaDescription;
    }

    public void setMetaDescription(String metaDescription) {
        this.metaDescription = metaDescription;
    }

    public String getMetaKeywords() {
        return metaKeywords;
    }

    public void setMetaKeywords(String metaKeywords) {
        this.metaKeywords = metaKeywords;
    }

    public String getMetaTitle() {
        return metaTitle;
    }

    public void setMetaTitle(String metaTitle) {
        this.metaTitle = metaTitle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvailableNow() {
        return availableNow;
    }

    public void setAvailableNow(String availableNow) {
        this.availableNow = availableNow;
    }

    public String getAvailableLater() {
        return availableLater;
    }

    public void setAvailableLater(String availableLater) {
        this.availableLater = availableLater;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.idProduct;
        hash = 59 * hash + this.idShop;
        hash = 59 * hash + this.idLang;
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
        final ProductLang other = (ProductLang) obj;
        if (this.idProduct != other.idProduct) {
            return false;
        }
        if (this.idShop != other.idShop) {
            return false;
        }
        if (this.idLang != other.idLang) {
            return false;
        }
        return true;
    }
    
    
}
