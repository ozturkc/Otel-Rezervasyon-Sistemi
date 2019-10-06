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
public class Oda {
    private int odaId;
    private String odaNumarasi;
    private String odaTipi;
    private String ozellikleri;
    private double fiyat;
    private boolean odaDurumu;
    private int odaTipiId;
    

    public Oda(int odaId, String odaNumarasi,String odaTipi, String ozellikleri, double fiyat,boolean odaDurumu) {
        this.odaId=odaId;
        this.odaNumarasi=odaNumarasi;
        this.odaTipi = odaTipi;
        this.ozellikleri = ozellikleri;
        this.fiyat = fiyat;
        this. odaDurumu=odaDurumu;
    }
      public Oda(int odaId, String odaNumarasi,int odaTipiId, String ozellikleri, double fiyat,boolean odaDurumu) {
        this.odaId=odaId;
        this.odaNumarasi=odaNumarasi;
        this.odaTipiId = odaTipiId;
        this.ozellikleri = ozellikleri;
        this.fiyat = fiyat;
        this. odaDurumu=odaDurumu;
    }
    
      public Oda(String odaNumarasi,int odaTipiId, String ozellikleri, double fiyat) {
        this.odaNumarasi=odaNumarasi;
        this.odaTipiId = odaTipiId;
        this.ozellikleri = ozellikleri;
        this.fiyat = fiyat;
        this. odaDurumu=true;
    }

    public int getOdaId() {
        return odaId;
    }

    public void setOdaId(int odaId) {
        this.odaId = odaId;
    }

    public String getOdaNumarasi() {
        return odaNumarasi;
    }

    public void setOdaNumarasi(String odaNumarasi) {
        this.odaNumarasi = odaNumarasi;
    }
     

    public String getOdaTipi() {
        return odaTipi;
    }

    public void setOdaTipi(String odaTipi) {
        this.odaTipi = odaTipi;
    }

    public String getOzellikleri() {
        return ozellikleri;
    }

    public void setOzellikleri(String ozellikleri) {
        this.ozellikleri = ozellikleri;
    }

    public double getFiyat() {
        return fiyat;
    }

    public void setFiyat(double fiyat) {
        this.fiyat = fiyat;
    }
    
    public boolean getOdaDurumu(){
        return odaDurumu;
    }
    public void setOdaDurumu(boolean odaDurumu){
        this.odaDurumu=odaDurumu;
    }

    public int getOdaTipiId() {
        return odaTipiId;
    }

    public void setOdaTipiId(int odaTipiId) {
        this.odaTipiId = odaTipiId;
    }
    
   
    
    
    
}
