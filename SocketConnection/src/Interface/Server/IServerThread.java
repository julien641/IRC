/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Server;

import Interface.Server.IControllerThread;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author julien
 */
public interface IServerThread {

	ArrayList<IControllerThread> getControllerthreads();

	int getPort();

	ServerSocket getServersocket();

	boolean isRunning();

	void run();

	void setControllerthreads(ArrayList<IControllerThread> controllerthreads);

	void setRunning(boolean running);

	void setServersocket(ServerSocket serversocket);

	Socket socketcreation();

	ServerSocket startingserversocket(int port);

	
	
}
