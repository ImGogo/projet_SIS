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
public class Hebergement {
    Patient patient;
    String serviceSource, serviceArrivee;
    
    public Hebergement(Patient patient, String serviceSource, String serviceArrivee){
        this.patient = patient;
        this.serviceArrivee = serviceArrivee;
        this.serviceSource = serviceSource;
    }

    public Patient getPatient() {
        return patient;
    }

    public String getServiceSource() {
        return serviceSource;
    }

    public String getServiceArrivee() {
        return serviceArrivee;
    }
    
    
}
