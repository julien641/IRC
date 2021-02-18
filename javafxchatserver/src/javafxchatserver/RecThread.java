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
public class RecThread implements Runnable {
	private ControllerThread controller;
    
	public RecThread() {

    }

    public RecThread(ControllerThread controller) {
   	this.controller =controller; 
    
    }

    @Override
    public void run() {
        System.out.println("Thread running");
    	 
            while(controller.isRunning()){
             messageInterface message =  controller.getSw().receivemessage();
	     message.setupController();
             message.process();
            
            }
           
            
         

           
        }//end run
    
    
        
    
    
   

 }/////////////////////////////////////////end
