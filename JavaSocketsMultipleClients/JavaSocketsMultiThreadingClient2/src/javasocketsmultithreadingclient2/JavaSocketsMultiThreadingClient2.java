/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javasocketsmultithreadingclient2;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ben
 */
public class JavaSocketsMultiThreadingClient2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
     
        String host = "localhost"; // if not local would use IP (could use local IP)
        int port = 5000;
        
        try {
            Socket connectionSock = new Socket(host,port);
            
            
            PrintWriter serverOutput = new PrintWriter(connectionSock.getOutputStream(),true);
           
            serverOutput.println(" I'm a a new client that loves sockkeetts");
            
            while(true){
                Scanner keyboard = new Scanner(System.in);
                String input = keyboard.nextLine();
                serverOutput.println(input);
                
            }
            
            
            
            
          
        } catch (IOException ex) {
            Logger.getLogger(JavaSocketsMultiThreadingClient2.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }
}
