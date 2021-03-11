package Interface.Server;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import socketconnection.MessagesToSend;
import socketconnection.RC;
import socketconnection.Socketwrapper;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 *
 * @author julien
 */
public interface IControllerThread {

	RC Start();

	MessagesToSend getMessagetosend();

	Thread getRcthread();

	IRecThread getRecthread();

	Thread getSdthread();

	ISendThread getSendthread();

	Socketwrapper getSw();


	void setMessagetosend(MessagesToSend messagetosend);

	void setRcthread(Thread rcthread);

	void setRecthread(IRecThread recthread);


	void setSdthread(Thread sdthread);

	void setSendthread(ISendThread sendthread);

	void setSw(Socketwrapper sw);
	IServerThread getServerthread();

	AtomicBoolean getRunning();
	void setRunning(AtomicBoolean running);
}