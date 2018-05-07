/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sai.persistence.order;

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
@Table(name="ps_order_state")
public class OrderState implements Serializable {
    @Id
    @Column(name="id_order_state")
    private int idOrderState;
    @Column(name="invoice")
    private short invoice;
    @Column(name="send_email")
    private short sendEmail;
    @Column(name="module_name")
    private String moduleName;
    @Column(name="color")
    private String color;
    @Column(name="unremovable")
    private short unremovable;
    @Column(name="hidden")
    private short hidden;
    @Column(name="logable")
    private short logable;
    @Column(name="delivery")
    private short delivery;
    @Column(name="shipped")
    private short shipped;
    @Column(name="paid")
    private short paid;
    @Column(name="deleted")
    private short deleted;
    
    protected OrderState(){}

    public OrderState(int idOrderState, short invoice, short sendEmail, String moduleName, String color, short unremovable, short hidden, short logable, short delivery, short shipped, short paid, short deleted) {
        this.idOrderState = idOrderState;
        this.invoice = invoice;
        this.sendEmail = sendEmail;
        this.moduleName = moduleName;
        this.color = color;
        this.unremovable = unremovable;
        this.hidden = hidden;
        this.logable = logable;
        this.delivery = delivery;
        this.shipped = shipped;
        this.paid = paid;
        this.deleted = deleted;
    }

    public int getIdOrderState() {
        return idOrderState;
    }

    public void setIdOrderState(int idOrderState) {
        this.idOrderState = idOrderState;
    }

    public short getInvoice() {
        return invoice;
    }

    public void setInvoice(short invoice) {
        this.invoice = invoice;
    }

    public short getSendEmail() {
        return sendEmail;
    }

    public void setSendEmail(short sendEmail) {
        this.sendEmail = sendEmail;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public short getUnremovable() {
        return unremovable;
    }

    public void setUnremovable(short unremovable) {
        this.unremovable = unremovable;
    }

    public short getHidden() {
        return hidden;
    }

    public void setHidden(short hidden) {
        this.hidden = hidden;
    }

    public short getLogable() {
        return logable;
    }

    public void setLogable(short logable) {
        this.logable = logable;
    }

    public short getDelivery() {
        return delivery;
    }

    public void setDelivery(short delivery) {
        this.delivery = delivery;
    }

    public short getShipped() {
        return shipped;
    }

    public void setShipped(short shipped) {
        this.shipped = shipped;
    }

    public short getPaid() {
        return paid;
    }

    public void setPaid(short paid) {
        this.paid = paid;
    }

    public short getDeleted() {
        return deleted;
    }

    public void setDeleted(short deleted) {
        this.deleted = deleted;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.idOrderState;
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
        final OrderState other = (OrderState) obj;
        if (this.idOrderState != other.idOrderState) {
            return false;
        }
        return true;
    }
    
    
    
}
