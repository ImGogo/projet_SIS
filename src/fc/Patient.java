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
    private Adresse adresse;

    public Patient(String ipp, String nom, String prenom, Date dateDeNaissance) {
        this.ipp = ipp;
        this.nom = nom;
        this.prenom = prenom;
        this.dateDeNaissance = dateDeNaissance;
    }
    
    public Patient(String nom, String prenom, Date dateDeNaissance, Localisation localisation, Sexe sexe, Adresse adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateDeNaissance = dateDeNaissance;
        this.localisation = localisation;
        this.sexe = sexe;
        this.adresse = adresse;
        this.ipp = generateIPP();
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
    
    public String generateIPP(){
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

    public String getPrenom() {
        return prenom;
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
    @Override
    public String toString() {
        return getNomPrenomFormat() + " (" + sexe.toString() + "-" + dateDeNaissance.getAgeString() + ")";
    }
}
