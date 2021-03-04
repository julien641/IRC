/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientMessage;

import messageAction.ActionLogin;
import Interface.Server.IControllerThread;

/**
 *
 * @author julien
 */
public class MessageLogin extends Message implements IServerMessage{
	private String password;
	public MessageLogin(String from,String password) {
		super(from);
		this.password =password;
	
	}



	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public void setDefaultAction(IControllerThread controllerthread){
		super.setAction(new ActionLogin(controllerthread,super.getFrom(),password));
	}



	
	
}
