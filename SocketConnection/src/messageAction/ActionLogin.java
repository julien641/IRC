package messageAction;

import Interface.Server.IControllerThread;
import clientMessage.MessageLoginResponse;

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
	private final String username;
	private final String password;


	public ActionLogin(IControllerThread controllerthread,  String username, String password) {
		this.controllerthread = controllerthread;
		this.username = username;
		this.password = password;
	}

	@Override
	public void action() {
		boolean indatabase =true;
		String response = "You are logged in";
		System.out.println("HI");
		if(indatabase){
		
		controllerthread.getMessagetosend().addMessage(new MessageLoginResponse(username,response));
		}
		
	}
	
}
