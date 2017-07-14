/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javasocketclientsidedemo;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ben
 */
public class JavaSocketClientSideDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        try{
            // for network communication on the same computer
            String hostName = "localhost";
            int port = 7000; // Port of the Server to connect to
            
            // Create the clientSide Socket
            System.out.println("Connecting to server...");
            // Clients port number is assigned by the system. (For the server
            // to communicate back to the client)
            Socket connectionSock = new Socket(hostName,7000);
            
            // Make a Dataoutputstream object from the client socket to write to
            // the server
            DataOutputStream serverOutput = new DataOutputStream(connectionSock.getOutputStream());
            
            // Used for reading in data from Server (reads in chars)
//            BufferedReader serverInput = new BufferedReader(new InputStreamReader(connectionSock.getInputStream()));
            
            DataInputStream serverInput = new DataInputStream(connectionSock.getInputStream());
            
            serverOutput.writeInt(99);
            
            // input from server, wait till it writes back confirming it processed
            // -1 and can close
            int input = 0;
            while(input != -1){
                Scanner userInput = new Scanner(System.in);
                input = userInput.nextInt();
                serverOutput.writeInt(input);
            }
            
            // if the server outputs -1 back to client, it means it's processed and can close
            input = serverInput.readInt();
            if(input == -1){
                System.out.println("Server says I should close.. closing");
                connectionSock.close();
                serverInput.close();
                serverOutput.close();
            }
            
          
            
            
        } catch (IOException ex) {
            Logger.getLogger(JavaSocketClientSideDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
