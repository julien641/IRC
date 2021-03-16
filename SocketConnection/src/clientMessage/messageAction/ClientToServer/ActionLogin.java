package clientMessage.messageAction.ClientToServer;

import Interface.Server.IControllerThread;
import clientMessage.MessageData.ServerToClient.MessageLoginResponse;
import  clientMessage.messageAction.IMessageAction;
import socketconnection.Login;
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
	private final Login login;

	public ActionLogin(IControllerThread controllerthread, Login login) {
		this.controllerthread = controllerthread;
		this.login =login;
	}

	@Override
	public void action() {
		boolean indatabase =true;
		String response = "You are logged in";
		if(true) {
			if (indatabase) {
				controllerthread.getMessagetosend().addMessage(new MessageLoginResponse(login, response));
			}
		}else{



		}

	//	MessageLoginResponse x = new MessageLoginResponse(username, response);
	//	x.


		
	}
	
}
