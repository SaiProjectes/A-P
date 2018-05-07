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
@Table(name="ps_specific_price_rule_condition_group")
public class SpecificPriceRuleConditionGroup implements Serializable {
    @Id
    @Column(name="id_specific_price_rule_condition_group")
    private int idSpecificPriceRuleConditionGroup;
    @Column(name="id_specific_price_rule")
    private int idSpecificPriceRule;
    
    protected SpecificPriceRuleConditionGroup() {}

    public SpecificPriceRuleConditionGroup(int idSpecificPriceRuleConditionGroup, int idSpecificPriceRule) {
        this.idSpecificPriceRuleConditionGroup = idSpecificPriceRuleConditionGroup;
        this.idSpecificPriceRule = idSpecificPriceRule;
    }

    public int getIdSpecificPriceRuleConditionGroup() {
        return idSpecificPriceRuleConditionGroup;
    }

    public int getIdSpecificPriceRule() {
        return idSpecificPriceRule;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.idSpecificPriceRuleConditionGroup;
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
        final SpecificPriceRuleConditionGroup other = (SpecificPriceRuleConditionGroup) obj;
        if (this.idSpecificPriceRuleConditionGroup != other.idSpecificPriceRuleConditionGroup) {
            return false;
        }
        return true;
    }
    
    
}
