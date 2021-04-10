/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxchatclient;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import Interface.client.IChatThreadController;
import Interface.client.IChatclientController;
import Interface.client.IJavafxchatclient;
import Interface.client.INewChattabController;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Callback;
import javafxchatclient.Tree.Cell.MyTreeCellRoot;

/**
 * FXML Controller class
 * Main View for the client, hosts the list of channels, chat tabs, and the list of users in the server
 *
 * @author julien
 */
public class ChatclientController implements Initializable, IChatclientController {

    @FXML
    private MenuItem newChannelMenuItem;
    @FXML
    private ListView<?> userListview;
    @FXML
    private Color x4;
    @FXML
    private Font x3;
    @FXML
    private VBox windowVBox;
    @FXML
    private MenuBar menuBar;
    @FXML
    private Menu menuFile;
    @FXML
    private MenuItem menuItemOpen;
    @FXML
    private Menu openRecentMenu;
    @FXML
    private MenuItem closeMenuItem;
    @FXML
    private MenuItem saveMenuItem;
    @FXML
    private MenuItem saveAsMenuItem;
    @FXML
    private MenuItem revertMenuItem;
    @FXML
    private MenuItem preferencesMenuItems;
    @FXML
    private MenuItem quitMenuItem;
    @FXML
    private MenuItem about;
    @FXML
    private SplitPane mainSplitPane;
    @FXML
    private HBox bottomHbox;
    @FXML
    private Label leftStatusLabel;
    @FXML
    private Pane middleBottomPane;
    @FXML
    private Label rightStatusLabel;
    @FXML
    private TabPane tabPane;
    @FXML
    private TreeView treechannelview;
    //custom fields
    private Tab addChat;
    private INewChattabController newChattabController;
    private List<Tab> tabarray;
    private List<IChatThreadController> chatcontrollers;
    private IJavafxchatclient javafxchatclient;
    private Stage stage;
    //end custom fields
    public void constructor(IJavafxchatclient iJavafxchatclient, Stage stage, Parent root){
        this.javafxchatclient =iJavafxchatclient;
        this.stage =stage;
        this.stage.setTitle("#IRC");
        this.stage.setScene(new Scene(root,900,600));
        this.stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                closeClient();
                stage.close();
            }
        });
        this.stage.show();

    }
    public void hide(){
        stage.hide();
    }
    public void show(){
        stage.show();
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("ChatclientController - Initializer");
        treechannelview.setRoot(new TreeItem("root"));
        setuptreechannel();
        newChannelMenuItem.setOnAction(a -> {
            Pane newChattabtab;
            try {
                FXMLLoader newtabloader = new FXMLLoader(getClass().getResource("newChattab.fxml"));
                newChattabtab = newtabloader.load();
                newChattabController = newtabloader.<NewChattabController>getController();
                newChattabController.constructor(this,new Stage(),newChattabtab);
            } catch (IOException ex) {

            } finally {
            }
        });
    }
    public void remove(Object chatThreadController){
        chatcontrollers.remove(chatThreadController);
    }
    public void closeClient(){
        if(chatcontrollers!=null) {
            for (IChatThreadController x : chatcontrollers) {
                x.end();
            }
        }
    }

    @Override
    public void setJavafxchatclient(IJavafxchatclient iJavafxchatclient) {
        this.javafxchatclient =iJavafxchatclient;
    }


    public void addToTreeChannelView(TreeItem serverTreeItem){
        treechannelview.getRoot().getChildren().add(serverTreeItem);
    }
    private void setuptreechannel() {
        treechannelview.setCellFactory(new Callback<TreeView, TreeCell>() {
            @Override
            public TreeCell call(TreeView param) {
                return new MyTreeCellRoot(param);
            }
        });

    }

}
