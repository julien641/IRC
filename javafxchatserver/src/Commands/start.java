/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafxchatserver.Javafxchatserver;
import javafxchatserver.ServerThread;

/**
 *
 * @author julien
 */
public class start implements Commands{

	private final Javafxchatserver server;	
	private final String input;
	private final String[] inputparsed;
	private final String[] argument ={"-p",""};
	final private int defaultport =55555;
	public start(Javafxchatserver server, String input){
	this.server =server;
	this.input =input;
	this.inputparsed =input.split(" ");	
	}
	@Override
	public void man() {
	
	}

	@Override
	public void run() {
		//-p argument
		
		int ports = CLIFUNCTION.getnumberargument(inputparsed, argument[0]);
		System.out.println(ports);
		if(ports == -2){
			System.out.println("Invalid arguments");
		}else if(ports == -1){
		ports= defaultport;
		startserver(ports);
		}else if(CLIFUNCTION.isvalidport(ports)){
		startserver(ports);
		
		}
		
	
	}
	private void startserver(int port) {
	
		System.out.println("Starting server on port:"+port);
		if(server.getServer()!=null){
			System.out.println("Restarting server");
			server.getServer().setRunning(false);
			server.setServer(null);
		
		}	
		if(server.getThread()!=null){
			System.out.println("Restarting server");
			try {
				server.getThread().join();
			} catch (InterruptedException ex) {
				Logger.getLogger(start.class.getName()).log(Level.SEVERE, null, ex);
			}
			server.setThread(null);
		
		}
		System.out.println("Server starting on port:"+port);	
		ServerThread serverthread =new ServerThread(port);
		
		Thread thread =new Thread(serverthread);
		thread.start();
		server.setServer(serverthread);
		server.setThread(thread);
		System.out.println("Server started on port:"+port);
	
	}


}
