/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fc;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Go
 */
public class Visite {
    String numeroSejour, IPP, idPh, motif, observation, nomService, type, id, nomPh;
    Date dateEntree, dateSortie;
    List<Prescription> prescriptions;
    List<Prestation> prestations;

    public Visite(){
        this.prestations = new ArrayList<>();
        this.prescriptions = new ArrayList<>();
    }
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
        this.prestations = new ArrayList<>();
        this.prescriptions = new ArrayList<>();
    }

    public List<Prescription> getPrescriptions() {
        return prescriptions;
    }

    public List<Prestation> getPrestations() {
        return prestations;
    }

    public Visite(String numeroSejour, String IPP, String idPh, String motif, String observation, String nomService) {
        this.numeroSejour = numeroSejour;
        this.IPP = IPP;
        this.idPh = idPh;
        this.motif = motif;
        this.observation = observation;
        this.nomService = nomService;
        this.prestations = new ArrayList<>();
        this.prescriptions = new ArrayList<>();
    }
    
    public Visite(String numeroSejour, String IPP, Date date, String nomService ){
        this.numeroSejour = numeroSejour;
        this.IPP = IPP;
        this.dateEntree = date;
        this.nomService = nomService;
        this.prestations = new ArrayList<>();
        this.prescriptions = new ArrayList<>();
    }
    
    public Visite(String numeroSejour, String IPP, Date date, String nomService, String type, String id, String nomPh){
        this.numeroSejour = numeroSejour;
        this.IPP = IPP;
        this.dateEntree = date;
        this.nomService = nomService;
        this.type = type;
        this.id = id;
        this.nomPh = nomPh;
        this.prestations = new ArrayList<>();
        this.prescriptions = new ArrayList<>();
    }
    
    public Visite(String numeroSejour, String IPP, Date date, String nomService, String type, String id, String nomPh, String motif){
        this.numeroSejour = numeroSejour;
        this.IPP = IPP;
        this.dateEntree = date;
        this.nomService = nomService;
        this.type = type;
        this.id = id;
        this.nomPh = nomPh;
        this.motif = motif;
        this.prestations = new ArrayList<>();
        this.prescriptions = new ArrayList<>();
    }
    
    public Visite(String numeroSejour, String IPP, Date date, String nomService, String type, String id, String nomPh, String motif, String observations){
        this.numeroSejour = numeroSejour;
        this.IPP = IPP;
        this.dateEntree = date;
        this.nomService = nomService;
        this.type = type;
        this.id = id;
        this.nomPh = nomPh;
        this.motif = motif;
        this.observation = observations;
        this.prestations = new ArrayList<>();
        this.prescriptions = new ArrayList<>();
    }
    
    public String[] getConsultationForConsultationListe(){
        String[] s = {dateEntree.toString(), type, nomService, numeroSejour, id};
        return s;
    }
    
    public void addPrestation(Prestation p){
        prestations.add(p);
    }
    
    public void addPrescription(Prescription p){
        prescriptions.add(p);
    }

    public String getType() {
        return type;
    }

    public String getNomPh() {
        return nomPh;
    }

    public Date getDateEntree() {
        return dateEntree;
    }

    public Date getDateSortie() {
        return dateSortie;
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
