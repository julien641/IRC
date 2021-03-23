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
import clientMessage.MessageData.ClientToServer.MessageLogin;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.text.Text;
import javafxchatclient.Tree.Item.ConnectionTreeItem;
import javafxchatclient.Tree.Item.ServerTreeItem;
import socketconnection.Login;
import socketconnection.MessagesToSend;
import socketconnection.RC;
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
	private ServerTreeItem server;
	private Thread connection;
	private IChatclientController chatclientController;
	private boolean connected = false;
	private STATUS status;
	public void setChatclientController(IChatclientController chatclientController) {
		this.chatclientController = chatclientController;
	}

	public ChatThreadController(Login login, IChatclientController chatclientController) {
		status =STATUS.initialized;
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

	private void setuptree(){

		server =new ServerTreeItem(login.getServername(), this);
		server.setExpanded(true);
		ConnectionTreeItem connectionTreeItem = new ConnectionTreeItem(this);
		server.getChildren().add(connectionTreeItem);
		TreeView view  =chatclientController.getTreechannelview();
		view.getRoot().getChildren().add(server);
	}



	public void init(){
		setuptree();
		RC rc = RC.failed;

		if( server.getChildren().size() ==1 && server.getChildren().get(0) instanceof ConnectionTreeItem) {
			ConnectionTreeItem connecting = (ConnectionTreeItem) server.getChildren().get(0);
			status = STATUS.connecting;

			for (int i = 0; i < connecting.getMax(); i++) {
				connecting.setValue(new Text("Connecting ....(" + i + ")"));
				rc = this.getSw().connect(this.getLogin().getIp(), this.getLogin().getPort());
				if (rc == RC.success) {
					status =STATUS.connected;
					break;
				}
				try {
					connecting.setValue(new Text("Sleeping for 10 seconds"));
					Thread.currentThread().sleep(10000);

				} catch (InterruptedException ignored) {
				}

			}
			if (rc != RC.success) {
				connecting.setValue(new Text("Failed to connect"));
				status = STATUS.failedtoconnect;
			}else{
				start();
				MessageLogin messageLogin = new MessageLogin(this.getLogin());
				getMts().addMessage(messageLogin);
				connecting.setValue(new Text("Waiting for the server"));
				status = STATUS.waitingforresponse;
			}
		}


	}

	private void start(){

		if(status ==STATUS.connected) {
			status = STATUS.started;
			running.set(true);
			recChatThread = new RecChatThread(this);
			sendChatThread = new SendChatThread(this);
			trec = new Thread(recChatThread);
			tsend = new Thread(sendChatThread);
			mts = new MessagesToSend<>(tsend);
			trec.start();
			tsend.start();
		}

	}
	enum STATUS{

		initialized,
		started,
		waitingforresponse,
		failedtoconnect,
		connecting,
		connected, disconnected
	}



	public void end(){
		status =STATUS.disconnected;
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
