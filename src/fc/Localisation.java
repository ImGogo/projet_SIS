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
public class Localisation {
    int numChambre;
    CoteLit coteLit;
    Service serviceOrigine, serviceGeographique;

    public Localisation(int numChambre, CoteLit coteLit, Service serviceOrigine, Service serviceGeographique) {
        this.numChambre = numChambre;
        this.coteLit = coteLit;
        this.serviceOrigine = serviceOrigine;
        this.serviceGeographique = serviceGeographique;
    }

    @Override
    public String toString() {
        return String.format("%03d", numChambre) + coteLit.toString() + "-" + serviceGeographique.getVal();
    }
    
    
}
