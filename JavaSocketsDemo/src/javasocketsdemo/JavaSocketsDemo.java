/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javasocketsdemo;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
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
public class JavaSocketsDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            // port 7000 (1-65535, 1-1024 used primarily by OS)
        ServerSocket servSocket = new ServerSocket(7000); 
        // Server now listening on Port 7000, Once client connects to this port
        // a socket is made. Identifies remote port, remote computer, and local port
        System.out.println("Waiting for client to connect...");
       
        Socket connectionSock =  servSocket.accept();
        
        // Used for reading in data from client (reads in chars)
        //BufferedReader clientInput = new BufferedReader(new InputStreamReader(connectionSock.getInputStream()));
        
        // Make a Dataoutputstream object from the server socket to write to
        // the server
        DataOutputStream clientOutput = new DataOutputStream(connectionSock.getOutputStream());
        
        // Reads in ints too
        DataInputStream clientInput = new DataInputStream(connectionSock.getInputStream());
        
        System.out.println("Client's HP is: " + clientInput.readInt());
        
        int input = 0;
        while(input != -1){
            input = clientInput.readInt();
            System.out.println("Client's HP is: " + input);
            
        }
        
        // after processed -1, notify client to close
        if(input == -1){
            clientOutput.writeInt(input);
        }
        
        connectionSock.close();
        clientOutput.close();
        clientInput.close();
            
        } catch (IOException ex) {
            Logger.getLogger(JavaSocketsDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
     
        
    }
    
}
