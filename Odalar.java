/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otelrezervasyonu;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import static otelrezervasyonu.DbConnect.dbBaglanti;
import static otelrezervasyonu.MusterilerSayfasi.musteriler;
import static otelrezervasyonu.MusterilerSayfasi.tblTumMusteriler;

/**
 *
 * @author developer
 */
public class Odalar extends javax.swing.JFrame {
    
static ArrayList<Oda> odalar=new ArrayList<Oda>();
static Otel otel=new Otel();
       static  ArrayList<OdaTipleri> odaTipleri=new ArrayList<OdaTipleri>();


    /**
     * Creates new form Odalar
     */
    public Odalar() {
        initComponents();
        
        String sorgu="select oda_id,oda_numarasi,odaTipleri.odaTipi,oda_ozellikleri,oda_fiyati,odaDurumu from aktifotelOdalari JOIN   odaTipleri on aktifotelOdalari.odaTipi_id=odaTipleri.odaTipi_id";
        odaListele(sorgu);
        odaTipleriGetir();
        
        
    }
     
    
        public  static void odaListele(String sorgu){
                DefaultTableModel model;
        odalar.clear();
         model=(DefaultTableModel)tblTumOdalar.getModel();
                 model.setRowCount(0);        
            
                otel.otelOdalariListele(sorgu);
                odalar=otel.getotelOdalari();
                
            if(odalar!=null){                    
                    for(Oda oda:odalar){       
                        if(oda.getOdaDurumu()==true){
                         Object[] add={oda.getOdaNumarasi(),oda.getOdaTipi(),oda.getOzellikleri(),oda.getFiyat(),"Oda Boş"};
                           model.addRow(add);                  
                        }
                        
                        else if(oda.getOdaDurumu()==false){
                            ArrayList<String> gelenler=new ArrayList<String>();         
                                                        System.out.println(gelenler.size());
                                                            System.out.println(oda.getOdaId());
                           gelenler= otel.doluOdaMusteri(oda.getOdaId());
                           
                               Object[] add={oda.getOdaNumarasi(),oda.getOdaTipi(),oda.getOzellikleri(),oda.getFiyat(),gelenler.get(0)};
                           model.addRow(add);    
                        
                             
                        }
                        
                    }
             }
                                             tblTumOdalar.setModel(model);                   
    
    
    }
        
       public void odaTipleriGetir(){
        String sorgu="select * from odaTipleri";
        Statement state=null;
       ResultSet rs=null;
        DefaultComboBoxModel model;
        try{
           state=DbConnect.dbBaglanti().createStatement();
          rs=state.executeQuery(sorgu);
          cmbOdaTİpi.addItem("Tümü");
          while(rs.next()){
                int tipId=rs.getInt("odaTipi_id");
                String odaTipi=rs.getString("odaTipi");
                odaTipleri.add(new OdaTipleri(tipId,odaTipi));
                 cmbOdaTİpi.addItem(odaTipi);
             }  //while finish
                                    DbConnect.dbBaglanti().close();

             
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    

        public void filtreleme(){
            
            //seçili bilgilere göre oda bilgilerini filtreleme
            int index=cmbOdaTİpi.getSelectedIndex();
             int  oTip=1;
            if(index>0){
                           oTip =odaTipleri.get(index-1).getTipid();

            }
            int odaDurum=cmbOdaDurumu.getSelectedIndex();
            String sorgu="";
                    
           if(odaDurum==0){   //Tümü 
               if(index==0){  //Tümü
                 sorgu="select oda_id,oda_numarasi,odaTipleri.odaTipi,oda_ozellikleri,oda_fiyati,odaDurumu from aktifotelOdalari JOIN   odaTipleri on aktifotelOdalari.odaTipi_id=odaTipleri.odaTipi_id";

           }
               else if(index!=0){
              //seçili tipe göre  durumu tümü
                   sorgu="select oda_id,oda_numarasi,odaTipleri.odaTipi,oda_ozellikleri,oda_fiyati,odaDurumu from aktifotelOdalari JOIN   odaTipleri on aktifotelOdalari.odaTipi_id=odaTipleri.odaTipi_id where aktifotelOdalari.odaTipi_id="+oTip+" ";

               }

           }
           else if(odaDurum!=0){  
                 if(index==0){
                     //seçili duruma göre  oda tipi tümü
             sorgu="select oda_id,oda_numarasi,odaTipleri.odaTipi,oda_ozellikleri,oda_fiyati,odaDurumu from aktifotelOdalari JOIN   odaTipleri on aktifotelOdalari.odaTipi_id=odaTipleri.odaTipi_id where aktifotelOdalari.odaDurumu="+(odaDurum-1)+"";

                 }
                 else if(index!=0){
                    //seçili duruma ve seçili oda tipine göre
                                  sorgu="select oda_id,oda_numarasi,odaTipleri.odaTipi,oda_ozellikleri,oda_fiyati,odaDurumu from aktifotelOdalari JOIN   odaTipleri on aktifotelOdalari.odaTipi_id=odaTipleri.odaTipi_id where aktifotelOdalari.odaDurumu="+(odaDurum-1)+" and aktifotelOdalari.odaTipi_id="+oTip+" ";

                 }
               
           }
           
            odaListele(sorgu);
                    
            
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
        btnOdaSil = new javax.swing.JButton();
        btnOdaGuncelleme = new javax.swing.JButton();
        btnOdaEkle = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTumOdalar = new javax.swing.JTable();
        txtOdaAra = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cmbOdaDurumu = new javax.swing.JComboBox<>();
        cmbOdaTİpi = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        btnOdaSil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Button-Close-icon.png"))); // NOI18N
        btnOdaSil.setText("Sil");
        btnOdaSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOdaSilActionPerformed(evt);
            }
        });

