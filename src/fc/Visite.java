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
public class Visite {
    String numeroSejour, IPP, idPh, motif, observation, nomService, type, id, nomPh;

    public Visite(String numeroSejour, String IPP, String idPh, String motif, String observation, String nomService, String type, String id, String nomPh, Date dateEntree, Date dateSortie) {
        this.numeroSejour = numeroSejour;
        this.IPP = IPP;
        this.idPh = idPh;
        this.motif = motif;
        this.observation = observation;
        this.nomService = nomService;
        this.type = type;
        this.id = id;
        this.nomPh = nomPh;
        this.dateEntree = dateEntree;
        this.dateSortie = dateSortie;
    }
    Date dateEntree, dateSortie;

    public Visite(String numeroSejour, String IPP, String idPh, String motif, String observation, String nomService) {
        this.numeroSejour = numeroSejour;
        this.IPP = IPP;
        this.idPh = idPh;
        this.motif = motif;
        this.observation = observation;
        this.nomService = nomService;
    }
    
    public Visite(String numeroSejour, String IPP, Date date, String nomService ){
        this.numeroSejour = numeroSejour;
        this.IPP = IPP;
        this.dateEntree = date;
        this.nomService = nomService;
    }
    
    public Visite(String numeroSejour, String IPP, Date date, String nomService, String type, String id){
        this.numeroSejour = numeroSejour;
        this.IPP = IPP;
        this.dateEntree = date;
        this.nomService = nomService;
        this.type = type;
        this.id = id;
    }
    
    public String[] getConsultationForConsultationListe(){
        String[] s = {dateEntree.toString(), type, nomService, numeroSejour, id.toString()};
        return s;
    }
    public String getNumeroSejour() {
        return numeroSejour;
    }

    public String getIPP() {
        return IPP;
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
