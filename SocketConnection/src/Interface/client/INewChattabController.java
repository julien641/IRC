package Interface.client;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public interface INewChattabController {

    TextField getServer_name();

    Label getError();

    void setError(Label error);

    void initialize(URL url, ResourceBundle rb);

    void setupController(IChatclientController chatclientController);

    IChatclientController getChatclientController();

    void setChatclientController(IChatclientController chatclientController);

    TextField getUsernameNewChatTab();

    TextField getPasswordNewChatTab();

    TextField getPortNewChatTab();

    TextField getHostnameNewChatTab();

    Button getConnectNewChatTab();

    IConnectButton getConnectButton();

    TabPane getTabPane();
}
