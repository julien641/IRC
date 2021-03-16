package Interface.client;

import javafx.stage.Stage;

public interface IJavafxchatclient {
    void start(Stage primaryStage) throws Exception;

    IChatclientController getController();
}
