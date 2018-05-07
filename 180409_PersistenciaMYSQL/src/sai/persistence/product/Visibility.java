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
public enum Visibility {
    BOTH("both"), 
    CATALOG("catalog"), 
    SEARCH("search"), 
    NONE("none");
    

    private String label;

    private Visibility(String labe) {
        this.label = labe;
    }

    public String getLabel() {
        return label;
    }
}
