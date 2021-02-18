/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import javafxchatserver.Javafxchatserver;
import socketconnection.RC;

/**
 *
 * @author julien
 */
public abstract class  Commands {
	final private Javafxchatserver cli;
	private final String commands;
	final private String[]parsedcommands;
	
	public Commands(Javafxchatserver cli,String commands){
	this.cli = cli;
	this.commands =commands;
	String temp[] = commands.split(" ");
	for(String i :temp){
		i=i.trim().replace(" ", "");
	
	}
	
	this.parsedcommands =temp;
	}

	public abstract RC run();

	public Javafxchatserver getCli() {
		return cli;
	}

	public String[] getParsedcommands() {
		return parsedcommands;
	}

}
