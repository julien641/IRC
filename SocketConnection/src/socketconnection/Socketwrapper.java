/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketconnection;

import clientMessage.Message;

import javax.net.SocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.Socket;

/**
 *
 * @author julien
 */
public class Socketwrapper<E extends Message> {

	private Socket socket;

	private SSLSocket SSLsocket;
	private boolean connected;
	private OutputStream outputstream;
	private ObjectOutputStream objectOutputStream;
	private InputStream inputStream;
	private ObjectInputStream objectInputStream;

	public  E receivemessage() throws IOException, ClassNotFoundException {
		return  (E) objectInputStream.readObject();
	}

	public  void sendMessage(E message) throws IOException {
				objectOutputStream.writeObject(message);
				objectOutputStream.flush();
	}
	public void connect(Socket socket) throws IOException {

			this.socket = socket;
			outputstream = this.socket.getOutputStream();
			objectOutputStream = new ObjectOutputStream(outputstream);
			inputStream = this.socket.getInputStream();
			objectInputStream = new ObjectInputStream(inputStream);
			connected = socket.isConnected();
	}
	public void SSLconnect(SSLSocket socket) throws IOException {
			this.SSLsocket = socket;
			outputstream = this.socket.getOutputStream();
			objectOutputStream = new ObjectOutputStream(outputstream);
			inputStream = this.socket.getInputStream();
			objectInputStream = new ObjectInputStream(inputStream);
			connected = socket.isConnected();

	}

	public void connect(String website, int port) throws IOException {
			socket = SocketFactory.getDefault().createSocket(website, port);
			outputstream = socket.getOutputStream();
			objectOutputStream = new ObjectOutputStream(outputstream);
			inputStream = socket.getInputStream();
			objectInputStream = new ObjectInputStream(inputStream);
			connected = socket.isConnected();
			System.out.println("Connected to Website: " + website + " Port : " + port);
	}
	public void SSLconnect(String website, int port) throws IOException {
			SSLsocket = (SSLSocket) SSLSocketFactory.getDefault().createSocket(website, port);
			outputstream = socket.getOutputStream();
			objectOutputStream = new ObjectOutputStream(outputstream);
			inputStream = socket.getInputStream();
			objectInputStream = new ObjectInputStream(inputStream);
			connected = socket.isConnected();
			System.out.println("Connected to Website: " + website + " Port : " + port);
	}

	public void closeSocket() throws IOException {
		socket.setSoTimeout(1);
		socket.close();
	}

}
