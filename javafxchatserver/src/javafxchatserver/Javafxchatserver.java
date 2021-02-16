/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxchatserver;

import Commands.*;
import Commands.help;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author julien
 */
public class Javafxchatserver {

	private final String invalidinput = "Invalid command entered";
	private boolean running = true;
	private boolean debug = true;
	private Thread thread;
	private ServerThread server;
	private boolean testing= false;	



	public Javafxchatserver() {

	}

	public void start() {

		Scanner kb = new Scanner(System.in);

		while (running) {
			String input="";
			if(!testing){	
			input = kb.nextLine();
			}
			
			String[] inputparsed = input.split(" ");
			try {
				Class commandclass = Class.forName("Commands."+inputparsed[0]);
				
				Class[] types = {this.getClass(), String.class};

				Constructor constructor = commandclass.getConstructor(types);
				Object[] parameters = {this, input};
				Commands command = (Commands) constructor.newInstance(parameters);
				command.run();
			} catch (ClassNotFoundException ex) {
				commandlineerror(ex);
			} catch (InstantiationException ex) {
				commandlineerror(ex);
			} catch (IllegalAccessException ex) {
				commandlineerror(ex);
			} catch (IllegalArgumentException ex) {
				commandlineerror(ex);
			} catch (InvocationTargetException ex) {
				commandlineerror(ex);
			} catch (NoSuchMethodException ex) {
				commandlineerror(ex);
			} catch (SecurityException ex) {
				commandlineerror(ex);
			}

		}

	}

	public void commandlineerror(Exception ex) {
		if (debug) {
			ex.printStackTrace();
		}
		System.out.println(invalidinput);
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		Javafxchatserver server = new Javafxchatserver();
		server.start();

	}

	public int locate(String[] command, String arguments) {
		boolean found = false;
		for (int i = 0; i < command.length; i++) {
			if (command.equals(arguments)) {
				return i;
			}

		}
		return -1;
	}
	public boolean isDebug() {
		return debug;
	}

	public void setDebug(boolean debug) {
		this.debug = debug;
	}

	public Thread getThread() {
		return thread;
	}

	public void setThread(Thread thread) {
		this.thread = thread;
	}
	public ServerThread getServer() {
		return server;
	}

	public void setServer(ServerThread server) {
		this.server = server;
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}
}
