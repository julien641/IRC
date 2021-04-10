package Interface.client;


import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import socketconnection.ServerInfo;

public interface INewChattabController {
    void constructor(IChatclientController chatclientController, Stage stage, Pane pane);
    void setErrorMessage(String errorMessage);
    ServerInfo getServerInfo();


}
