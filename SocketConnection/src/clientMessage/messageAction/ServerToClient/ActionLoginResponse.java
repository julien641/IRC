/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientMessage.messageAction.ServerToClient;

import Interface.client.IChatThreadController;
import javafx.application.Platform;
import javafx.scene.text.Text;
import clientMessage.messageAction.IMessageAction;
/**
 *
 * @author julien
 */
public class ActionLoginResponse implements IMessageAction{
	private String response;
	private IChatThreadController client;
	public ActionLoginResponse(IChatThreadController client, String response)
	{
		this.response = response;
		this.client =client;
	}
	
	
	@Override
	public void action() {
		System.out.println("Response");
		Platform.runLater(() -> client.getChattabController().getChatbox().getChildren().add(new Text("Welcome to this server")));


	}
	
}
