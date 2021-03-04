/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxchatclient.thread;

import java.util.concurrent.atomic.AtomicBoolean;

import clientMessage.Message;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafxchatclient.ChattabController;
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
	private IChat chattabController;

	public ChatThreadController() {
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
