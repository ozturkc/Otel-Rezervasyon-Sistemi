/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otelrezervasyonu;

/**
 *
 * @author developer
 */
public class Admin {
    
    private String kul_adi;
    private String sifre;

    public Admin(String kul_adi, String sifre) {
        this.kul_adi = kul_adi;
        this.sifre = sifre;
    }

    public String getKul_adi() {
        return kul_adi;
    }

    public void setKul_adi(String kul_adi) {
        this.kul_adi = kul_adi;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }
    
    
    
}
