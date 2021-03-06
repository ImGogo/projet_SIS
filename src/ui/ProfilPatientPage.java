/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import fc.Service;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.geom.RoundRectangle2D;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.KeyStroke;

/**
 *
 * @author Go
 */
public class ProfilPatientPage extends javax.swing.JFrame {
    fc.Patient p;
    JFrame main;
    /**
     * Creates new form SecretaireAdminPage
     */
    public ProfilPatientPage() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    public ProfilPatientPage(fc.Patient p, JFrame main) {
        initComponents();
        setLocationRelativeTo(null);
        this.main = main;
        this.p = p;
        initLabels();
    }

    private void initLabels() {
        this.txtCodePostal.setText( p.getAdresse().getCodePostal() );
        this.txtVille.setText( p.getAdresse().getVille() );
        this.txtNomRue.setText( p.getAdresse().getNomRue() );
        this.txtNumRue.setText( p.getAdresse().getNumRue() );
        this.txtDate.setText( p.getDateDeNaissance().toString() );
        this.txtIpp.setText( p.getIpp() );
        this.txtMail.setText( p.getEmail() );
        this.txtNom.setText( p.getNomFormat() );
        this.txtNss.setText( p.getNss() );
        this.txtPrenom.setText( p.getPrenomFormat() );
        this.txtSexe.setText( p.getSexe().getVal() );
        this.txtPh.setText( p.getMedecinGeneraliste() );
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        HomePanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        profilePictLb = new javax.swing.JButton();
        serviceLb = new javax.swing.JLabel();
        nameLb = new javax.swing.JLabel();
        disconnectBtn = new javax.swing.JButton();
        portalLb = new javax.swing.JLabel();
        profilePictLb1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtIpp = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPrenom = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNom = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtMail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtPh = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtSexe = new javax.swing.JTextField();
        txtDate = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtNss = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtNomRue = new javax.swing.JTextField();
        txtNumRue = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtVille = new javax.swing.JTextField();
        txtCodePostal = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        HomePanel.setBackground(new java.awt.Color(255, 255, 255));
        HomePanel.setPreferredSize(new java.awt.Dimension(1280, 720));

        jPanel1.setBackground(new java.awt.Color(31, 58, 105));

        jPanel2.setBackground(new java.awt.Color(34, 170, 224));

        profilePictLb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/images/profile_placeholder.png"))); // NOI18N
        profilePictLb.setBorder(null);
        profilePictLb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                profilePictLbMouseEntered(evt);
            }
        });
        profilePictLb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profilePictLbActionPerformed(evt);
            }
        });

        serviceLb.setFont(new java.awt.Font("Ebrima", 1, 20)); // NOI18N
        serviceLb.setForeground(new java.awt.Color(255, 255, 255));
        serviceLb.setText("Service");

        nameLb.setFont(new java.awt.Font("Ebrima", 1, 20)); // NOI18N
        nameLb.setForeground(new java.awt.Color(255, 255, 255));
        nameLb.setText("NOM Pr??nom");

        disconnectBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/images/disconnect.png"))); // NOI18N
        disconnectBtn.setBorder(null);
        disconnectBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                disconnectBtnMouseEntered(evt);
            }
        });
        disconnectBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disconnectBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(profilePictLb)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(nameLb)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                        .addComponent(disconnectBtn))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(serviceLb)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nameLb)
                .addGap(18, 18, 18)
                .addComponent(serviceLb)
                .addGap(18, 18, 18))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(disconnectBtn)
                    .addComponent(profilePictLb))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        portalLb.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        portalLb.setForeground(new java.awt.Color(255, 255, 255));
        portalLb.setText("PROFIL DU PATIENT");

        profilePictLb1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ui/images/left_arrow.png"))); // NOI18N
        profilePictLb1.setBorder(null);
        profilePictLb1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                profilePictLb1MouseEntered(evt);
            }
        });
        profilePictLb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profilePictLb1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(profilePictLb1)
                .addGap(18, 18, 18)
                .addComponent(portalLb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(portalLb))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(profilePictLb1))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(31, 58, 105), 2, true));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Ebrima", 1, 26)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(31, 58, 105));
        jLabel1.setText("Informations personnelles");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(31, 58, 105));
        jLabel2.setText("IPP :");

        txtIpp.setEditable(false);
        txtIpp.setBackground(new java.awt.Color(255, 255, 255));
        txtIpp.setFont(new java.awt.Font("Ebrima", 1, 20)); // NOI18N
        txtIpp.setForeground(new java.awt.Color(116, 116, 116));
        txtIpp.setBorder(null);
        txtIpp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIppActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(31, 58, 105));
        jLabel3.setText("Pr??nom :");

        txtPrenom.setEditable(false);
        txtPrenom.setBackground(new java.awt.Color(255, 255, 255));
        txtPrenom.setFont(new java.awt.Font("Ebrima", 1, 20)); // NOI18N
        txtPrenom.setForeground(new java.awt.Color(116, 116, 116));
        txtPrenom.setBorder(null);

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(31, 58, 105));
        jLabel4.setText("Nom :");

        txtNom.setEditable(false);
        txtNom.setBackground(new java.awt.Color(255, 255, 255));
        txtNom.setFont(new java.awt.Font("Ebrima", 1, 20)); // NOI18N
        txtNom.setForeground(new java.awt.Color(116, 116, 116));
        txtNom.setBorder(null);

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(31, 58, 105));
        jLabel5.setText("E-mail :");

        txtMail.setEditable(false);
        txtMail.setBackground(new java.awt.Color(255, 255, 255));
        txtMail.setFont(new java.awt.Font("Ebrima", 1, 20)); // NOI18N
        txtMail.setForeground(new java.awt.Color(116, 116, 116));
        txtMail.setBorder(null);

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(31, 58, 105));
        jLabel6.setText("Praticien Hospitalier :");

        txtPh.setEditable(false);
        txtPh.setBackground(new java.awt.Color(255, 255, 255));
        txtPh.setFont(new java.awt.Font("Ebrima", 1, 20)); // NOI18N
        txtPh.setForeground(new java.awt.Color(116, 116, 116));
        txtPh.setBorder(null);

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(31, 58, 105));
        jLabel7.setText("Sexe :");

        txtSexe.setEditable(false);
        txtSexe.setBackground(new java.awt.Color(255, 255, 255));
        txtSexe.setFont(new java.awt.Font("Ebrima", 1, 20)); // NOI18N
        txtSexe.setForeground(new java.awt.Color(116, 116, 116));
        txtSexe.setBorder(null);

        txtDate.setEditable(false);
        txtDate.setBackground(new java.awt.Color(255, 255, 255));
        txtDate.setFont(new java.awt.Font("Ebrima", 1, 20)); // NOI18N
        txtDate.setForeground(new java.awt.Color(116, 116, 116));
        txtDate.setBorder(null);

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(31, 58, 105));
        jLabel8.setText("Date de naissance :");

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(31, 58, 105));
        jLabel9.setText("N?? S??curit?? Sociale :");

        txtNss.setEditable(false);
        txtNss.setBackground(new java.awt.Color(255, 255, 255));
        txtNss.setFont(new java.awt.Font("Ebrima", 1, 20)); // NOI18N
        txtNss.setForeground(new java.awt.Color(116, 116, 116));
        txtNss.setBorder(null);

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Ebrima", 1, 26)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(31, 58, 105));
        jLabel10.setText("Adresse");

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(31, 58, 105));
        jLabel11.setText("Rue :");

        txtNomRue.setEditable(false);
        txtNomRue.setBackground(new java.awt.Color(255, 255, 255));
        txtNomRue.setFont(new java.awt.Font("Ebrima", 1, 20)); // NOI18N
        txtNomRue.setForeground(new java.awt.Color(116, 116, 116));
        txtNomRue.setBorder(null);

        txtNumRue.setEditable(false);
        txtNumRue.setBackground(new java.awt.Color(255, 255, 255));
        txtNumRue.setFont(new java.awt.Font("Ebrima", 1, 20)); // NOI18N
        txtNumRue.setForeground(new java.awt.Color(116, 116, 116));
        txtNumRue.setBorder(null);

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(31, 58, 105));
        jLabel12.setText("Num??ro :");

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(31, 58, 105));
        jLabel13.setText("Ville :");

        txtVille.setEditable(false);
        txtVille.setBackground(new java.awt.Color(255, 255, 255));
        txtVille.setFont(new java.awt.Font("Ebrima", 1, 20)); // NOI18N
        txtVille.setForeground(new java.awt.Color(116, 116, 116));
        txtVille.setBorder(null);

        txtCodePostal.setEditable(false);
        txtCodePostal.setBackground(new java.awt.Color(255, 255, 255));
        txtCodePostal.setFont(new java.awt.Font("Ebrima", 1, 20)); // NOI18N
        txtCodePostal.setForeground(new java.awt.Color(116, 116, 116));
        txtCodePostal.setBorder(null);

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(31, 58, 105));
        jLabel14.setText("Code postal :");

        jButton1.setBackground(new java.awt.Color(31, 58, 105));
        jButton1.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("TRANSMETTRE LE PATIENT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtNumRue))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtNomRue, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtVille))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCodePostal))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtMail))
                                    .addComponent(jLabel1)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtNom))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtPrenom))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtIpp, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtPh)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtNss, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(jLabel7)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtSexe))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(jLabel8)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtDate)))))
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(59, 59, 59))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIpp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtSexe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtPh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtNomRue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txtVille, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtNumRue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(txtCodePostal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout HomePanelLayout = new javax.swing.GroupLayout(HomePanel);
        HomePanel.setLayout(HomePanelLayout);
        HomePanelLayout.setHorizontalGroup(
            HomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HomePanelLayout.createSequentialGroup()
                .addContainerGap(111, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120))
        );
        HomePanelLayout.setVerticalGroup(
            HomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomePanelLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(HomePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1281, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(HomePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 604, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void profilePictLbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profilePictLbActionPerformed

        
    }//GEN-LAST:event_profilePictLbActionPerformed

    private void profilePictLbMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profilePictLbMouseEntered
        this.profilePictLb.setBackground(Color.yellow);
    }//GEN-LAST:event_profilePictLbMouseEntered

    private void disconnectBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_disconnectBtnMouseEntered
        
    }//GEN-LAST:event_disconnectBtnMouseEntered

    private void disconnectBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disconnectBtnActionPerformed
    java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginPage().setVisible(true);
            }
        });
        this.dispose();
    }//GEN-LAST:event_disconnectBtnActionPerformed

    private void profilePictLb1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profilePictLb1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_profilePictLb1MouseEntered

    private void profilePictLb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profilePictLb1ActionPerformed
        main.setVisible(true);
        dispose();
    }//GEN-LAST:event_profilePictLb1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        PopupFactory.createPopupDemandeMigration(p, Service.Accueil, main);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtIppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIppActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIppActionPerformed

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
            java.util.logging.Logger.getLogger(ProfilPatientPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProfilPatientPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProfilPatientPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProfilPatientPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProfilPatientPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel HomePanel;
    private javax.swing.JButton disconnectBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel nameLb;
    private javax.swing.JLabel portalLb;
    private javax.swing.JButton profilePictLb;
    private javax.swing.JButton profilePictLb1;
    private javax.swing.JLabel serviceLb;
    private javax.swing.JTextField txtCodePostal;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtIpp;
    private javax.swing.JTextField txtMail;
    private javax.swing.JTextField txtNom;
    private javax.swing.JTextField txtNomRue;
    private javax.swing.JTextField txtNss;
    private javax.swing.JTextField txtNumRue;
    private javax.swing.JTextField txtPh;
    private javax.swing.JTextField txtPrenom;
    private javax.swing.JTextField txtSexe;
    private javax.swing.JTextField txtVille;
    // End of variables declaration//GEN-END:variables
}
