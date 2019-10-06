/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otelrezervasyonu;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static otelrezervasyonu.DbConnect.dbBaglanti;
import static otelrezervasyonu.MusterilerSayfasi.tblTumMusteriler;

/**
 *
 * @author developer
 */
public class Otel {
   
    private String adres;
    private String sahibi;
    private int yildizSayisi;
    private static ArrayList<Oda> otelOdalari;

    public Otel(String adres, String sahibi, int yildizSayisi) {
        this.adres = adres;
        this.sahibi = sahibi;
        this.yildizSayisi = yildizSayisi;
          otelOdalari=new ArrayList<>();

    }
    
    public Otel(){
         otelOdalari=new ArrayList<>();
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getSahibi() {
        return sahibi;
    }

    public void setSahibi(String sahibi) {
        this.sahibi = sahibi;
    }

    public int getYildizSayisi() {
        return yildizSayisi;
    }

    public void setYildizSayisi(int yildizSayisi) {
        this.yildizSayisi = yildizSayisi;
    }

    public ArrayList<Oda> getotelOdalari() {
        return  otelOdalari;
    }

        public void setotelOdalari(ArrayList<Oda>  otelOdalari) {
        this. otelOdalari =  otelOdalari;
    }
        
        
        
        public static void  otelOdalariListele(String sorgu){
            //oteldebulunan odaları listeleme işlemi
        Statement state=null;
        ResultSet rs=null;
        try{
            state=dbBaglanti().createStatement();
            rs=state.executeQuery(sorgu);
            
            while(rs.next()){
                int odaId=rs.getInt("oda_id");
                String odaNo=rs.getString("oda_numarasi");
                String odaTipi=rs.getString("odaTipi");     
                String ozellik=rs.getString("oda_ozellikleri");
                double fiyat=rs.getDouble("oda_fiyati");
                boolean durum=rs.getBoolean("odaDurumu");
                
                otelOdalari.add(new Oda(odaId,odaNo,odaTipi,ozellik,fiyat,durum));
            }
                    
           DbConnect.dbBaglanti().close();

             
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, e);
       }
        }

    
        
  
        
        
    public  static void display(){
        //otelde kalan musteriler
          DefaultTableModel model;
        try{
             model=(DefaultTableModel)OtelBilgileri.tblOteldekiler.getModel();
                 model.setRowCount(0);  
            Statement state=null;
            ResultSet rs=null;
            //anlık olarak otelde kalan müşterilerin adı soyadı ve kaldıkları odanın numarası
            String sorgu="select musteriler.musteri_adi,musteriler.musteri_soyadi,otelOdalari.oda_numarasi from Rezervasyon JOIN musteriler on musteriler.musteri_id=Rezervasyon.musteri_id JOIN otelOdalari on otelOdalari.oda_id=Rezervasyon.oda_id ";
            state=DbConnect.dbBaglanti().createStatement();
            rs=state.executeQuery(sorgu);
            
            while(rs.next()){   
Object[] add={rs.getString("musteri_adi"),rs.getString("musteri_soyadi"),rs.getString("oda_numarasi")};
                  model.addRow(add);  
                OtelBilgileri.tblOteldekiler.setModel(model);            
            
            }
            
                                      DbConnect.dbBaglanti().close();

        }catch(Exception e){
            
        } 
    }

    
 public  static ArrayList<String> doluOdaMusteri(int odaid){
        //otelde kalan musteriler
                   ArrayList<String>MusteriListe=new ArrayList<String>();
        try{
            Statement state=null;
            ResultSet rs=null;
            //eğer oda dolu ise odada bulunan müşterinin adı ve soyadı
            String sorgu="select musteriler.musteri_adi,musteriler.musteri_soyadi,otelOdalari.oda_numarasi from Rezervasyon JOIN musteriler on musteriler.musteri_id=Rezervasyon.musteri_id JOIN otelOdalari on otelOdalari.oda_id=Rezervasyon.oda_id ";
            state=DbConnect.dbBaglanti().createStatement();
            rs=state.executeQuery(sorgu);
            while(rs.next()){
            System.out.println(rs.getString("musteri_adi"));
                MusteriListe.add(rs.getString("musteri_adi")+ " "+rs.getString("musteri_soyadi"));
                  
            }
            
            
        }catch(Exception e){
            
        } 
        return MusteriListe;
        
    }
    
 static ArrayList<Otel> otelBilgisi=new ArrayList<Otel>();
 public static void otelBilgileriGetir(){
     
     try{
         
         //otelin bilgilerini listeleme
            Statement state=null;
            ResultSet rs=null;
String sorgu="select * from Otel"; 
state=DbConnect.dbBaglanti().createStatement();
            rs=state.executeQuery(sorgu);
            while(rs.next()){
                    String sahibi=rs.getString("sahibi");
                    String adresi=rs.getString("adresi");
                     int ySayisi=rs.getInt("yildizSayisi");
                  otelBilgisi.add(new Otel(adresi,sahibi,ySayisi));
            }
            OtelBilgileri.txtOtelAdresi.setText(otelBilgisi.get(0).getAdres());
            OtelBilgileri.txtOtelSahibi.setText(otelBilgisi.get(0).getSahibi());
            OtelBilgileri.spYildizSayisi.setValue(otelBilgisi.get(0).getYildizSayisi());
            
            
            
        }catch(Exception e){
            
        } 
       
        
    }
     
public static int  otelBilgisiGuncelle(){
        
     int sonuc=0;
     otelBilgisi.clear();
        otelBilgisi.add(new Otel(OtelBilgileri.txtOtelAdresi.getText(),OtelBilgileri.txtOtelSahibi.getText(),Integer.parseInt(OtelBilgileri.spYildizSayisi.getValue()+"")));
        PreparedStatement pState=null;
        ResultSet rs=null;
        //gelen isteğe göre otelin bilgilerini güncelleme işlemi
        String sorgu="UPDATE Otel set adresi=?,sahibi=?,yildizSayisi=?";   //tek kayıt var where gerek yok
          try{
              
            pState=dbBaglanti().prepareStatement(sorgu);
            pState.setString(1,otelBilgisi.get(0).getAdres());
            pState.setString(2,otelBilgisi.get(0).getSahibi());
            pState.setInt(3 ,otelBilgisi.get(0).getYildizSayisi());
           sonuc= pState.executeUpdate();
           
               
                
          }catch(Exception e){
              
         
           JOptionPane.showMessageDialog(null, e);
       }
          return sonuc;
        
    }     


   
 }
    
    