        btnOdaGuncelleme.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/edit-validated-icon.png"))); // NOI18N
        btnOdaGuncelleme.setText("Düzenle");
        btnOdaGuncelleme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOdaGuncellemeActionPerformed(evt);
            }
        });

        btnOdaEkle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Add-icon.png"))); // NOI18N
        btnOdaEkle.setText("Oda Ekle");
        btnOdaEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOdaEkleActionPerformed(evt);
            }
        });

        tblTumOdalar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Oda Numarası", "Oda Tipi", "Özellikleri", "Oda Fiyatı", "Oda Durumu"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTumOdalar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblTumOdalar.setDoubleBuffered(true);
        tblTumOdalar.setDragEnabled(true);
        tblTumOdalar.setName(""); // NOI18N
        tblTumOdalar.setRowHeight(40);
        tblTumOdalar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTumOdalarMouseClicked(evt);
            }
        });
        tblTumOdalar.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                tblTumOdalarCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        jScrollPane1.setViewportView(tblTumOdalar);
        if (tblTumOdalar.getColumnModel().getColumnCount() > 0) {
            tblTumOdalar.getColumnModel().getColumn(0).setResizable(false);
            tblTumOdalar.getColumnModel().getColumn(1).setResizable(false);
            tblTumOdalar.getColumnModel().getColumn(2).setPreferredWidth(200);
            tblTumOdalar.getColumnModel().getColumn(3).setResizable(false);
            tblTumOdalar.getColumnModel().getColumn(4).setResizable(false);
        }

        txtOdaAra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtOdaAra.setText("Oda Numarası veya Oda Tipi ile Arama Yapmak için Tıkayın..");
        txtOdaAra.setToolTipText("Oda Numarası veya Oda Tipi ile Arama Yapmak için Tıkayın..");
        txtOdaAra.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtOdaAraFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtOdaAraFocusLost(evt);
            }
        });
        txtOdaAra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOdaAraActionPerformed(evt);
            }
        });
        txtOdaAra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtOdaAraKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtOdaAraKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtOdaAraKeyTyped(evt);
            }
        });

        jLabel1.setText("Oda Durumu");

        cmbOdaDurumu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tümü", "Dolu", "Boş" }));
        cmbOdaDurumu.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cmbOdaDurumuPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        cmbOdaTİpi.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cmbOdaTİpiPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jLabel2.setText("Filtrele:");

        jLabel3.setText("Oda Tİpi");

        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setBorder(javax.swing.BorderFactory.createTitledBorder("Oda Özellikleri"));
        jTextArea1.setEnabled(false);
        jScrollPane2.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbOdaDurumu, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbOdaTİpi, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 212, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(txtOdaAra, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(btnOdaEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnOdaGuncelleme, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnOdaSil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(31, 31, 31))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1038, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnOdaSil, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtOdaAra, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnOdaEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnOdaGuncelleme, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbOdaDurumu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbOdaTİpi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(527, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap(106, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
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

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        
    }//GEN-LAST:event_formWindowOpened

    private void btnOdaEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOdaEkleActionPerformed
        // TODO add your handling code here:
       OdaIslemleri islemler=new OdaIslemleri();
        islemler.setVisible(true);
       islemler.btnOdaGuncelle.setVisible(false);
       islemler.btnOdaKaydet.setVisible(true);
               
    }//GEN-LAST:event_btnOdaEkleActionPerformed

    private void btnOdaGuncellemeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOdaGuncellemeActionPerformed
        // TODO add your handling code here:
        if(tblTumOdalar.getSelectedRow()>=0){
            if(odalar.get(tblTumOdalar.getSelectedRow()).getOdaDurumu()==true){
                 OdaIslemleri islemler=new OdaIslemleri();
               int i=tblTumOdalar.getSelectedRow();
      islemler.txtOdaNumarasi.setText(odalar.get(i).getOdaNumarasi());
      islemler.txtOdaOzellikleri.setText(odalar.get(i).getOzellikleri());
      islemler.txtOdaFiyati.setText(""+odalar.get(i).getFiyat());
      islemler.odaId=odalar.get(i).getOdaId();
      islemler.tip=tblTumOdalar.getModel().getValueAt(i, 1).toString();
      
        islemler.setVisible(true);
         islemler.btnOdaGuncelle.setVisible(true);
       islemler.btnOdaKaydet.setVisible(false);
            }
            else{
                JOptionPane.showMessageDialog(null, "Düzenleme işlemi boş odalar için geçerlidir");
            }
           
        }
         
       
 
      
      

      
    }//GEN-LAST:event_btnOdaGuncellemeActionPerformed

    private void cmbOdaDurumuPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cmbOdaDurumuPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        filtreleme();
    }//GEN-LAST:event_cmbOdaDurumuPopupMenuWillBecomeInvisible

    private void cmbOdaTİpiPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cmbOdaTİpiPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        filtreleme();
    }//GEN-LAST:event_cmbOdaTİpiPopupMenuWillBecomeInvisible

    private void btnOdaSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOdaSilActionPerformed
        // TODO add your handling code here:
        if(tblTumOdalar.getSelectedRow()>=0){
             if(odalar.get(tblTumOdalar.getSelectedRow()).getOdaDurumu()==true){
            int i=tblTumOdalar.getSelectedRow();

       if( JOptionPane.showConfirmDialog(null, odalar.get(i).getOdaNumarasi()+ "  numaralaı Odayı silmek istiyormusunuz?", "Uyarı" ,0)==JOptionPane.YES_OPTION){
           int id=odalar.get(i).getOdaId();
           
           Statement st=null;
           
           try{
               String sorgu="delete  from aktifotelOdalari where oda_id="+id+" ";
               st=dbBaglanti().createStatement();
               int sonuc=st.executeUpdate(sorgu);
                                         DbConnect.dbBaglanti().close();

               if(sonuc==1){
                   JOptionPane.showMessageDialog(null,"Oda Silindi");
         sorgu="select oda_id,oda_numarasi,odaTipleri.odaTipi,oda_ozellikleri,oda_fiyati,odaDurumu from aktifotelOdalari JOIN   odaTipleri on aktifotelOdalari.odaTipi_id=odaTipleri.odaTipi_id";

                   odaListele(sorgu);
               }
           }catch(Exception e){
               JOptionPane.showMessageDialog(null, e);
           }
       }
        }
             else{
                                 JOptionPane.showMessageDialog(null, "Silme işlemi boş odalar için geçerlidir");

             }
        }
               
    }//GEN-LAST:event_btnOdaSilActionPerformed

    private void tblTumOdalarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTumOdalarMouseClicked
        // TODO add your handling code here:
                                                                jTextArea1.setText(""+tblTumOdalar.getModel().getValueAt( (tblTumOdalar.getSelectedRow()) ,2));


    }//GEN-LAST:event_tblTumOdalarMouseClicked

    private void tblTumOdalarCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_tblTumOdalarCaretPositionChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_tblTumOdalarCaretPositionChanged

    private void txtOdaAraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOdaAraKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_txtOdaAraKeyTyped

    private void txtOdaAraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOdaAraKeyReleased
        // TODO add your handling code here:

        String sorgu="select oda_id,oda_numarasi,odaTipleri.odaTipi,oda_ozellikleri,oda_fiyati,odaDurumu from aktifotelOdalari JOIN   odaTipleri on aktifotelOdalari.odaTipi_id=odaTipleri.odaTipi_id where aktifotelOdalari.oda_numarasi like'%"+txtOdaAra.getText()+"%'  or odaTipleri.odaTipi like '%"+txtOdaAra.getText()+"%' ";

        odaListele(sorgu);

    }//GEN-LAST:event_txtOdaAraKeyReleased

    private void txtOdaAraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOdaAraKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtOdaAraKeyPressed

    private void txtOdaAraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOdaAraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOdaAraActionPerformed

    private void txtOdaAraFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtOdaAraFocusLost
        // TODO add your handling code here:
        if(txtOdaAra.getText().equals("") ){
            txtOdaAra.setText("Oda Numarası veya Oda Tipi ile Arama Yapmak için Tıkayın..");
        }

    }//GEN-LAST:event_txtOdaAraFocusLost

    private void txtOdaAraFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtOdaAraFocusGained
        // TODO add your handling code here:
        if(txtOdaAra.getText().equals("Oda Numarası veya Oda Tipi ile Arama Yapmak için Tıkayın..")){
            txtOdaAra.setText("");
        }

    }//GEN-LAST:event_txtOdaAraFocusGained

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
            java.util.logging.Logger.getLogger(Odalar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Odalar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Odalar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Odalar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Odalar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOdaEkle;
    private javax.swing.JButton btnOdaGuncelleme;
    private javax.swing.JButton btnOdaSil;
    private javax.swing.JComboBox<String> cmbOdaDurumu;
    private javax.swing.JComboBox<String> cmbOdaTİpi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private static javax.swing.JTable tblTumOdalar;
    private javax.swing.JTextField txtOdaAra;
    // End of variables declaration//GEN-END:variables
}
