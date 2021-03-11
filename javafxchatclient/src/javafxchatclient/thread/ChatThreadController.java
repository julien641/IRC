/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxchatclient.thread;

import java.util.concurrent.atomic.AtomicBoolean;

import Interface.client.IChatTabController;
import Interface.client.IChatThreadController;
import clientMessage.Message;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import socketconnection.Login;
import socketconnection.MessagesToSend;
import socketconnection.Socketwrapper;

/**
 *
 * @author julien
 */
public class ChatThreadController implements IChatThreadController {
	private Thread trec;
	private Thread tsend;
	private RecChatThread recChatThread;
	private SendChatThread sendChatThread;
	private volatile AtomicBoolean running;
	private MessagesToSend<Message> mts;

	private Login login;
	private TabPane tabpane;
	private Tab tab;
	private Socketwrapper sw;
	private IChatTabController chattabController;

	public ChatThreadController() {
			running = new AtomicBoolean();



	}
	@Override
	public void start(){
		running.set(true);
		recChatThread = new RecChatThread(this);
		sendChatThread = new SendChatThread(this);
		trec = new Thread(recChatThread);
		tsend = new Thread(sendChatThread);
		mts = new MessagesToSend<>(tsend);
		trec.start();
		tsend.start();
	}

	public Thread getTrec() {
		return trec;
	}

	public void setTrec(Thread trec) {
		this.trec = trec;
	}

	public Thread getTsend() {
		return tsend;
	}

	public void setTsend(Thread tsend) {
		this.tsend = tsend;
	}

	public RecChatThread getRecChatThread() {
		return recChatThread;
	}

	public void setRecChatThread(RecChatThread recChatThread) {
		this.recChatThread = recChatThread;
	}

	public SendChatThread getSendChatThread() {
		return sendChatThread;
	}

	public void setSendChatThread(SendChatThread sendChatThread) {
		this.sendChatThread = sendChatThread;
	}


	@Override
	public AtomicBoolean getRunning() {
		return running;
	}

	@Override
	public void setRunning(AtomicBoolean running) {
		this.running = running;
	}

	@Override
	public MessagesToSend getMts() {
		return mts;
	}

	@Override
	public void setMts(MessagesToSend mts) {
		this.mts = mts;
	}

	@Override
	public Login getLogin() {
		return login;
	}

	@Override
	public void setLogin(Login login) {
		this.login = login;
	}

	@Override
	public TabPane getTabpane() {
		return tabpane;
	}

	@Override
	public void setTabpane(TabPane tabpane) {
		this.tabpane = tabpane;
	}

	@Override
	public Tab getTab() {
		return tab;
	}

	@Override
	public void setTab(Tab tab) {
		this.tab = tab;
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
	public IChatTabController getChattabController() {
		return chattabController;
	}


	@Override
	public void setChattabController(IChatTabController chattabController) {
		this.chattabController = chattabController;
	}
}
