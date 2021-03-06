/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxchatserver;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicBoolean;

import Interface.Server.IControllerThread;
import Interface.Server.IRecThread;
import Interface.Server.ISendThread;
import Interface.Server.IServerThread;
import clientMessage.Message;
import socketconnection.MessagesToSend;
import socketconnection.RC;
import socketconnection.Socketwrapper;

/**
 *
 * @author julien
 */
public class ControllerThread implements IControllerThread {
	private ISendThread sendthread;
	private IRecThread recthread;
	private Thread sdthread;
	private Thread rcthread;
	private volatile AtomicBoolean running;
	private MessagesToSend messagetosend;
	private Socketwrapper <Message>sw;
	private IServerThread serverthread;

	public IServerThread getServerthread() {
		return serverthread;
	}

	
	public ControllerThread(Socket socket,IServerThread serverthread){
		this.serverthread =serverthread;
		running = new AtomicBoolean(true);
		sw = new Socketwrapper();
		sw.connect(socket);

		this.sendthread = new SendThread(this);
		this.recthread = new RecThread(this);

		
		this.sdthread = new Thread( this.sendthread);
		this.rcthread =new Thread(  this.recthread);
		this.messagetosend =new <Message>MessagesToSend(sdthread);

		sdthread.start();

		rcthread.start();
	}
	@Override
	public RC Start(){
	//	sdthread.start();
	//	rcthread.start();
	return RC.failed;	
	}	
	@Override
	public ISendThread getSendthread() {
		return sendthread;
	}

	@Override
	public void setSendthread(ISendThread sendthread) {
		this.sendthread = sendthread;
	}

	@Override
	public IRecThread getRecthread() {
		return recthread;
	}

	@Override
	public void setRecthread(IRecThread recthread) {
		this.recthread = recthread;
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
	@Override
	public AtomicBoolean getRunning() {
		return running;
	}
	@Override
	public void setRunning(AtomicBoolean running) {
		this.running = running;
	}
}
