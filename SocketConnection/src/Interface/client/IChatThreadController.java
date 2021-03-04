package Interface.client;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.TextFlow;

import java.net.URL;
import java.util.ResourceBundle;

public interface IChatThreadController extends Initializable {

    @Override
    void initialize(URL url, ResourceBundle rb);

    BorderPane getBorderPane();

    ButtonBar getChatbuttonbar();

    TextArea getSendchattextarea();

    Button getSendchatbutton();

    TextFlow getChatbox();
}
