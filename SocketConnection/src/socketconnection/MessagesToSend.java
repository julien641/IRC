/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketconnection;

import java.util.ArrayList;
import java.util.Vector;
import java.util.concurrent.locks.ReentrantLock;
import clientMessage.Message;

/**
 *
 * @author julien
 */
public class MessagesToSend <T>{

	private final ReentrantLock lock = new ReentrantLock();
	private ArrayList<T> messagetosend = new ArrayList<>();
	private Thread sendthread;

	public MessagesToSend(Thread sendthread) {
		this.sendthread = sendthread;
	}

	public boolean addMessage(T message) {
		boolean rc = false;
		lock.lock();
		try {
			rc = messagetosend.add(message);
		} finally {
			lock.unlock();
			synchronized (sendthread) {

				sendthread.notify();
			}
		}

		return rc;

	}

	public T getRemMessage() {
		T rc = null;
		lock.lock();
		try {
			rc = messagetosend.get(0);
			messagetosend.remove(0);
		} finally {
			lock.unlock();
		}

		return rc;

	}

	public boolean hasremaining() {
		boolean rc = false;

		lock.lock();
		try {
			rc = !messagetosend.isEmpty();
		} finally {
			lock.unlock();
			return rc;
		}
	}
}
