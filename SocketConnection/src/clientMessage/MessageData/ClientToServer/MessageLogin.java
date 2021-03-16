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
import socketconnection.Login;

import java.io.Serializable;

/**
 *
 * @author julien
 */
public class MessageLogin extends Message implements IServerMessage, Serializable {
	private Login login;
	public MessageLogin(Login login) {
		super(login);
		this.login = login;
	
	}

	@Override
	public void setDefaultAction(IControllerThread controllerthread){
		super.setAction(new ActionLogin(controllerthread,login));
	}



	
	
}
