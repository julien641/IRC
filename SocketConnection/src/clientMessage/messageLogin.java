/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientMessage;

import messageAction.ActionLogin;
import Interface.IControllerThread;

/**
 *
 * @author julien
 */
public class MessageLogin extends Message implements IServerMessage{
	private String username;
	private String password;	
	public MessageLogin(String from,String username,String password) {
		super(from);
		this.username =username;
		this.password =password;
	
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public void setDefaultAction(IControllerThread controllerthread){
		super.setAction(new ActionLogin(controllerthread,username,password));
	}



	
	
}
