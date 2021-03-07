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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.TextFlow;
import javafxchatclient.Button.SendButton;
import javafxchatclient.thread.ChatThreadController;

/**
 * FXML Controller class
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
        sendchatbutton.setOnAction(new SendButton(this));
    }


    @Override
    public BorderPane getBorderPane() {
        return borderPane;
    }

    @Override
    public ButtonBar getChatbuttonbar() {
        return chatbuttonbar;
    }

    @Override
    public TextArea getSendchattextarea() {
        return sendchattextarea;
    }

    @Override
    public Button getSendchatbutton() {
        return sendchatbutton;
    }

    @Override
    public TextFlow getChatbox() {
        return chatbox;
    }

    @Override
    public IChatThreadController getIChatThreadController() {
        return ichatThreadController;
    }

    @Override
    public void setIChatThreadController(IChatThreadController iChatThreadController) {
        this.ichatThreadController =iChatThreadController;
    }
}
