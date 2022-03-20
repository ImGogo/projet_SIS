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
public enum Service {
    Cardiologie("CARD"),
    Anesthesie("ANES"),
    Diabétologie("DIAB"),
    Soins_paliatifs("SPAL"),
    Gynecologie_Obstetrique("GYNO"),
    Hepato_gastroentérologie("GAST"),
    Maladies_infectieuses_tropicales("MINF"),
    Medecine_du_sport("SPRT"),
    Neurologie("NEUR"),
    Oncologie("ONCO"),
    Ophtalmologie("OPHT"),
    ORL("ORL"),
    Pediatrie("PEDT"),
    Pneumologie("PNEM"),
    Rhumatologie("RHUM"),
    Imagerie("IMAG"),
    Laboratoire_Biologie_Medicale("BIOM"),
    Laboratoire_Anatomie_Cytologie("ANAC");

    
    private final String val;
    
    Service(String val){
        this.val = val;
    }
    
    public String getVal(){
        return this.val;
    }
}
