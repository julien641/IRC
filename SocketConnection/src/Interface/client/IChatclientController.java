package Interface.client;

import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public interface IChatclientController {
    TreeView getTreechannelview();

    void setTreechannelview(TreeView treechannelview);

    void initialize(URL url, ResourceBundle rb);

    void setAddChat(Tab addChat);

    void setNewChattabController(INewChattabController newChattabController);

    void setTabarray(ArrayList<Tab> tabarray);

    void setChatcontrollers(ArrayList<IChatThreadController> chatcontrollers);

    void setJavafxchatclient(IJavafxchatclient javafxchatclient);

    MenuItem getNewChannelMenuItem();

    ListView<?> getUserListview();

    Color getX4();

    Font getX3();

    VBox getWindowVBox();

    MenuBar getMenuBar();

    Menu getMenuFile();

    MenuItem getMenuItemOpen();

    Menu getOpenRecentMenu();

    MenuItem getCloseMenuItem();

    MenuItem getSaveMenuItem();

    MenuItem getSaveAsMenuItem();

    MenuItem getRevertMenuItem();

    MenuItem getPreferencesMenuItems();

    MenuItem getQuitMenuItem();

    MenuItem getAbout();

    SplitPane getMainSplitPane();

    HBox getBottomHbox();

    Label getLeftStatusLabel();

    Pane getMiddleBottomPane();

    Label getRightStatusLabel();

    TabPane getTabPane();

    Tab getAddChat();

    INewChattabController getNewChattabController();

    List<Tab> getTabarray();

    List<IChatThreadController> getChatcontrollers();

    IJavafxchatclient getJavafxchatclient();
}
