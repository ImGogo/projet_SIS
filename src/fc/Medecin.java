/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fc;

/**
 *
 * @author Go
 */
public class Medecin {
    String nom, prenom;
    Specialite specialite;

    public Medecin(String nom, String prenom, Specialite specialite) {
        this.nom = nom;
        this.prenom = prenom;
        this.specialite = specialite;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Specialite getSpecialite() {
        return specialite;
    }
    
    
}
