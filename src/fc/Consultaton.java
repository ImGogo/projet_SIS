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
public class Consultaton {
    String numeroSejour, IPP, nomPH, motif, observation, nomService;

    public Consultaton(String numeroSejour, String IPP, String nomPH, String motif, String observation, String nomService) {
        this.numeroSejour = numeroSejour;
        this.IPP = IPP;
        this.nomPH = nomPH;
        this.motif = motif;
        this.observation = observation;
        this.nomService = nomService;
    }

    public String getNumeroSejour() {
        return numeroSejour;
    }

    public String getIPP() {
        return IPP;
    }

    public String getNomPH() {
        return nomPH;
    }

    public String getMotif() {
        return motif;
    }

    public String getObservation() {
        return observation;
    }

    public String getNomService() {
        return nomService;
    }
}
