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
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.SocketException;
import java.util.Scanner;

/**
 * entry point to the application
 * @author julien
 *
 */
public class Javafxchatclient extends Application implements IJavafxchatclient {
    private static String token ="";
    private static String type;
    private Stage primaryStage;

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    private IChatclientController controller;

    public static String getToken() {
        return type+" "+token;
    }

    public static void setToken(String token,String type) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("token",token);
        jsonObject.put("type",type);

        File auth = new File("secret.json");

        try {
            if(auth.exists()){
                auth.delete();

            }
            if(auth.createNewFile() && auth.canWrite()) {
                FileWriter fw = new FileWriter(auth);
                fw.write(jsonObject.toString());
                fw.flush();
                fw.close();
                Javafxchatclient.token = token;
                Javafxchatclient.type = type;
            }else{
                throw new IOException();

            }
            } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //loads the main scene
        this.primaryStage =primaryStage;
        loadtoken();
        if(token=="" || type==""){
            login();
        }else{
            setupClient();
        }

    }



    public static void loadtoken(){
        Scanner scanner = new Scanner("secret.json");
        String json = "";
        while(scanner.hasNextLine()){
            json+= scanner.nextLine();
        }
        JSONParser parser = new JSONParser();
        try {
            JSONObject object = (JSONObject)parser.parse(json);
            if(object.containsKey("token")&& object.containsKey(type)) {
                token = (String) object.get("token");
                type = (String) object.get("type");
            }
            }catch(Exception exception){


        }

    }


    public void login() throws IOException {
        FXMLLoader loginloader = new FXMLLoader(getClass().getResource("login.fxml"));
        //get the main sce
        Parent loginroot = loginloader.load();
        LoginController logincontroller = loginloader.getController();
        Stage loginstage = new Stage();
        Scene loginscene = new Scene(loginroot);
        loginstage.setScene(loginscene);
        logincontroller.setup(loginstage,this);
        loginstage.show();

    }



    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public IChatclientController getController() {
        return controller;
    }

    public void setupClient() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("chatclient.fxml"));
        Parent root = loader.load();
        controller = loader.getController();
        //changes the on close event to end all sockets
        controller.constructor(this,primaryStage,root);
    }


}
