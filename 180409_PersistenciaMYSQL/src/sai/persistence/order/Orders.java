/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sai.persistence.order;

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
@Table (name="ps_orders")
public class Orders implements Serializable {
    @Id
    @Column(name="id_order") //
    private int idOrder;
    @Column(name="reference")//
    private String reference;
    @Column(name="id_carrier")//
    private int idCarrier;
    @Column(name="id_lang")//
    private int idLang;
    @Column(name="id_customer")//
    private int idCustomer;
    @Column(name="id_cart")
    private int idCart;
    @Column(name="id_currency")
    private int idCurrency;
    @Column(name="id_address_delivery")//
    private int idAddressDelivery;
    @Column(name="id_address_invoice")
    private int idAddressInvoice;
    @Column(name="current_state")
    private int currentState;
    @Column(name="payment")//
    private String payment;
//    @Column(name="invoice_date")
//    private Date invoiceDate;
//    @Column(name="delivery_date")
//    private Date deliveryDate;
    @Column(name="date_add")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateAdd;
    @Column(name="date_upd")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateUpd;
    @Column(name="total_paid")
    private BigDecimal totalPaid;
    @Column(name="total_products")
    private BigDecimal totalProducts;
    
    protected Orders(){}

    public Orders(int idOrder, String reference, int idCarrier, int idLang, int idCustomer, int idAddressDelivery, String payment) {
        this.idOrder = idOrder;
        this.reference = reference;
        this.idCarrier = idCarrier;
        this.idLang = idLang;
        this.idCustomer = idCustomer;
        this.idAddressDelivery = idAddressDelivery;
        this.payment = payment;
        omplirResta ();
        
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public int getIdCarrier() {
        return idCarrier;
    }

    public void setIdCarrier(int idCarrier) {
        this.idCarrier = idCarrier;
    }

    public int getIdLang() {
        return idLang;
    }

    public void setIdLang(int idLang) {
        this.idLang = idLang;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public BigDecimal getTotalPaid() {
        return totalPaid;
    }

    public void setTotalPaid(BigDecimal totalPaid) {
        this.totalPaid = totalPaid;
    }

    public BigDecimal getTotalProducts() {
        return totalProducts;
    }

    public void setTotalProducts(BigDecimal totalProducts) {
        this.totalProducts = totalProducts;
    }

    public int getIdCart() {
        return idCart;
    }

    public void setIdCart(int idCart) {
        this.idCart = idCart;
    }

    public int getIdCurrency() {
        return idCurrency;
    }

    public void setIdCurrency(int idCurrency) {
        this.idCurrency = idCurrency;
    }

    public int getIdAddressDelivery() {
        return idAddressDelivery;
    }

    public void setIdAddressDelivery(int idAddressDelivery) {
        this.idAddressDelivery = idAddressDelivery;
    }

    public int getIdAddressInvoice() {
        return idAddressInvoice;
    }

    public void setIdAddressInvoice(int idAddressInvoice) {
        this.idAddressInvoice = idAddressInvoice;
    }

    public int getCurrentState() {
        return currentState;
    }

    public void setCurrentState(int currentState) {
        this.currentState = currentState;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public Date getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(Date dateAdd) {
        this.dateAdd = dateAdd;
    }

    public Date getDateUpd() {
        return dateUpd;
    }

    public void setDateUpd(Date dateUpd) {
        this.dateUpd = dateUpd;
    }

    

    @Override
    public String toString() {
        return "Orders{" + "idOrder=" + idOrder + ", reference=" + reference + ", idCustomer=" + idCustomer + '}';
    }

    private void omplirResta() {
        Date now = new Date();
        this.idCart = 5;
        this.idCurrency = 1;
        this.idAddressInvoice = this.idAddressDelivery;
        this.currentState = 8;
        this.dateAdd = now;
        this.dateUpd = now;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.idOrder;
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
        final Orders other = (Orders) obj;
        if (this.idOrder != other.idOrder) {
            return false;
        }
        return true;
    }
    
    
    
    
    
    
    
    
    
    
    
}
