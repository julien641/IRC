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
import socketconnection.RC;

/**
 *
 * @author julien
 */
public class start extends Commands{

	private final String[] argument ={"-p",""};
	final private int defaultport =55555;
	public start(Javafxchatserver cli, String input){
	super(cli,input);
	}

	@Override
	public RC run() {
		//-p argument
		RC rc =RC.failed;
		int ports = CLIFUNCTION.getnumberargument(super.getParsedcommands(), argument[0]);
		System.out.println(ports);
		if(ports == -2){
			
			System.out.println("Invalid arguments");
			rc =RC.failed;
		}else if(ports == -1){
		ports= defaultport;
		startserver(ports);
		}else if(CLIFUNCTION.isvalidport(ports)){
		startserver(ports);
		
		}
		
	return rc;
	}
	private void startserver(int port) {
	
		System.out.println("Starting server on port:"+port);
		if(super.getCli().getServer()!=null){
			System.out.println("Restarting server");
			super.getCli().getServer().setRunning(false);
			super.getCli().setServer(null);
		
		}	
		if(super.getCli().getThread()!=null){
			System.out.println("Restarting server");
			try {
				super.getCli().getThread().join();
			} catch (InterruptedException ex) {
				Logger.getLogger(start.class.getName()).log(Level.SEVERE, null, ex);
			}
			super.getCli().setThread(null);
		
		}
		System.out.println("Server starting on port:"+port);	
		ServerThread serverthread =new ServerThread(port);
		
		Thread thread =new Thread(serverthread);
		thread.start();
		super.getCli().setServer(serverthread);
		super.getCli().setThread(thread);
		System.out.println("Server started on port:"+port);
	
	}


}
