/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxchatclient;

import javafx.event.EventHandler;
import javafx.stage.WindowEvent;
import javafxchatclient.thread.ChatThreadController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;

import java.net.SocketException;

/**
 *
 * @author julien
 *
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

        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                if(controller != null && controller.getChatcontrollers()!=null) {
                    for (ChatThreadController x : controller.getChatcontrollers()) {
                        x.getRunning().set(false);
                        try {
                            //TODO Send message to signal the server that the client logged off

                          //  x.getMts().addMessage();
                            x.getSw().getSocket().setSoTimeout(1);

                        } catch (SocketException e) {
                            e.printStackTrace();
                        }


                    }
                }
                primaryStage.close();
            }

        });


        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
    public ChatclientController getController() {
        return controller;
    }
}
