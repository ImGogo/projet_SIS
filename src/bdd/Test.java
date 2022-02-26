/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdd;

/**
 *
 * @author Go
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
//import java.sql.ResultSet;
import java.sql.Statement;

public class Test{
    public static void main(String[] args) {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            String lien = "jdbc:mysql://mysql-lygalma.alwaysdata.net:3306/lygalma_test";
            Connection con = DriverManager.getConnection(lien, "lygalma", "LygalmaSIS1");
            System.out.println("Connected");  
            
            Statement sta = con.createStatement();
            
//            ResultSet res = sta.executeQuery("SELECT * FROM patient");
            ResultSet res = sta.executeQuery("SELECT dateNaissance FROM patient");
            
            while(res.next()) {
//                int ipp = res.getInt(1);
//                String nom = res.getString(2);
//                String prenom = res.getString(3);
                java.sql.Date dateNaissance = res.getDate(1);
//                String sexe = res.getString(5);
//                String adresse = res.getString(6);
                java.util.Date date = new java.util.Date(dateNaissance.getTime());
                System.out.println(dateNaissance.getTime());
               ///String naturePrestation = res.getString(7);
//                System.out.println(prenom + " " + nom + "id: " + ipp + "et sa date de naissance est" + dateNaissance);

            }
            
                        
            res.close();
            sta.close();
            con.close();
            
            System.out.println("Disconnected");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }  
}
