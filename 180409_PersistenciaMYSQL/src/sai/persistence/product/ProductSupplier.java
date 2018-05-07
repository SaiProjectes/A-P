/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sai.persistence.product;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author PROGRAMACIO3
 */
@Entity
@Table(name="ps_product_supplier")
public class ProductSupplier implements Serializable {
    @Id
    @Column(name="id_product_supplier")
    private int idProductSupplier;
    @Column(name="id_product")
    private int idProduct;
    @Column(name="id_product_attribute")
    private int idProductAttribute;
    @Column(name="id_supplier")
    private int idSupplier;
    @Column(name="product_supplier_reference")
    private String productSupplierReference;
    @Column(name="product_supplier_price_te")
    private BigDecimal productSupplierPriceTe;
    @Column(name="id_currency")
    private int idCurrency;
    
    protected ProductSupplier () {}

    public ProductSupplier(int idProductSupplier, int idProduct, int idProductAttribute, int idSupplier, String productSupplierReference, BigDecimal productSupplierPriceTe, int idCurrency) {
        this.idProductSupplier = idProductSupplier;
        this.idProduct = idProduct;
        this.idProductAttribute = idProductAttribute;
        this.idSupplier = idSupplier;
        this.productSupplierReference = productSupplierReference;
        this.productSupplierPriceTe = productSupplierPriceTe;
        this.idCurrency = idCurrency;
    }

    public int getIdProductSupplier() {
        return idProductSupplier;
    }

    public void setIdProductSupplier(int idProductSupplier) {
        this.idProductSupplier = idProductSupplier;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getIdProductAttribute() {
        return idProductAttribute;
    }

    public void setIdProductAttribute(int idProductAttribute) {
        this.idProductAttribute = idProductAttribute;
    }

    public int getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(int idSupplier) {
        this.idSupplier = idSupplier;
    }

    public String getProductSupplierReference() {
        return productSupplierReference;
    }

    public void setProductSupplierReference(String productSupplierReference) {
        this.productSupplierReference = productSupplierReference;
    }

    public BigDecimal getProductSupplierPriceTe() {
        return productSupplierPriceTe;
    }

    public void setProductSupplierPriceTe(BigDecimal productSupplierPriceTe) {
        this.productSupplierPriceTe = productSupplierPriceTe;
    }

    public int getIdCurrency() {
        return idCurrency;
    }

    public void setIdCurrency(int idCurrency) {
        this.idCurrency = idCurrency;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.idProductSupplier;
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
        final ProductSupplier other = (ProductSupplier) obj;
        if (this.idProductSupplier != other.idProductSupplier) {
            return false;
        }
        return true;
    }
    
    
}
