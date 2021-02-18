/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import java.util.logging.Level;
import java.util.logging.Logger;
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
		if(super.getCli().getServer()!=null){
			super.getCli().getServer().setRunning(false);
			super.getCli().setServer(null);
		
		}	
		if(super.getCli().getThread()!=null){
			try {
				super.getCli().getThread().join();
			} catch (InterruptedException ex) {
				Logger.getLogger(start.class.getName()).log(Level.SEVERE, null, ex);
			}
			super.getCli().setThread(null);
		
		}
	return RC.success;
	}
	
}
