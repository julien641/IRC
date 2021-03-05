/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxchatclient;

import socketconnection.RC;
import socketconnection.Socketwrapper;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
/**
 *
 * @author julien
 */
public class Javafxchatclient extends Application {
	private ChatclientController controller;
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("chatclient.fxml"));
        controller = (ChatclientController)loader.getController();
       //controller.setJavafxchatclient(this);
        Parent root = loader.load();
        Scene  scene = new Scene(root,900,600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
    public ChatclientController getController() {
        return controller;
    }
    /*
    private class sendchatbutton implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            String messages = getSendtextfield().getCharacters().toString();
            if (messages.length() != 0) {
                getSw().sendMessage(new Message<>(Messagestype.name, messages));
            }
        }

    }
    */
/*
    private class setupNamebutton implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            RC sendingmessage;
        
            
            setName(getSendtextfield().getCharacters().toString());
            Message<String> message = new Message<>(Messagestype.name, getName());
            primaryStage.setTitle(message.getMessage());
            getSendtextfield().clear();
            sendingmessage =getSw().sendMessage(message);
            
            switch (sendingmessage){
                
                case success:    
                    System.out.println("Name sent");
                    setNamesent(true);
                    getSendchat().setText("Send Message");
                    setChat(new clientchatthread(getSw(), getChatarea()));
                    getChat().start();
                    getSendchat().setOnAction(new sendchatbutton());
                    getLabel().setText("success");
                    break;
                    
                default:
                    getLabel().setText("failed");
             
            }
            
            
            
            
            
            }
           

            
        }
        public RC connectToServer(){
            RC socketconnection;
            Socketwrapper sw =    new Socketwrapper();
           socketconnection =sw.connect(website, port);
            setSw(sw);
            

           return socketconnection;
        }
    
*/




}
