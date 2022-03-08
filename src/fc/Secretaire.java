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
public class Secretaire extends Personnel{

    public Secretaire(String nom, String prenom) {
        super(nom, prenom);
    }

    @Override
    public String toString() {
        return nom.toUpperCase() + " " + prenom;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }
    
    
}
