/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxchatserver;


import java.util.ArrayList;
import socketconnection.Socketwrapper;
import socketconnection.messageInterface;


/**
 *
 * @author julien
 */
public class chatthread extends Thread {

    Socketwrapper sw;
    String name;
    static ArrayList<Socketwrapper> chatstockets = new ArrayList<>();

    public chatthread() {

    }

    public chatthread(Socketwrapper sw) {
        chatstockets.add(sw);
        this.sw = sw;
    }

    @Override
    public void run() {
        System.out.println("Thread running");
     
            while(true){
             messageInterface message =  sw.receivemessage();
             message.process();
            
            }
           
            
         

           
        }//end run
    
    
  /*  public void processmessage(messageInterface message){
    switch(message.getMessagestype()){
        case name:
            processname(message);
            break;
        case chat:
            
            
            
            break;
        case userlist:
            break;
        case connection:
            break;
            default:System.out.println("Unknown message type");
        
    }
    */
    
    
   
/*
    private void processname(Message message) {
      name= (String)message.getMessage();
        System.out.println("Name " + name);
        
        
    }
    */

 }/////////////////////////////////////////end
