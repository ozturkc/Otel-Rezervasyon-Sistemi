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
public class OdaServisi {
    
    private int odaServisi_id;
    private String urun_adi;
    private double urun_fiyati;
    private int  tur;

    public OdaServisi(int odaServisi_id, String urun_adi, double urun_fiyati, int tur) {
        this.odaServisi_id = odaServisi_id;
        this.urun_adi = urun_adi;
        this.urun_fiyati = urun_fiyati;
        this.tur = tur;
    }
    
      public OdaServisi(String urun_adi, double urun_fiyati, int tur) {
        this.urun_adi = urun_adi;
        this.urun_fiyati = urun_fiyati;
        this.tur = tur;
    }

    public int getOdaServisi_id() {
        return odaServisi_id;
    }

    public void setOdaServisi_id(int odaServisi_id) {
        this.odaServisi_id = odaServisi_id;
    }

    public String getUrun_adi() {
        return urun_adi;
    }

    public void setUrun_adi(String urun_adi) {
        this.urun_adi = urun_adi;
    }

    public double getUrun_fiyati() {
        return urun_fiyati;
    }

    public void setUrun_fiyati(double urun_fiyati) {
        this.urun_fiyati = urun_fiyati;
    }

    public int getTur() {
        return tur;
    }

    public void setTur(int tur) {
        this.tur = tur;
    }
    
    
    
}
