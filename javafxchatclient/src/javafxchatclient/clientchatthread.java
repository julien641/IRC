/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxchatclient;



import socketconnection.Message;
import socketconnection.Socketwrapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.TextArea;

/**
 *
 * @author julien
 */
public class clientchatthread extends Thread {

    Socketwrapper sw;
    String name;
    TextArea chatarea;

    public clientchatthread() {

    }

    public clientchatthread(Socketwrapper sw, TextArea chatarea) {

        this.sw = sw;
        this.chatarea = chatarea;
    }

    @Override
    public void run() {
        System.out.println("Thread running");
  
            while (true) {
               Message message = sw.receivemessage();
               processmessage(message);
          
            }
    }
    public void processmessage(Message message){
        switch(message.getMessagestype()){
         case name:
            break;
        case chat:
            break;
        case userlist:
            break;
        case connection:
            break;
        
            default:System.out.println("Unknown message type");
        }
        
        

    
    
    
    }
    
    
    

}
