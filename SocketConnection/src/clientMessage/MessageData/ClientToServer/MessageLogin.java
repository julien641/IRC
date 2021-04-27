/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientMessage.MessageData.ClientToServer;

import clientMessage.Message;
import Interface.Server.IControllerThread;
import clientMessage.MessageData.IServerMessage;
import clientMessage.MessageData.IMessageAction;
import socketconnection.ServerInfo;

import java.io.Serializable;

/**
 *
 * @author julien
 */
public class MessageLogin extends Message implements IServerMessage, Serializable {

	public MessageLogin(ServerInfo login) {
		super(login);

	}

	@Override
	public void setDefaultAction(IControllerThread controllerthread){
		super.setAction(new ActionLogin(controllerthread,super.getServerInfo()));
	}




	private class ActionLogin implements IMessageAction {
		private final IControllerThread controllerthread;
		private final ServerInfo serverinfo;

		public ActionLogin(IControllerThread controllerthread, ServerInfo serverInfo) {
			this.controllerthread = controllerthread;
			this.serverinfo = serverInfo;
		}

		@Override
		public void action() {
			boolean indatabase = true;
			String response = "You are logged in";
			if (true) {
				if (indatabase) {
					//	controllerthread.getMessagetosend().addMessage(new MessageLoginResponse(serverinfo, response));
				}
			} else {


			}

			//	MessageLoginResponse x = new MessageLoginResponse(username, response);
			//	x.


		}
	}
	
	
}
