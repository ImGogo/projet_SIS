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

    public Patient(String ipp, String nom, String prenom, Date dateDeNaissance) {
        this.ipp = ipp;
        this.nom = nom;
        this.prenom = prenom;
        this.dateDeNaissance = dateDeNaissance;
    }
    
    public Patient(String ipp, String nom, String prenom, Date dateDeNaissance, Localisation localisation) {
        this.ipp = ipp;
        this.nom = nom;
        this.prenom = prenom;
        this.dateDeNaissance = dateDeNaissance;
        this.localisation = localisation;
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
    
    public String[] getPatientForPatientList(){
        String [] s = {nom, prenom, dateDeNaissance.toString(), localisation.toString(), ipp};
        return s;
    }

    @Override
    public String toString() {
        return "Patient{" + "ipp=" + ipp + ", nom=" + nom + ", prenom=" + prenom + ", dateDeNaissance=" + dateDeNaissance + '}';
    }
}
