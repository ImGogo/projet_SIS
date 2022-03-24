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
    Accueil("ACCL"),
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
    Urgences("URGC"),
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

    @Override
    public String toString() {
        return this.name().replace("_", " ");
    }
    
    public static Service[] values(Service req) {
        Service[] values = Service.values();
        Service[] newValues = new Service[values.length-3];
        int i = 0;
        int j = 0;
        while ( i < values.length ) {
            if( !values[i].getVal().equals(req.getVal()) && !values[i].getVal().equals("ACCL") && !values[i].getVal().equals("URGC")){
                newValues[j] = values[i];
                j++;
            } 
            i++;
        }
        return newValues;
    }
}
