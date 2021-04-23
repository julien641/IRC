/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxchatserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;

import Interface.Server.IControllerThread;
import Interface.Server.IServerThread;

import javax.net.ServerSocketFactory;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

/**
 * @author julien
 */
public class ServerThread implements Runnable, IServerThread {

    private SSLServerSocket sslserversocket;
    private ServerSocket serverSocket;
    private AtomicBoolean running;
    final private int port;
    private ArrayList<IControllerThread> controllerthreads;
    final private int timeout = 0;
    private Javafxchatserver mainthread;


    public ServerThread(Javafxchatserver mainthread, int port) {
        this.port = port;
        controllerthreads = new ArrayList<>();
        this.running = new AtomicBoolean(true);
        this.mainthread = mainthread;
    }


    @Override
    public void run() {

        serverSocket = startingserversocket(port);
        try {
            while (running.get() && serverSocket != null) {

                Socket s = null;
                try {
                    s = serverSocket.accept();

                    if (s != null && s.isConnected() && s.isBound() && !s.isClosed() && !s.isInputShutdown() && !s.isOutputShutdown()) {
                        System.out.println("Socket accepted");
                        try {
                            ControllerThread current = new ControllerThread(s, this);
                            current.Start();
                            controllerthreads.add(current);
                        } catch (Exception x) {
                            System.out.println("Failed to connect initialize socket wrapper");
                        }
                    }
                } catch (SocketTimeoutException timeout) {

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Closing server");
        cleanend();
    }


    public ServerSocket startingserversocket(int port) {
        ServerSocket serversocket = null;
        try {
            serversocket = ServerSocketFactory.getDefault().createServerSocket(port);
            serversocket.setSoTimeout(timeout);
        } catch (IOException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        return serversocket;
    }

    public SSLServerSocket SSLstartingserversocket(int port) {
        SSLServerSocket serversocket = null;
        try {
            serversocket = (SSLServerSocket) SSLServerSocketFactory.getDefault().createServerSocket(port);
            serversocket.setEnabledCipherSuites(new String[]{"SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA"});
            serversocket.setSoTimeout(timeout);
        } catch (IOException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        return serversocket;
    }

    public Socket socketcreation() {

        Socket s = null;
        try {
            s = serverSocket.accept();
        } catch (IOException ex) {
            //	Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;

    }

    public void stop() {
        running.set(false);
    }

    public int getPort() {
        return port;
    }

    private void cleanend() {
        try {
            serverSocket.close();
            serverSocket = null;
            for (IControllerThread thread : controllerthreads) {
                thread.close();
            }

        } catch (IOException ex) {
            System.out.println("");
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, "Cleaning error", ex);
        }

    }


}
