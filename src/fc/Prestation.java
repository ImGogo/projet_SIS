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
public class Prestation {
    private String prestation, observations;
    private Service service;
    
    public Prestation(String prestation, Service service) {
        this.prestation = prestation;
        this.service = service;
    }

    public Prestation(String prestation, Service service, String observations) {
        this.prestation = prestation;
        this.service = service;
        this.observations = observations;
    }
    
    public String[] getPrestationForTable(){
        return new String[] {prestation, service.getVal()};
    }
    public String getPrestation() {
        return prestation;
    }

    

    public Service getService() {
        return service;
    }

    public String getObservations() {
        return observations;
    }
    
    
}
