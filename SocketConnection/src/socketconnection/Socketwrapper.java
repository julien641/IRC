/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketconnection;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author julien
 */
public class Socketwrapper {

    int port;
    String website;
    Socket socket;
    int personalid;
  
    boolean connected;
    OutputStream outputstream;
    ObjectOutputStream objectOutputStream;
    InputStream inputStream;
    ObjectInputStream objectInputStream;
    
    


    public Message receivemessage()  {
        Message message = null;
        try {
            message=(Message)objectInputStream.readObject();
        } catch (IOException ex) {
            System.out.println("IOException");
            Logger.getLogger(Socketwrapper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
             System.out.println("ClassNotFoundException");
            Logger.getLogger(Socketwrapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return message;
    }

    public RC sendMessage(Message message) {
        RC rc=RC.disconnected;
        if (connected) {
            rc = RC.connected;
            try {
                
                objectOutputStream.writeObject(message);
                objectOutputStream.flush();
                
            } catch (UnknownHostException unknownHostException) {
                
                System.out.println("unknownHostException");
                System.out.println(unknownHostException.getMessage());
               rc= RC.unknownHostException;
                
            } catch (IOException e) {
                //TODO: better error loging
                System.out.println("IOException");
                System.out.println(e.getMessage());
                rc= RC.IOException;
                
                
            } 
        }
        return rc;
    }
        public RC connect(Socket socket) {
         RC rc = RC.failed; 
        try {
            this.socket =socket;
            outputstream = this.socket.getOutputStream();
            objectOutputStream = new ObjectOutputStream(outputstream);
            inputStream = this.socket.getInputStream();
            objectInputStream = new ObjectInputStream(inputStream);
            rc= RC.success;
        } catch (IOException ex) {
            Logger.getLogger(Socketwrapper.class.getName()).log(Level.SEVERE, null, ex);
            rc= RC.IOException;
        } finally {

        }

        connected = socket.isConnected();
        return rc;

    }
    
    
    
    
      public RC connect(String website, int port) {
           RC rc= RC.failed;
        try {
           
            
            
            
            socket = new Socket(website, port);
            
            outputstream = socket.getOutputStream();
            objectOutputStream = new ObjectOutputStream(outputstream);
            inputStream = socket.getInputStream();
            objectInputStream = new ObjectInputStream(inputStream);

            rc=RC.success;
            connected = socket.isConnected();
        System.out.println("Connected to Website: "+website+" Port : "+port);
        }catch(ConnectException CE){
         Logger.getLogger(Socketwrapper.class.getName()).log(Level.SEVERE, "ConnectException", CE);
         rc = RC.ConnectException;
        } 
        catch (IOException ex) {
            Logger.getLogger(Socketwrapper.class.getName()).log(Level.SEVERE, "IOException", ex);
             rc = RC.IOException;
        }
    return rc;
    }

}
