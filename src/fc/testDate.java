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
        for(Service s: Service.values(Service.Urgences)) {
            System.out.println(s);
        }
    }
    
}
