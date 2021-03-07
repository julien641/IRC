/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxchatclient.thread;

import clientMessage.Message;
import clientMessage.MessageData.IClientMessage;

/**
 *
 * @author julien
 */
public class RecChatThread implements Runnable{
	  private ChatThreadController chatThreadController;

	public RecChatThread(ChatThreadController chatThreadController) {
		this.chatThreadController = chatThreadController;
	}
		
	
	  
	@Override
	public void run() {

		while(chatThreadController.getRunning().get()){
			Message message = chatThreadController.getSw().receivemessage();
			//TODO find what to pass in so it can interact with the whole client
			System.out.println("message");
			((IClientMessage)message).setDefaultAction(chatThreadController);
			message.activateAction();
			
		
		}

		
	}






	
}
