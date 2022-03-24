/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import fc.Service;
import javax.swing.JFrame;

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
    
    public static void createPopupCreationPatientReussite(JFrame main, JFrame parent){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PopupCreationPatientReussite(main, parent).setVisible(true);
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
    
    public static void createPopupDemandeMigration(fc.Patient p, fc.Service s, JFrame main) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PopupDemandeMigration(p, s, main).setVisible(true);
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
    
    public static void createPopupPatientExistant(){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PopupPatientExistant().setVisible(true);
            }
        });
    }
}
