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
public class Prescription {
    String medicament, dose, posologie;
    Date dateDebut, dateFin;

    public Prescription(String medicament, String dose, String posologie, Date dateDebut, Date dateFin) {
        this.medicament = medicament;
        this.dose = dose;
        this.posologie = posologie;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }
    
    public String[] getPrescriptionForTable(){
        String[] s = {medicament, dose, posologie, dateDebut.toString(), dateFin.toString()};
        return s;
    }

    public String getMedicament() {
        return medicament;
    }

    public String getDose() {
        return dose;
    }

    public String getPosologie() {
        return posologie;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }
    
    
}
