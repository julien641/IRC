/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxchatserver;

import java.net.Socket;
import socketconnection.Socketwrapper;

/**
 *
 * @author julien
 */
public class ControllerThread {
	private SendThread sendthread;
	private RecThread recthread;
	private Thread sdthread;
	private Thread rcthread;
	private boolean running;
	private MessagesToSend messagetosend;
	private Socketwrapper sw;
	
	public ControllerThread(Socket socket){
		this.messagetosend =new MessagesToSend();
		sw = new Socketwrapper();
		sw.connect(socket);
		this.sendthread = new SendThread(this);
		this.recthread = new RecThread(this);
		this.sdthread = new Thread(this.sendthread);
		this.rcthread =new Thread(this.recthread);
		
	}	

	public SendThread getSendthread() {
		return sendthread;
	}

	public void setSendthread(SendThread sendthread) {
		this.sendthread = sendthread;
	}

	public RecThread getRecthread() {
		return recthread;
	}

	public void setRecthread(RecThread recthread) {
		this.recthread = recthread;
	}

	public Thread getSdthread() {
		return sdthread;
	}

	public void setSdthread(Thread sdthread) {
		this.sdthread = sdthread;
	}

	public Thread getRcthread() {
		return rcthread;
	}

	public void setRcthread(Thread rcthread) {
		this.rcthread = rcthread;
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public MessagesToSend getMessagetosend() {
		return messagetosend;
	}

	public void setMessagetosend(MessagesToSend messagetosend) {
		this.messagetosend = messagetosend;
	}

	public Socketwrapper getSw() {
		return sw;
	}

	public void setSw(Socketwrapper sw) {
		this.sw = sw;
	}
	
}
