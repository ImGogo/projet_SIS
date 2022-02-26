/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fc;

import java.time.LocalDate;
import java.util.Calendar;

/**
 *
 * @author Go
 */
public class Date {
    int jour, mois , annee;
    
    public Date(java.sql.Date date){
        LocalDate localDate = date.toLocalDate();
        jour = localDate.getDayOfMonth();
        mois = localDate.getMonthValue();
        annee = localDate.getYear();
    }
    public Date(int jour, int mois, int annee) {
        this.jour = jour;
        this.mois = mois;
        this.annee = annee;
    }
    
    public Date(String jour, String mois, String annee) {
        this.jour = Integer.parseInt(jour);
        this.mois = Integer.parseInt(mois);
        this.annee = Integer.parseInt(annee);
    }

    @Override
    public String toString() {
        return String.format("%02d", jour) + "-" + 
               String.format("%02d", mois) + "-" +
               String.format("%02d", annee);
    }

    public int getJour() {
        return jour;
    }

    public int getMois() {
        return mois;
    }

    public int getAnnee() {
        return annee;
    }
    
    
}
