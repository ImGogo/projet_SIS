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
public class Adresse {
    String IPP, nomRue, numRue, codePostal, Ville;

    public Adresse(String IPP, String nomRue, String numRue, String codePostal, String Ville) {
        this.IPP = IPP;
        this.nomRue = nomRue;
        this.numRue = numRue;
        this.codePostal = codePostal;
        this.Ville = Ville;
    }

    public String getIPP() {
        return IPP;
    }

    public String getNomRue() {
        return nomRue;
    }

    public String getNumRue() {
        return numRue;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public String getVille() {
        return Ville;
    }
    
    
}
