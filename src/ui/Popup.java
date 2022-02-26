/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Go
 */
public class Popup {
    
    public static void createPopupCreationPatientReussite(){
        
        JDialog dialog = new JDialog();
        JPanel pane = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        pane.setBackground(new Color(255, 255, 255));
        JLabel msgLbl = new JLabel("Patient ajouté avec succès");
        
        c.insets = new Insets(1, 1, 1, 1); 
        
        c.gridx = 0;
        c.gridy = 0;
        
        pane.add(msgLbl, c);
        
        JButton okBtn = new JButton("Valider");
        
        okBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                dialog.dispose();
            }
        });
        
        okBtn.setOpaque(true);
        okBtn.setBackground(new Color(31,58,105));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        
        pane.add(okBtn, c);
        
        
        
        dialog.add(pane);
        dialog.pack();
        
        dialog.setVisible(true);
        dialog.setLocationRelativeTo(null);
        dialog.setUndecorated(true);
        
//        dialog.setUndecorated(true);
//        JOptionPane.showMessageDialog(null, pane);
    }
}
