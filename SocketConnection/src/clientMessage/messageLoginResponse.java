/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientMessage;

import Interface.Iclient;
import messageAction.ActionLoginResponse;

/**
 *
 * @author julien
 */
public class MessageLoginResponse extends Message implements IClientMessage{
	//toclient
	private String response;
	public MessageLoginResponse(String response,String from) {
		super(from);
		this.response =response;
	}



	@Override
	public void setDefaultAction(Iclient client) {
		super.setAction(new ActionLoginResponse(client,response));
	
	}
	
}
