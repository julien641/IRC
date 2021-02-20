/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientMessage;

import java.sql.Timestamp;
import messageActions.Imessageaction;

/**
 *
 * @author julien
 */
public interface IMessage {

	public Imessageaction getAction();

	public String getFrom();

	public int getId();

	public Timestamp getTimestamp();

	public void setAction(Imessageaction action);
	
}
