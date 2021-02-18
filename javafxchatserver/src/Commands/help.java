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
public class help extends Commands{
	private final String[]commands ={"help","start","stop"};
	public help(Javafxchatserver cli,String input){
		super(cli,input);
	
	}
	public RC run(){
		System.out.println("Commands list");

		
		for(int i  = 0; i<commands.length;i++){
			System.out.println(commands[i]);
		}
		return RC.success;
	}
		

	
}
