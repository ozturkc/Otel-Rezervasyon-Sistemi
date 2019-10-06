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
public class Musteri {
    private int m_id;
    private  String ad;
    private String soyad;
    private int yas;
    private String meslegi;
    private String tc;
    private String tel;

        //veri kaydetmek, guncellemek için
    public Musteri(String ad, String soyad, int yas, String meslegi, String tc, String tel) {
        this.ad = ad;
        this.soyad = soyad;
        this.yas = yas;
        this.meslegi = meslegi;
        this.tc = tc;
        this.tel = tel;
    }
    //göstermek için
       public Musteri(int m_id, String ad, String soyad, int yas, String meslegi, String tc, String tel) {
       this.m_id=m_id;
         this.ad = ad;
        this.soyad = soyad;
        this.yas = yas;
        this.meslegi = meslegi;
        this.tc = tc;
        this.tel = tel;
    }
       

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public int getYas() {
        return yas;
    }

    public void setYas(int yas) {
        this.yas = yas;
    }

    public String getMeslegi() {
        return meslegi;
    }

    public void setMeslegi(String meslegi) {
        this.meslegi = meslegi;
    }

    public String getTc() {
        return tc;
    }

    public void setTc(String tc) {
        this.tc = tc;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getM_id() {
        return m_id;
    }

    public void setM_id(int m_id) {
        this.m_id = m_id;
    }
    
    
    
  
    
}
