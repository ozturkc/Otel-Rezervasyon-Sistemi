/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otelrezervasyonu;

import javax.swing.JOptionPane;

/**
 *
 * @author developer
 */
public class RezervasyonlarSayfasi extends javax.swing.JFrame {

    /**
     * Creates new form RezervasyonlarSayfasi
     */
    public RezervasyonlarSayfasi() {
        initComponents();
        String sorgu="select Rezervasyon.rezervasyon_id,musteriler.musteri_adi,musteriler.musteri_soyadi,otelOdalari.oda_numarasi,RezervasyonTipleri.RezervasyonTipi, Rezervasyon.kisiSayisi,Rezervasyon.toplamFiyat FROM Rezervasyon JOIN musteriler on musteriler.musteri_id=Rezervasyon.musteri_id JOIN otelOdalari on otelOdalari.oda_id=Rezervasyon.oda_id JOIN RezervasyonTipleri on  RezervasyonTipleri.RTipleri_id=Rezervasyon.RezervasyonTipi_id  GROUP BY Rezervasyon.rezervasyon_id DESC";
        Rezervasyon.rezervasyonGoster(sorgu);
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
        txtRezervasyonAra = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblRezervasyonlar = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnOdaServisi = new javax.swing.JButton();
        btnCikisYap = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtRezervasyonAra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtRezervasyonAra.setText("Müşteri Adı Soyadı veya Oda Numarası ile Arama Yapmak için Tıkayın..");
        txtRezervasyonAra.setToolTipText("Oda Numarası veya Oda Tipi ile Arama Yapmak için Tıkayın..");
        txtRezervasyonAra.setFocusTraversalPolicyProvider(true);
        txtRezervasyonAra.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtRezervasyonAraFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtRezervasyonAraFocusLost(evt);
            }
        });
        txtRezervasyonAra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRezervasyonAraKeyReleased(evt);
            }
        });

        tblRezervasyonlar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Adı", "Soyadı", "Oda No", "Rezervasyon Tipi", "Kişi Sayısı", "Toplam Tutar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblRezervasyonlar.setRowHeight(30);
        jScrollPane2.setViewportView(tblRezervasyonlar);

        btnOdaServisi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Household-Dining-Room-icon.png"))); // NOI18N
        btnOdaServisi.setText("Oda Servisi");
        btnOdaServisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOdaServisiActionPerformed(evt);
            }
        });

        btnCikisYap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Ok-icon.png"))); // NOI18N
        btnCikisYap.setText("Otel Çıkış Yap");
        btnCikisYap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCikisYapActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnOdaServisi, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnCikisYap, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOdaServisi, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCikisYap, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(txtRezervasyonAra, javax.swing.GroupLayout.DEFAULT_SIZE, 1051, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtRezervasyonAra, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(480, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap(182, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void txtRezervasyonAraFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRezervasyonAraFocusGained
        // TODO add your handling code here:
        if(txtRezervasyonAra.getText().equals("Müşteri Adı Soyadı veya Oda Numarası ile Arama Yapmak için Tıkayın..")){
            txtRezervasyonAra.setText("");
        }

    }//GEN-LAST:event_txtRezervasyonAraFocusGained

    private void txtRezervasyonAraFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRezervasyonAraFocusLost
        // TODO add your handling code here:
        if(txtRezervasyonAra.getText().equals("") ){
            txtRezervasyonAra.setText("Müşteri Adı Soyadı veya Oda Numarası ile Arama Yapmak için Tıkayın..");
        }
    }//GEN-LAST:event_txtRezervasyonAraFocusLost

    private void txtRezervasyonAraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRezervasyonAraKeyReleased
        // TODO add your handling code here:

         String sorgu="select Rezervasyon.rezervasyon_id,musteriler.musteri_adi,musteriler.musteri_soyadi,otelOdalari.oda_numarasi,RezervasyonTipleri.RezervasyonTipi, Rezervasyon.kisiSayisi,Rezervasyon.toplamFiyat FROM Rezervasyon JOIN musteriler on musteriler.musteri_id=Rezervasyon.musteri_id JOIN otelOdalari on otelOdalari.oda_id=Rezervasyon.oda_id JOIN RezervasyonTipleri on  RezervasyonTipleri.RTipleri_id=Rezervasyon.RezervasyonTipi_id where musteriler.musteri_adi LIKE '%"+txtRezervasyonAra.getText()+"%' or musteriler.musteri_soyadi LIKE '%"+txtRezervasyonAra.getText()+"%'  or otelOdalari.oda_numarasi like'%"+txtRezervasyonAra.getText()+"%' ";   
            Rezervasyon.rezervasyonGoster(sorgu);

    }//GEN-LAST:event_txtRezervasyonAraKeyReleased

    private void btnOdaServisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOdaServisiActionPerformed
        // TODO add your handling code here:
        if(tblRezervasyonlar.getSelectedRow()>=0){
        OdaServisiSayfasi oServisi=new OdaServisiSayfasi();
        oServisi.Rezervasyon_id=Rezervasyon.rezervasyonlar.get(tblRezervasyonlar.getSelectedRow()).getRezervasyonid();
        oServisi.setAlwaysOnTop(true);
        oServisi.setVisible(true);
            
        }
        
        
    }//GEN-LAST:event_btnOdaServisiActionPerformed

    private void btnCikisYapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCikisYapActionPerformed
        // TODO add your handling code here:
        if(tblRezervasyonlar.getSelectedRow()>=0){
            
            //eğerseçili rezervasyon varsa müşterinin otelden çıkışının vermek için exit metodunu çağırdık
          if( JOptionPane.showConfirmDialog(null, "Müşterinin Çıkışını Vermek İstiyormusunuz? \n Ödenecek Tutar="+
                  Rezervasyon.rezervasyonlar.get(tblRezervasyonlar.getSelectedRow()).getToplamFiyat()+"", "Uyarı" ,0)==JOptionPane.YES_OPTION){
                 int rezervasyon_id=Rezervasyon.rezervasyonlar.get(tblRezervasyonlar.getSelectedRow()).getRezervasyonid();

                  JOptionPane.showMessageDialog(null, Rezervasyon.exit(rezervasyon_id)+" TL Ödeme alındı!!");
                   String sorgu="select Rezervasyon.rezervasyon_id, musteriler.musteri_adi,musteriler.musteri_soyadi,otelOdalari.oda_numarasi,RezervasyonTipleri.RezervasyonTipi, Rezervasyon.kisiSayisi,Rezervasyon.toplamFiyat FROM Rezervasyon JOIN musteriler on musteriler.musteri_id=Rezervasyon.musteri_id JOIN otelOdalari on otelOdalari.oda_id=Rezervasyon.oda_id JOIN RezervasyonTipleri on  RezervasyonTipleri.RTipleri_id=Rezervasyon.RezervasyonTipi_id  GROUP BY Rezervasyon.rezervasyon_id DESC";
                   Rezervasyon.rezervasyonGoster(sorgu);
          }
        
        }
    }//GEN-LAST:event_btnCikisYapActionPerformed

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
            java.util.logging.Logger.getLogger(RezervasyonlarSayfasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RezervasyonlarSayfasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RezervasyonlarSayfasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RezervasyonlarSayfasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RezervasyonlarSayfasi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCikisYap;
    private javax.swing.JButton btnOdaServisi;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTable tblRezervasyonlar;
    public static javax.swing.JTextField txtRezervasyonAra;
    // End of variables declaration//GEN-END:variables
}
