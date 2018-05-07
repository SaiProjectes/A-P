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
import javax.persistence.Temporal;

/**
 *
 * @author PROGRAMACIO3
 */
@Entity
@Table(name="ps_product_shop")
public class ProductShop implements Serializable {
    @Id
    @Column(name="id_product")
    private int idProducte;
    @Id
    @Column(name="id_shop")
    private int idShop;
    @Column(name="id_category_default")
    private int idCategoryDefault;
    @Column(name="id_tax_rules_group")
    private int idTaxRulesGroup;
//    //-----------------------------------
//    @Column(name="on_sale")
//    private short onSale;
//    @Column(name="online_only")
//    private short onlineOnly;
//    @Column(name="ecotax")
//    private BigDecimal ecotax;
//    @Column(name="minimal_quantity")
//    private int minimalQuantity;
    
    
    @Column(name="price")
    private BigDecimal price;
    @Column(name="wholesale_price")
    private BigDecimal wholesalePrice;
    
    
    //pendents
    @Column(name="active")
    private short active;
    @Column(name="redirect_type")
    private String redirectType;//enum
    @Column(name="indexed")
    private short indexed;
    @Column(name="unity")
    private String unity;
    @Column(name="cache_default_attribute")
    private short cacheDefaultAttribute;
    
    @Column(name="show_condition")
    private short showCondition;
    
    
    

    
    @Column(name="date_add")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateAdd;
    @Column(name="date_upd")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateUpd;
    
    protected ProductShop (){}

    public ProductShop(int idProducte, int idShop, int idCategoryDefault, BigDecimal price, BigDecimal wholesalePrice) {
        this.idProducte = idProducte;
        this.idShop = idShop;
        this.idCategoryDefault = idCategoryDefault;
        this.price = price;
        this.wholesalePrice = wholesalePrice;
        omplirResta ();
        
    }

    /*
    
    INSERT INTO `ps_product_shop` VALUES
    ('8','1','5','1','0','0','0.000000','1','16.510000','4.950000',NULL,
    '0.000000','0.00','0','0','0','1','404','0','1','0000-00-00','0','new',
    '1','1','both','1','0','2017-06-09 09:21:09','2017-06-09 09:21:09','3');
    */
    
    private void omplirResta() {
        Date d = new Date();
        this.idTaxRulesGroup = 1;
        this.dateAdd = d;
        this.dateUpd = d;
        
        
        this.active = (short)1;
        this.redirectType = "404";//enum
        this.indexed= (short)1;
        this.unity  ="";
        this.cacheDefaultAttribute= (short)0;
        this.showCondition = (short)0;

        
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + this.idProducte;
        hash = 17 * hash + this.idShop;
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
        final ProductShop other = (ProductShop) obj;
        if (this.idProducte != other.idProducte) {
            return false;
        }
        if (this.idShop != other.idShop) {
            return false;
        }
        return true;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    
    
    
}
