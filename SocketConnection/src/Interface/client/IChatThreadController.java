/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.client;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TreeItem;
import socketconnection.Login;
import socketconnection.MessagesToSend;
import socketconnection.Socketwrapper;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 *
 * @author julien
 */
public interface IChatThreadController {
    AtomicBoolean getRunning();
    void end();
    void setRunning(AtomicBoolean running);
    MessagesToSend getMts();
    void setMts(MessagesToSend mts);
    Login getLogin();
    void setLogin(Login login);
    Socketwrapper getSw();
    void setSw(Socketwrapper sw);
    IChatTabController getChattabController();
    void setChattabController(IChatTabController chattabController);
    Thread getConnection();
    void setConnection(Thread connection);
    void setChatclientController(IChatclientController chatclientController);
    public IChatclientController getChatclientController();
    void init();
}
