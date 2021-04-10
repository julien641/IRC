package clientMessage.messageAction.ClientToServer;

import Interface.Server.IControllerThread;
import clientMessage.MessageData.ServerToClient.MessageLoginResponse;
import  clientMessage.messageAction.IMessageAction;
import socketconnection.ServerInfo;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author julien
 */
public class ActionLogin implements IMessageAction{
	private final IControllerThread controllerthread;
	private final ServerInfo serverinfo;
	public ActionLogin(IControllerThread controllerthread, ServerInfo serverInfo) {
		this.controllerthread = controllerthread;
		this.serverinfo =serverInfo;
	}

	@Override
	public void action() {
		boolean indatabase =true;
		String response = "You are logged in";
		if(true) {
			if (indatabase) {
				controllerthread.getMessagetosend().addMessage(new MessageLoginResponse(serverinfo, response));
			}
		}else{



		}

	//	MessageLoginResponse x = new MessageLoginResponse(username, response);
	//	x.


		
	}
	
}
