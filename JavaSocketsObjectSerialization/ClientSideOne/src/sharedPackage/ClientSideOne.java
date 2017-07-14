/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sharedPackage;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ben
 */
public class ClientSideOne {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        
        String hostName = "localhost";
        int port = 7000;
        
        try {
            Socket connectionSock = new Socket(hostName,port);
            Scanner keyboard = new Scanner(System.in);
            
            
            
            Account kingBob = new Account(99,76,"King Bob");
            
            ObjectOutputStream objectOS = new ObjectOutputStream(connectionSock.getOutputStream());
            
            // First Object is already defined, the rest the user updates the HP
            // then sends the updated Object to the server
            while(true){
                    
            objectOS.reset(); // Disgregard any objects already written to stream
            System.out.println(kingBob.currentHP);
            objectOS.writeObject(kingBob);
            
            System.out.println("Update HP");
            Random rand = new Random(System.currentTimeMillis());
            int newHP = rand.nextInt(99) + 1;
            kingBob.updateCurrentHP(newHP);
                try {
                    Thread.sleep(5);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ClientSideOne.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            }
            
        } catch (IOException ex) {
            Logger.getLogger(ClientSideOne.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
      
        
    }
    
}
