package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("server avviato");
        ServerSocket s1 = new ServerSocket(9000);
        Socket s = s1.accept();
        System.out.println("un client si è collegato");
        BufferedReader in= new BufferedReader(new InputStreamReader(s.getInputStream()));
        DataOutputStream out = new DataOutputStream(s.getOutputStream());

        
        while (true) 
        
        {
            String stringaRicevuta=in.readLine();
            System.out.println("La stringa ricevuta "+ stringaRicevuta);

            String stringaMaiuscola=stringaRicevuta.toUpperCase();
            
            if(stringaRicevuta.equals("!"))
            
            break;
            
            out.writeBytes(stringaMaiuscola+'\n');
            
            
            
        
        }
        System.out.println("CONNESSIONE INTERROTTA");
       
        s.close();
        s1.close();
    }
}