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
@Table(name="ps_specific_price_rule")
public class SpecificPriceRule implements Serializable {
    @Id
    @Column(name="id_specific_price_rule")
    private int idSpecificPriceRule;
    @Column(name="name")
    private String name;
    @Column(name="id_shop")
    private int idShop;
    @Column(name="id_currency")
    private int idCurrency;
    @Column(name="id_country")
    private int idCountry;
    @Column(name="id_group")
    private int idGroup;
    @Column(name="from_quantity")
    private int fromQuantity;
    @Column(name="price")
    private BigDecimal price;
    @Column(name="reduction")
    private BigDecimal reduction;
    @Column(name="reduction_tax")
    private short reductionTax;
    @Column(name="reduction_type")
    private String reductionType;
    @Column(name="\"from\"")
    private Date fromdate;
    @Column(name="\"to\"")
    private Date todate;
    
    protected SpecificPriceRule () {}

    public SpecificPriceRule(int idSpecificPriceRule, String name, int idShop, int idCurrency, int idCountry, int idGroup, int fromQuantity, BigDecimal price, BigDecimal reduction, short reductionTax, String reductionType, Date from, Date to) {
        this.idSpecificPriceRule = idSpecificPriceRule;
        this.name = name;
        this.idShop = idShop;
        this.idCurrency = idCurrency;
        this.idCountry = idCountry;
        this.idGroup = idGroup;
        this.fromQuantity = fromQuantity;
        this.price = price;
        this.reduction = reduction;
        this.reductionTax = reductionTax;
        this.reductionType = reductionType;
        this.fromdate = from;
        this.todate = to;
    }

    
    
    public int getIdSpecificPriceRule() {
        return idSpecificPriceRule;
    }

    public String getName() {
        return name;
    }

    public int getIdShop() {
        return idShop;
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

    public int getFromQuantity() {
        return fromQuantity;
    }

    public BigDecimal getPrice() {
        return price;
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
        return fromdate;
    }

    public Date getTo() {
        return todate;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.idSpecificPriceRule;
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
        final SpecificPriceRule other = (SpecificPriceRule) obj;
        if (this.idSpecificPriceRule != other.idSpecificPriceRule) {
            return false;
        }
        return true;
    }
    
    
    
    
}
