/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxchatclient;

import java.net.URL;
import java.util.ResourceBundle;

import Interface.client.IChatclientController;
import Interface.client.IConnectButton;
import Interface.client.INewChattabController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafxchatclient.Button.ConnectButton;

import javax.xml.soap.Text;

/**
 * FXML Controller class
 *
 * @author julien
 */
public class NewChattabController implements Initializable, INewChattabController {

    @FXML
    private TextField usernameNewChatTab;
    @FXML
    private TextField passwordNewChatTab;
    @FXML
    private TextField portNewChatTab;
    @FXML
    private TextField hostnameNewChatTab;



    @FXML
    private TextField server_name;
    @FXML
    private Button connectNewChatTab;
    @FXML
    private CheckBox save;
    @FXML
    private Label error;
    @FXML
    private Label usernamelabel;
    @FXML
    private Label passwordlabel;
    @FXML
    private Label hostnamelabel;
    @FXML
    private Label portlabel;
    @FXML
    private Label servernamelabel;

    
    private IConnectButton connectButton;
    private TabPane tabPane;
    private IChatclientController chatclientController;
    /**
     * Initializes the controller class.
     */

    @Override
    public TextField getServer_name() {
        return server_name;
    }
    @Override
    public Label getError() {
        return error;
    }

    @Override
    public void setError(Label error) {
        this.error = error;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        usernameNewChatTab.focusedProperty().addListener(new changingLabels(usernamelabel,usernameNewChatTab));
        passwordNewChatTab.focusedProperty().addListener(new changingLabels(passwordlabel,passwordNewChatTab));
        portNewChatTab.focusedProperty().addListener(new changingLabels(portlabel,portNewChatTab));
        hostnameNewChatTab.focusedProperty().addListener(new changingLabels(hostnamelabel,hostnameNewChatTab));
        server_name.focusedProperty().addListener(new changingLabels(servernamelabel,server_name));

    }
    @Override
    public void setupController(IChatclientController chatclientController)
    {
	  this.chatclientController = chatclientController;
          this.tabPane =tabPane;
          connectButton= new ConnectButton(this,chatclientController);
          connectNewChatTab.setOnAction(connectButton);
    }

	@Override
    public IChatclientController getChatclientController() {
		return chatclientController;
	}

	@Override
    public void setChatclientController(IChatclientController chatclientController) { this.chatclientController = chatclientController; }

    @Override
    public TextField getUsernameNewChatTab() {
        return usernameNewChatTab;
    }

    @Override
    public TextField getPasswordNewChatTab() {
        return passwordNewChatTab;
    }

    @Override
    public TextField getPortNewChatTab() {
        return portNewChatTab;
    }

    @Override
    public TextField getHostnameNewChatTab() {
        return hostnameNewChatTab;
    }

    @Override
    public Button getConnectNewChatTab() {
        return connectNewChatTab;
    }

    @Override
    public IConnectButton getConnectButton() {
        return connectButton;
    }

    @Override
    public TabPane getTabPane() {
        return tabPane;
    }
    private class changingLabels implements ChangeListener<Boolean> {

        private final Label label;
        private final TextField textField;
        public changingLabels(Label label,TextField textfield){
           this.label = label;
           this.textField =textfield;
        }

        @Override
        public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                label.setVisible(newValue||!textField.getText().isEmpty());
            }
        }

    
}
