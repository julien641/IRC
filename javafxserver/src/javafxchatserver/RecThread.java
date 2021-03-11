/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxchatserver;


import Interface.Server.IControllerThread;
import Interface.Server.IRecThread;
import clientMessage.Message;
import clientMessage.MessageData.IServerMessage;


/**
 *
 * @author julien
 */
public class RecThread implements IRecThread {
	private IControllerThread controller;
    
	public RecThread() {

    }

    public RecThread(IControllerThread controller) {
   	this.controller =controller; 
    
    }

    @Override
    public void run() {
        System.out.println("rec Thread running");
    	 
            while(controller.getRunning().get()){

		    
             Message message =   controller.getSw().receivemessage();
             	System.out.println("hello");

		((IServerMessage)message).setDefaultAction(controller);
		message.activateAction();
	     	
            }
           
            
         

          //System.out.println("rec close");
        }//end run

	@Override
	public IControllerThread getController() {
		return  controller;
	}

	@Override
	public void setController(IControllerThread controller) {
		this.controller =  controller;
	}
    
    
        
    
    
   

 }/////////////////////////////////////////end
