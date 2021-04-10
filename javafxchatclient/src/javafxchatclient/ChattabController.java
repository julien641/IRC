/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxchatclient;

import java.net.URL;
import java.util.ResourceBundle;

import Interface.client.IChatTabController;
import Interface.client.IChatThreadController;
import clientMessage.MessageData.ClientToServer.MessageSendChat;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.TextFlow;

/**
 * FXML Controller class
 * controller class for chat tabs
 *
 * @author julien
 */
public class ChattabController implements IChatTabController {

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

    /**
     * Initializes the controller class.
     */
    private IChatThreadController ichatThreadController;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("ChattabController - Initializer");
        sendchatbutton.setOnAction(new SendButton());
    }
    private class SendButton implements EventHandler {
        @Override
        public void handle(Event event) {
            String payload = ChattabController.this.sendchattextarea.getText();
            ChattabController.this.ichatThreadController.sendMessage(new MessageSendChat(null,payload));
            ChattabController.this.sendchattextarea.setText("");
            //TODO MAke message TO SEND TO THE SERVER
        }
    }


}

