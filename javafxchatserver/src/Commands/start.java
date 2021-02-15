/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import javafxchatserver.Javafxchatserver;
import javafxchatserver.ServerThread;

/**
 *
 * @author julien
 */
public class start implements Commands{

	private final Javafxchatserver server;	
	private final String input;
	private final String[] argument ={"-p",""};
	private final int port =55555;
	public start(Javafxchatserver server, String input){
	this.server =server;
	this.input =input;
	
	}
	@Override
	public void man() {
	
	}

	@Override
	public void run() {
		ServerThread serverthread =new ServerThread(port);
		Thread thread =new Thread(serverthread);
		thread.run();
		server.setServer(serverthread);
		server.setThread(thread);
	}
	
}
