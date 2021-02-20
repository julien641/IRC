/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientMessage;

import Interface.IControllerThread;
import Interface.IServerThread;
import Interface.Iclient;
import messageActions.Imessageaction;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Random;

/**
 *
 * @author julien
 * @param <T>
 * @param <B>
 */
public abstract class Message implements Serializable, IMessage {

	private Imessageaction action;
	private final static Random RANDOM = new Random();
	final private int id;
	final private Timestamp timestamp;
	final private String from;
	
	public Message(String from) {
		this.id = RANDOM.nextInt();
		this.timestamp = Timestamp.from(Instant.now());
		this.from = from;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public String getFrom() {
		return from;
	}

	@Override
	public Timestamp getTimestamp() {
		return timestamp;
	}

	@Override
	public Imessageaction getAction() {
		return action;
	}

	@Override
	public void setAction(Imessageaction action) {
		this.action = action;
	}
	public void activateAction(){
		action.action();
	
	
	}
	
}
