/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxchatclient;

import java.net.URL;
import java.util.ResourceBundle;

import Interface.client.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafxchatclient.thread.ChatThreadController;
import socketconnection.ServerInfo;

//import javax.xml.soap.Text;

/**
 * FXML Controller class
 *
 * @author julien
 */
public class NewChattabController implements Initializable, INewChattabController {

    @FXML
    private Label hostnamelabel;

    @FXML
    private TextField hostnameNewChatTab;

    @FXML
    private Label passwordlabel;

    @FXML
    private TextField passwordNewChatTab;

    @FXML
    private Label portlabel;

    @FXML
    private TextField portNewChatTab;


    @FXML
    private CheckBox save;

    @FXML
    private Button connectNewChatTab;

    @FXML
    private Label error;

    private Stage stage;
    private IConnectButton connectButton;
    private IChatclientController chatclientController;
    public void initialize(URL url, ResourceBundle rb) {
        /******************do not use Stage here******************/
        passwordNewChatTab.focusedProperty().addListener(new changingLabels(passwordlabel, passwordNewChatTab));
        changingLabels portChanging = new changingLabels(portlabel, portNewChatTab);
        portChanging.changed(null, true, true);
        portNewChatTab.focusedProperty().addListener(new changingLabels(portlabel, portNewChatTab));
        hostnameNewChatTab.focusedProperty().addListener(new changingLabels(hostnamelabel, hostnameNewChatTab));
        connectButton = new ConnectButton();
        connectNewChatTab.setOnAction(connectButton);

    }
    @Override
    public void constructor(IChatclientController chatclientController, Stage stage, Pane pane) {
        this.stage =stage;
        this.chatclientController = chatclientController;
        this.stage.setScene(new Scene(pane));
        this.stage.show();
        this.chatclientController.hide();
        this.stage.setOnCloseRequest(windowEvent -> {
            close();
        });
    }

    /**
     * Initializes the controller class.
     */
    public boolean verifyTextFields(String username, String port) {
        boolean rc = false;
        if (!username.isEmpty()) {
            try {
                int x = Integer.valueOf(port);
                rc = x > -1;
            } catch (NumberFormatException e) {
                rc = false;
            }

        }
        return rc;
    }
    public void close(){
        chatclientController.show();
        stage.close();

    }


    public ServerInfo getServerInfo(){
        ServerInfo login = null;
        String hostname = hostnameNewChatTab.getText(),port =portNewChatTab.getText(),password =passwordNewChatTab.getText();
        if(verifyTextFields(hostname,port)){
            login = new ServerInfo(hostname,password,Integer.valueOf(port));
        }

        return login;

    }
    public void setErrorMessage(String errorMessage) {
        error.setText(errorMessage);
    }




    private class changingLabels implements ChangeListener<Boolean> {
        private final Label label;
        private final TextField textField;

        public changingLabels(Label label, TextField textfield) {
            this.label = label;
            this.textField = textfield;
        }

        public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
            label.setVisible(newValue || !textField.getText().isEmpty());
        }
    }
    private class ConnectButton implements IConnectButton {
        @Override
        public void handle(Event event) {
            ServerInfo login = NewChattabController.this.getServerInfo();
            if (login == null) {
                NewChattabController.this.setErrorMessage("Bad Login info");
                return;
            }
            NewChattabController.this.close();


            IChatThreadController iChatThreadController = new ChatThreadController(login,chatclientController);
            iChatThreadController.connectingToServer();
            NewChattabController.this.chatclientController.show();

        }
    }
}
/*
    public void chatTabLoader(ChatThreadController chatThreadController) {
        FXMLLoader Chattabloader = null;
        Tab server = null;
        BorderPane borderPane = null;
        ChattabController chattabController = null;
        try {
            Chattabloader = new FXMLLoader(getClass().getResource("Chattab.fxml"));
            borderPane = Chattabloader.load();
            chattabController = Chattabloader.getController();
            chatThreadController.setChattabController(chattabController);
            chattabController.setIChatThreadController(chatThreadController);
            //TODO assign tree item name to be fromt he form

            server = new Tab(chatThreadController.getLogin().getIp(), borderPane);
            //TODO Change to tree
            chatThreadController.setTab(server);


            tabPane.getTabs().add(tabPane.getTabs().size() - 1, server);
            tabPane.getSelectionModel().select(server);

        } catch (IOException ex) {
            Logger.getLogger(ConnectButton.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

*/