/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import fc.Service;
import ui.PopupCreationPatientReussite;
import ui.PopupValider;
import ui.PopupConnexionImpossible;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
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
public class PopupFactory {
    
    public static void createPopupCreationPatientReussite(){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PopupCreationPatientReussite().setVisible(true);
            }
        });
    }
    
    public static void createPopupValider(ui.creerDmaPage main){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PopupValider(main).setVisible(true);
            }
        });
    }
    
    public static void createPopupErreurConnexion(){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PopupConnexionImpossible().setVisible(true);
            }
        });
    }
    public static void createPopupMdpIncorrect(){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PopupMdpIncorrect().setVisible(true);
            }
        });
    }
    
    public static void createPopupDemandeMigration(fc.Patient p, fc.Service s) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PopupDemandeMigration(p, s).setVisible(true);
            }
        });
    }
    
    public static void createPopupChoixChambre(JFrame main, Service serviceGeographique, Service serviceOrigine, String ipp) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PopupChoixChambre(main, serviceGeographique, serviceOrigine, ipp).setVisible(true);
            }
        });
    }
}
