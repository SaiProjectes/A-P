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
@Table(name="ps_image_lang")
public class ImageLang implements Serializable {
    @Id
    @Column(name="id_image")
    private int idImage;
    @Id
    @Column(name="id_lang")
    private int idLang;
    @Column(name="legend")
    private String legend;
    
    protected ImageLang () {}

    public ImageLang(int idImage, int idLang, String legend) {
        this.idImage = idImage;
        this.idLang = idLang;
        this.legend = legend;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.idImage;
        hash = 79 * hash + this.idLang;
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
        final ImageLang other = (ImageLang) obj;
        if (this.idImage != other.idImage) {
            return false;
        }
        if (this.idLang != other.idLang) {
            return false;
        }
        return true;
    }
    
    
}
