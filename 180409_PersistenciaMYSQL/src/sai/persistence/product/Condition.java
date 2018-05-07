/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sai.persistence.product;

/**
 *
 * @author PROGRAMACIO3
 */
public enum Condition {
    NEW("new"), 
    USED("used"),
    REFURBISHED("refurbished");

    private String label;

    private Condition(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
