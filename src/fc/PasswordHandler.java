/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fc;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/**
 *
 * @author Go
 */
public class PasswordHandler {
    
    public static String encryptPass(String password) {
        try {
            MessageDigest digestor = MessageDigest.getInstance("SHA-256");//retrieve bytes to encrypt
            byte[] encodedhash = digestor.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder encryptionValue = new StringBuilder(2 * encodedhash.length);//perform encryption
            for (int i = 0; i < encodedhash.length; i++) {
                String hexVal = Integer.toHexString(0xff & encodedhash[i]);
                if (hexVal.length() == 1) {
                    encryptionValue.append('0');
                }
                encryptionValue.append(hexVal);
            }
            return encryptionValue.toString();} catch (Exception ex) {
            return ex.getMessage();
        }
    }
    
    public static boolean isEqual(String inputPass, String dbPass){
        return encryptPass(inputPass).equals(dbPass);
    }
}
