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
public class Personnel {
    String nom, prenom;
    Service service;
    public Personnel(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public Personnel(String nom, String prenom, Service service) {
        this.nom = nom;
        this.prenom = prenom;
        this.service = service;
    }

    @Override
    public String toString() {
        return nom.toUpperCase() + " " + prenom.substring(0,1).toUpperCase() + prenom.substring(1).toLowerCase();
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Service getService() {
        return service;
    }
    
    
}
