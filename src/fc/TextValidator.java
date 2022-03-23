/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fc;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Go
 */
public class TextValidator {
    
    public static void consumeNonIntegers(java.awt.event.KeyEvent evt, int length, int max){
        char c = evt.getKeyChar();
        if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
             evt.consume();  // ignorer l'événement
        } else if( (((JTextField) evt.getComponent()).getText().length() == length)) {
            evt.consume();
        }
    }
    public static boolean allFieldsAreFilled(JPanel panel){
        boolean areFilled = true;
        Component[] components = panel.getComponents();
        int i = 0;
        
        while( i < components.length && areFilled){
            Component component = components[i];
            if (component instanceof JTextField && ((JTextField) component).getText().isEmpty()) {
                areFilled = false;
            }
            i++;
        }
        return areFilled;
    }
    
    
    public static boolean isValidDate(String dateStr) {
        DateFormat sdf = new SimpleDateFormat("ddMMyyyy");
        sdf.setLenient(false);
        try {
            sdf.parse(dateStr);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
}
