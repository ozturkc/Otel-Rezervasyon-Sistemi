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
import static otelrezervasyonu.DbConnect.dbBaglanti;

/**
 *
 * @author developer
 */
public class OdaIslemleri extends javax.swing.JFrame {

    public Anasayfa anasayfa;
    
    public int odaId;
    public String tip="";
    ArrayList<OdaTipleri> odaTipleri=new ArrayList<OdaTipleri>();
    
    
    
    
    
    /**
     * Creates new form OdaIslemleri
     */
    public OdaIslemleri() {
        initComponents();
         odaTipiGetir();
                txtOdaFiyati.setText(""+odaTipleri.get(0).getOdaFiyati());

      

    }
    
    
    
    
    
    private void odaTipiGetir(){
        String sorgu="select * from odaTipleri";
        Statement state=null;
       ResultSet rs=null;
        DefaultComboBoxModel model;
        try{
           state=DbConnect.dbBaglanti().createStatement();
          rs=state.executeQuery(sorgu);
          while(rs.next()){
                int tipId=rs.getInt("odaTipi_id");
                String odaTipi=rs.getString("odaTipi");
                double odaTipiFiyat=rs.getDouble("odaTipiFiyati");
                odaTipleri.add(new OdaTipleri(tipId,odaTipi,odaTipiFiyat));
                 cmbOdaTipi.addItem(odaTipi);
             }  //while finish
                                    DbConnect.dbBaglanti().close();

          if(!tip.equals("")){
                if(tip.equals(odaTipleri.get(0).getOdaTipi())){
              cmbOdaTipi.setSelectedIndex(0);
          }
          else if(tip.equals(odaTipleri.get(1).getOdaTipi())){
              cmbOdaTipi.setSelectedIndex(1);
                     
          }
          else if(tip.equals(odaTipleri.get(2).getOdaTipi())){
              cmbOdaTipi.setSelectedIndex(2);
                      
          }
               
          }
        
             tip="";
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    
    public  int odaIslemleriYap(String sorgu1 ,String sorgu2){
        int sonuc=0;
         ArrayList<Oda> odalar=new ArrayList<Oda>(); 
         int index=cmbOdaTipi.getSelectedIndex();
         int oTip=odaTipleri.get(index).getTipid();
        odalar.add(new Oda(txtOdaNumarasi.getText(), oTip,txtOdaOzellikleri.getText(),Double.parseDouble(txtOdaFiyati.getText())   ));
        PreparedStatement pState=null;
        ResultSet rs=null;
          try{
              
            pState=dbBaglanti().prepareStatement(sorgu1);
            pState.setString(1,odalar.get(0).getOdaNumarasi());
            pState.setInt(2,odalar.get(0).getOdaTipiId());
            pState.setString(3 ,odalar.get(0).getOzellikleri());
            pState.setDouble(4, odalar.get(0).getFiyat());
           sonuc= pState.executeUpdate();
             
            pState=dbBaglanti().prepareStatement(sorgu2);
            pState.setString(1,odalar.get(0).getOdaNumarasi());
            pState.setInt(2,odalar.get(0).getOdaTipiId());
            pState.setString(3 ,odalar.get(0).getOzellikleri());
            pState.setDouble(4, odalar.get(0).getFiyat());
            sonuc=pState.executeUpdate();
              
                                         DbConnect.dbBaglanti().close();

                
          }catch(Exception e){
              
         
           JOptionPane.showMessageDialog(null, e);
       }
          return sonuc;
        
    } 
    
    private void odaListeGuncelle(){
         String sorgu="select oda_id,oda_numarasi,odaTipleri.odaTipi,oda_ozellikleri,oda_fiyati,odaDurumu from aktifotelOdalari JOIN   odaTipleri on aktifotelOdalari.odaTipi_id=odaTipleri.odaTipi_id";
         Odalar.odaListele(sorgu);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtOdaNumarasi = new javax.swing.JTextField();
        btnOdaKaydet = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtOdaFiyati = new javax.swing.JTextField();
        btnOdaGuncelle = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtOdaOzellikleri = new javax.swing.JTextArea();
        cmbOdaTipi = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setText("Oda Numarası:");

        btnOdaKaydet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Add-icon.png"))); // NOI18N
        btnOdaKaydet.setText("Kaydet");
        btnOdaKaydet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOdaKaydetActionPerformed(evt);
            }
        });

