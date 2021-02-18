/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxchatserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import socketconnection.Socketwrapper;

/**
 *
 * @author julien
 */
public class ServerThread implements Runnable {

	private ServerSocket serversocket;
	private volatile boolean running;
	final private int port;
	private ArrayList<ControllerThread> controllerthreads;
	final private int timeout = 1000;
	
	public ServerThread(int port) {
		this.port = port;
		controllerthreads = new ArrayList<>();
		this.running = true;
	}

	@Override
	public void run() {
		
		serversocket = startingserversocket(port);

		while (running && serversocket != null) {
			Socket s = socketcreation();
			if (s != null) {
				ControllerThread current= new ControllerThread(s);
				
				controllerthreads.add(current);
				
				
				
			}
		}
		System.out.println("Closing server");
		cleanend();
	}

	public ServerSocket startingserversocket(int port) {
		ServerSocket serversocket = null;
		try {
			serversocket = new ServerSocket(port);
			serversocket.setSoTimeout(timeout);
		} catch (IOException ex) {
			Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
		}
		return serversocket;
	}

	public Socket socketcreation() {

		Socket s = null;
		try {
			s = serversocket.accept();
		} catch (IOException ex) {
			//	Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
		}
		return s;

	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}



	public int getPort() {
		return port;
	}

	private void cleanend() {
		try {
			serversocket.close();
			serversocket = null;

		} catch (IOException ex) {
			Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

}
