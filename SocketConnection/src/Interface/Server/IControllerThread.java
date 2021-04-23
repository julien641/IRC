package Interface.Server;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import socketconnection.MessagesToSend;
import socketconnection.RC;
import socketconnection.Socketwrapper;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 *
 * @author julien
 */
public interface IControllerThread {
	RC Start();
	boolean isRunning();
	void close();

}