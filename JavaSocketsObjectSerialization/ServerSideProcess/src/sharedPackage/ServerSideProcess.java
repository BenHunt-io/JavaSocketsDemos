/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sharedPackage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ben
 */
public class ServerSideProcess {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here

            ServerSocket serverSock = new ServerSocket(7000);
            System.out.println("Waiting for connection from client");
            Socket connectionSock = serverSock.accept();
            
            ObjectInputStream objectIS = new ObjectInputStream(connectionSock.getInputStream());
            
            int count = 0;
            while(true){
                
                System.out.println(count++);
                Account account1 = (Account) objectIS.readObject();
                account1.display();
                
            }
            
            
            
            
            
            
            
            
            
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(ServerSideProcess.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServerSideProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }
    
}
