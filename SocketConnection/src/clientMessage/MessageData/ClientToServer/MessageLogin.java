/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientMessage.MessageData.ClientToServer;

import clientMessage.Message;
import clientMessage.messageAction.ClientToServer.ActionLogin;
import Interface.Server.IControllerThread;
import clientMessage.MessageData.IServerMessage;
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



	
	
}
