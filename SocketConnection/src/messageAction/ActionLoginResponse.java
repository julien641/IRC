/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messageAction;

import Interface.client.IChatTabController;
import Interface.client.IChatThreadController;

/**
 *
 * @author julien
 */
public class ActionLoginResponse implements IMessageAction{
	private String response;

	public ActionLoginResponse(IChatThreadController client, String response) {
		this.response = response;
	}
	
	
	@Override
	public void action() {
	}
	
}
