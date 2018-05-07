/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sai.persistence.connections;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author PROGRAMACIO3
 */
@Entity
@Table(name="ps_connections")
public class Connections implements Serializable {
    @Id
    @Column(name="id_connections")
    private int idConnections;
    @Column(name="id_shop_group")
    private int idShopGroup;
    @Column(name="id_shop")
    private int idShop;
    @Column(name="id_guest")
    private int idGuest;
    @Column(name="id_page")
    private int idPage;
    @Column(name="ip_address")
    private int ipAddress;
    @Column(name="date_add")
    private Date dateAdd;
    @Column(name="http_referer")
    private String httpReferer;
    
    
    protected Connections() {}

    public Connections(int idConnections, int idShopGroup, int idShop, int idGuest, int idPage, int ipAddress, Date dateAdd, String httpReferer) {
        this.idConnections = idConnections;
        this.idShopGroup = idShopGroup;
        this.idShop = idShop;
        this.idGuest = idGuest;
        this.idPage = idPage;
        this.ipAddress = ipAddress;
        this.dateAdd = dateAdd;
        this.httpReferer = httpReferer;
    }

    public int getIdConnections() {
        return idConnections;
    }

    public int getIdShopGroup() {
        return idShopGroup;
    }

    public int getIdShop() {
        return idShop;
    }

    public int getIdGuest() {
        return idGuest;
    }

    public int getIdPage() {
        return idPage;
    }

    public int getIpAddress() {
        return ipAddress;
    }

    public Date getDateAdd() {
        return dateAdd;
    }

    public String getHttpReferer() {
        return httpReferer;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.idConnections;
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
        final Connections other = (Connections) obj;
        if (this.idConnections != other.idConnections) {
            return false;
        }
        return true;
    }
    
    
}
