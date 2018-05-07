/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sai.persistence.Category;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author PROGRAMACIO3
 */
@Entity
@Table (name="ps_category")
public class Category implements Serializable {
    @Id
    @Column (name="id_category")
    private int idCategory;
    @Column (name="id_parent")
    private int idParent;
    @Column (name="id_shop_default")
    private int idShopDefault;
    @Column (name="level_depth")
    private short levelDepth;
    @Column (name="nleft")
    private int nleft;
    @Column (name="nright")
    private int nright;
    @Column (name="active")
    private short active;
    @Column (name="date_add")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateAdd;
    @Column (name="date_upd")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateUpd;
    @Column (name="position")
    private int position;
    @Column (name="is_root_category")
    private short isRootCategory;
    
    
    protected Category () {}
                    //values (null,2,1,2,23,24,1,'2017-05-02','2017-05-02',0,0); 
    public Category(int idCategory, int idParent, short levelDepth, short active, int position, short isRootCategory) {
        this.idCategory = idCategory;
        this.idParent = idParent;
        this.levelDepth = levelDepth;
        this.active = active;
        this.position = position;
        this.isRootCategory = isRootCategory;
        completaCamps();
    }

    private void completaCamps() {
        this.idShopDefault = 1;
        this.nleft = 25;
        this.nright = 26;
        this.dateAdd = new Date();
        this.dateUpd = new Date();
        
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public int getIdParent() {
        return idParent;
    }

    public void setIdParent(int idParent) {
        this.idParent = idParent;
    }

    public int getIdShopDefault() {
        return idShopDefault;
    }

    public void setIdShopDefault(int idShopDefault) {
        this.idShopDefault = idShopDefault;
    }

    public short getLevelDepth() {
        return levelDepth;
    }

    public void setLevelDepth(short levelDepth) {
        this.levelDepth = levelDepth;
    }

    public int getNleft() {
        return nleft;
    }

    public void setNleft(int nleft) {
        this.nleft = nleft;
    }

    public int getNright() {
        return nright;
    }

    public void setNright(int nright) {
        this.nright = nright;
    }

    public short getActive() {
        return active;
    }

    public void setActive(short active) {
        this.active = active;
    }

    public Date getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(Date dateAdd) {
        this.dateAdd = dateAdd;
    }

    public Date getDateUpd() {
        return dateUpd;
    }

    public void setDateUpd(Date dateUpd) {
        this.dateUpd = dateUpd;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public short getIsRootCategory() {
        return isRootCategory;
    }

    public void setIsRootCategory(short isRootCategory) {
        this.isRootCategory = isRootCategory;
    }

    @Override
    public String toString() {
        return "Category{" + "idCategory=" + idCategory + ", idParent=" + idParent + ", idShopDefault=" + idShopDefault + ", levelDepth=" + levelDepth + ", nleft=" + nleft + ", nright=" + nright + ", active=" + active + ", dateAdd=" + dateAdd + ", dateUpd=" + dateUpd + ", position=" + position + ", isRootCategory=" + isRootCategory + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.idCategory;
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
        final Category other = (Category) obj;
        if (this.idCategory != other.idCategory) {
            return false;
        }
        return true;
    }
    
    
    
    
    
    
}
