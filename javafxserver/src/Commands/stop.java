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
public class stop extends Commands{
	
	public stop(Javafxchatserver cli, String input){
	super(cli,input);
	}

	@Override
	public RC run() {
		System.out.println("Stoping server");
		return super.getCli().stop();
	}
	
}
