package Interface.client;

import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public interface IChatclientController {
    void addToTreeChannelView(TreeItem serverTreeItem);
    void remove(Object chatThreadController);
    void closeClient();
    void setJavafxchatclient(IJavafxchatclient iJavafxchatclient);
    void constructor(IJavafxchatclient iJavafxchatclient, Stage stage, Parent root);
     void hide();
    void show();
}
