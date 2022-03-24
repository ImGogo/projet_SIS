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
    
    public Localisation(String numChambre, CoteLit coteLit){
        this.numChambre = Integer.parseInt(numChambre);
        this.coteLit = coteLit;
    }
    
    public Localisation(Service serviceOrigine) {
        this.serviceOrigine = serviceOrigine;
    }
    
    public Service getServiceOrigine() {
        return this.serviceOrigine;
    }
    
    public int getNumChambre(){
        return this.numChambre;
    }
    public String getNumChambreString(){
        return Integer.toString(numChambre);
    }
    
    public CoteLit getCoteLit(){
        return coteLit;
    }

    @Override
    public String toString() {
        return String.format("%03d", numChambre) + coteLit.toString() + "-" + serviceGeographique.getVal();
    }
    
    
}
