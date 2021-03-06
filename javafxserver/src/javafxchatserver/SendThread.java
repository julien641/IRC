/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxchatserver;


import Interface.Server.IControllerThread;
import Interface.Server.ISendThread;
import clientMessage.Message;

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
			
		while(controller.getRunning().get()){
			
			while(controller.getMessagetosend().hasremaining()){

				controller.getSw().sendMessage((Message) controller.getMessagetosend().getRemMessage());

			}
		}
		System.out.println("closing send thread");
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
