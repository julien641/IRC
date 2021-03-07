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
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafxchatclient.Button.ConnectButton;

/**
 * FXML Controller class
 *
 * @author julien
 */
public class NewChattabController implements Initializable {

    @FXML
    private TextField usernameNewChatTab;
    @FXML
    private TextField passwordNewChatTab;
    @FXML
    private TextField portNewChatTab;
    @FXML
    private TextField hostnameNewChatTab;
    @FXML
    private Button connectNewChatTab;
    
    
    private ConnectButton connectButton;
    private TabPane tabPane;
    private ChatclientController chatclientController;
    /**
     * Initializes the controller class.
     */
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    public void setupController(TabPane tabPane, ChatclientController chatclientController)
    {
	  this.chatclientController = chatclientController;
          this.tabPane =tabPane;
          connectButton= new ConnectButton(this,this.tabPane);
          connectNewChatTab.setOnAction(connectButton);
    }

	public ChatclientController getChatclientController() {
		return chatclientController;
	}

	public void setChatclientController(ChatclientController chatclientController) { this.chatclientController = chatclientController; }

    public TextField getUsernameNewChatTab() {
        return usernameNewChatTab;
    }

    public TextField getPasswordNewChatTab() {
        return passwordNewChatTab;
    }

    public TextField getPortNewChatTab() {
        return portNewChatTab;
    }

    public TextField getHostnameNewChatTab() {
        return hostnameNewChatTab;
    }

    public Button getConnectNewChatTab() {
        return connectNewChatTab;
    }

    public ConnectButton getConnectButton() {
        return connectButton;
    }

    public TabPane getTabPane() {
        return tabPane;
    }
    
}
