/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otelrezervasyonu;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author developer
 */
public class Anasayfa extends javax.swing.JFrame {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
     Date tarih=new Date();
    /**
     * Creates new form Anasayfa
     */
    public Anasayfa() {
        initComponents();
        odaTipleriGetir();
        
        //rezervasyonu griş çıkışını geçmiş tarih seçmemesi için giriş tarihini o gun çıkış tarihini 1 gun sonrası olarak ayarladım.
        dtGirisTarihi.setDate(tarih);
        Calendar cal=Calendar.getInstance();
        cal.setTime(tarih);
        cal.add(Calendar.DATE,1);
        dtCikisTarihi.setDate(cal.getTime());
        dtGirisTarihi.setMinSelectableDate(tarih);
        dtCikisTarihi.setMinSelectableDate(tarih);
        //Login page Jdialog Form
        JFrame f=new JFrame("frame");
        LoginPage login=new LoginPage(f,true);
        login.show(true);
        
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
        btnRezervasyonlar = new javax.swing.JButton();
        btnOdalar = new javax.swing.JButton();
        btnOtelBilgileri = new javax.swing.JButton();
        btnMusteriler = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmbOdaTipi = new javax.swing.JComboBox<>();
        btnOdaListele = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dtGirisTarihi = new com.toedter.calendar.JDateChooser();
        dtCikisTarihi = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        txtOdaIlerler = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOdalar = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setState(-1);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        btnRezervasyonlar.setBackground(new java.awt.Color(255, 255, 255));
        btnRezervasyonlar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnRezervasyonlar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iconfinder_book_4171938 (1).png"))); // NOI18N
        btnRezervasyonlar.setText("Rezervasyonlar");
        btnRezervasyonlar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRezervasyonlarActionPerformed(evt);
            }
        });

        btnOdalar.setBackground(new java.awt.Color(255, 255, 255));
        btnOdalar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnOdalar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/bed (1).png"))); // NOI18N
        btnOdalar.setText("Odalar");
        btnOdalar.setToolTipText("");
        btnOdalar.setPreferredSize(new java.awt.Dimension(100, 49));
        btnOdalar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOdalarActionPerformed(evt);
            }
        });

        btnOtelBilgileri.setBackground(new java.awt.Color(255, 255, 255));
        btnOtelBilgileri.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnOtelBilgileri.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/hotel-icon.png"))); // NOI18N
        btnOtelBilgileri.setText("Otel Bilgileri");
        btnOtelBilgileri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOtelBilgileriActionPerformed(evt);
            }
        });

        btnMusteriler.setBackground(new java.awt.Color(255, 255, 255));
        btnMusteriler.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnMusteriler.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/User-Group-icon.png"))); // NOI18N
        btnMusteriler.setText("Müşteriler");
        btnMusteriler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMusterilerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnOtelBilgileri, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(btnMusteriler, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(btnOdalar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRezervasyonlar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRezervasyonlar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnMusteriler, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnOdalar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnOtelBilgileri, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78))
        );

        jLabel1.setText("Çıkış Tarihi:");

        cmbOdaTipi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbOdaTipiActionPerformed(evt);
            }
        });

        btnOdaListele.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Checklist-icon.png"))); // NOI18N
        btnOdaListele.setText("Oda Listele");
        btnOdaListele.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOdaListeleActionPerformed(evt);
            }
        });

        jLabel2.setText("Oda Tipi Seçiniz:");

        jLabel3.setText("Giriş Tarihi:");

        dtGirisTarihi.setDateFormatString("dd/MMM/yyyy");
        dtGirisTarihi.setMaxSelectableDate(new java.util.Date(253370757715000L));
        dtGirisTarihi.setMinSelectableDate(new java.util.Date(-62135776685000L));

        dtCikisTarihi.setDateFormatString("dd/MMM/yyyy");

        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setBorder(javax.swing.BorderFactory.createTitledBorder("Odanın Özellikleri"));
        jTextArea1.setEnabled(false);
        jScrollPane2.setViewportView(jTextArea1);

        txtOdaIlerler.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ileri.png"))); // NOI18N
        txtOdaIlerler.setText("İlerle ");
        txtOdaIlerler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOdaIlerlerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dtGirisTarihi, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dtCikisTarihi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnOdaListele, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cmbOdaTipi, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(190, 190, 190))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(txtOdaIlerler, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbOdaTipi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dtGirisTarihi, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dtCikisTarihi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOdaListele, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(txtOdaIlerler, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        tblOdalar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Oda Numarasi", "Oda Tipi", "Fiyat", "Oda Durumu"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblOdalar.setRowHeight(30);
        tblOdalar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblOdalarMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblOdalar);
        if (tblOdalar.getColumnModel().getColumnCount() > 0) {
            tblOdalar.getColumnModel().getColumn(0).setResizable(false);
            tblOdalar.getColumnModel().getColumn(1).setResizable(false);
            tblOdalar.getColumnModel().getColumn(2).setResizable(false);
            tblOdalar.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
                //id  bilgisini kullanmak için ArrayListleri global olarak tanımladım
         ArrayList<Oda> odalar=new ArrayList<Oda>();
        ArrayList<OdaTipleri> odaTipleri=new ArrayList<OdaTipleri>();
        
    public void odaTipleriGetir(){
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
                double odaFiyati=rs.getDouble("odaTipiFiyati");
                odaTipleri.add(new OdaTipleri(tipId,odaTipi,odaFiyati));
                 cmbOdaTipi.addItem(odaTipi);
             }  //while finish
             DbConnect.dbBaglanti().close();
                     
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    


    private void btnOdaListeleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOdaListeleActionPerformed
        // TODO add your handling code here:
        String d = sdf.format(dtGirisTarihi.getDate());
      
        
DefaultTableModel model;
        odalar.clear();
        int i=cmbOdaTipi.getSelectedIndex();
        int oTip=odaTipleri.get(i).getTipid();
        String sorgu="select oda_id,oda_numarasi, odaTipleri.odaTipi,oda_ozellikleri,oda_fiyati,odaDurumu from    aktifotelOdalari JOIN  odaTipleri on odaTipleri.odaTipi_id=aktifotelOdalari.odaTipi_id where aktifotelOdalari.odaTipi_id="+oTip+"  and  aktifotelOdalari.odaDurumu=1"  ;
        Statement state=null;
       ResultSet rs=null;
       model=(DefaultTableModel)tblOdalar.getModel();
        try{
        model.setRowCount(0);

            state=DbConnect.dbBaglanti().createStatement();
            rs=state.executeQuery(sorgu);
            while(rs.next()){          
                int odaId=rs.getInt("oda_id");
                String odaNumarasi=rs.getString("oda_numarasi");
                String odaTipi=rs.getString("odaTipi");
                String ozellikler=rs.getString("oda_ozellikleri");
                double fiyat=rs.getDouble("oda_fiyati");
                boolean durum=rs.getBoolean("odaDurumu");
                odalar.add(new Oda(odaId,odaNumarasi,odaTipi,ozellikler,fiyat,durum));
                  }  //while finished
                if(odalar!=null){                    
                    for(Oda oda:odalar){       
                        
                        Object[] add={oda.getOdaNumarasi(),oda.getOdaTipi(),oda.getFiyat(),"Şu anda Uygun",};
                        model.addRow(add);
                        
                    }//for finished
                                tblOdalar.setModel(model);

                } //if finished     
             DbConnect.dbBaglanti().close();
                
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            System.out.println(e);
        }
            
        
        
        
    }//GEN-LAST:event_btnOdaListeleActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        
    }//GEN-LAST:event_formWindowOpened

    private void cmbOdaTipiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbOdaTipiActionPerformed
        // TODO add your handling code here:
        //int i=cmbOdaTipi.getSelectedIndex();
        //  JOptionPane.showMessageDialog(null, odaTipleri.get(i).getTipid() +"  ->"+odaTipleri.get(i).getOdaFiyati());
        
    }//GEN-LAST:event_cmbOdaTipiActionPerformed

    private void tblOdalarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOdalarMouseClicked
        // TODO add your handling code here:
        
           jTextArea1.setText(""+odalar.get(tblOdalar.getSelectedRow()).getOzellikleri());
          
            
     
        
        
      
    }//GEN-LAST:event_tblOdalarMouseClicked

    private void btnOdalarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOdalarActionPerformed
        // TODO add your handling code here:
        
         Odalar odalar=new Odalar();
          odalar.setVisible(true); 
         
      
           
    }//GEN-LAST:event_btnOdalarActionPerformed

    private void btnMusterilerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMusterilerActionPerformed
        // TODO add your handling code here:
        MusterilerSayfasi musteriler=new MusterilerSayfasi();
        musteriler.setAlwaysOnTop(true);
        musteriler.setVisible(true);
          musteriler.rezervasyonYap=false;
    }//GEN-LAST:event_btnMusterilerActionPerformed

    private void txtOdaIlerlerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOdaIlerlerActionPerformed
        // TODO add your handling code here:
        if(tblOdalar.getSelectedRow()>=0){
             DefaultTableModel model;
       int i=tblOdalar.getSelectedRow();
       //seçilen odanın bilgilerini rezervasyon sayfalarındaki değişkenlere atadım
       RezervasyonYap.o_id=odalar.get(i).getOdaId();
        RezervasyonYap.oNumarasi=odalar.get(i).getOdaNumarasi();
        RezervasyonYap.oTipi=odalar.get(i).getOdaTipi();
        RezervasyonYap.oTipFiyat=odalar.get(i).getFiyat();
        RezervasyonYap.toplamGun=   (dtCikisTarihi.getDate().getDay()-dtGirisTarihi.getDate().getDay());
        
        //odayı seçtikten sonra müşterileri listedim
            MusterilerSayfasi musteriler=new MusterilerSayfasi();
            musteriler.rezervasyonYap=true;
            musteriler.setVisible(true);
        }
          
    }//GEN-LAST:event_txtOdaIlerlerActionPerformed

    private void btnRezervasyonlarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRezervasyonlarActionPerformed
        // TODO add your handling code here:
        RezervasyonlarSayfasi rSayfasi=new RezervasyonlarSayfasi();
        rSayfasi.setVisible(true);
    }//GEN-LAST:event_btnRezervasyonlarActionPerformed

    private void btnOtelBilgileriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOtelBilgileriActionPerformed
        // TODO add your handling code here:
        OtelBilgileri oBilgi=new OtelBilgileri();
        oBilgi.setVisible(true);
    }//GEN-LAST:event_btnOtelBilgileriActionPerformed

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
            java.util.logging.Logger.getLogger(Anasayfa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Anasayfa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Anasayfa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Anasayfa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Anasayfa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMusteriler;
    private javax.swing.JButton btnOdaListele;
    private javax.swing.JButton btnOdalar;
    private javax.swing.JButton btnOtelBilgileri;
    private javax.swing.JButton btnRezervasyonlar;
    private javax.swing.JComboBox<String> cmbOdaTipi;
    private com.toedter.calendar.JDateChooser dtCikisTarihi;
    private com.toedter.calendar.JDateChooser dtGirisTarihi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTable tblOdalar;
    private javax.swing.JButton txtOdaIlerler;
    // End of variables declaration//GEN-END:variables
}
