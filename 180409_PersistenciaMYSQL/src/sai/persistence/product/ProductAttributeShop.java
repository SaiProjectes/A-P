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
@Table(name="ps_product_attribute_shop")
public class ProductAttributeShop implements Serializable {
    @Column(name="id_product")
    private int idProduct;
    @Id
    @Column(name="id_product_attribute")
    private int idProductAttribute;
    @Id
    @Column(name="id_shop")
    private int idShop;
    @Column(name="wholesale_price")
    private BigDecimal wholesalePrice;
    @Column(name="price")
    private BigDecimal price;
    @Column(name="ecotax")
    private BigDecimal ecotax;
    @Column(name="weight")
    private BigDecimal weight;
    @Column(name="unit_price_impact")
    private BigDecimal unitPriceImpact;
    @Column(name="default_on")
    private short defaultOn;
    @Column(name="minimal_quantity")
    private int minimalQuantity;
    
    protected ProductAttributeShop (){}

    public ProductAttributeShop(int idProduct, int idProductAttribute, int idShop, BigDecimal wholesalePrice, BigDecimal price, BigDecimal ecotax, BigDecimal weight, BigDecimal unitPriceImpact, short defaultOn, int minimalQuantity) {
        this.idProduct = idProduct;
        this.idProductAttribute = idProductAttribute;
        this.idShop = idShop;
        this.wholesalePrice = wholesalePrice;
        this.price = price;
        this.ecotax = ecotax;
        this.weight = weight;
        this.unitPriceImpact = unitPriceImpact;
        this.defaultOn = defaultOn;
        this.minimalQuantity = minimalQuantity;
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

    public int getIdShop() {
        return idShop;
    }

    public void setIdShop(int idShop) {
        this.idShop = idShop;
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
        hash = 67 * hash + this.idProductAttribute;
        hash = 67 * hash + this.idShop;
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
        final ProductAttributeShop other = (ProductAttributeShop) obj;
        if (this.idProductAttribute != other.idProductAttribute) {
            return false;
        }
        if (this.idShop != other.idShop) {
            return false;
        }
        return true;
    }
    
    
    
    
}
