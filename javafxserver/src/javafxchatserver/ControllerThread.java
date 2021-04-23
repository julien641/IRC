/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxchatserver;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicBoolean;

import Interface.Server.IControllerThread;
import Interface.Server.IServerThread;
import clientMessage.Message;
import clientMessage.MessageData.IServerMessage;
import socketconnection.MessagesToSend;
import socketconnection.RC;
import socketconnection.Socketwrapper;

import javax.net.ssl.SSLSocket;

/**
 * @author julien
 */
public class ControllerThread implements IControllerThread {
    private Runnable sendthread;
    private Runnable recthread;
    private Thread sdthread;
    private Thread rcthread;
    private volatile AtomicBoolean running;
    private MessagesToSend messagetosend;
    private Socketwrapper<Message> sw;
    private IServerThread serverthread;

    public ControllerThread(Socket socket, IServerThread serverthread) throws Exception {
        sw = new Socketwrapper<>();
        sw.connect(socket);
        this.serverthread = serverthread;
        this.running = new AtomicBoolean(true);
        this.sendthread = new SendThread();
        this.recthread = new RecThread();
        this.sdthread = new Thread(this.sendthread);
        this.rcthread = new Thread(this.recthread);
        this.messagetosend = new <Message>MessagesToSend();
        sdthread.start();
        rcthread.start();
    }
    public ControllerThread(SSLSocket socket, IServerThread serverthread) throws IOException {
        this.serverthread = serverthread;
        running = new AtomicBoolean(true);
        sw = new Socketwrapper<>();
        sw.SSLconnect(socket);
        this.sendthread = new SendThread();
        this.recthread = new RecThread();
        this.sdthread = new Thread(this.sendthread);
        this.rcthread = new Thread(this.recthread);
        this.messagetosend = new <Message>MessagesToSend();
        sdthread.start();
        rcthread.start();
    }
    @Override
    public RC Start() {
        //	sdthread.start();
        //	rcthread.start();
        return RC.failed;
    }
    public boolean isRunning() {
        return running.get();

    }
    public void close(){
        running.set(false);
        try {
            sw.closeSocket();
        } catch (IOException e) {
        }

    }

    public void sendThread() {
        synchronized (messagetosend.getMessagetosend()) {
            while (isRunning()) {
                messagetosend.waitOnMessage();

                try {
                    sw.sendMessage((Message) messagetosend.getRemMessage());
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

    }
    public void RecThread() {
        while (isRunning()) {

            Message message = null;
            try {
                message = (Message) sw.receivemessage();

                ((IServerMessage) message).setDefaultAction(this);
                message.activateAction();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
    }
    private class SendThread implements Runnable {
        @Override
        public void run() {
            ControllerThread.this.sendThread();
            System.out.println("closing send thread");
        }
    }
    private class RecThread implements Runnable {
        public void run() {
            System.out.println("rec Thread running");
            ControllerThread.this.RecThread();
        }
    }
}
