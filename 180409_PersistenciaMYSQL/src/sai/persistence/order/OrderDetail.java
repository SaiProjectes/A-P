/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sai.persistence.order;

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
@Table(name="ps_order_detail")
public class OrderDetail implements Serializable {
    @Id
    @Column(name="id_order_detail")
    private int idOrderDetail;
    @Column(name="id_order")
    private int idOrder;
    @Column(name="id_order_invoice")
    private int idOrderInvoice;
    @Column(name="id_shop")
    private int idShop;
    @Column(name="product_id")
    private int productId;
    @Column(name="product_name")
    private String productName;
    @Column(name="product_weight")
    private BigDecimal productWeight;
    @Column(name="tax_name")
    private String taxName;
    @Column(name="product_price")
    private BigDecimal productPrice;
    @Column(name="product_reference")
    private String productReference;
    @Column(name="product_quantity")
    private int productQuantity;
    @Column(name="total_price_tax_incl")
    private BigDecimal totalPriceTaxIncl;
    @Column(name="total_price_tax_excl")
    private BigDecimal totalPriceTaxExcl;
    
    protected OrderDetail(){}

    public OrderDetail(int idOrderDetail, int idOrder, int idOrderInvoice, int idShop, int productId, String productName, BigDecimal productWeight, String taxName, BigDecimal productPrice, String productReference, int productQuantity, BigDecimal totalPriceTaxIncl, BigDecimal totalPriceTaxExcl) {
        this.idOrderDetail = idOrderDetail;
        this.idOrder = idOrder;
        this.idOrderInvoice = idOrderInvoice;
        this.idShop = idShop;
        this.productId = productId;
        this.productName = productName;
        this.productWeight = productWeight;
        this.taxName = taxName;
        this.productPrice = productPrice;
        this.productReference = productReference;
        this.productQuantity = productQuantity;
        this.totalPriceTaxIncl = totalPriceTaxIncl;
        this.totalPriceTaxExcl = totalPriceTaxExcl;
    }

    public int getIdOrderDetail() {
        return idOrderDetail;
    }

    public void setIdOrderDetail(int idOrderDetail) {
        this.idOrderDetail = idOrderDetail;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdOrderInvoice() {
        return idOrderInvoice;
    }

    public void setIdOrderInvoice(int idOrderInvoice) {
        this.idOrderInvoice = idOrderInvoice;
    }

    public int getIdShop() {
        return idShop;
    }

    public void setIdShop(int idShop) {
        this.idShop = idShop;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getProductWeight() {
        return productWeight;
    }

    public void setProductWeight(BigDecimal productWeight) {
        this.productWeight = productWeight;
    }

    public String getTaxName() {
        return taxName;
    }

    public void setTaxName(String taxName) {
        this.taxName = taxName;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductReference() {
        return productReference;
    }

    public void setProductReference(String productReference) {
        this.productReference = productReference;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public BigDecimal getTotalPriceTaxIncl() {
        return totalPriceTaxIncl;
    }

    public void setTotalPriceTaxIncl(BigDecimal totalPriceTaxIncl) {
        this.totalPriceTaxIncl = totalPriceTaxIncl;
    }

    public BigDecimal getTotalPriceTaxExcl() {
        return totalPriceTaxExcl;
    }

    public void setTotalPriceTaxExcl(BigDecimal totalPriceTaxExcl) {
        this.totalPriceTaxExcl = totalPriceTaxExcl;
    }

    @Override
    public String toString() {
        return "OrderDetail{" + "idOrderDetail=" + idOrderDetail + ", idOrder=" + idOrder + ", idOrderInvoice=" + idOrderInvoice + ", productName=" + productName + ", productPrice=" + productPrice + ", productQuantity=" + productQuantity + ", totalPriceTaxIncl=" + totalPriceTaxIncl + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.idOrderDetail;
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
        final OrderDetail other = (OrderDetail) obj;
        if (this.idOrderDetail != other.idOrderDetail) {
            return false;
        }
        return true;
    }
    
    
    
    
}
