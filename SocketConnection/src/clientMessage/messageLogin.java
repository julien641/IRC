/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientMessage;

import messageActions.ActionLogin;
import Interface.IControllerThread;

/**
 *
 * @author julien
 */
public class messageLogin extends Message implements Iservermessage{
	private String username;
	private String password;	
	public messageLogin(String from,String username,String password) {
		super(from);
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
