/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientMessage.MessageData.ServerToClient;

import Interface.client.IChatThreadController;
import clientMessage.Message;
import clientMessage.messageAction.ServerToClient.ActionLoginResponse;
import clientMessage.MessageData.IClientMessage;
/**
 *
 * @author julien
 */
public class MessageLoginResponse extends Message implements IClientMessage {
	//toclient
	private String response;
	public MessageLoginResponse(String response,String from) {
		super(from);
		this.response =response;
	}



	@Override
	public void setDefaultAction(IChatThreadController client) {
		super.setAction(new ActionLoginResponse(client,response));
	
	}
	
}
