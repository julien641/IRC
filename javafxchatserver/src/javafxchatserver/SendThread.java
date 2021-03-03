/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxchatserver;

import Interface.IControllerThread;
import Interface.ISendThread;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import socketconnection.Socketwrapper;

/**
 *
 * @author julien
 */
public class SendThread implements ISendThread {
	private IControllerThread controller;


	public SendThread(IControllerThread controller){
	this.controller =controller;

	} 
	@Override
	public void run() {
			
		while(controller.isRunning()){
			
			while(controller.getMessagetosend().hasremaining()){
				controller.getSw().sendMessage(controller.getMessagetosend().getRemMessage());
			}
			try {
				this.wait();
			} catch (InterruptedException ex) {
				System.out.println("send thread interrupted exception");
			}
		}
	}

	@Override
	public IControllerThread getController() {
		return controller;
	}

	@Override
	public void setController(IControllerThread controller) {
		this.controller = controller;
	}
	
}
