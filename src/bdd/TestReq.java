/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdd;

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
//        bdd.ConnectBD.insertPatient(2341353 , "toto", "dupont", new fc.Date(19, 3, 1994), fc.Sexe.Homme);
//        System.out.println(fc.PasswordHandler.encryptPass("toto"));
        try {
            System.out.println( bdd.ConnectBD.login("011", "toto") );
        } catch (Exception ex) {
            Logger.getLogger(TestReq.class.getName()).log(Level.SEVERE, null, ex);
        }
//        System.out.println("011".substring(0, 2));
    }
    
}
