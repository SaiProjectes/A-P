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
@Table(name="ps_product_attribute")
public class ProductAttribute implements Serializable {
    @Id 
    @Column(name="id_product_attribute")
    private int idProductAttribute;
    @Column(name="id_product")
    private int idProduct;
    @Column(name="reference")
    private String reference;
    @Column(name="supplier_reference")
    private String supplierReference;
    @Column(name="location")
    private String location;
    @Column(name="ean13")
    private String ean13;
    @Column(name="isbn")
    private String isbn;
    @Column(name="upc")
    private String upc;
    @Column(name="wholesale_price")
    private BigDecimal wholesalePrice;
    @Column(name="price")
    private BigDecimal price;
    @Column(name="ecotax")
    private BigDecimal ecotax;
    @Column(name="quantity")
    private int quantity;
    @Column(name="weight")
    private BigDecimal weight;
    @Column(name="unit_price_impact")
    private BigDecimal unitPriceImpact;
    @Column(name="default_on")
    private short defaultOn;
    @Column(name="minimal_quantity")
    private int minimalQuantity;
    
    protected ProductAttribute () {}

    public ProductAttribute(int idProductAttribute, int idProduct, String reference, String supplierReference, String location, String ean13, String isbn, String upc, BigDecimal wholesalePrice, BigDecimal price, BigDecimal ecotax, int quantity, BigDecimal weight, BigDecimal unitPriceImpact, short defaultOn, int minimalQuantity) {
        this.idProductAttribute = idProductAttribute;
        this.idProduct = idProduct;
        this.reference = reference;
        this.supplierReference = supplierReference;
        this.location = location;
        this.ean13 = ean13;
        this.isbn = isbn;
        this.upc = upc;
        this.wholesalePrice = wholesalePrice;
        this.price = price;
        this.ecotax = ecotax;
        this.quantity = quantity;
        this.weight = weight;
        this.unitPriceImpact = unitPriceImpact;
        this.defaultOn = defaultOn;
        this.minimalQuantity = minimalQuantity;
    }

    public int getIdProductAttribute() {
        return idProductAttribute;
    }

    public void setIdProductAttribute(int idProductAttribute) {
        this.idProductAttribute = idProductAttribute;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getSupplierReference() {
        return supplierReference;
    }

    public void setSupplierReference(String supplierReference) {
        this.supplierReference = supplierReference;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEan13() {
        return ean13;
    }

    public void setEan13(String ean13) {
        this.ean13 = ean13;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public BigDecimal getWholesalePrice() {
        return wholesalePrice;
    }

    public void setWholesalePrice(BigDecimal wholesalePrice) {
        this.wholesalePrice = wholesalePrice;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getEcotax() {
        return ecotax;
    }

    public void setEcotax(BigDecimal ecotax) {
        this.ecotax = ecotax;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getUnitPriceImpact() {
        return unitPriceImpact;
    }

    public void setUnitPriceImpact(BigDecimal unitPriceImpact) {
        this.unitPriceImpact = unitPriceImpact;
    }

    public short getDefaultOn() {
        return defaultOn;
    }

    public void setDefaultOn(short defaultOn) {
        this.defaultOn = defaultOn;
    }

    public int getMinimalQuantity() {
        return minimalQuantity;
    }

    public void setMinimalQuantity(int minimalQuantity) {
        this.minimalQuantity = minimalQuantity;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.idProductAttribute;
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
        final ProductAttribute other = (ProductAttribute) obj;
        if (this.idProductAttribute != other.idProductAttribute) {
            return false;
        }
        return true;
    }
    
    
    
}
