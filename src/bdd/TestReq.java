/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdd;

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
            System.out.println( ConnectBD.login("011", "toto") );
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            Logger.getLogger(TestReq.class.getName()).log(Level.FINE, null, ex);
        }
    }
    
}
