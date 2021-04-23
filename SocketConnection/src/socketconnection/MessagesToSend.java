/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketconnection;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author julien
 */
public class MessagesToSend <T>{

	private final ReentrantLock lock = new ReentrantLock();
	private final ArrayList<T> messagetosend = new ArrayList<>();

	public ArrayList<T> getMessagetosend() {
		return messagetosend;
	}

	public boolean addFrontMessage(T message) {

		synchronized (messagetosend) {
			System.out.println("adding message");
			boolean rc = true;
			lock.lock();
			try {
				messagetosend.add(0,message);
			} finally {
				lock.unlock();
				messagetosend.notify();
			}

			return rc;
		}
	}
	public void waitOnMessage(){
		while (!hasremaining()) {
			try {
				messagetosend.wait();
			} catch (InterruptedException ignored) {
				Thread.currentThread().interrupt();
			}
		}

	}


	public boolean addMessage(T message) {

		synchronized (messagetosend) {
			System.out.println("adding message");
			boolean rc = false;
			lock.lock();
			try {
				rc = messagetosend.add(message);
			} finally {
				lock.unlock();

				messagetosend.notify();
			}

			return rc;
		}
	}

	public T getRemMessage() {
		System.out.println("removing message");
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
