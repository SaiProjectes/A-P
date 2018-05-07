/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sai.persistence.product;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author PROGRAMACIO3
 */
@Entity
@Table (name="ps_product")
public class Product implements Serializable {

   
    
    public Product(int idProducte, int idSupplier, int idManufacturer, int idCategoryDefault, int idShopDefault, BigDecimal price, BigDecimal wholesalePrice, String reference) {
        this.idProducte = idProducte;
        this.idSupplier = idSupplier;
        this.idManufacturer = idManufacturer;
        this.idCategoryDefault = idCategoryDefault;
        this.idShopDefault = idShopDefault;
        this.price = price;
        this.wholesalePrice = wholesalePrice;
        this.reference = reference;
        omplirRestants();
    }

    
    @Id
    @Column(name="id_product")
    private int idProducte;
    @Column(name="id_supplier")
    private int idSupplier;
    @Column(name="id_manufacturer")
    private int idManufacturer;
    @Column(name="id_category_default")
    private int idCategoryDefault;
    @Column(name="id_shop_default")
    private int idShopDefault;
    @Column(name="price")
    private BigDecimal price;
    @Column(name="wholesale_price")
    private BigDecimal wholesalePrice;
    @Column(name="reference")
    private String reference;
    @Column(name="id_tax_rules_group")
    private int idTaxRulesGroup;
    @Column(name="quantity")
    private int quantity;
    //pendent
    @Column(name="on_sale")
    private short onSale;
    @Column(name="ean13")
    private String ean13;
    @Column(name="isbn")
    private String isbn;
    @Column(name="upc")
    private String upc;
    @Column(name="unity")
    private String unity;
    @Column(name="location")
    private String location;
    @Column(name="supplier_reference")
    private String supplierReference;
    @Column(name="active")
    private short active;
    @Column(name="show_condition")
    private short showCondition;
    @Column(name="indexed")
    private short indexed;
    
   
    @Column(name="cache_default_attribute")
    private int cacheDefaultAttribute;
    
    
    @Column(name="date_add")
    private Date dateAdd;
    @Column(name="date_upd")
    private Date dateUpd;
    
    

    protected Product () {}

   



    @Override
    public String toString() {
        return "Product{" + "idProducte = "  + idProducte + ", idSupplier = " + idSupplier + ", idManufacturer = " + idManufacturer + ", price = " + price + ", reference = " + reference + '}';
    }

    private void omplirRestants() {
        Date d = new Date();
        this.idTaxRulesGroup = 1;
        this.dateAdd = d;
        this.dateUpd = d;
        this.onSale = (short)0;
        this.ean13  ="";
        this.isbn="";
        this.upc="";
        this.unity="";
        this.location="";
        this.supplierReference="";
        this.active = (short)1;
        this.showCondition= (short)0;
        this.indexed= (short)0;
        this.cacheDefaultAttribute= (short)0;
        this.quantity = 1000;
    }

    public int getIdProducte() {
        return idProducte;
    }

    private void setIdProducte(int idProducte) {
        this.idProducte = idProducte;
    }

    public int getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(int idSupplier) {
        this.idSupplier = idSupplier;
    }

    public int getIdManufacturer() {
        return idManufacturer;
    }

    public void setIdManufacturer(int idManufacturer) {
        this.idManufacturer = idManufacturer;
    }

    public int getIdCategoryDefault() {
        return idCategoryDefault;
    }

    public void setIdCategoryDefault(int idCategoryDefault) {
        this.idCategoryDefault = idCategoryDefault;
    }

    public int getIdShopDefault() {
        return idShopDefault;
    }

    public void setIdShopDefault(int idShopDefault) {
        this.idShopDefault = idShopDefault;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getWholesalePrice() {
        return wholesalePrice;
    }

    public void setWholesalePrice(BigDecimal wholesalePrice) {
        this.wholesalePrice = wholesalePrice;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.idProducte;
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
        final Product other = (Product) obj;
        if (this.idProducte != other.idProducte) {
            return false;
        }
        return true;
    }

    
    
    
    
    
}
