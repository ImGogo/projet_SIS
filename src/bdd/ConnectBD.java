/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdd;

import com.mysql.jdbc.CommunicationsException;
import fc.TypePersonnel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.SwingWorker;

/**
 *
 * @author Go
 */
public class ConnectBD {
    
    private static Connection getConnectionToDB() throws Exception{
        java.sql.Connection con = null;

        Class.forName("com.mysql.jdbc.Driver");
        String lien = "jdbc:mysql://mysql-lygalma.alwaysdata.net:3306/lygalma_test";
        con = DriverManager.getConnection(lien, "lygalma", "LygalmaSIS1");
        System.out.println("Connecté");

        return con;
    }
    
    public static void insertPatient(int ipp, String nom, String prenom, fc.Date date, fc.Sexe sexe) throws Exception{
        
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
    
    public static boolean login(String id, String inPass) throws Exception {
        Connection con = getConnectionToDB();
        Statement st = null;
        ResultSet rs = null;
        boolean connected = false;
        if(id.equals("Identifiant") || id.equals("") || id.length() < 3){
            return false;
        }
        String query = "select mdp from " + getTableName(id) + " where id=" + id;
        st = con.createStatement();
        rs = st.executeQuery(query);
        while (rs.next()) {
            String dbPass = rs.getString("mdp");
            boolean isEqual = fc.PasswordHandler.isEqual(inPass, dbPass);
            connected = isEqual;
        }
      
        return connected;
    }
    
    private static String getTableName(String id){
        switch(id.substring(0, 2)){
            case "01" : return "secretaire";
            case "02" : return "secretaire";
            case "03" : return "praticien";
        }
        return null;
    }
}
