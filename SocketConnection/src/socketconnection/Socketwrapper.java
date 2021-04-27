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
 * The goal of this class is to handle sockets and
* keep a socket alive and send and receive objects through the socket
*
 */
public class Socketwrapper<E extends Message> {
	private boolean SSL;
	private Socket socket;
	private SSLSocket SSLsocket;
	private OutputStream outputstream;
	private ObjectOutputStream objectOutputStream;
	private InputStream inputStream;
	private ObjectInputStream objectInputStream;


	/**
	 * @param website URl to the server
	 * @param port port that the server is running on
	 * @param ssl is it SSL?
	 * @throws IOException throws if the socket cannot connect to the server
	 */
	public Socketwrapper(String website, int port,boolean ssl) throws IOException {
		this.SSL =ssl;
		if(ssl) {
			SSLsocket = (SSLSocket) SSLSocketFactory.getDefault().createSocket(website, port);
			outputstream = SSLsocket.getOutputStream();
			inputStream = SSLsocket.getInputStream();
		}else {
			socket = SocketFactory.getDefault().createSocket(website, port);
			outputstream = socket.getOutputStream();
			inputStream = socket.getInputStream();
		}

		objectOutputStream = new ObjectOutputStream(outputstream);
		objectInputStream = new ObjectInputStream(inputStream);
		System.out.println("Connected to Website: " + website + " Port : " + port);
	}

	/**
	 * @param socket passed in by the server non ssl
	 * @throws IOException throws when the server cannot create the streams
	 *
	 * The purpose of this constructor is to create this socketwrapper for the server,
	 * when a socket is already created in a non ssl server connection
	 */
	public Socketwrapper(Socket socket) throws IOException {
		SSL=false;
		this.socket = socket;
		outputstream = this.socket.getOutputStream();
		objectOutputStream = new ObjectOutputStream(outputstream);
		inputStream = this.socket.getInputStream();
		objectInputStream = new ObjectInputStream(inputStream);

	}

	/**
	 * @param socket passed in by the server SSL enabled
	 * @throws IOException throws when the server cannot create the streams
	 */
	public  Socketwrapper(SSLSocket socket) throws IOException{
		SSL = true;
		this.SSLsocket = socket;
		outputstream = this.socket.getOutputStream();
		objectOutputStream = new ObjectOutputStream(outputstream);
		inputStream = this.socket.getInputStream();
		objectInputStream = new ObjectInputStream(inputStream);
	}
	/**
	* This method is to receive messages using the objectInputSTream
	*
	*
	 */
	public  E receivemessage() throws IOException, ClassNotFoundException {
		return  (E) objectInputStream.readObject();
	}
	/**
	 * @param message  object to send through the socket
	 * @throws IOException this is thrown when something is wrong with the socket, or any underlined exception thrown
	 * The purpose of this method is to send a object through the socket
	 *
	 *
	 *
	 */
	public  void sendMessage(E message) throws IOException {
				objectOutputStream.writeObject(message);
				objectOutputStream.flush();
	}


	/**
	 * @throws IOException  thrown if theirs an issue with the underlying sockets, usually ignored
	 */
	public void closeSocket() throws IOException {
		if(SSL) {
			this.SSLsocket.setSoTimeout(1);
			this.SSLsocket.close();
		}else{
			socket.setSoTimeout(1);
			socket.close();


		}

	}

}
