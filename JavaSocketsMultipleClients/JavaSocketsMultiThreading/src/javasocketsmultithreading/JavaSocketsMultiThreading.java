/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javasocketsmultithreading;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ben
 */
public class JavaSocketsMultiThreading {

    public static int clientCount = 0;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            // TODO code application logic here
            ServerSocket serverSock = new ServerSocket(5000);
            while(true){
                System.out.println("Waiting for client " + clientCount + " to connect");
                new Handler(serverSock.accept(), clientCount++);
            }
        } catch (IOException ex) {
            Logger.getLogger(JavaSocketsMultiThreading.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
 
}

class Handler implements Runnable{
        
        Socket connectionSock;
        int clientNumber;

        public Handler(Socket connectionSock, int clientNumber){
            
            System.out.println();
            this.connectionSock = connectionSock;
            this.clientNumber = clientNumber;
            new Thread(this).start(); // Starts the thread with "this" Runnable
            System.out.println("Client " + clientNumber + " Connected");
        }
        
        @Override
        public void run() {
            
            try {
                BufferedReader clientInput = new BufferedReader(new InputStreamReader
                                        (this.connectionSock.getInputStream()));
                
                while(true){
                    String input = clientInput.readLine();
                    System.out.println("Client " + clientNumber + " says: " +
                            input);
                    
                    if(input.contains("quit")){
                        connectionSock.close();
                        break;
                    }
                    
                }
                
                
            } catch (IOException ex) {
                Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
}
