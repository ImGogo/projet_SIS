/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fc;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;

/**
 *
 * @author Go
 */
public class Date {
    int jour, mois, annee;
    int heure, minute;
    
    public Date(){
        LocalDateTime ldt = LocalDateTime.now();
        
        jour = ldt.getDayOfMonth();
        mois = ldt.getMonthValue();
        annee = ldt.getYear();
        heure = ldt.getHour();
        minute = ldt.getMinute();
    }
    
    public Date(java.sql.Date date){
        
        LocalDate localDate = date.toLocalDate();
        jour = localDate.getDayOfMonth();
        mois = localDate.getMonthValue();
        annee = localDate.getYear();
        
    }
    
    public Date(java.sql.Timestamp ts){
        LocalDateTime ldt = ts.toLocalDateTime();
        
        jour = ldt.getDayOfMonth();
        mois = ldt.getMonthValue();
        annee = ldt.getYear();
        heure = ldt.getHour();
        minute = ldt.getMinute();
        
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
    
    public Date(String jour, String mois, String annee, String heure, String minute) {
        this.jour = Integer.parseInt(jour);
        this.mois = Integer.parseInt(mois);
        this.annee = Integer.parseInt(annee);
        this.heure = Integer.parseInt(heure);
        this.minute = Integer.parseInt(minute);
    }

    @Override
    public String toString() {
        return String.format("%02d", jour) + " / " + 
               String.format("%02d", mois) + " / " +
               String.format("%04d", annee);
    }
    
    public String getDateHeure(){
        return this.toString() + " " + getHeureMinute();
    }
    
    public String getHeureMinute(){
        return String.format("%02d", heure) + ":" + String.format("%02d", minute);
    }
    
    public String getDateForQuery() {
        return annee + "-" + mois + "-" + jour;
    }

    public int getJour() {
        return jour;
    }
    
    public String getJourString(){
        return String.format("%02d", jour);
    }

    public int getMois() {
        return mois;
    }
    
    public String getMoisString(){
        return String.format("%02d", mois);
    }

    public int getAnnee() {
        return annee;
    }
    
    public String getAnneeString(){
        return String.format("%04d", annee);
    }
    
    public String getHeureString(){
        return String.format("%02d", heure);
    }
    
    public String getMinuteString(){
        return String.format("%02d", minute);
    }
    
    public String getAgeString(){
        LocalDate now = LocalDate.now();
        LocalDate dat = LocalDate.of(annee, Month.of(mois), jour);
        
        return Integer.toString( Period.between(dat, now).getYears() );
    }
}
