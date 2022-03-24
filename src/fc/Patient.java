package fc;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Patient {

    private String ipp;
    private String nom;
    private String prenom;
    private Date dateDeNaissance;
    private Sexe sexe;
    private String medecinGeneraliste;
    private Localisation localisation;
    private String email;
    private String nss;
    private Adresse adresse;

    public Patient(String ipp, String nom, String prenom, Date dateDeNaissance) {
        this.ipp = ipp;
        this.nom = nom;
        this.prenom = prenom;
        this.dateDeNaissance = dateDeNaissance;
    }
    
    public Patient(String nom, String prenom, Date dateDeNaissance, Localisation localisation, Sexe sexe, Adresse adresse, String nss, String email, String medecin) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateDeNaissance = dateDeNaissance;
        this.localisation = localisation;
        this.sexe = sexe;
        this.adresse = adresse;
        this.nss = nss;
        this.medecinGeneraliste = medecin;
        this.email = email;
        this.ipp = generateIPP();
    }
    
     public Patient(String ipp, String nom, String prenom, Date dateDeNaissance, Localisation localisation, Sexe sexe, Adresse adresse, String nss, String email, String medecin) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateDeNaissance = dateDeNaissance;
        this.localisation = localisation;
        this.sexe = sexe;
        this.adresse = adresse;
        this.nss = nss;
        this.medecinGeneraliste = medecin;
        this.email = email;
        this.ipp = ipp;
    }
    
    public Patient(String ipp, String nom, String prenom, Date dateDeNaissance, Localisation localisation, Sexe sexe) {
        this.ipp = ipp;
        this.nom = nom;
        this.prenom = prenom;
        this.dateDeNaissance = dateDeNaissance;
        this.localisation = localisation;
        this.sexe = sexe;
    }

    public Patient(String ipp, String nom, String prenom, Date dateDeNaissance, Sexe sexe) {
        this.ipp = ipp;
        this.nom = nom;
        this.prenom = prenom;
        this.dateDeNaissance = dateDeNaissance;
        this.sexe = sexe;
        
    }
    
    public final String generateIPP(){
        String id = nom + prenom + dateDeNaissance.getJour() + dateDeNaissance.getMois()+ dateDeNaissance.getAnnee();
        return Integer.toString( java.lang.Math.abs(id.hashCode()) );
    }
    
    public void setIpp(String ipp){
        this.ipp = ipp;
    }
    
    public String getIpp() {
        return ipp;
    }

    public String getNom() {
        return nom;
    }
    
    public String getNomFormat() {
        return nom.toUpperCase();
    }

    public String getPrenom() {
        return prenom;
    }
    
    public String getPrenomFormat() {
        return prenom.substring(0,1).toUpperCase() + prenom.substring(1).toLowerCase();
    }

    public Date getDateDeNaissance() {
        return dateDeNaissance;
    }

    public Sexe getSexe() {
        return sexe;
    }

    public String getMedecinGeneraliste() {
        return medecinGeneraliste;
    }

    public Localisation getLocalisation() {
        return localisation;
    }
    
    public String getNomPrenomFormat(){
        return nom.toUpperCase() + " " + prenom.substring(0, 1).toUpperCase() + prenom.substring(1);
    }
    
    
    public String[] getPatientForPatientList(){
        return new String[] {nom, prenom, dateDeNaissance.toString(), localisation.toString(), ipp};
    }
    
    public String[] getPatientForConsultationList(){
        return new String[] {nom, prenom, dateDeNaissance.toString(), dateDeNaissance.getHeureMinute(), ipp};
    }
    
    public Adresse getAdresse(){
        return this.adresse;
    }
    
    public static boolean verifyINSEE(String numINSEE) {
        if (numINSEE.length() != 15) {
            return false;
        } else {
            String firstPart = numINSEE.substring(0, 13);
            String cle = numINSEE.substring(13);
            double fp = Double.parseDouble(firstPart);
            double verifCle = Double.parseDouble(cle);
            double calculCle=97-(fp%97);
            return verifCle==calculCle;
        }
    }

    public String getEmail() {
        return email;
    }

    public String getNss() {
        return nss;
    }
    
    @Override
    public String toString() {
        return getNomPrenomFormat() + " (" + sexe.toString() + "-" + dateDeNaissance.getAgeString() + ")";
    }
    
    public String getNomPrenomAndIpp(){
        return this.getNomFormat() + " " + this.getPrenomFormat() + " (" + this.ipp + ")";
    }
    
    public static Patient generateAnonymousPatient(){
        Date d = new Date();
        Patient p = new Patient( null, d.getMinuteString(), d.getHeureString(), d);
        p.setIpp( p.generateIPP() );
        return p;
    }
    
    public void setLocalisation(Localisation localisation) {
        this.localisation = localisation;
    }
}
