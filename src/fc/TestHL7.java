/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fc;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.logging.Level;
import java.util.logging.Logger;
import library.interfaces.ServeurHL7;

/**
 *
 * @author Go
 */
public class TestHL7 {
    
    private static final int port = 4444;
    /**
     * @param args the command line arguments
     */
    private static void startClient() {
        library.interfaces.Patient p = new library.interfaces.Patient( 123, "nomPatient", 'C');
        
        p.setSex('F');
        p.setFirstName("Patient admis");
        library.interfaces.ClientHL7 c = new library.interfaces.ClientHL7();
        c.connexion("localhost", port);
        c.admit(p);
        
        System.out.println( c.getMsg() + " toto" );
        c.close();
    }
    
    private static void startServer(){
        ServeurHL7 serveur = new ServeurHL7();
        serveur.connection(port);
        serveur.ecoute();
        String msg = serveur.protocole();
        
        System.out.println( serveur.getPatient().getFirstName() );
    }
    public static void main(String[] args) {
          Thread threadServer = new Thread(){
                @Override
                public void run(){
                    startServer();
                }
          };
          Thread threadClient = new Thread(){
                @Override
                public void run(){
                    startClient();
                }
          };
        
//          threadClient.start();
          threadServer.start();
    }
    
    
    
}
