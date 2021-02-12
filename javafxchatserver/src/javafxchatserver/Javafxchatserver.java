/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxchatserver;



import java.sql.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import socketconnection.Socketwrapper;


/**
 *
 * @author julien
 */
public class Javafxchatserver {

    ArrayList<chatthread> chatthreads;

    public Javafxchatserver() {
        chatthreads = new ArrayList<>();

    }

    public void start() {
        ServerSocket serversocket;
        
        Connection sqlite= null;
        try {
         Class.forName("org.sqlite.JDBC");
         sqlite = DriverManager.getConnection("jdbc:sqlite:test.db");
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
        try {
            serversocket = new ServerSocket(4999);
            while (true) {
                System.out.println("loop");
                Socket s = serversocket.accept();
                Socketwrapper sw = new Socketwrapper(); 
                sw.connect(s);
                chatthread chat = new chatthread(sw);
                chatthreads.add(chat);
                chat.start();

            }

            
            
            
        } catch (IOException e) {
            System.out.println("IOException");
            System.out.println(e.toString());
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Javafxchatserver server = new Javafxchatserver();
        server.start();

    }

}
