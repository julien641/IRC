/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientMessage.MessageData;

import java.sql.Timestamp;
import clientMessage.messageAction.IMessageAction;
import socketconnection.Login;

/**
 *
 * @author julien
 */
public interface IMessage {

	 IMessageAction getAction();
	 Login getLogin();

	public int getId();

	public Timestamp getTimestamp();

	public void setAction(IMessageAction action);
	
}
