/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import bdd.ConnectBD;
import fc.TextValidator;
import javax.swing.JFrame;
import javax.swing.SwingWorker;

/**
 *
 * @author Go
 */
public class searchDmaPage extends javax.swing.JFrame {
    JFrame main;
    /**
     * Creates new form searchDmaPage
     */
    public searchDmaPage(JFrame main) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.main = main;
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtPrenom = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNom = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jourTxt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        moisTxt = new javax.swing.JTextField();
        anneeTxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(31, 58, 105), 3, true));

        jButton1.setBackground(new java.awt.Color(31, 58, 105));
        jButton1.setFont(new java.awt.Font("Ebrima", 1, 16)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("RECHERCHER");
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(31, 58, 105));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("X");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtPrenom.setBackground(new java.awt.Color(255, 255, 255));
        txtPrenom.setFont(new java.awt.Font("Ebrima", 1, 20)); // NOI18N
        txtPrenom.setForeground(new java.awt.Color(116, 116, 116));
        txtPrenom.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(31, 28, 105), 2, true));
        txtPrenom.setMargin(new java.awt.Insets(5, 5, 5, 5));
        txtPrenom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrenomActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(31, 58, 105));
        jLabel3.setText("Recherche");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(31, 58, 105));
        jLabel5.setText("Pr??nom ");

        txtNom.setBackground(new java.awt.Color(255, 255, 255));
        txtNom.setFont(new java.awt.Font("Ebrima", 1, 20)); // NOI18N
        txtNom.setForeground(new java.awt.Color(116, 116, 116));
        txtNom.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(31, 28, 105), 2, true));
        txtNom.setMargin(new java.awt.Insets(5, 5, 5, 5));
        txtNom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(31, 58, 105));
        jLabel6.setText("Nom");

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(31, 58, 105));
        jLabel9.setText("Date de naissance");

        jourTxt.setBackground(new java.awt.Color(255, 255, 255));
        jourTxt.setFont(new java.awt.Font("Ebrima", 1, 20)); // NOI18N
        jourTxt.setForeground(new java.awt.Color(116, 116, 116));
        jourTxt.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(31, 58, 105)));
        jourTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jourTxtKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Ebrima", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(31, 58, 105));
        jLabel7.setText("/");

        moisTxt.setBackground(new java.awt.Color(255, 255, 255));
        moisTxt.setFont(new java.awt.Font("Ebrima", 1, 20)); // NOI18N
        moisTxt.setForeground(new java.awt.Color(116, 116, 116));
        moisTxt.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(31, 58, 105)));
        moisTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moisTxtActionPerformed(evt);
            }
        });
        moisTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                moisTxtKeyTyped(evt);
            }
        });

        anneeTxt.setBackground(new java.awt.Color(255, 255, 255));
        anneeTxt.setFont(new java.awt.Font("Ebrima", 1, 20)); // NOI18N
        anneeTxt.setForeground(new java.awt.Color(116, 116, 116));
        anneeTxt.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(31, 58, 105)));
        anneeTxt.setMaximumSize(new java.awt.Dimension(0, 28));
        anneeTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anneeTxtActionPerformed(evt);
            }
        });
        anneeTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                anneeTxtKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Ebrima", 1, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(31, 58, 105));
        jLabel8.setText("/");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtNom, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                                .addComponent(txtPrenom, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addComponent(jourTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(moisTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(anneeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 152, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(jLabel3))
                .addGap(37, 37, 37)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jourTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(moisTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(anneeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(jButton1)
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void anneeTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_anneeTxtKeyTyped
        TextValidator.consumeNonIntegers(evt, 4, (new fc.Date()).getAnnee());
    }//GEN-LAST:event_anneeTxtKeyTyped

    private void anneeTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anneeTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_anneeTxtActionPerformed

    private void moisTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_moisTxtKeyTyped
        TextValidator.consumeNonIntegers(evt, 2, 12);
    }//GEN-LAST:event_moisTxtKeyTyped

    private void moisTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moisTxtActionPerformed

    }//GEN-LAST:event_moisTxtActionPerformed

    private void jourTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jourTxtKeyTyped
        TextValidator.consumeNonIntegers(evt, 2, 31);
    }//GEN-LAST:event_jourTxtKeyTyped

    private void txtNomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomActionPerformed

    private void txtPrenomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrenomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrenomActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFrame popup = new PopupLoading();
        popup.setVisible(true);

        String nom = this.txtNom.getText();
        String prenom = this.txtPrenom.getText();
        int jour = 0, mois = 0, annee = 0;
        if( !this.jourTxt.getText().equals(""))
            jour = Integer.parseInt( this.jourTxt.getText() );
        if( !this.moisTxt.getText().equals(""))
            mois = Integer.parseInt( this.moisTxt.getText() );
        if( !this.anneeTxt.getText().equals(""))
            annee = Integer.parseInt( this.anneeTxt.getText() );
        fc.Date date = new fc.Date(jour, mois, annee);

        fc.Patient p = new fc.Patient(null, nom, prenom, date);
        SwingWorker sw = new SwingWorker(){
            @Override
            protected String doInBackground() throws Exception
            {
                fc.Patient result = ConnectBD.getPatientByNomPrenomDateNaissance(p);
                try {
                    if ( result == null) {
                        java.awt.EventQueue.invokeLater(new Runnable() {
                            public void run() {
                                new PopupPatientNonTrouve().setVisible(true);
                            }
                        });
                    } else {
                        java.awt.EventQueue.invokeLater(new Runnable() {
                            public void run() {
                                new ProfilPatientPage(result, main).setVisible(true);
                            }
                        });
                        System.out.println(result);
                        searchDmaPage.this.dispose();
                        main.setVisible(false);
                    }
                } catch (Exception e) {
                    System.err.println(e);
                    PopupFactory.createPopupErreurConnexion();
                }
                return "";
            }

            @Override
            protected void done()
            {
                popup.setVisible(false);
            }
        };
        // executes the swingworker on worker thread
        sw.execute();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(searchDmaPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(searchDmaPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(searchDmaPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(searchDmaPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new searchDmaPage(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField anneeTxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jourTxt;
    private javax.swing.JTextField moisTxt;
    private javax.swing.JTextField txtNom;
    private javax.swing.JTextField txtPrenom;
    // End of variables declaration//GEN-END:variables
}
