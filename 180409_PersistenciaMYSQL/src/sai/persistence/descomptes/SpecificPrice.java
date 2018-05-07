/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sai.persistence.descomptes;

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
@Table(name="ps_specific_price")
public class SpecificPrice implements Serializable {
    @Id
    @Column(name="id_specific_price")
    private int idSpecificPrice;
    @Column(name="id_specific_price_rule")
    private int idSpecificPriceRule;
    @Column(name="id_cart")
    private int idCart;
    @Column(name="id_product")
    private int idProduct;
    @Column(name="id_shop")
    private int idShop;
    @Column(name="id_shop_group")
    private int idShopGroup;
    @Column(name="id_currency")
    private int idCurrency;
    @Column(name="id_country")
    private int idCountry;
    @Column(name="id_group")
    private int idGroup;
    @Column(name="id_customer")
    private int idCustomer;
    @Column(name="id_product_attribute")
    private int idProductAttribute;
    @Column(name="price")
    private BigDecimal price;
    @Column(name="from_quantity")
    private int fromQuantity;
    @Column(name="reduction")
    private BigDecimal reduction;
    @Column(name="reduction_tax")
    private short reductionTax;
    @Column(name="reduction_type")
    private String reductionType;
    @Column(name="\"from\"")
    private Date from;
    @Column(name="\"to\"")
    private Date to;
    
    protected SpecificPrice () {}

    public SpecificPrice(int idSpecificPrice, int idSpecificPriceRule, int idProduct, int idCustomer, BigDecimal price, int fromQuantity, BigDecimal reduction, short reductionTax, String reductionType, Date from, Date to) {
        this.idSpecificPrice = idSpecificPrice;
        this.idSpecificPriceRule = idSpecificPriceRule;
        this.idProduct = idProduct;
        this.idCustomer = idCustomer;
        this.price = price;
        this.fromQuantity = fromQuantity;
        this.reduction = reduction;
        this.reductionTax = reductionTax;
        this.reductionType = reductionType;
        this.from = from;
        this.to = to;
    }

    public void setIdGroup(int idGroup) {
        this.idGroup = idGroup;
    }

    
    public int getIdSpecificPrice() {
        return idSpecificPrice;
    }

    public int getIdSpecificPriceRule() {
        return idSpecificPriceRule;
    }

    public int getIdCart() {
        return idCart;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public int getIdShop() {
        return idShop;
    }

    public int getIdShopGroup() {
        return idShopGroup;
    }

    public int getIdCurrency() {
        return idCurrency;
    }

    public int getIdCountry() {
        return idCountry;
    }

    public int getIdGroup() {
        return idGroup;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public int getIdProductAttribute() {
        return idProductAttribute;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getFromQuantity() {
        return fromQuantity;
    }

    public BigDecimal getReduction() {
        return reduction;
    }

    public short getReductionTax() {
        return reductionTax;
    }

    public String getReductionType() {
        return reductionType;
    }

    public Date getFrom() {
        return from;
    }

    public Date getTo() {
        return to;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.idSpecificPrice;
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
        final SpecificPrice other = (SpecificPrice) obj;
        if (this.idSpecificPrice != other.idSpecificPrice) {
            return false;
        }
        return true;
    }

    
    
    
    
    
}
