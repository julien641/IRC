/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.client;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import socketconnection.Login;
import socketconnection.MessagesToSend;
import socketconnection.Socketwrapper;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 *
 * @author julien
 */
public interface IChatThreadController {
    void start();

    AtomicBoolean getRunning();

    void setRunning(AtomicBoolean running);

    MessagesToSend getMts();

    void setMts(MessagesToSend mts);

    Login getLogin();

    void setLogin(Login login);

    TabPane getTabpane();

    void setTabpane(TabPane tabpane);

    Tab getTab();

    void setTab(Tab tab);

    Socketwrapper getSw();

    void setSw(Socketwrapper sw);

    IChatTabController getChattabController();

    void setChattabController(IChatTabController chattabController);
}
