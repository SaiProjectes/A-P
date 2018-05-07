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
@Table(name="ps_order_state_lang")
public class OrderStateLang implements Serializable {
    @Id 
    @Column(name="id_order_state")
    private int idOrderState;
    @Column(name="id_lang")
    private int idLang;
    @Column(name="name")
    private String name;
    @Column(name="template")
    private String template;
    
    protected OrderStateLang(){}

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + this.idOrderState;
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
        final OrderStateLang other = (OrderStateLang) obj;
        if (this.idOrderState != other.idOrderState) {
            return false;
        }
        return true;
    }
    
    
}
