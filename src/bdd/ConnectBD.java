/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdd;

import com.mysql.jdbc.CommunicationsException;
import fc.Consultation;
import fc.Date;
import fc.Patient;
import fc.Patient_2;
import fc.Personnel;
import fc.TypePersonnel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    public static Personnel login(String id, String inPass) throws Exception {
        Connection con = getConnectionToDB();
        Statement st;
        ResultSet rs;
        Personnel personnel = null;
        
        if(id.equals("Identifiant") || id.equals("") || id.length() < 3){
            return null;
        }
        String query = "select mdp, nom, prenom from " + getTableName(id) + " where id=" + id;
        st = con.createStatement();
        rs = st.executeQuery(query);
        while (rs.next()) {
            String dbPass = rs.getString("mdp");
//            boolean isEqual = fc.PasswordHandler.isEqual(inPass, dbPass);
            if(fc.PasswordHandler.isEqual(inPass, dbPass))
                personnel = new Personnel(rs.getString("nom"), rs.getString("prenom"));
        }
        
        terminateConnexion(con, st, rs);
        
        return personnel;
    }
    
    public static ArrayList<Patient> getListePatientFromService(String service) throws Exception{
        ArrayList<Patient> listePatients = new ArrayList<>();
        Connection con = getConnectionToDB();
        Statement st;
        ResultSet rs;
        
        String query = 
        "SELECT patient.IPP, nom, prenom, dateNaissance " + 
        "FROM localisation INNER JOIN patient ON patient.IPP = localisation.IPP " +
        "WHERE service = \"" + service + "\";";
        
        st = con.createStatement();
        rs = st.executeQuery(query);
        while (rs.next()) {
            String ipp = rs.getString("patient.ipp");
            String nom = rs.getString("nom");
            String prenom = rs.getString("prenom");
            java.sql.Date dateNaissance = rs.getDate("dateNaissance");
            listePatients.add( new Patient(ipp, nom, prenom, new fc.Date(dateNaissance)));
        }
        
        terminateConnexion(con, st, rs);
        
        return listePatients;
    }
    
    public static ArrayList<Consultation> getListeConsultationFromIpp(String ipp) throws Exception{
        ArrayList<Consultation> listeConsultation = new ArrayList<>();
        Connection con = getConnectionToDB();
        Statement st;
        ResultSet rs;
        
        String query = 
        "SELECT numeroSejour, date, service " + 
        "FROM consultation " +
        "WHERE ipp = \"" + ipp + "\";";
        
        st = con.createStatement();
        rs = st.executeQuery(query);
        while (rs.next()) {
            int numSejour = rs.getInt("numeroSejour");
            Date date = new Date( rs.getDate("date") );
            String service = rs.getString("service");
            listeConsultation.add( new Consultation(Integer.toString(numSejour), ipp, date, service));
        }
        
        terminateConnexion(con, st, rs);
        
        return listeConsultation;
    }
    
    public static Consultation getConsultationFromNum(String numSejour) throws Exception{
        Connection con = getConnectionToDB();
        Statement st;
        ResultSet rs;
        
        String query = 
        "SELECT ";
        return null;
    }
    
    private static void terminateConnexion(Connection con, Statement st, ResultSet rs){
        try {
            con.close();
            st.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectBD.class.getName()).log(Level.SEVERE, null, ex);
        }
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
