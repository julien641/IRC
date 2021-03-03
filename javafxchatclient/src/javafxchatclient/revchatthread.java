/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxchatclient;

import clientMessage.IClientMessage;
import clientMessage.Message;

/**
 *
 * @author julien
 */
public class revchatthread implements Runnable{
	  private ChatController chatController;

	public revchatthread(ChatController chatController) {
		this.chatController = chatController;
	}
		
	
	  
	@Override
	public void run() {
		while(chatController.getRunning().get()){
			Message message = chatController.getSw().receivemessage();
			//TODO
			((IClientMessage)message).setDefaultAction(null);
			message.activateAction();
			
		
		}

		
	}






	
}
