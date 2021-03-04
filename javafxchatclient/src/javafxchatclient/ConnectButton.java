/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxchatclient;

import Interface.client.IChatTabController;
import clientMessage.MessageLogin;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafxchatclient.thread.ChatThreadController;


import socketconnection.Login;
import socketconnection.RC;
import socketconnection.Socketwrapper;

/**
 *
 * @author julien
 */
public class ConnectButton implements EventHandler{
    private final NewChattabController newChattabController;
    private final TabPane tabPane;

    
    public ConnectButton(NewChattabController newChattabController,TabPane tabPane){
        this.newChattabController =newChattabController;
        this.tabPane= tabPane;
    }
    
 
    
    @Override
    public void handle(Event event) {
        Login login =setLogin(newChattabController);
       if(login != null) {
               Socketwrapper sw = new Socketwrapper();

               RC rc = sw.connect(login.getIp(), login.getPort());
               if(rc ==RC.success){
                   ChatThreadController chatThreadController = new ChatThreadController();
                   chatThreadController.setSw(sw);
                   MessageLogin messageLogin=new MessageLogin(login.getUsername(), login.getPassword());
                   chatThreadController.getMts().addMessage(messageLogin);



               }else {
                   //connection failed
                   //TODO Display message to the user for the failed connection

               }

           } else {
               //TODO Display message to the user for invalid credential

           }
       }
      
        
        
      
    public Login setLogin(NewChattabController newChattabController){
        String username = newChattabController.getUsernameNewChatTab().getText();
        String password = newChattabController.getPasswordNewChatTab().getText();
        String hostname = newChattabController.getHostnameNewChatTab().getText();
        String port     = newChattabController.getPortNewChatTab().getText();
        Login login = null;
        if(verifyTextFields(username,port,hostname,password)){
             login= new Login(username,password,Integer.valueOf(port),hostname);


        }
      return login;


    }

    public void chatTabLoader(ChatThreadController chatThreadController){
        FXMLLoader Chattabloader =null;
        Tab server =null;
        BorderPane borderPane =null;
        ChattabController chattabController =null;
        try {
            Chattabloader = new FXMLLoader(getClass().getResource("Chattab.fxml"));
            borderPane = Chattabloader.load();
            chattabController = Chattabloader.<ChattabController>getController();
            chatThreadController.setChattabController( chattabController);
            server = new Tab(chatThreadController.getLogin().getIp(),borderPane);
            chatThreadController.setTab(server);
            tabPane.getTabs().add(tabPane.getTabs().size()-1,server);

        } catch (IOException ex) {
            Logger.getLogger(ConnectButton.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    public boolean verifyTextFields(String Username,String port,String host,String password){
        //TODO
    return true;
    }
    
    
    
    
}
