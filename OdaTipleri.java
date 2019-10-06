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
public class OdaTipleri {
    
    
   private int Tipid;
   private String odaTipi;
   private double odaFiyati;

    public OdaTipleri(int Tipid, String odaTipi, double odaFiyati) {
        this.Tipid = Tipid;
        this.odaTipi = odaTipi;
        this.odaFiyati = odaFiyati;
    }
    
      public OdaTipleri(int Tipid, String odaTipi) {
        this.Tipid = Tipid;
        this.odaTipi = odaTipi;
    }

    public int getTipid() {
        return Tipid;
    }

    public void setTipid(int Tipid) {
        this.Tipid = Tipid;
    }

    public String getOdaTipi() {
        return odaTipi;
    }

    public void setOdaTipi(String odaTipi) {
        this.odaTipi = odaTipi;
    }

    public double getOdaFiyati() {
        return odaFiyati;
    }

    public void setOdaFiyati(double odaFiyati) {
        this.odaFiyati = odaFiyati;
    }
   
   
   
   
    
}
