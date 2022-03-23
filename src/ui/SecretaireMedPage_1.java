/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import bdd.ConnectBD;
import fc.Hebergement;
import fc.Look;
import fc.Patient;
import fc.Personnel;
import fc.Service;
import java.awt.Color;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Go
 */
public class SecretaireMedPage_1 extends javax.swing.JFrame {
    ArrayList<Patient> listePatientService;
    ArrayList<Patient> listePatientEntree;
    ArrayList<Patient> listePatientSortie;
    ArrayList<Hebergement> listeHebergement;
    Personnel personnel;
    /**
     * Creates new form SecretaireAdminPage
     */
    public SecretaireMedPage_1() {
        initComponents();
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Look.setTableLook(tableEntrees);
        Look.setTableLook(this.tablePatientService);
        Look.setTableLook(this.tableSortie);
        Look.setTableLook(this.tableHebergement);
        Look.setScrollBar(jScrollPane1);
        Look.setScrollBar(jScrollPane2);
        Look.setScrollBar(jScrollPane3);
        Look.setScrollBar(jScrollPane4);
        initAllTables();
    }
    
    public SecretaireMedPage_1(Personnel p) {
        initComponents();
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.personnel = p;
        Look.setTableLook(tableEntrees);
        Look.setTableLook(this.tablePatientService);
        Look.setTableLook(this.tableSortie);
        Look.setTableLook(this.tableHebergement);
        Look.setScrollBar(jScrollPane1);
        Look.setScrollBar(jScrollPane2);
        Look.setScrollBar(jScrollPane3);
        Look.setScrollBar(jScrollPane4);
        initAllTables();
        
        this.nameLb.setText(p.getNom().toUpperCase() + " " + p.getPrenom());
        this.serviceLb.setText( p.getService().toString());
    }
    
    private void initAllTables() {
        JFrame popup = new PopupLoading();
        popup.setVisible(true);
        SwingWorker sw = new SwingWorker(){
            @Override
            protected String doInBackground() throws Exception 
            {
                initTablePatientService();
                initTableHebergement();
                initTableEntree();
                initTableSortie();
                return "";
            }

            @Override
            protected void done() 
            {
                try {
                    String id = get().toString();

                } catch (InterruptedException ex) {
                    Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ExecutionException ex) {
                    Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
                }
                popup.setVisible(false);
            }
        };
        // executes the swingworker on worker thread
        sw.execute(); 
    }
    
    private void initTableEntree(){
        try {
            String headers[] = {"Patient"};
            DefaultTableModel model = new DefaultTableModel(null, headers);
            
            listePatientEntree = ConnectBD.getListeEntreesFromService("Cardiologie");
            for(Patient p : listePatientEntree) {
                Object [] row = {p};
                model.addRow( row );
            }
            tableEntrees.setModel(model);
        } catch(Exception e) {
            System.err.println(e.getMessage());
        }
    }
        
    private void initTablePatientService() {
        try {
            String headers[] = {"Patient", "Localisation"};
            DefaultTableModel model = new DefaultTableModel(null, headers);
            
            listePatientService = ConnectBD.getListePatientFromService("Cardiologie");
            for(Patient p : listePatientService) {
                Object [] row = {p, p.getLocalisation()};
                model.addRow( row );
            }
            tablePatientService.setModel(model);
        } catch(Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    private void initTableHebergement() {
        try {
            String headers[] = {"Patient", "Service demandeur"};
            DefaultTableModel model = new DefaultTableModel(null, headers);
            
            listeHebergement = ConnectBD.getListeHebergementByService("Cardiologie");
            for(Hebergement h : listeHebergement) {
                Object [] row = {h.getPatient(), h.getServiceSource()};
                model.addRow( row );
            }
            tableHebergement.setModel(model);
        } catch(Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    private void initTableSortie() {
        
        try {
            String headers[] = {"Patient", "Localisation"};
            DefaultTableModel model = new DefaultTableModel(null, headers);
            
            listePatientSortie = ConnectBD.getListePatientEnSortieByService(personnel.getService().toString());
            for(Patient p : listePatientSortie) {
                Object [] row = {p, p.getLocalisation()};
                model.addRow( row );
            }
            tableSortie.setModel(model);
        } catch(Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void refreshTables(){
        this.initAllTables();
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
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableEntrees = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableSortie = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableHebergement = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablePatientService = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setResizable(false);

        HomePanel.setBackground(new java.awt.Color(255, 255, 255));

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
        nameLb.setText("NOM Prénom");

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
        portalLb.setText("PORTAIL SECRETAIRE MEDICAL");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
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
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(31, 58, 105), 2, true));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Ebrima", 1, 26)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(31, 58, 105));
        jLabel1.setText("Entrees");

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(31, 58, 105), 2, true));
        jScrollPane1.setOpaque(false);

        tableEntrees.setBackground(new java.awt.Color(255, 255, 255));
        tableEntrees.setFont(new java.awt.Font("Ebrima", 1, 20)); // NOI18N
        tableEntrees.setForeground(new java.awt.Color(116, 116, 116));
        tableEntrees.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Patient"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableEntrees.setGridColor(new java.awt.Color(255, 255, 255));
        tableEntrees.setRowHeight(40);
        tableEntrees.setRowMargin(5);
        tableEntrees.setSelectionBackground(new java.awt.Color(31, 58, 105));
        tableEntrees.setShowHorizontalLines(false);
        tableEntrees.setShowVerticalLines(false);
        tableEntrees.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableEntreesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableEntrees);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Ebrima", 1, 26)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(31, 58, 105));
        jLabel3.setText("Sorties");

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setBorder(null);
        jScrollPane3.setOpaque(false);

        tableSortie.setBackground(new java.awt.Color(255, 255, 255));
        tableSortie.setFont(new java.awt.Font("Ebrima", 1, 20)); // NOI18N
        tableSortie.setForeground(new java.awt.Color(116, 116, 116));
        tableSortie.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Patient", "Localisation"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableSortie.setGridColor(new java.awt.Color(255, 255, 255));
        tableSortie.setRowHeight(40);
        tableSortie.setRowMargin(5);
        tableSortie.setSelectionBackground(new java.awt.Color(31, 58, 105));
        tableSortie.setShowHorizontalLines(false);
        tableSortie.setShowVerticalLines(false);
        tableSortie.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableSortieMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableSortie);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Ebrima", 1, 26)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(31, 58, 105));
        jLabel2.setText("Demandes d'hébergement");

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setBorder(null);
        jScrollPane2.setOpaque(false);

        tableHebergement.setBackground(new java.awt.Color(255, 255, 255));
        tableHebergement.setFont(new java.awt.Font("Ebrima", 1, 20)); // NOI18N
        tableHebergement.setForeground(new java.awt.Color(116, 116, 116));
        tableHebergement.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Patient", "Service"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableHebergement.setGridColor(new java.awt.Color(255, 255, 255));
        tableHebergement.setRowHeight(40);
        tableHebergement.setRowMargin(5);
        tableHebergement.setSelectionBackground(new java.awt.Color(31, 58, 105));
        tableHebergement.setShowHorizontalLines(false);
        tableHebergement.setShowVerticalLines(false);
        tableHebergement.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableHebergementMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableHebergement);

