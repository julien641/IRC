/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxchatclient;

import Interface.MessagesToSend;
import java.util.concurrent.atomic.AtomicBoolean;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import socketconnection.Socketwrapper;

/**
 *
 * @author julien
 */
public class ChatController {
	private Thread trec;
	private Thread tsend;
	private volatile AtomicBoolean running;
	private MessagesToSend mts;
	
	private TabPane tabpane;
	private Tab tab;
	private Socketwrapper sw;

	public ChatController(Thread trec, Thread tsend, MessagesToSend mts, TabPane tabpane, Tab tab, Socketwrapper sw) {
		this.trec = trec;
		this.tsend = tsend;
		this.mts = mts;
		this.tabpane = tabpane;
		this.tab = tab;
		this.sw = sw;
	}
	
	public void start(){
		running.set(true);

	
	
	
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

	public AtomicBoolean getRunning() {
		return running;
	}

	public void setRunning(AtomicBoolean running) {
		this.running = running;
	}

	public MessagesToSend getMts() {
		return mts;
	}

	public void setMts(MessagesToSend mts) {
		this.mts = mts;
	}

	public TabPane getTabpane() {
		return tabpane;
	}

	public void setTabpane(TabPane tabpane) {
		this.tabpane = tabpane;
	}

	public Tab getTab() {
		return tab;
	}

	public void setTab(Tab tab) {
		this.tab = tab;
	}

	public Socketwrapper getSw() {
		return sw;
	}

	public void setSw(Socketwrapper sw) {
		this.sw = sw;
	}
	

	
	
	
}
