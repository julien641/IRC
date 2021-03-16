/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxchatclient.thread;

import java.io.IOException;
import java.net.SocketException;
import java.util.concurrent.atomic.AtomicBoolean;

import Interface.client.IChatTabController;
import Interface.client.IChatThreadController;
import Interface.client.IChatclientController;
import clientMessage.Message;
import javafx.scene.control.TreeItem;
import javafxchatclient.ChatclientController;
import socketconnection.Login;
import socketconnection.MessagesToSend;
import socketconnection.Socketwrapper;

/**
 *
 * @author julien
 */
public class ChatThreadController implements IChatThreadController {


	private volatile AtomicBoolean running;

	private Login login;
	private Socketwrapper sw;
	private IChatTabController chattabController;
	private TreeItem<?> server;
	private Thread connection;
	private IChatclientController chatclientController;

	public void setChatclientController(IChatclientController chatclientController) {
		this.chatclientController = chatclientController;
	}

	public ChatThreadController(Login login, IChatclientController chatclientController) {
		this.login =login;
		sw =new Socketwrapper();
		running = new AtomicBoolean();
		this.server = server;
		this.chatclientController =chatclientController;
	}

	public IChatclientController getChatclientController() {
		return chatclientController;
	}

	private Thread trec;
	private Thread tsend;
	private RecChatThread recChatThread;
	private SendChatThread sendChatThread;
	private MessagesToSend<Message> mts;
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
	public void end(){
		running.set(false);
		try {
			sw.getSocket().setSoTimeout(1);
			sw.getSocket().close();
			server.getParent().getChildren().remove(server);
			chatclientController.getChatcontrollers().remove(this);
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public Thread  getConnection(){
		return connection;
	}
	public void setConnection(Thread Connection){
		this.connection =connection;

	}

	public TreeItem<?> getServer() {
		return server;
	}

	public void setServer(TreeItem<?> server) {
		this.server = server;
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
