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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static otelrezervasyonu.DbConnect.dbBaglanti;
import static otelrezervasyonu.MusterilerSayfasi.musteriler;

/**
 *
 * @author developer
 */
public class Rezervasyon {
    
    private int  rezervasyonid;
    private int  rezervasyonTipi_id;
    private int oda_id;
    private int musteri_id;
    private int kisiSayisi;
    private double toplamFiyat;
    
    private String musteriAdi;
    private String musteriSoyadi;
    private String odaNumarasi;
    private String rezervasyonTipi;        

    public Rezervasyon(int rezervasyonTipi_id, int oda_id, int musteri_id, int kisiSayisi, double toplamFiyat) {
        this.rezervasyonTipi_id = rezervasyonTipi_id;
        this.oda_id = oda_id;
        this.musteri_id = musteri_id;
        this.kisiSayisi = kisiSayisi;
        this.toplamFiyat = toplamFiyat;
    }
    
   
    
       public Rezervasyon(int rezervasyonid,int rezervasyonTipi_id, int oda_id, int musteri_id, int kisiSayisi, double toplamFiyat) {
        this.rezervasyonid=this.rezervasyonid;
        this.rezervasyonTipi_id = rezervasyonTipi_id;
        this.oda_id = oda_id;
        this.musteri_id = musteri_id;
        this.kisiSayisi = kisiSayisi;
        this.toplamFiyat = toplamFiyat;
    }

    public Rezervasyon(int rezervasyonid, String musteriAdi,String musteriSoyadi, String odaNumarasi, String rezervasyonTipi,int kisiSayisi, double toplamFiyat ) {
        this.rezervasyonid = rezervasyonid;
        this.kisiSayisi = kisiSayisi;
        this.toplamFiyat = toplamFiyat;
        this.musteriAdi = musteriAdi;
        this.musteriSoyadi = musteriSoyadi;
        this.odaNumarasi = odaNumarasi;
        this.rezervasyonTipi = rezervasyonTipi;
    }
       
       
       
       

    public int getRezervasyonTipi_id() {
        return rezervasyonTipi_id;
    }

    public void setRezervasyonTipi_id(int rezervasyonTipi_id) {
        this.rezervasyonTipi_id = rezervasyonTipi_id;
    }

    public int getOda_id() {
        return oda_id;
    }

    public void setOda_id(int oda_id) {
        this.oda_id = oda_id;
    }

    public int getMusteri_id() {
        return musteri_id;
    }

    public void setMusteri_id(int musteri_id) {
        this.musteri_id = musteri_id;
    }

    public int getKisiSayisi() {
        return kisiSayisi;
    }

    public void setKisiSayisi(int kisiSayisi) {
        this.kisiSayisi = kisiSayisi;
    }

    public double getToplamFiyat() {
        return toplamFiyat;
    }

    public void setToplamFiyat(double toplamFiyat) {
        this.toplamFiyat = toplamFiyat;
    }

    public int getRezervasyonid() {
        return rezervasyonid;
    }

    public void setRezervasyonid(int rezervasyonid) {
        this.rezervasyonid = rezervasyonid;
    }

    public String getMusteriAdi() {
        return musteriAdi;
    }

    public void setMusteriAdi(String musteriAdi) {
        this.musteriAdi = musteriAdi;
    }

    public String getMusteriSoyadi() {
        return musteriSoyadi;
    }

    public void setMusteriSoyadi(String musteriSoyadi) {
        this.musteriSoyadi = musteriSoyadi;
    }

    public String getOdaNumarasi() {
        return odaNumarasi;
    }

    public void setOdaNumarasi(String odaNumarasi) {
        this.odaNumarasi = odaNumarasi;
    }

    public String getRezervasyonTipi() {
        return rezervasyonTipi;
    }

    public void setRezervasyonTipi(String rezervasyonTipi) {
        this.rezervasyonTipi = rezervasyonTipi;
    }
    
    
            
    //
    
   static ArrayList<Rezervasyon> rezervasyonlar=new ArrayList<Rezervasyon>();
    
