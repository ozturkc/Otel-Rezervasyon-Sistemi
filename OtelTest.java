/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otelrezervasyonu;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static otelrezervasyonu.DbConnect.dbBaglanti;

/**
 *
 * @author developer
 */
public class OtelTest {
    
    
    
    
    public static int odaServisi(double tutar,int Rezervasyon_id,int[] odaServisi_id){
        
      return Rezervasyon.yiyecekIcecekGonder(tutar,Rezervasyon_id,odaServisi_id);
        
    }
    
    
     public  static  int musteriIslemleriYap(String sorgu1 ,String sorgu2){
         
         //Müşteri ekleme ve güncelleme işlemleri 2 sorgu cümlesi geliyor 
         //1 i musteriler için diğeri aktif musteriler için
         
        int sonuc=0;
         ArrayList<Musteri> musteriler=new ArrayList<Musteri>(); 
         //kutulardaki müşteri bilgilerini alıp musteriler arrayliste  ekleme
        musteriler.add(new Musteri(MusteriIslemler.txtMusteriAdi.getText(),MusteriIslemler.txtMusteriSoyadi.getText(),Integer.parseInt(MusteriIslemler.txtYas.getText()),MusteriIslemler.txtMeslek.getText(),MusteriIslemler.txtTC.getText(),MusteriIslemler.txtTelefon.getText()   ));
        PreparedStatement pState=null;
        ResultSet rs=null;
          try{
              
            pState=dbBaglanti().prepareStatement(sorgu1);
            pState.setString(1,musteriler.get(0).getAd());
            pState.setString(2,musteriler.get(0).getSoyad());
            pState.setInt(3 ,musteriler.get(0).getYas());
            pState.setString(4, musteriler.get(0).getTc());
            pState.setString(5, musteriler.get(0).getTel());
            pState.setString(6, musteriler.get(0).getMeslegi());
            sonuc=pState.executeUpdate();
             
            pState=dbBaglanti().prepareStatement(sorgu2);
            pState.setString(1,musteriler.get(0).getAd());
            pState.setString(2,musteriler.get(0).getSoyad());
            pState.setInt(3 ,musteriler.get(0).getYas());
            pState.setString(4, musteriler.get(0).getTc());
            pState.setString(5, musteriler.get(0).getTel());
            pState.setString(6, musteriler.get(0).getMeslegi());
            sonuc= pState.executeUpdate();
              
                                         DbConnect.dbBaglanti().close();

                
          }catch(Exception e){
              
         
           JOptionPane.showMessageDialog(null, e);
       }
          return sonuc;
        
    } 
     
     
    
}
