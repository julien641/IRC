/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientMessage.MessageData;

import java.sql.Timestamp;

import socketconnection.ServerInfo;

/**
 *
 * @author julien
 */
public interface IMessage {

	 ServerInfo getServerInfo();

	public int getId();

	public Timestamp getTimestamp();

	public void setAction(IMessageAction action);
	
}
