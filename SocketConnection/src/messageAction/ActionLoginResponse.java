/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messageAction;

import Interface.client.IChatTabController;
import Interface.client.IChatThreadController;
import javafx.scene.text.Text;

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
		client.getChattabController().getChatbox().getChildren().add(new Text("response"));


	}
	
}
