/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafxchatserver.Javafxchatserver;

/**
 *
 * @author julien
 */
public class stop implements Commands{
	private final Javafxchatserver cli;
	private final String[] inputparsed;
	private final String[] argumen = {""};
	private final String input;
	
	public stop(Javafxchatserver cli, String input){
	
	this.cli=cli;
	this.input =input;
	this.inputparsed =input.split(" ");	
	
	}
	@Override
	public void man() {
	}

	@Override
	public void run() {
		System.out.println("Stoping server");
		if(cli.getServer()!=null){
			cli.getServer().setRunning(false);
			cli.setServer(null);
		
		}	
		if(cli.getThread()!=null){
			try {
				cli.getThread().join();
			} catch (InterruptedException ex) {
				Logger.getLogger(start.class.getName()).log(Level.SEVERE, null, ex);
			}
			cli.setThread(null);
		
		}
	}
	
}
