/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxchatclient;

import clientMessage.Message;
import clientMessage.messageLogin;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import socketconnection.RC;
import socketconnection.Socketwrapper;

/**
 *
 * @author julien
 */
public class ConnectButton implements EventHandler{
    private final NewChattabController newChattabController;
    private final TabPane tabPane;
    private  ChattabController chattabController;
    
    
    public ConnectButton(NewChattabController newChattabController,TabPane tabPane){
        this.newChattabController =newChattabController;
        this.tabPane= tabPane;
    }
    
 
    
    @Override
    public void handle(Event event) {
        Tab server;
        BorderPane borderPane =null;
        FXMLLoader Chattabloader;
        String username = newChattabController.getUsernameNewChatTab().getText();
        String password = newChattabController.getPasswordNewChatTab().getText(); 
        String hostname = newChattabController.getHostnameNewChatTab().getText();
        String port     = newChattabController.getPortNewChatTab().getText();
        
        Socketwrapper sw = new Socketwrapper();
        clientchatthread chat;
        if(verifytextfields(username,port,hostname,password)){
            int numberport=Integer.valueOf(port);
            RC rc = sw.connect(hostname, numberport);
            if(rc==RC.success){
                sw.sendMessage(new messageLogin(username,username,password));
                Message m=(Message)sw.receivemessage();
               
               
                try {
                    Chattabloader = new FXMLLoader(getClass().getResource("Chattab.fxml"));
                      System.out.println("loading");
                    borderPane = Chattabloader.load();
                    chattabController = Chattabloader.<ChattabController>getController();
                      System.out.println("controller");
                    
                } catch (IOException ex) {
                    Logger.getLogger(ConnectButton.class.getName()).log(Level.SEVERE, null, ex);
                } 
                System.out.println("tab");
                server = new Tab(hostname,borderPane); 
                tabPane.getTabs().add(server);
                System.out.println("out");
            }else{
            
            
            }
            
            
        }else{
        //TODO
        
        }
        
      
        
        
      
    }

    
    
    
    
    public boolean verifytextfields(String Username,String port,String host,String password){
        //TODO
    return true;
    }
    
    
    
    
}
