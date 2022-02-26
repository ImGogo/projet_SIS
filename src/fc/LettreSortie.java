/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fc;

import fc.Patient;
import java.util.Date;

/**
 *
 * @author Go
 */
public class LettreSortie {
    Medecin medecin;
    Patient patient;
    Date date;
    Heure heure;
    String texte;

    public LettreSortie(Medecin medecin, Patient patient, Date date, Heure heure, String texte) {
        this.medecin = medecin;
        this.patient = patient;
        this.date = date;
        this.heure = heure;
        this.texte = texte;
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public Patient getPatient() {
        return patient;
    }

    public Date getDate() {
        return date;
    }

    public Heure getHeure() {
        return heure;
    }

    public String getTexte() {
        return texte;
    }
    
    
}
