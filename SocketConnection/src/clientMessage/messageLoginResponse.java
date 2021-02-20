/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientMessage;

import Interface.Iclient;

/**
 *
 * @author julien
 */
public class messageLoginResponse extends Message implements Iclientmessage{
	//toclient	
	public messageLoginResponse(String from) {
		super(from);
	}



	@Override
	public void setDefaultAction(Iclient client) {
	
	
	}
	
}
