/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;
import Commands.Commands;
import java.util.Set;
import javafxchatserver.Javafxchatserver;
/**
 *
 * @author julien
 */
public class help implements Commands{
	private Javafxchatserver server;	
	private final String[]commands ={"help","start","stop"};
	public help(Javafxchatserver server,String input){
	this.server =server;
	
	}
	@Override
	 public void man() {
	
	}
	public void run(){
		System.out.println("Commands list");

		
		for(int i  = 0; i<commands.length;i++){
			System.out.println(commands[i].toString());
		}
	}
		

	
}
