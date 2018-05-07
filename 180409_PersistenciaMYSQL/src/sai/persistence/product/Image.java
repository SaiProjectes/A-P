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
 * @author programacio3
 */
@Entity
@Table(name="ps_image")
public class Image implements Serializable {
    @Id
    @Column(name="id_image")
    private int idImage;
    @Column(name="id_product")
    private int idProduct;
    @Column(name="position")
    private short position;
    @Column(name="cover")
    private short cover;
    
    protected Image (){}

    public Image(int idImage, int idProduct, short position, short cover) {
        this.idImage = idImage;
        this.idProduct = idProduct;
        this.position = position;
        this.cover = cover;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.idProduct;
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
        final Image other = (Image) obj;
        if (this.idProduct != other.idProduct) {
            return false;
        }
        return true;
    }
    
    
    
}