        jScrollPane4.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane4.setBorder(null);
        jScrollPane4.setOpaque(false);

        tablePatientService.setBackground(new java.awt.Color(255, 255, 255));
        tablePatientService.setFont(new java.awt.Font("Ebrima", 1, 20)); // NOI18N
        tablePatientService.setForeground(new java.awt.Color(116, 116, 116));
        tablePatientService.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Patient", "Localisation"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablePatientService.setGridColor(new java.awt.Color(255, 255, 255));
        tablePatientService.setRowHeight(40);
        tablePatientService.setRowMargin(5);
        tablePatientService.setSelectionBackground(new java.awt.Color(31, 58, 105));
        tablePatientService.setShowHorizontalLines(false);
        tablePatientService.setShowVerticalLines(false);
        tablePatientService.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePatientServiceMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tablePatientService);

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Ebrima", 1, 26)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(31, 58, 105));
        jLabel4.setText("Liste des patients du service");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jLabel3))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jLabel4))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 28, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout HomePanelLayout = new javax.swing.GroupLayout(HomePanel);
        HomePanel.setLayout(HomePanelLayout);
        HomePanelLayout.setHorizontalGroup(
            HomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(HomePanelLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        HomePanelLayout.setVerticalGroup(
            HomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomePanelLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(HomePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(HomePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void tableEntreesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableEntreesMouseClicked
        if(evt.getClickCount() == 2){
            JTable target = (JTable) evt.getSource();
            int row = target.getSelectedRow();
           
            Patient patientSelect = (Patient) tableEntrees.getValueAt(row, 0);
            
            PopupFactory.createPopupChoixChambre(this, personnel.getService(),  personnel.getService(), patientSelect.getIpp());
        }
    }//GEN-LAST:event_tableEntreesMouseClicked

    private void tableSortieMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSortieMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tableSortieMouseClicked

    private void tableHebergementMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableHebergementMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tableHebergementMouseClicked

    private void tablePatientServiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePatientServiceMouseClicked
        if(evt.getClickCount() == 2){
            JTable target = (JTable) evt.getSource();
            int row = target.getSelectedRow();
            
            new PatientDMPage( (Patient) tablePatientService.getValueAt(row, 0), SecretaireMedPage_1.this).setVisible(true);
            
            this.setVisible(false);
        }
    }//GEN-LAST:event_tablePatientServiceMouseClicked

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
            java.util.logging.Logger.getLogger(SecretaireMedPage_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SecretaireMedPage_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SecretaireMedPage_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SecretaireMedPage_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SecretaireMedPage_1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel HomePanel;
    private javax.swing.JButton disconnectBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel nameLb;
    private javax.swing.JLabel portalLb;
    private javax.swing.JButton profilePictLb;
    private javax.swing.JLabel serviceLb;
    private javax.swing.JTable tableEntrees;
    private javax.swing.JTable tableHebergement;
    private javax.swing.JTable tablePatientService;
    private javax.swing.JTable tableSortie;
    // End of variables declaration//GEN-END:variables
}
