/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxchatclient;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import Interface.client.IChatThreadController;
import Interface.client.IChatclientController;
import Interface.client.IJavafxchatclient;
import Interface.client.INewChattabController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Callback;
import javafxchatclient.Tree.Cell.MyTreeCellRoot;
import javafxchatclient.thread.ChatThreadController;

/**
 * FXML Controller class
 * Main View for the client, hosts the list of channels, chat tabs, and the list of users in the server
 * @author julien
 */
public class ChatclientController implements Initializable, IChatclientController {

    @FXML
    private MenuItem newChannelMenuItem;
    @FXML
    private ListView<?> userListview;
    @FXML
    private Color x4;
    @FXML
    private Font x3;
    @FXML
    private VBox windowVBox;
    @FXML
    private MenuBar menuBar;
    @FXML
    private Menu menuFile;
    @FXML
    private MenuItem menuItemOpen;
    @FXML
    private Menu openRecentMenu;
    @FXML
    private MenuItem closeMenuItem;
    @FXML
    private MenuItem saveMenuItem;
    @FXML
    private MenuItem saveAsMenuItem;
    @FXML
    private MenuItem revertMenuItem;
    @FXML
    private MenuItem preferencesMenuItems;
    @FXML
    private MenuItem quitMenuItem;
    @FXML
    private MenuItem about;
    @FXML
    private SplitPane mainSplitPane;
    @FXML
    private HBox bottomHbox;
    @FXML
    private Label leftStatusLabel;
    @FXML
    private Pane middleBottomPane;
    @FXML
    private Label rightStatusLabel;
    @FXML
    private TabPane tabPane;
    @FXML
    private TreeView treechannelview;
    //custom fields
    private Tab addChat;
    private INewChattabController newChattabController;
    private List<Tab> tabarray;
    private List<IChatThreadController> chatcontrollers;
    private IJavafxchatclient javafxchatclient;
    //end custom fields

    @Override
    public TreeView getTreechannelview() {
        return treechannelview;
    }

    @Override
    public void setTreechannelview(TreeView treechannelview) {
        this.treechannelview = treechannelview;
    }

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("ChatclientController - Initializer");
        treechannelview.setRoot(new TreeItem("root"));
        setuptreechannel();


        VBox newChattabtab;
        try {
            FXMLLoader newtabloader = new FXMLLoader(getClass().getResource("newChattab.fxml"));
            ///load before getting the controller
            newChattabtab =  newtabloader.load();
            newChattabController =  newtabloader.<NewChattabController>getController();
            addChat = new Tab("+",newChattabtab);
            addChat.closableProperty().setValue(false);
            tabPane.getTabs().add(addChat);
            newChattabController.setupController(this);
        } catch (IOException ex) {
            Logger.getLogger(ChatclientController.class.getName()).log(Level.SEVERE, "IOException failed to load (+)new tab", ex);
           // System.exit(1);

        }finally{
        }



    }

    private void setuptreechannel() {
        treechannelview.setCellFactory(new Callback<TreeView, TreeCell>() {
            @Override
            public TreeCell call(TreeView param) {

                return new MyTreeCellRoot(param);
            }
        });

    }


    @Override
    public void setAddChat(Tab addChat) { this.addChat = addChat; }
    @Override
    public void setNewChattabController(INewChattabController newChattabController) { this.newChattabController = newChattabController; }
    @Override
    public void setTabarray(ArrayList<Tab> tabarray) { this.tabarray = tabarray; }
    @Override
    public void setChatcontrollers(ArrayList<IChatThreadController> chatcontrollers) { this.chatcontrollers = chatcontrollers; }
    @Override
    public void setJavafxchatclient(IJavafxchatclient javafxchatclient) { this.javafxchatclient = javafxchatclient; }
    @Override
    public MenuItem getNewChannelMenuItem() { return newChannelMenuItem; }
    @Override
    public ListView<?> getUserListview() { return userListview; }
    @Override
    public Color getX4() { return x4; }
    @Override
    public Font getX3() { return x3; }
    @Override
    public VBox getWindowVBox() { return windowVBox; }
    @Override
    public MenuBar getMenuBar() { return menuBar; }
    @Override
    public Menu getMenuFile() { return menuFile; }
    @Override
    public MenuItem getMenuItemOpen() { return menuItemOpen; }
    @Override
    public Menu getOpenRecentMenu() { return openRecentMenu; }
    @Override
    public MenuItem getCloseMenuItem() { return closeMenuItem; }
    @Override
    public MenuItem getSaveMenuItem() { return saveMenuItem; }
    @Override
    public MenuItem getSaveAsMenuItem() { return saveAsMenuItem; }
    @Override
    public MenuItem getRevertMenuItem() { return revertMenuItem; }
    @Override
    public MenuItem getPreferencesMenuItems() { return preferencesMenuItems; }
    @Override
    public MenuItem getQuitMenuItem() { return quitMenuItem; }
    @Override
    public MenuItem getAbout() { return about; }
    @Override
    public SplitPane getMainSplitPane() { return mainSplitPane; }
    @Override
    public HBox getBottomHbox() { return bottomHbox; }
    @Override
    public Label getLeftStatusLabel() { return leftStatusLabel; }
    @Override
    public Pane getMiddleBottomPane() { return middleBottomPane; }
    @Override
    public Label getRightStatusLabel() { return rightStatusLabel; }
    @Override
    public TabPane getTabPane() { return tabPane; }
    @Override
    public Tab getAddChat() { return addChat; }
    @Override
    public INewChattabController getNewChattabController() { return newChattabController; }
    @Override
    public List<Tab> getTabarray() { return tabarray; }
    @Override
    public List<IChatThreadController> getChatcontrollers() { return chatcontrollers; }
    @Override
    public IJavafxchatclient getJavafxchatclient() { return javafxchatclient; }
}
