/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sai.persistence.descomptes;

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
@Table(name="ps_specific_price_rule_condition")
public class SpecificPriceRuleCondition implements Serializable {
    @Id
    @Column(name="id_specific_price_rule_condition")
    private int idSpecificPriceRuleCondition;
    @Column(name="id_specific_price_rule_condition_group")
    private int idSpecificPriceRuleConditionGroup;
    @Column(name="type")
    private String type;
    @Column(name="value")
    private String value;
    
    protected SpecificPriceRuleCondition () {}

    public SpecificPriceRuleCondition(int idSpecificPriceRuleCondition, int idSpecificPriceRuleConditionGroup, String type, String value) {
        this.idSpecificPriceRuleCondition = idSpecificPriceRuleCondition;
        this.idSpecificPriceRuleConditionGroup = idSpecificPriceRuleConditionGroup;
        this.type = type;
        this.value = value;
    }

    public int getIdSpecificPriceRuleCondition() {
        return idSpecificPriceRuleCondition;
    }

    public int getIdSpecificPriceRuleConditionGroup() {
        return idSpecificPriceRuleConditionGroup;
    }

    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.idSpecificPriceRuleCondition;
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
        final SpecificPriceRuleCondition other = (SpecificPriceRuleCondition) obj;
        if (this.idSpecificPriceRuleCondition != other.idSpecificPriceRuleCondition) {
            return false;
        }
        return true;
    }
    
    
    
    
}
