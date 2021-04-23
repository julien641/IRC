/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxchatserver;

import Commands.*;
import Interface.Server.IJavafxchatserver;
import Interface.Server.IServerConfig;
import Interface.Server.IServerThread;
import Properties.PropertyManager;
import Properties.ServerConfig;
import socketconnection.RC;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author julien
 */
public class Javafxchatserver implements IJavafxchatserver {

	private final String invalidinput = "Invalid command entered";
	private AtomicBoolean running;
	private boolean debug = true;
	private Thread thread;
	private IServerThread server;
	private boolean testing= false;	
	static  public IServerConfig serverconfig;
	private String configpath ="server.properties";


	public Javafxchatserver() {
		this.running =new AtomicBoolean(true);

	}
	private IServerConfig loadserverproperties(String file) {
		try{
		PropertyManager propertymanager = new PropertyManager();
			
			Properties  property;
		
			property = propertymanager.PropertyManager(file);


		return  ServerConfig.newInstance(property);
		}catch(NumberFormatException number){
			
		System.out.println("error loading config file");
		number.printStackTrace();
		
		return null;	
		}catch(NullPointerException n){
			System.err.println(n.getMessage());
			n.printStackTrace();
			
			return null;
			
			}
				
	}
	public RC stop(){
		stopServerThread();
		running.set(false);


		return RC.success;
	}
	public void start() {
		startingmessage();
		serverconfig= loadserverproperties(configpath);
		
		Scanner kb = new Scanner(System.in);
			
		while (isRunning()) {
			String input="";
			if(!testing){	
			input = kb.nextLine();
			}
			
			String[] inputparsed = input.split(" ");
			try {
				Class<?> commandclass =  Class.forName("Commands."+inputparsed[0]);
				Constructor<?> constructor;
				constructor = commandclass.getConstructor(this.getClass(),String.class);
				Object[] parameters = {this, input};
				Commands command = (Commands) constructor.newInstance(parameters);
				command.run();
			} catch (ClassNotFoundException | InstantiationException | 
				IllegalAccessException | IllegalArgumentException 
				| InvocationTargetException | NoSuchMethodException 
				| SecurityException ex) {
				commandlineerror(ex);
				
			}

		}

	}
	public void startingmessage(){
	System.out.println("Welcome to the chat server");
	}
	public void commandlineerror(Exception ex) {
		if (debug) {
			ex.printStackTrace();
		}
		System.out.println(invalidinput);
	}

	public RC stopServerThread(){
		if(server!=null){
			server.stop();
			server =null;
		}
		if(thread!=null){
			try {
				thread.join();
				thread=null;
			} catch (InterruptedException ex) {
				Logger.getLogger(start.class.getName()).log(Level.SEVERE, null, ex);
			}

		}
	return RC.success;
	}
	public void startserver(int port) {

		System.out.println("Starting server on port:"+port);
		if(server!=null){
			System.out.println("Restarting server");
			//	super.getCli().getServer().setRunning(false);
			server=null;
		}
		if(thread!=null){
			System.out.println("Restarting server");
			try {
				thread.join();
			} catch (InterruptedException ex) {
				Logger.getLogger(start.class.getName()).log(Level.SEVERE,
						"joining thread in startserver caused a InterruptedException",
						ex);
				thread.interrupt();
			}
			thread=null;
		}
		System.out.println("Server starting on port:"+port);
		server =new ServerThread(this,port);
		thread =new Thread((Runnable) server);
		thread.setName("Server Thread");
		thread.start();
		System.out.println("Server started on port:"+port);

	}


	/**
	 */
	public boolean isRunning(){
		return running.get();

	}
  public static void main(String[] args) {
	  Javafxchatserver javafxchatserver = new Javafxchatserver();
	  javafxchatserver.start();
  }
	public int locate(String[] command, String arguments) {
		for (int i = 0; i < command.length; i++) {
			if (command.equals(arguments)) {
				return i;
			}
		}
		return -1;
	}

}
