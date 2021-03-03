/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messageAction;

import Interface.Iclient;

/**
 *
 * @author julien
 */
public class ActionLoginResponse implements IMessageAction{
	private String response;

	public ActionLoginResponse(Iclient client,String response) {
		this.response = response;
	}
	
	
	@Override
	public void action() {
	}
	
}
