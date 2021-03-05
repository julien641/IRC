/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxchatserver;
import java.net.Socket;

import Interface.Server.IControllerThread;
import Interface.Server.IRecThread;
import Interface.Server.ISendThread;
import Interface.Server.IServerThread;
import socketconnection.MessagesToSend;
import socketconnection.RC;
import socketconnection.Socketwrapper;

/**
 *
 * @author julien
 */
public class ControllerThread implements IControllerThread {
	private SendThread sendthread;
	private RecThread recthread;
	private Thread sdthread;
	private Thread rcthread;
	private volatile boolean running;
	private MessagesToSend messagetosend;
	private Socketwrapper sw;
	private IServerThread serverthread;

	public IServerThread getServerthread() {
		return serverthread;
	}

	
	public ControllerThread(Socket socket,IServerThread serverthread){
		this.serverthread =serverthread;
		
		sw = new Socketwrapper();
		sw.connect(socket);
		this.sendthread = new SendThread(this);
		this.recthread = new RecThread(this);

		
		this.sdthread = new Thread( this.sendthread);
		this.rcthread =new Thread(  this.recthread);
		this.messagetosend =new MessagesToSend(sdthread);	
	}	
	@Override
	public RC Start(){
		sdthread.start();
		rcthread.start();
	return RC.failed;	
	}	
	@Override
	public ISendThread getSendthread() {
		return sendthread;
	}

	@Override
	public void setSendthread(ISendThread sendthread) {
		this.sendthread = (SendThread)sendthread;
	}

	@Override
	public IRecThread getRecthread() {
		return recthread;
	}

	@Override
	public void setRecthread(IRecThread recthread) {
		this.recthread = (RecThread)recthread;
	}

	@Override
	public Thread getSdthread() {
		return sdthread;
	}

	@Override
	public void setSdthread(Thread sdthread) {
		this.sdthread = sdthread;
	}

	@Override
	public Thread getRcthread() {
		return rcthread;
	}

	@Override
	public void setRcthread(Thread rcthread) {
		this.rcthread = rcthread;
	}

	@Override
	public boolean isRunning() {
		return running;
	}

	@Override
	public void setRunning(boolean running) {
		this.running = running;
	}

	@Override
	public MessagesToSend getMessagetosend() {
		return messagetosend;
	}

	@Override
	public void setMessagetosend(MessagesToSend messagetosend) {
		this.messagetosend = messagetosend;
	}

	@Override
	public Socketwrapper getSw() {
		return sw;
	}

	@Override
	public void setSw(Socketwrapper sw) {
		this.sw = sw;
	}
	
}
