/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxchatclient;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * FXML Controller class
 *
 * @author julien
 */
public class ChatclientController implements Initializable {

    @FXML
    private MenuItem newChannelMenuItem;
    @FXML
    private ListView<?> channelListView;
    private Button sendChatButton;
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
    
    private Tab addChat;
    private NewChattabController newChattabController;
    private ArrayList<Tab> tabarray;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("ChatclientController - Initializer");
        AnchorPane newChattabtab;

     
        try { 
            FXMLLoader newChattabloader = new FXMLLoader(getClass().getResource("newChattab.fxml"));
            
            ///load before getting the controller
            newChattabtab =  newChattabloader.load();
            newChattabController = (NewChattabController) newChattabloader.<NewChattabController>getController();
            
            
            addChat = new Tab("+",newChattabtab); 
            tabPane.getTabs().add(addChat); 
            
            
            System.out.println("before-----------setup");
            newChattabController.setupController(tabPane);
        } catch (IOException ex) {
            Logger.getLogger(ChatclientController.class.getName()).log(Level.SEVERE, null, ex);
           // System.exit(1);
        }finally{
            
        }
        System.out.println("ChatclientController - end");
         
            
        
       
        
    }    
    
}
