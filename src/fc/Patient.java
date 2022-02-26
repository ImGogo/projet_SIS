package fc;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Patient {

    private String numeroIPP;
    private String nom;
    private String prenom;
    private String dateDeNaissance;
    private Sexe sexe;
    private String medecinGeneraliste;
    private String nomRue;
    private int numeroRue;
    private int codePostal;
    private String ville;
    private String pays;
    private boolean CIC; //true : accepte d'eventuellement etre contacté pour une recherche clinique, false : il n'accepte pas

    //constructeur pour générer un numéro IPP
    public Patient(String nom, String prenom, String dateDeNaissance, Sexe sexe, String medecinGeneraliste, String nomRue, int numeroRue, int codePostal, String ville, String pays, int compteurIpp) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateDeNaissance = dateDeNaissance;
        this.sexe = sexe;
        this.medecinGeneraliste = medecinGeneraliste;
        this.nomRue = nomRue;
        this.numeroRue = numeroRue;
        this.codePostal = codePostal;
        this.ville = ville;
        this.pays = pays;

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Calendar c = Calendar.getInstance();
        //System.out.println("Date de création du patient : " + dateFormat.format(c.getTime()) + "\n");
        numeroIPP = creerIpp(c, compteurIpp);
    }

    //constructeur sans numéro IPP
    public Patient(String nom, String prenom, String dateDeNaissance, Sexe sexe, String medecinGeneraliste, String nomRue, int numeroRue, int codePostal, String ville, String pays) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateDeNaissance = dateDeNaissance;
        this.sexe = sexe;
        this.medecinGeneraliste = medecinGeneraliste;
        this.nomRue = nomRue;
        this.numeroRue = numeroRue;
        this.codePostal = codePostal;
        this.ville = ville;
        this.pays = pays;
    }

    //constructeur avec numéro IPP déjà existant
    public Patient(String numeroIPP, String nom, String prenom, String dateDeNaissance, Sexe sexe, String medecinGeneraliste, String nomRue, int numeroRue, int codePostal, String ville, String pays) {
        this.numeroIPP = numeroIPP;
        this.nom = nom;
        this.prenom = prenom;
        this.dateDeNaissance = dateDeNaissance;
        this.sexe = sexe;
        this.medecinGeneraliste = medecinGeneraliste;
        this.nomRue = nomRue;
        this.numeroRue = numeroRue;
        this.codePostal = codePostal;
        this.ville = ville;
        this.pays = pays;
    }

    //constructeur pour vérifier dans le CIC qu'un patient correspond à une étude
    public Patient(String nom, String prenom, String dateDeNaissance, Sexe sexe) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateDeNaissance = dateDeNaissance;
        this.sexe = sexe;
    }

    //constructeur pour ajouter un volontaire sain
    public Patient(String nom, String prenom, String dateDeNaissance, Sexe sexe, String nomRue, int numeroRue, int codePostal, String ville, String pays) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateDeNaissance = dateDeNaissance;
        this.sexe = sexe;
        this.nomRue = nomRue;
        this.numeroRue = numeroRue;
        this.codePostal = codePostal;
        this.ville = ville;
        this.pays = pays;
    }
    
    

    public String creerNumVisite(Calendar c, int compteurNumVisite) {
        //On récupère les deux derniers chiffres de l'année
        int annee = c.get(Calendar.YEAR);
        int unite = annee % 10;
        annee = (annee - unite) / 10;
        int dizaine = annee % 10;

        String numVisite = String.valueOf(dizaine) + String.valueOf(unite);

        //On récupère le mois en cours
        int mois = c.get(Calendar.MONTH);
        numVisite += String.valueOf(mois);

        //On écrit des 0 pour compléter le compteur sur 5 positions
        int num = String.valueOf(compteurNumVisite).length();
        for (int i = 1; i < (6 - num); i++) {
            numVisite = numVisite + "0";
        }

        //On complète le numéro de séjour avec le compteur
        numVisite += compteurNumVisite;
        compteurNumVisite++;

        return numVisite;
    }

    public void afficherAdresse() {
        System.out.println("Adresse du patient " + nom + " " + prenom);
        System.out.println(numeroRue + " " + nomRue);
        System.out.println(codePostal + " " + ville);
        System.out.println(pays + "\n");
    }

    public void resumerPatient() {
        System.out.println(nom + " " + prenom);
        System.out.println("Numero IPP : " + numeroIPP);
        System.out.println("Date de naissance : " + dateDeNaissance);
        System.out.println("Sexe : " + sexe);
        System.out.println("Medecin generaliste : Dr " + medecinGeneraliste + "\n");
    }

    public String creerIpp(Calendar c, int compteurIpp) {
        int annee = c.get(Calendar.YEAR);
        int unite = annee % 10;
        annee = (annee - unite) / 10;
        int dizaine = annee % 10;

        String numeroIpp = String.valueOf(dizaine) + String.valueOf(unite);

        int num = String.valueOf(compteurIpp).length();

        for (int i = 1; i < (8 - num); i++) {
            numeroIpp = numeroIpp + "0";
        }
        numeroIpp = numeroIpp + compteurIpp;
        compteurIpp++;
        return numeroIpp;
    }

    public int getEtage(int chambre) {
        int etage;
        int unite = chambre % 10;
        chambre = (chambre - unite) / 10;
        int dizaine = chambre % 10;
        chambre = (chambre - dizaine) / 10;
        etage = chambre % 10;
        return etage;
    }

//------------GETTER ET SETTER--------------
    public String getNumeroIPP() {
        return numeroIPP;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getDateDeNaissance() {
        return dateDeNaissance;
    }

    public Sexe getSexe() {
        return sexe;
    }

    public String getMedecinGeneraliste() {
        return medecinGeneraliste;
    }

    public String getNomRue() {
        return nomRue;
    }

    public int getNumeroRue() {
        return numeroRue;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public String getVille() {
        return ville;
    }

    public String getPays() {
        return pays;
    }

    public boolean isCIC() {
        return CIC;
    }

    public void setNumeroIPP(String numeroIPP) {
        this.numeroIPP = numeroIPP;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDateDeNaissance(String dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }

    public void setMedecinGeneraliste(String medecinGeneraliste) {
        this.medecinGeneraliste = medecinGeneraliste;
    }

    public void setNomRue(String nomRue) {
        this.nomRue = nomRue;
    }

    public void setNumeroRue(int numeroRue) {
        this.numeroRue = numeroRue;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public void setCIC(boolean CIC) {
        this.CIC = CIC;
    }

}
