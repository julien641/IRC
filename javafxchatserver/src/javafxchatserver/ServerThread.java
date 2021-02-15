/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxchatserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import socketconnection.Socketwrapper;

/**
 *
 * @author julien
 */
public class ServerThread implements Runnable {

    private boolean running;
    final private int port;
    private ArrayList<chatthread> chatthreads;
    
    public ServerThread(int port) {
        this.port = port;
        chatthreads = new ArrayList<>();
       this.running =true;
    }

    @Override
    public void run() {

        ServerSocket serversocket;
        while (running) {

            try {
                serversocket = new ServerSocket(port);
                while (running) {
                    Socket s = serversocket.accept();
                    Socketwrapper sw = new Socketwrapper();
                    sw.connect(s);
                    chatthread chat = new chatthread(sw);
                    chatthreads.add(chat);
                    chat.start();

                }

            } catch (IOException e) {
                System.out.println("IOException");
                System.out.println(e.toString());
            }

        }
    }

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public ArrayList<chatthread> getChatthreads() {
		return chatthreads;
	}

	public void setChatthreads(ArrayList<chatthread> chatthreads) {
		this.chatthreads = chatthreads;
	}

}
