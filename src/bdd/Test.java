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
//import java.sql.ResultSet;
import java.sql.Statement;

public class Test{
    public static void main(String[] args) {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://mysql-lygalma.alwaysdata.net:3306/lygalma_test","lygalma","LygalmaSIS1");
            System.out.println("Connected");  
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }  
}
