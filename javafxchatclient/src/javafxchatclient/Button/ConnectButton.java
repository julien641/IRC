/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxchatclient.Button;


import Interface.client.IChatThreadController;
import Interface.client.IChatclientController;
import Interface.client.IConnectButton;
import Interface.client.INewChattabController;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.TabPane;
import javafxchatclient.ChatclientController;
import javafxchatclient.NewChattabController;
import javafxchatclient.Processes.ServerConnection;
import javafxchatclient.thread.ChatThreadController;


import socketconnection.Login;
import socketconnection.Socketwrapper;

/**
 * @author julien
 */
public class ConnectButton implements IConnectButton {
    private final INewChattabController newChattabController;
   private final IChatclientController chatclientController;

    public ConnectButton(INewChattabController newChattabController, IChatclientController chatclientController) {
        this.newChattabController = newChattabController;
        this.chatclientController =chatclientController;
    }


    @Override
    public void handle(Event event) {
        Login login = setLogin(newChattabController);
        if (login == null) {
            newChattabController.getError().setText("Bad Login info");
            return;
        }
        IChatThreadController iChatThreadController = new ChatThreadController(login,chatclientController);
        Thread connection = new Thread(new ServerConnection(newChattabController,iChatThreadController));
        connection.start();
        iChatThreadController.setConnection(connection);
    }


    public Login setLogin(INewChattabController newChattabController) {
        String username = newChattabController.getUsernameNewChatTab().getText();
        String password = newChattabController.getPasswordNewChatTab().getText();
        String hostname = newChattabController.getHostnameNewChatTab().getText();
        String port = newChattabController.getPortNewChatTab().getText();
        String servername = newChattabController.getServer_name().getText();
        Login login = null;
        if (verifyTextFields(username, port)) {
            login = new Login(username, password, Integer.valueOf(port), hostname,servername);
        }
        return login;


    }
    //public

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


}
