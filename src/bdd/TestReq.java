/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdd;

import fc.Prescription;
import fc.TypePersonnel;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Go
 */
public class TestReq {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            fc.Patient r = new fc.Patient(null, "marcal", "mArtiN", new fc.Date(16,3,2006));
            System.out.println( ConnectBD.getPatientByNomPrenomDateNaissance(r) );
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            Logger.getLogger(TestReq.class.getName()).log(Level.FINE, null, ex);
        }
    }
    
}
