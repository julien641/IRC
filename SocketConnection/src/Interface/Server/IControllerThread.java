package Interface.Server;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import socketconnection.MessagesToSend;
import socketconnection.RC;
import socketconnection.Socketwrapper;

/**
 *
 * @author julien
 */
public interface IControllerThread {

	public RC Start();

	public MessagesToSend getMessagetosend();

	public Thread getRcthread();

	public IRecThread getRecthread();

	public Thread getSdthread();

	public ISendThread getSendthread();

	public Socketwrapper getSw();

	public boolean isRunning();

	public void setMessagetosend(MessagesToSend messagetosend);

	public void setRcthread(Thread rcthread);

	public void setRecthread(IRecThread recthread);

	public void setRunning(boolean running);

	public void setSdthread(Thread sdthread);

	public void setSendthread(ISendThread sendthread);

	public void setSw(Socketwrapper sw);
	public IServerThread getServerthread();
	
}