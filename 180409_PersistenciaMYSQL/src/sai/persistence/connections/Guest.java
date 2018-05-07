/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sai.persistence.connections;

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
@Table(name="ps_guest")
public class Guest implements Serializable {
    @Id
    @Column(name="id_guest")
    private int idGuest;
    @Column(name="id_operating_system")
    private int idOperatingSystem;
    @Column(name="id_web_browser")
    private int idWebBrowser;
    @Column(name="id_customer")
    private int idCustomer;
    @Column(name="javascript")
    private short javascript;
    @Column(name="screen_resolution_x")
    private short screenResolutionX;
    @Column(name="screen_resolution_y")
    private short screenResolutionY;
    @Column(name="screen_color")
    private short screenColor;
    @Column(name="sun_java")
    private short sunJava;
    @Column(name="adobe_flash")
    private short adobeFlash;
    @Column(name="adobe_director")
    private short adobeDirector;
    @Column(name="apple_quicktime")
    private short appleQuicktime;
    @Column(name="real_player")
    private short realPlayer;
    @Column(name="windows_media")
    private short windowsMedia;
    @Column(name="accept_language")
    private String acceptLanguage;
    @Column(name="mobile_theme")
    private short mobileTheme;
    
    protected Guest () {}

    public Guest(int idGuest, int idOperatingSystem, int idWebBrowser, int idCustomer, short javascript, short screenResolutionX, short screenResolutionY, short screenColor, short sunJava, short adobeFlash, short adobeDirector, short appleQuicktime, short realPlayer, short windowsMedia, String acceptLanguage, short mobileTheme) {
        this.idGuest = idGuest;
        this.idOperatingSystem = idOperatingSystem;
        this.idWebBrowser = idWebBrowser;
        this.idCustomer = idCustomer;
        this.javascript = javascript;
        this.screenResolutionX = screenResolutionX;
        this.screenResolutionY = screenResolutionY;
        this.screenColor = screenColor;
        this.sunJava = sunJava;
        this.adobeFlash = adobeFlash;
        this.adobeDirector = adobeDirector;
        this.appleQuicktime = appleQuicktime;
        this.realPlayer = realPlayer;
        this.windowsMedia = windowsMedia;
        this.acceptLanguage = acceptLanguage;
        this.mobileTheme = mobileTheme;
    }

    public int getIdGuest() {
        return idGuest;
    }

    public int getIdOperatingSystem() {
        return idOperatingSystem;
    }

    public int getIdWebBrowser() {
        return idWebBrowser;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public short getJavascript() {
        return javascript;
    }

    public short getScreenResolutionX() {
        return screenResolutionX;
    }

    public short getScreenResolutionY() {
        return screenResolutionY;
    }

    public short getScreenColor() {
        return screenColor;
    }

    public short getSunJava() {
        return sunJava;
    }

    public short getAdobeFlash() {
        return adobeFlash;
    }

    public short getAdobeDirector() {
        return adobeDirector;
    }

    public short getAppleQuicktime() {
        return appleQuicktime;
    }

    public short getRealPlayer() {
        return realPlayer;
    }

    public short getWindowsMedia() {
        return windowsMedia;
    }

    public String getAcceptLanguage() {
        return acceptLanguage;
    }

    public short getMobileTheme() {
        return mobileTheme;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.idGuest;
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
        final Guest other = (Guest) obj;
        if (this.idGuest != other.idGuest) {
            return false;
        }
        return true;
    }
    
    
}