    //
    
    
    
    
    public static void rezervasyonGoster(String sorgu){
         DefaultTableModel model;
         
        rezervasyonlar.clear();
        Statement state=null;
        ResultSet rs=null;
         model=(DefaultTableModel)RezervasyonlarSayfasi.tblRezervasyonlar.getModel();
                 model.setRowCount(0);        
       try{
            state=dbBaglanti().createStatement();
            rs=state.executeQuery(sorgu);
            
            while(rs.next()){
                int r_id=rs.getInt("rezervasyon_id");
                String m_adi=rs.getString("musteri_adi");
                String m_soyadi=rs.getString("musteri_soyadi");
               String oda_no=rs.getString("oda_numarasi");
                String rTipi=rs.getString("RezervasyonTipi");
                int kisiSayisi  =rs.getInt("kisiSayisi");
                double tutar=rs.getDouble("toplamFiyat");
                
                rezervasyonlar.add(new Rezervasyon(r_id,m_adi,m_soyadi,oda_no,rTipi,kisiSayisi,tutar));
            }
                                      DbConnect.dbBaglanti().close();

             if(rezervasyonlar!=null){                    
                    for(Rezervasyon rezervasyon:rezervasyonlar){       
                        
                        Object[] add={rezervasyon.musteriAdi,rezervasyon.musteriSoyadi,rezervasyon.odaNumarasi,rezervasyon.rezervasyonTipi,rezervasyon.kisiSayisi,rezervasyon.toplamFiyat};
                                            model.addRow(add);                  
                    }
             }
                              RezervasyonlarSayfasi.tblRezervasyonlar.setModel(model);             
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, e);
       }
      
        
    }
            
    
    public static  void rezervasyonTipiGetir(){
         String sorgu="select * from RezervasyonTipleri";
        Statement state=null;
       ResultSet rs=null;
        DefaultComboBoxModel model;
        try{
           state=DbConnect.dbBaglanti().createStatement();
          rs=state.executeQuery(sorgu);
          
             while(rs.next()){
                int rTipId=rs.getInt("RTipleri_id");
                String rTipi=rs.getString("RezervasyonTipi");
                double rTipiFiyati=rs.getDouble("RezervasyonTipiFiyati");
               RezervasyonYap.rTipleri.add(new RezervasyonTipleri(rTipId,rTipi,rTipiFiyati));
                 RezervasyonYap.cmbRezervasyonTİpi.addItem(rTipi);
             }  //while finish
                                       DbConnect.dbBaglanti().close();

            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    
    
    
    public static double toplamTutarHesapla(double odaTipiFiyat,double rTipiFiyat,int toplamGun){
        

        return  ((odaTipiFiyat+rTipiFiyat) /2)*toplamGun;
    }
    
    
      public  static  int rezarvasyonIslemleriYap(String sorgu1){
        int sonuc=0;
         ArrayList<Rezervasyon> rezervasyon=new ArrayList<Rezervasyon>(); 
        rezervasyon.add(new Rezervasyon(RezervasyonYap.rTipleri.get(RezervasyonYap.cmbRezervasyonTİpi.getSelectedIndex()-1).getrTipi_id(),RezervasyonYap.o_id,RezervasyonYap.m_id ,Integer.parseInt(""+RezervasyonYap.spKisiSayisi.getValue()),Double.parseDouble(RezervasyonYap.lblToplamTutar.getText()) ));
        PreparedStatement pState=null;
        ResultSet rs=null;
          try{
              
            pState=dbBaglanti().prepareStatement(sorgu1);
            pState.setInt(1,rezervasyon.get(0).getRezervasyonTipi_id());
            pState.setInt(2,rezervasyon.get(0).getOda_id());
            pState.setInt(3,rezervasyon.get(0).getMusteri_id());
            pState.setInt(4,rezervasyon.get(0).getKisiSayisi());
            pState.setDouble(5,rezervasyon.get(0).getToplamFiyat());

        

            sonuc=pState.executeUpdate();
             
        if(sonuc==1){
            String sorgu="update aktifotelOdalari set odaDurumu=0  where oda_id=? ";
            pState=dbBaglanti().prepareStatement(sorgu); 
            pState.setInt(1, rezervasyon.get(0).getOda_id());
            pState.executeUpdate();
            sorgu="update otelOdalari set odaDurumu=0 where oda_id=? ";
             pState=dbBaglanti().prepareStatement(sorgu);      
                         pState.setInt(1, rezervasyon.get(0).getOda_id());

            pState.executeUpdate();

            
        } 
              
                                         DbConnect.dbBaglanti().close();

                
          }catch(Exception e){
              
         
           JOptionPane.showMessageDialog(null, e);
       }
          return sonuc;
        
    } 
      
      
      public static int yiyecekIcecekGonder(double tutar,int Rezervasyon_id,int[] odaServisi_id){
          
          //rezervasyon toplam tutar 
          //mevcut rezervasyon id sinin toplam tutarına gelen tutarı ekle
          //rezervasyonodaservisi tablosuna  r_id , servis_id servis tutari
          int sonuc=0;   
          try{
                  String sorgu="";
                     PreparedStatement pState=null;
               ResultSet rs=null;
          for (int i = 0; i <odaServisi_id.length; i++) {
            
              sorgu="insert into RezervasyonOdaServisi(rezervasyon_id,odaServisi_id) VALUES(?,?) ";
            
              System.out.println("=========="+odaServisi_id[i]);
              // yiyecek içecekleri kaydettik
            pState=dbBaglanti().prepareStatement(sorgu);
            pState.setInt(1,Rezervasyon_id );
            pState.setInt(2,odaServisi_id[i]);
           pState.executeUpdate();
            
           
          } // for finish 
          
          //fiyat guncelleme
                   sorgu="select Rezervasyon.rezervasyon_id,musteriler.musteri_adi,musteriler.musteri_soyadi,otelOdalari.oda_numarasi,RezervasyonTipleri.RezervasyonTipi, Rezervasyon.kisiSayisi,Rezervasyon.toplamFiyat FROM Rezervasyon JOIN musteriler on musteriler.musteri_id=Rezervasyon.musteri_id JOIN otelOdalari on otelOdalari.oda_id=Rezervasyon.oda_id JOIN RezervasyonTipleri on  RezervasyonTipleri.RTipleri_id=Rezervasyon.RezervasyonTipi_id  where  rezervasyon_id="+Rezervasyon_id+" ";

              rezervasyonGoster(sorgu);
              tutar+=rezervasyonlar.get(0).getToplamFiyat();
          sorgu="UPDATE Rezervasyon set toplamFiyat=? where rezervasyon_id=? ";
            pState=dbBaglanti().prepareStatement(sorgu);
            pState.setDouble(1,tutar );
            pState.setInt(2,Rezervasyon_id);
           sonuc=pState.executeUpdate();
                
          }catch(Exception e){
              
         
           JOptionPane.showMessageDialog(null, e);
       }        
  
              return sonuc;
          }
          
                  
      public static double exit(int Rezervasyon_id){
          
             DefaultTableModel model;
         String sorgu="select Rezervasyon.RezervasyonTipi_id,Rezervasyon.oda_id,Rezervasyon.musteri_id,Rezervasyon.kisiSayisi,Rezervasyon.toplamFiyat from Rezervasyon where rezervasyon_id="+Rezervasyon_id+"";
        rezervasyonlar.clear();
        Statement state=null;
        PreparedStatement pState=null;
        ResultSet rs=null;
        int sonuc=0;
       try{
            state=dbBaglanti().createStatement();
            rs=state.executeQuery(sorgu);
            
            while(rs.next()){
                int rTip_id=rs.getInt("RezervasyonTipi_id");
                int oda_id=rs.getInt("oda_id");
                int musteri_id=rs.getInt("musteri_id");
               int kisiSayisi=rs.getInt("kisiSayisi");
                double toplamFiyat=rs.getDouble("toplamFiyat");
                
                rezervasyonlar.add(new Rezervasyon(rTip_id,oda_id,musteri_id,kisiSayisi,toplamFiyat));
            }
             
            sorgu="insert into gecmisRezervasyonlar(RezervasyonTipi_id,oda_id,musteri_id,kisiSayisi,toplamFiyat) VALUES(?,?,?,?,?)";
            
            pState=dbBaglanti().prepareStatement(sorgu);
            pState.setInt(1,rezervasyonlar.get(0).getRezervasyonTipi_id());
            pState.setInt(2,rezervasyonlar.get(0).getOda_id());
            pState.setInt(3,rezervasyonlar.get(0).getMusteri_id());
            pState.setInt(4,rezervasyonlar.get(0).getKisiSayisi());
            pState.setDouble(5,rezervasyonlar.get(0).getToplamFiyat());
           sonuc= pState.executeUpdate();
           
            if(sonuc==1){
            sorgu="delete  from Rezervasyon where rezervasyon_id=? "   ;
              pState=dbBaglanti().prepareStatement(sorgu);
            pState.setInt(1,Rezervasyon_id);
             sonuc= pState.executeUpdate();
             sorgu="update aktifotelOdalari set odaDurumu=1 where oda_id=?";
               pState=dbBaglanti().prepareStatement(sorgu);
            pState.setInt(1,rezervasyonlar.get(0).getOda_id());
             sonuc= pState.executeUpdate();
            }
            
             
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, e);
       }
      
          
          
          return rezervasyonlar.get(0).getToplamFiyat();
      }
          
          
          
      }
    