        jLabel2.setText("Oda Tipi:");

        jLabel3.setText("Özellikler:");

        jLabel4.setText("Oda Fiyatı:");

        txtOdaFiyati.setEnabled(false);

        btnOdaGuncelle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/edit-validated-icon.png"))); // NOI18N
        btnOdaGuncelle.setText("Güncelle");
        btnOdaGuncelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOdaGuncelleActionPerformed(evt);
            }
        });

        txtOdaOzellikleri.setColumns(16);
        txtOdaOzellikleri.setLineWrap(true);
        txtOdaOzellikleri.setRows(5);
        jScrollPane1.setViewportView(txtOdaOzellikleri);

        cmbOdaTipi.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cmbOdaTipiPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtOdaNumarasi, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtOdaFiyati, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                            .addComponent(cmbOdaTipi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(btnOdaKaydet, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btnOdaGuncelle, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtOdaNumarasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbOdaTipi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtOdaFiyati, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnOdaKaydet, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(btnOdaGuncelle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnOdaKaydetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOdaKaydetActionPerformed
        // TODO add your handling code here:
this.setAlwaysOnTop(false);
        String sorgu1="insert into otelOdalari(oda_numarasi,odaTipi_id,oda_ozellikleri,oda_fiyati)  VALUES(?,?,?,?)";
          String sorgu2="insert into aktifotelOdalari(oda_numarasi,odaTipi_id,oda_ozellikleri,oda_fiyati)  VALUES(?,?,?,?)";
       
       int sonuc=odaIslemleriYap(sorgu1, sorgu2);
        
       if(sonuc==1){
                    JOptionPane.showMessageDialog(null, "Müşteri Başarıyla Eklendi");
                odaListeGuncelle();
                }
     
            
       
    }//GEN-LAST:event_btnOdaKaydetActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
       
    }//GEN-LAST:event_formWindowOpened

    private void btnOdaGuncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOdaGuncelleActionPerformed
        // TODO add your handling code here:
        this.setAlwaysOnTop(false);

         String   sorgu1="update otelOdalari set oda_numarasi=? ,odaTipi_id=?, oda_ozellikleri=?, oda_fiyati=? where  oda_id="+odaId+" ";

         String   sorgu2="update aktifotelOdalari set oda_numarasi=? ,odaTipi_id=?, oda_ozellikleri=?, oda_fiyati=? where  oda_id="+odaId+" ";
         
             int sonuc=odaIslemleriYap(sorgu1, sorgu2);
                if(sonuc==1){
                    JOptionPane.showMessageDialog(null, "Müşteri Bilgileri Başarıyla Güncelledi");
                    odaListeGuncelle();
                }
    }//GEN-LAST:event_btnOdaGuncelleActionPerformed

    private void cmbOdaTipiPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cmbOdaTipiPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        txtOdaFiyati.setText(""+odaTipleri.get(cmbOdaTipi.getSelectedIndex()).getOdaFiyati());
    }//GEN-LAST:event_cmbOdaTipiPopupMenuWillBecomeInvisible

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OdaIslemleri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OdaIslemleri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OdaIslemleri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OdaIslemleri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OdaIslemleri().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnOdaGuncelle;
    public javax.swing.JButton btnOdaKaydet;
    public javax.swing.JComboBox<String> cmbOdaTipi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextField txtOdaFiyati;
    public javax.swing.JTextField txtOdaNumarasi;
    public javax.swing.JTextArea txtOdaOzellikleri;
    // End of variables declaration//GEN-END:variables
}
