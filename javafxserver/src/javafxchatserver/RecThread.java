/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxchatserver;


import Interface.Server.IControllerThread;
import Interface.Server.IRecThread;
import clientMessage.IServerMessage;
import clientMessage.Message;


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
        System.out.println("Thread running");
    	 
            while(controller.isRunning()){

		    
             Message message =  (Message) controller.getSw().receivemessage();
		((IServerMessage)message).setDefaultAction(controller);
		message.activateAction();
	     	
            }
           
            
         

           
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
