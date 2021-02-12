/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxchatclient;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.TextFlow;
import socketconnection.Socketwrapper;

/**
 * FXML Controller class
 *
 * @author julien
 */
public class ChattabController implements Initializable {

    @FXML
    private BorderPane borderPane;
    @FXML
    private ButtonBar chatbuttonbar;
    @FXML
    private TextArea sendchattextarea;
    @FXML
    private Button sendchatbutton;
    @FXML
    private TextFlow chatbox;
    
    private Socketwrapper sw;
    private Tab tab;
    /**
     * Initializes the controller class.
     */

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("ChattabController - Initializer");
        
        
        
    }    

    public Socketwrapper getSw() {
        return sw;
    }

    public void setSw(Socketwrapper sw) {
        this.sw = sw;
    }

    public Tab getTab() {
        return tab;
    }
    
    
    

    public void setTab(Tab tab) {
        this.tab = tab;
    }
    
}
