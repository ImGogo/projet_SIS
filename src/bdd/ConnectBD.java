/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdd;

import com.mysql.jdbc.CommunicationsException;
import fc.Visite;
import fc.CoteLit;
import fc.Date;
import fc.Localisation;
import fc.Patient;
import fc.Patient_2;
import fc.Personnel;
import fc.Prescription;
import fc.Prestation;
import fc.Service;
import fc.Sexe;
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
        "SELECT patient.IPP, nom, prenom, dateNaissance, numChambre, serviceGeographique, coteLit " + 
        "FROM localisation INNER JOIN patient ON patient.IPP = localisation.IPP " +
        "WHERE serviceOrigine = \"" + service + "\";";
        
        st = con.createStatement();
        rs = st.executeQuery(query);
        while (rs.next()) {
            String ipp = rs.getString("patient.ipp");
            String nom = rs.getString("nom");
            String prenom = rs.getString("prenom");
            java.sql.Date dateNaissance = rs.getDate("dateNaissance");
            int numChambre = rs.getInt("numChambre");
            Service sg = Service.valueOf( rs.getString("serviceGeographique"));
            CoteLit cl = CoteLit.valueOf( rs.getString("coteLit"));
            Localisation localisation = new Localisation(numChambre, cl, sg, Service.valueOf(service));
            listePatients.add( new Patient(ipp, nom, prenom, new fc.Date(dateNaissance), localisation));
        }
        
        terminateConnexion(con, st, rs);
        
        return listePatients;
    }
    
    public static ArrayList<Visite> getListeConsultationFromIpp(String ipp) throws Exception{
        ArrayList<Visite> listeConsultation = new ArrayList<>();
        Connection con = getConnectionToDB();
        Statement st;
        ResultSet rs;
        
        String query = 
        "SELECT numSejour, dateEntree, service, type, idDM " + 
        "FROM DM " +
        "WHERE ipp = \"" + ipp + "\";";
        
        st = con.createStatement();
        rs = st.executeQuery(query);
        while (rs.next()) {
            int numSejour = rs.getInt("numSejour");
            String type = rs.getString("type");
            Date date = new Date( rs.getDate("dateEntree") );
            String service = rs.getString("service");
            String id = Integer.toString( rs.getInt("idDM") );
            listeConsultation.add(new Visite(Integer.toString(numSejour), ipp, date, service, type, id));
        }
        
        terminateConnexion(con, st, rs);
        
        return listeConsultation;
    }
    
    public static Visite getConsultationFromIdDm(String idDM) throws Exception{
        Visite visite = null;
        Connection con = getConnectionToDB();
        Statement st;
        ResultSet rs;
        
        String query = 
        "SELECT DM.*, nom, prenom" +
        "FROM DM INNER JOIN praticien ON idPH = praticien.id " +
        "WHERE idDM = " + idDM;
        
        st = con.createStatement();
        rs = st.executeQuery(query);
        
        while (rs.next()) {
            int numSejour = rs.getInt("numSejour");
            String type = rs.getString("type");
            Date date = new Date( rs.getDate("dateEntree") );
            String service = rs.getString("service");
            String id = Integer.toString( rs.getInt("idDM") );
            String ipp = Integer.toString( rs.getInt("IPP") );
            
            visite = new Visite(Integer.toString(numSejour), ipp, date, service, type, id);
        }
        
        terminateConnexion(con, st, rs);
        
        return visite;
    }
    
    public static ArrayList<Prescription> getListePrescriptionByIdDM(String idDM) throws Exception{
        ArrayList<Prescription> liste = new ArrayList<>();
        
        Connection con = getConnectionToDB();
        Statement st;
        ResultSet rs;
        
        String query = 
        "SELECT * " +
        "FROM prescription " +
        "WHERE idDM = " + idDM;
        
        System.out.println(query);
        st = con.createStatement();
        rs = st.executeQuery(query);
        
        while (rs.next()) {
            String medicament = rs.getString("medicament");
            Date dateDebut = new Date( rs.getDate("dateDebut") );
            Date dateFin = new Date( rs.getDate("dateFin") );
            String posologie = rs.getString("posologie");
            String dose = Integer.toString( rs.getInt("dosage") );
            Prescription p = new Prescription(medicament, dose, posologie, dateDebut, dateFin);
            System.out.println(p);
            liste.add(p);
        }
        
        terminateConnexion(con, st, rs);
        
        return liste;
    }
    
    public ArrayList<Prestation> getListePrestationByIdDM(String idDM) throws Exception{
        ArrayList<Prestation> liste = new ArrayList<>();
        
        Connection con = getConnectionToDB();
        Statement st;
        ResultSet rs;
        
        String query = 
        "SELECT * " +
        "FROM prestation " +
        "WHERE idDM = " + idDM;
        
        System.out.println(query);
        st = con.createStatement();
        rs = st.executeQuery(query);
        
        while (rs.next()) {
            String prestation = rs.getString("prestation");
            String observations = rs.getString("observations");
            Service service = Service.valueOf( rs.getString("service") );
            Prestation p = new Prestation(prestation, service, observations);
            System.out.println(p);
            liste.add(p);
        }
        
        terminateConnexion(con, st, rs);
        
        return liste;
    }
    
    public Patient getPatientByIPP(String ipp) throws Exception{
        Patient p = null;
        Connection con = getConnectionToDB();
        Statement st;
        ResultSet rs;
        
        String query = 
        "SELECT * " +
        "FROM patient " +
        "WHERE IPP = " + ipp;
        
        System.out.println(query);
        st = con.createStatement();
        rs = st.executeQuery(query);
        
//        while (rs.next()) {
//            String nom = rs.getString("nom");
//            String prenom = rs.getString("prenom");
//            Date dateNaiss = new Date( rs.getDate("dateNaissance") );
//            Sexe sexe = rs.getString("posologie");
//            String dose = Integer.toString( rs.getInt("dosage") );
//            Prescription p = new Prescription(medicament, dose, posologie, dateDebut, dateFin);
//            System.out.println(p);
//            liste.add(p);
//        }
        
        terminateConnexion(con, st, rs);
        
        return p;
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
