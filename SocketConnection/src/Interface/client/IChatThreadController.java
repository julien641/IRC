/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.client;

import clientMessage.Message;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TreeItem;
import socketconnection.MessagesToSend;
import socketconnection.ServerInfo;
import socketconnection.Socketwrapper;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 *
 * @author julien
 */
public interface IChatThreadController {
    void end();
    void init();
    void setuptree();
    void start();
    boolean isRunning();
    void processMessage();
    void sendMessage(Message message);
    void connectingToServer();
}
