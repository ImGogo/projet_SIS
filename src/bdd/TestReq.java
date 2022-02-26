/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdd;

import java.sql.SQLException;

/**
 *
 * @author Go
 */
public class TestReq {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        bdd.ConnectBD.insertPatient(2341353 , "toto", "dupont", new fc.Date(19, 3, 1994), fc.Sexe.Homme);
    }
    
}
