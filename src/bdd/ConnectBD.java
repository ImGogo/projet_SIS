/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdd;

import fc.Adresse;
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
    
    public static Connection getConnectionToDB() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        String lien = "jdbc:mysql://mysql-lygalma.alwaysdata.net:3306/lygalma_test";
        
        return DriverManager.getConnection(lien, "lygalma", "LygalmaSIS1");
    }
    
    public static void insertPatient(Patient p, Adresse a) throws Exception{
        
        Connection con = getConnectionToDB();
        PreparedStatement pstmt = con.prepareStatement(
            "INSERT INTO patient (IPP, nom, prenom, dateNaissance, sexe, nomPH, numSecu, adresseMail) VALUE (?,?,?,?,?,?,?,?)");
        PreparedStatement pstmt2 = con.prepareStatement(
            "INSERT INTO adresse (IPP, nomRue, numRue, codePostal, ville) VALUE (?,?,?,?,?)");
        
        pstmt.setInt(1, Integer.parseInt( p.getIpp() ));
        pstmt.setString(2, p.getNom());
        pstmt.setString(3, p.getPrenom() );
        pstmt.setDate(4, new java.sql.Date(new SimpleDateFormat("dd / MM / yyyy").parse(p.getDateDeNaissance().toString()).getTime()));
        pstmt.setString(5, p.getSexe().toString());
        pstmt.setString(6, p.getMedecinGeneraliste());
        pstmt.setString(7, p.getNss());
        pstmt.setString(8, p.getEmail());
        pstmt.executeUpdate();

        pstmt.close();

        pstmt2.setInt(1, Integer.parseInt( p.getIpp() ));
        pstmt2.setString(2, a.getNomRue() );
        pstmt2.setInt(3, Integer.parseInt( a.getNumRue()));
        pstmt2.setInt(4, Integer.parseInt( a.getCodePostal()));
        pstmt2.setString(5, a.getVille());
        pstmt2.executeUpdate();

        pstmt2.close();
        con.close();
    }
    
    public static void insertPatientAnonyme(Patient p) throws Exception{
        
        Connection con = getConnectionToDB();
        PreparedStatement pstmt = con.prepareStatement(
            "INSERT INTO patient (IPP, nom, prenom, dateNaissance) VALUE (?,?,?,?)");
        
        pstmt.setInt(1, Integer.parseInt( p.getIpp() ));
        pstmt.setString(2, p.getNom());
        pstmt.setString(3, p.getPrenom() );
        pstmt.setDate(4, new java.sql.Date(new SimpleDateFormat("dd / MM / yyyy").parse(p.getDateDeNaissance().toString()).getTime()));
        
        pstmt.executeUpdate();

        con.close();
    }
    
    public static void insertVisite(Visite v, boolean entree) throws Exception{
        
        Connection con = getConnectionToDB();
        PreparedStatement pstmt = con.prepareStatement(
            "INSERT INTO DM (IPP, nom, prenom, dateNaissance) VALUE (?,?,?,?)");
        
//        pstmt.setInt(1, Integer.parseInt( p.getIpp() ));
//        pstmt.setString(2, p.getNom());
//        pstmt.setString(3, p.getPrenom() );
//        pstmt.setDate(4, new java.sql.Date(new SimpleDateFormat("dd / MM / yyyy").parse(p.getDateDeNaissance().toString()).getTime()));
//        
//        pstmt.executeUpdate();
//
//        con.close();
    }
    
    public static void insertMigration(String type, String ipp, Service source, Service arrivee) throws Exception{
        Connection con = getConnectionToDB();
        PreparedStatement pstmt = con.prepareStatement(
            "INSERT INTO migration (ipp, serviceSource, serviceArrivee, hebergement) VALUE (?,?,?,?)");
        
        pstmt.setString(1, ipp);
        pstmt.setString(2, source.toString());
        pstmt.setString(3, arrivee.toString());
        pstmt.setString(4, type);
        
        pstmt.execute();
        
        pstmt.close();
        con.close();
    }
    
    public static void removeMigration(String ipp) throws Exception{
        Connection con = getConnectionToDB();
        PreparedStatement pstmt = con.prepareStatement(
            "DELETE FROM `migration` WHERE ipp = ?");
        pstmt.setString(1, ipp);
        pstmt.execute();
        pstmt.close();
        con.close();
    }
    
    public static void insertLocalisation(Service serviceOrigine, Service serviceGeographique, String ipp, Localisation localisation) throws Exception{
        Connection con = getConnectionToDB();
        PreparedStatement pstmt = con.prepareStatement(
            "INSERT INTO localisation (IPP, numChambre, coteLit, serviceGeographique, serviceOrigine) VALUE (?,?,?,?,?)");
        
        pstmt.setInt(1, Integer.parseInt( ipp ));
        pstmt.setInt(2, localisation.getNumChambre() );
        pstmt.setString(3, localisation.getCoteLit().toString() );
        pstmt.setString(4, serviceGeographique.toString());
        pstmt.setString(5, serviceOrigine.toString());
        pstmt.executeUpdate();

        pstmt.close();
        con.close();
    }
    
    public static Personnel login(String id, String inPass) throws Exception {
        Connection con = getConnectionToDB();
        Statement st;
        ResultSet rs;
        Personnel personnel = null;
        
        if(id.equals("Identifiant") || id.equals("") || id.length() < 3){
            return null;
        }
        String query = "select * from " + getTableName(id) + " where id=" + id;
        st = con.createStatement();
        rs = st.executeQuery(query);
        while (rs.next()) {
            String dbPass = rs.getString("mdp");
            if(fc.PasswordHandler.isEqual(inPass, dbPass)){
                if(getTableName(id).equals("secretaire")){
                    Service service = Service.valueOf( rs.getString("service") );
                    personnel = new Personnel(rs.getString("nom"), rs.getString("prenom"), service);
                } else {
                    personnel = new Personnel(rs.getString("nom"), rs.getString("prenom"));
                }
            }
        }
        
        terminateConnexion(con, st, rs);
        
        return personnel;
    }
    
    public static ArrayList<Patient> getListePatientFromService(String service, Connection con) throws Exception{
        ArrayList<Patient> listePatients = new ArrayList<>();

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
        
        terminateConnexion(st, rs);
        
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
    
    public static ArrayList<Patient> getListeEntreesFromService(String service, Connection con) throws Exception{
        ArrayList<Patient> listePatients = new ArrayList<>();

        Statement st;
        ResultSet rs;
        String query = 
        "SELECT patient.*, serviceArrivee " + 
        "FROM patient INNER JOIN migration ON migration.IPP = patient.IPP " +
        "WHERE hebergement = 0 AND serviceArrivee = \"" + service + "\" ";
        
        System.out.println(query);
        st = con.createStatement();
        rs = st.executeQuery(query);
        while (rs.next()) {
            String ipp = rs.getString("patient.IPP");
            String nom = rs.getString("nom");
            String prenom = rs.getString("prenom");
            Date dateNaissance =  new Date( rs.getDate("dateNaissance") );
            Sexe sexe = Sexe.valueOf( rs.getString("sexe"));
            String serviceArrivee = rs.getString("serviceArrivee");
            
            Patient p = new Patient(ipp, nom, prenom, dateNaissance, sexe);
            p.setLocalisation( new Localisation(Service.valueOf( serviceArrivee )));
            listePatients.add(p);
        }
        
        terminateConnexion(st, rs);
        
        return listePatients;
    }
    
    public static ArrayList<Patient> getListePatientEnSortieByService(String service, Connection con) throws Exception{
        ArrayList<Patient> listePatients = new ArrayList<>();
        
        Statement st;
        ResultSet rs;
        String query = 
        "SELECT patient.*, numChambre, coteLit, serviceGeographique " + 
        "FROM `DM` INNER JOIN patient ON patient.IPP = DM.IPP " +
        "INNER JOIN localisation ON patient.IPP = localisation.IPP " +
        "WHERE numChambre IS NOT NULL AND dateSortie IS NULL AND lettreSortie IS NOT NULL AND service = \"" + service + "\" ";
        
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
        
        terminateConnexion(st, rs);
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
    
    public static ArrayList<Hebergement> getListeHebergementByService(String service, Connection con) throws Exception{

        ArrayList<Hebergement> liste = new ArrayList<>();
        
        Statement st;
        ResultSet rs;
        String query = 
        "SELECT patient.*, serviceSource, serviceArrivee " + 
        "FROM `migration` " +
        "INNER JOIN patient ON patient.ipp = migration.ipp " +
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
        
        terminateConnexion(st, rs);
        
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
        "WHERE ipp = " + ipp + ";";
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
    
    public static Patient getPatientByNomPrenomDateNaissance(Patient r) throws Exception{
        Patient p = null;
        Connection con = getConnectionToDB();
        Statement st;
        ResultSet rs;
        
        String query = 
        "SELECT * " +
        "FROM patient INNER JOIN adresse ON patient.IPP = adresse.IPP " +
        "WHERE nom = \"" + r.getNom() + 
        "\" AND prenom = \"" + r.getPrenom() + 
         "\" AND dateNaissance = \"" + r.getDateDeNaissance().getDateForQuery() + "\";";
        
        st = con.createStatement();
        rs = st.executeQuery(query);
        
        if (rs.next()) {
            String ipp = rs.getString("IPP");
            String nom = rs.getString("nom");
            String prenom = rs.getString("prenom");
            Date dateNaiss = new Date( rs.getDate("dateNaissance") );
            Sexe sexe = Sexe.valueOf( rs.getString("sexe"));
            String nss = rs.getString("numSecu");
            String mail = rs.getString("adresseMail");
            String medecin = rs.getString("nomPH");
            String nomRue = rs.getString("nomRue");
            String numRue = rs.getString("numRue");
            String cp = rs.getString("codePostal");
            String ville = rs.getString("ville");
            
            Adresse a = new Adresse(ipp, nomRue, numRue, cp, ville);
            p = new Patient(ipp, nom, prenom, dateNaiss, null, sexe, a, nss, mail, medecin);
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

