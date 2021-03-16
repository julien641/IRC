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
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;
import java.util.Scanner;

/**
 *
 * @author julien
 */
public class Javafxchatserver implements IJavafxchatserver {

	private final String invalidinput = "Invalid command entered";
	private boolean running = true;
	private boolean debug = true;
	private Thread thread;
	private IServerThread server;
	private boolean testing= false;	
	private IServerConfig serverconfig;
	private String configpath ="server.properties";

	@Override
	public IServerConfig getServerconfig() {
		return serverconfig;
	}

	@Override
	public void setServerconfig(IServerConfig serverconfig) {
		this.serverconfig = serverconfig;
	}

	public Javafxchatserver() {

	}
	private IServerConfig loadserverproperties(String file) {
		try{
		PropertyManager propertymanager = new PropertyManager();
			
			Properties  property;
		
			property = propertymanager.PropertyManager(file);
		
		
			IServerConfig config = ServerConfig.newInstance(property);
				
		return config;
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
	@Override
	public void start() {
		startingmessage();
		serverconfig= loadserverproperties(configpath);
		
		Scanner kb = new Scanner(System.in);
			
		while (running) {
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
	@Override
	public void startingmessage(){
	System.out.println("Welcome to the chat server");
	
	
	}
	@Override
	public void commandlineerror(Exception ex) {
		if (debug) {
			ex.printStackTrace();
		}
		System.out.println(invalidinput);
	}

	/**
	 */
	

	@Override
	public int locate(String[] command, String arguments) {
		for (int i = 0; i < command.length; i++) {
			if (command.equals(arguments)) {
				return i;
			}

		}
		return -1;
	}
	@Override
	public boolean isDebug() {
		return debug;
	}

	@Override
	public void setDebug(boolean debug) {
		this.debug = debug;
	}

	@Override
	public Thread getThread() {
		return thread;
	}

	@Override
	public void setThread(Thread thread) {
		this.thread = thread;
	}

	@Override
	public IServerThread getServer() {
		return server;
	}

	@Override
	public void setServer(IServerThread server) {
		this.server = server;
	}

	@Override
	public boolean isRunning() {
		return running;
	}

	@Override
	public void setRunning(boolean running) {
		this.running = running;
	}

}
