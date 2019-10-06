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
public class RezervasyonTipleri {
    
    private int rTipi_id;
    private String rTipi;
    private double rTipiFiyat;

    public RezervasyonTipleri(int rTipi_id, String rTipi, double rTipiFiyat) {
        this.rTipi_id = rTipi_id;
        this.rTipi = rTipi;
        this.rTipiFiyat = rTipiFiyat;
    }

    public int getrTipi_id() {
        return rTipi_id;
    }

    public void setrTipi_id(int rTipi_id) {
        this.rTipi_id = rTipi_id;
    }

    public String getrTipi() {
        return rTipi;
    }

    public void setrTipi(String rTipi) {
        this.rTipi = rTipi;
    }

    public double getrTipiFiyat() {
        return rTipiFiyat;
    }

    public void setrTipiFiyat(double rTipiFiyat) {
        this.rTipiFiyat = rTipiFiyat;
    }
    
    
    
}
