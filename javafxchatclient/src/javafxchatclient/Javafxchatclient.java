/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxchatclient;

import Interface.client.IChatThreadController;
import Interface.client.IChatclientController;
import Interface.client.IJavafxchatclient;
import javafx.event.EventHandler;
import javafx.stage.WindowEvent;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;

import java.net.SocketException;

/**
 * entry point to the application
 * @author julien
 *
 */
public class Javafxchatclient extends Application implements IJavafxchatclient {
	private IChatclientController controller;
    @Override
    public void start(Stage primaryStage) throws Exception {
        //loads the main scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource("chatclient.fxml"));
        //get the main sce
        Parent root = loader.load();
        controller = loader.getController();


        Scene  scene = new Scene(root,900,600);
        primaryStage.setTitle("IRC");
        primaryStage.setScene(scene);
        //changes the on close event to end all sockets
        controller.setJavafxchatclient(this);



        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                System.out.println(event.toString());
                if(controller.getChatcontrollers()!=null) {
                    for (IChatThreadController x : controller.getChatcontrollers()) {
                            x.end();
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
    @Override
    public IChatclientController getController() {
        return controller;
    }
}
