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
public enum RedirectType {
   
    FOF("404"), 
    PRODUCT1("301-product"), 
    PRODUCT2("302-product"), 
    CATEGORY1("301-category"),
    CATEGORY2("302-category");
    

    private String label;

    private RedirectType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

}
