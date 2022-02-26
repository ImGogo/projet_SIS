/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

/**
 *
 * @author Go
 */
public class ConnectBD {
    
    private static Connection getConnectionToDB(){
        java.sql.Connection con = null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            String lien = "jdbc:mysql://mysql-lygalma.alwaysdata.net:3306/lygalma_test";
            con = DriverManager.getConnection(lien, "lygalma", "LygalmaSIS1");
            System.out.println("Connecté");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return con;
    }
    
    public static void insertPatient(int ipp, String nom, String prenom, fc.Date date, fc.Sexe sexe) throws SQLException{
        
        Connection con = getConnectionToDB();
        PreparedStatement pstmt = con.prepareStatement(
            "INSERT INTO patient (IPP, nom, prenom, dateNaissance, sexe) VALUE (?,?,?,?,?)");
        try{
            pstmt.setInt(1, ipp);
            pstmt.setString(2, nom);
            pstmt.setString(3, prenom);
            pstmt.setDate(4, new java.sql.Date(new SimpleDateFormat("dd-MM-yyyy").parse(date.toString()).getTime()));
            pstmt.setString(5, sexe.getVal());
            pstmt.executeUpdate();
            
            con.close();
            pstmt.close();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
