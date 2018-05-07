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
@Table(name="ps_stock_available")
public class StockAvailable implements Serializable {
    @Id
    @Column(name="id_stock_available")
    private int idStockAvailable;
    @Column(name="id_product")
    private int idProduct;
    @Column(name="id_product_attribute")
    private int idProductAttribute;
    @Column(name="id_shop")
    private int idShop;
    @Column(name="id_shop_group")
    private int idShopGroup;
    @Column(name="quantity")
    private int quantity;
    @Column(name="depends_on_stock")
    private short dependsOnStock;
    @Column(name="out_of_stock")
    private short outOfStock;
    
    protected StockAvailable() {}

    public StockAvailable(int idStockAvailable, int idProduct, int idProductAttribute, int idShop, int idShopGroup, int quantity) {
        this.idStockAvailable = idStockAvailable;
        this.idProduct = idProduct;
        this.idProductAttribute = idProductAttribute;
        this.idShop = idShop;
        this.idShopGroup = idShopGroup;
        this.quantity = quantity;
        this.dependsOnStock = 0;
        this.outOfStock = 2;
    }

    public int getIdStockAvailable() {
        return idStockAvailable;
    }

    public void setIdStockAvailable(int idStockAvailable) {
        this.idStockAvailable = idStockAvailable;
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

    public int getIdShopGroup() {
        return idShopGroup;
    }

    public void setIdShopGroup(int idShopGroup) {
        this.idShopGroup = idShopGroup;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public short getDependsOnStock() {
        return dependsOnStock;
    }

    public void setDependsOnStock(short dependsOnStock) {
        this.dependsOnStock = dependsOnStock;
    }

    public short getOutoOfStock() {
        return outOfStock;
    }

    public void setOutoOfStock(short outoOfStock) {
        this.outOfStock = outoOfStock;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.idStockAvailable;
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
        final StockAvailable other = (StockAvailable) obj;
        if (this.idStockAvailable != other.idStockAvailable) {
            return false;
        }
        return true;
    }
    
    
    
    
    
}
