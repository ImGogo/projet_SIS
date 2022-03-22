/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdd;

import fc.Visite;
import fc.CoteLit;
import fc.Date;
import fc.Hebergement;
import fc.Localisation;
import fc.Medecin;
import fc.Patient;
import fc.Personnel;
import fc.Prescription;
import fc.Prestation;
import fc.Service;
import fc.Sexe;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Go
 */
public class ConnectBD {
    
    private static Connection getConnectionToDB() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        String lien = "jdbc:mysql://mysql-lygalma.alwaysdata.net:3306/lygalma_test";
        
        return DriverManager.getConnection(lien, "lygalma", "LygalmaSIS1");
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
        "SELECT patient.IPP, nom, prenom, dateNaissance, numChambre, serviceGeographique, coteLit, sexe " + 
        "FROM localisation INNER JOIN patient ON patient.IPP = localisation.IPP " +
        "WHERE numChambre IS NOT NULL AND serviceOrigine = \"" + service + "\";";
        
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
            Sexe sexe = Sexe.valueOf( rs.getString("sexe"));
            Localisation localisation = new Localisation(numChambre, cl, sg, Service.valueOf(service));
            listePatients.add( new Patient(ipp, nom, prenom, new fc.Date(dateNaissance), localisation, sexe));
        }
        
        terminateConnexion(con, st, rs);
        
        return listePatients;
    }
    
    public static ArrayList<Patient> getListePatientSansChambreFromService(String service) throws Exception{
        ArrayList<Patient> listePatients = new ArrayList<>();
        Connection con = getConnectionToDB();
        Statement st;
        ResultSet rs;
        String query = 
        "SELECT patient.* " + 
        "FROM `DM` INNER JOIN patient ON patient.IPP = DM.IPP " +
        "INNER JOIN localisation ON localisation.IPP = DM.IPP " +
        "WHERE localisation.numChambre IS NULL AND serviceOrigine = \"" + service + "\" ";
        
        st = con.createStatement();
        rs = st.executeQuery(query);
        while (rs.next()) {
            String ipp = rs.getString("patient.IPP");
            String nom = rs.getString("nom");
            String prenom = rs.getString("prenom");
            Date dateNaissance =  new Date( rs.getDate("dateNaissance") );
            Sexe sexe = Sexe.valueOf( rs.getString("sexe"));
            listePatients.add( new Patient(ipp, nom, prenom, dateNaissance, sexe));
        }
        
        terminateConnexion(con, st, rs);
        
        return listePatients;
    }
    
    public static ArrayList<Patient> getListePatientEnSortieByService(String service) throws Exception{
        ArrayList<Patient> listePatients = new ArrayList<>();
        Connection con = getConnectionToDB();
        Statement st;
        ResultSet rs;
        String query = 
        "SELECT patient.* " + 
        "FROM `DM` INNER JOIN patient ON patient.IPP = DM.IPP " +
        "WHERE dateSortie IS NULL AND lettreSortie IS NOT NULL AND service = \"" + service + "\" ";
        
        st = con.createStatement();
        rs = st.executeQuery(query);
        while (rs.next()) {
            String ipp = rs.getString("patient.IPP");
            String nom = rs.getString("nom");
            String prenom = rs.getString("prenom");
            Date dateNaissance =  new Date( rs.getDate("dateNaissance") );
            Sexe sexe = Sexe.valueOf( rs.getString("sexe"));
            listePatients.add( new Patient(ipp, nom, prenom, dateNaissance, sexe));
        }
        
        terminateConnexion(con, st, rs);
        
        return listePatients;
    }
    
    public static ArrayList<Patient> getListeConsultationsByidPH(String idPH) throws Exception{
        ArrayList<Patient> listePatients = new ArrayList<>();
        Connection con = getConnectionToDB();
        Statement st;
        ResultSet rs;
        String query = 
        "SELECT nom, prenom, dateEntree, patient.ipp " + 
        "FROM `DM` INNER JOIN patient on patient.IPP = DM.IPP " +
        "WHERE type = \"Consultation\" AND lettreSortie IS NULL AND idPH = \"" + idPH + "\" " +
        "ORDER BY dateEntree ASC;";
        
        st = con.createStatement();
        rs = st.executeQuery(query);
        while (rs.next()) {
            String ipp = rs.getString("patient.IPP");
            String nom = rs.getString("nom");
            String prenom = rs.getString("prenom");
            java.sql.Date dateNaissance = rs.getDate("dateNaissance");
            Sexe sexe = Sexe.valueOf( rs.getString("sexe"));
            // utilisation de la date de naissance pour stocker la date de la consultation
            Date dateEntree = new Date( rs.getTimestamp("dateEntree") ); 
            listePatients.add( new Patient(ipp, nom, prenom, dateEntree));
        }
        
        terminateConnexion(con, st, rs);
        
        return listePatients;
    }
    
    public static ArrayList<Hebergement> getListeHebergementByService(String service) throws Exception{
        Connection con = getConnectionToDB();
        ArrayList<Hebergement> liste = new ArrayList<>();
        
        Statement st;
        ResultSet rs;
        String query = 
        "SELECT patient.*, serviceSource, serviceArrivee " + 
        "FROM `migration` " +
        "INNER JOIN DM ON DM.idDM = migration.idDM " +
        "INNER JOIN patient ON patient.ipp = DM.ipp " +
        "WHERE hebergement = 1 AND serviceArrivee = \"" + service  + "\";";
        
        st = con.createStatement();
        rs = st.executeQuery(query);
        while (rs.next()) {
            int ipp = rs.getInt("IPP");
            String serviceSource = rs.getString("serviceSource");
            String serviceArrivee = rs.getString("serviceArrivee");
            String nom = rs.getString("nom");
            String prenom = rs.getString("prenom");
            Sexe sexe = Sexe.valueOf( rs.getString("sexe"));
            Date dateNaissance = new Date( rs.getDate("dateNaissance") ); 
            Patient p = new Patient(Integer.toString(ipp), nom, prenom, dateNaissance, sexe);
            
            liste.add( new Hebergement(p, serviceSource, serviceArrivee));
        }
        
        terminateConnexion(con, st, rs);
        
        return liste;
    }
    
    public static ArrayList<Visite> getListeConsultationFromIpp(String ipp) throws Exception{
        ArrayList<Visite> listeConsultation = new ArrayList<>();
        Connection con = getConnectionToDB();
        Statement st;
        ResultSet rs;
        
        String query = 
        "SELECT DM.*, nom, prenom " + 
        "FROM DM INNER JOIN praticien ON idPH = praticien.id " +
        "WHERE ipp = \"" + ipp + "\";";
        
        st = con.createStatement();
        rs = st.executeQuery(query);
        while (rs.next()) {
            int numSejour = rs.getInt("numSejour");
            String type = rs.getString("type");
            
            Date date = new Date( rs.getDate("dateEntree") );
            String service = rs.getString("service");
            String id = Integer.toString( rs.getInt("idDM") );
            String nom = rs.getString("nom");
            String prenom = rs.getString("prenom");
            String motif = rs.getString("motif");
            System.out.println(motif);
            listeConsultation.add(new Visite(Integer.toString(numSejour), ipp, date, service, type, id, nom + " " + prenom, motif));
        }
        
        terminateConnexion(con, st, rs);
        
        return listeConsultation;
    }
    
    public static Visite getVisiteByIdDm(String idDM) throws Exception{
        Visite visite = null;
        Connection con = getConnectionToDB();
        Statement st;
        ResultSet rs;
        
        String query = 
        "SELECT DM.*, nom, prenom " +
        "FROM DM INNER JOIN praticien ON idPH = praticien.id " +
        "WHERE idDM = " + idDM;
        
        st = con.createStatement();
        rs = st.executeQuery(query);
        
        if (rs.next()) {
            int numSejour = rs.getInt("numSejour");
            String type = rs.getString("type");
            
            Date date = new Date( rs.getTimestamp("dateEntree") );
            String service = rs.getString("service");
            String id = Integer.toString( rs.getInt("idDM") );
            String ipp = Integer.toString( rs.getInt("IPP") );
            String nom = rs.getString("nom");
            String prenom = rs.getString("prenom");
            String motif = rs.getString("motif");
            String observations = rs.getString("observation");
            
            visite = new Visite(Integer.toString(numSejour), ipp, date, service, type, id, nom + " " + prenom, motif, observations);
            
            for( Prescription p : getListePrescriptionByIdDM(idDM, con)){
                visite.addPrescription(p);
            }
            for( Prestation p : getListePrestationByIdDM(idDM, con)){
                visite.addPrestation(p);
            }
        }
        
        terminateConnexion(con, st, rs);
        
        return visite;
    }
    
    private static ArrayList<Prescription> getListePrescriptionByIdDM(String idDM, Connection con) throws Exception{
        ArrayList<Prescription> liste = new ArrayList<>();
        
        Statement st;
        ResultSet rs;
        
        String query = 
        "SELECT * " +
        "FROM prescription " +
        "WHERE idDM = " + idDM;
        
        st = con.createStatement();
        rs = st.executeQuery(query);
        
        while (rs.next()) {
            String medicament = rs.getString("medicament");
            Date dateDebut = new Date( rs.getDate("dateDebut") );
            Date dateFin = new Date( rs.getDate("dateFin") );
            String posologie = rs.getString("posologie");
            String dose = rs.getString("dosage");
            
            Prescription p = new Prescription(medicament, dose, posologie, dateDebut, dateFin);
            liste.add(p);
        }
        
        terminateConnexion(st, rs);
        
        return liste;
    }
    
    
    public static ArrayList<Prestation> getListePrestationByIdDM(String idDM, Connection con) throws Exception{
        ArrayList<Prestation> liste = new ArrayList<>();
        
        Statement st;
        ResultSet rs;
        
        String query = 
        "SELECT * " +
        "FROM prestation " +
        "WHERE idDM = " + idDM;
        
        st = con.createStatement();
        rs = st.executeQuery(query);
        
        while (rs.next()) {
            String prestation = rs.getString("typePrestation");
            String observations = rs.getString("observations");
            Service service = Service.valueOf( rs.getString("service") );
            Prestation p = new Prestation(prestation, service, observations);
            liste.add(p);
        }
        
        terminateConnexion(st, rs);
        
        return liste;
    }
    
    public static Patient getPatientByIPP(String ipp) throws Exception{
        Patient p = null;
        Connection con = getConnectionToDB();
        Statement st;
        ResultSet rs;
        
        String query = 
        "SELECT * " +
        "FROM patient " +
        "WHERE IPP = " + ipp;
        
        st = con.createStatement();
        rs = st.executeQuery(query);
        
        if (rs.next()) {
            String nom = rs.getString("nom");
            String prenom = rs.getString("prenom");
            Date dateNaiss = new Date( rs.getDate("dateNaissance") );
            Sexe sexe = Sexe.valueOf( rs.getString("sexe"));
            p = new Patient(ipp, nom, prenom, dateNaiss, sexe);
        }
        
        terminateConnexion(con, st, rs);
        
        return p;
    }
    
    public static Service[] getListServiceAvecMedecin() throws Exception{
        Connection con = getConnectionToDB();
        Statement st;
        ResultSet rs;
        
        int rowCount = 0;
        int i = 0;
        
        String query = 
        "SELECT DISTINCT service " +
        "FROM praticien";
        
        st = con.createStatement();
        rs = st.executeQuery(query);
        
        if (rs.last()) {
            rowCount = rs.getRow();
            rs.beforeFirst();
        }
        Service[] liste = new Service[rowCount];
        
        while (rs.next()) {
            String service = rs.getString("service");
            liste[i++] = Service.valueOf(service);
        }
        
        terminateConnexion(con, st, rs);
        
        return liste;
    }
    
    public static Medecin[] getListMedecinFrom(String service) throws Exception{
        Connection con = getConnectionToDB();
        Statement st;
        ResultSet rs;
        
        int rowCount = 0;
        int i = 0;
        
        String query = 
        "SELECT id, nom, prenom " +
        "FROM praticien " +
        "WHERE service = \"" + service + "\";";
        
        st = con.createStatement();
        rs = st.executeQuery(query);
        
        if (rs.last()) {
            rowCount = rs.getRow();
            rs.beforeFirst();
        }
        Medecin[] liste = new Medecin[rowCount];
        
        while (rs.next()) {
            int id = rs.getInt("id");
            String nom = rs.getString("nom");
            String prenom = rs.getString("prenom");
            liste[i++] = new Medecin(id, nom, prenom);
        }
        
        terminateConnexion(con, st, rs);
        
        return liste;
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
    
    private static void terminateConnexion(Statement st, ResultSet rs){
        try {
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
