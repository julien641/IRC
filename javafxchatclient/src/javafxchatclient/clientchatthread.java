/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxchatclient;



import clientMessage.Message;
import socketconnection.Socketwrapper;
import javafx.scene.control.TextArea;

/**
 *
 * @author julien
 */
public class clientchatthread implements Runnable {

    private Socketwrapper sw;
    private String name;
    private TextArea chatarea;

    public clientchatthread() {

	}

	public clientchatthread(Socketwrapper sw, TextArea chatarea) {

		this.sw = sw;
		this.chatarea = chatarea;
	}

	@Override
	public void run() {
		System.out.println("Thread running");

		while (true) {
			Message message = (Message) sw.receivemessage();
			processmessage(message);

		}
	}

	public void processmessage(Message message) {

	}

}
