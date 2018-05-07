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
@Table(name="ps_image_shop")
public class ImageShop implements Serializable {
    @Column(name="id_product")
    private int idProduct;
    @Id
    @Column(name="id_image")
    private int idImage;
    @Id
    @Column(name="id_shop")
    private int idShop;
    @Column(name="cover")
    private short cover;
    
    protected ImageShop () {}

    public ImageShop(int idProduct, int idImage, int idShop, short cover) {
        this.idProduct = idProduct;
        this.idImage = idImage;
        this.idShop = idShop;
        this.cover = cover;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + this.idImage;
        hash = 43 * hash + this.idShop;
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
        final ImageShop other = (ImageShop) obj;
        if (this.idImage != other.idImage) {
            return false;
        }
        if (this.idShop != other.idShop) {
            return false;
        }
        return true;
    }

    

    
    
    
    
    
    
}
