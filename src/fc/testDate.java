/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fc;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Calendar;

/**
 *
 * @author Go
 */
public class testDate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) { 
        
        Date d = new Date(8, 9, 1999);
        System.out.println( d.getAgeString() );
    }
    
}
