/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientMessage;

import Interface.IControllerThread;

/**
 *
 * @author julien
 */
public interface IServerMessage {
	public abstract void setDefaultAction(IControllerThread controllerthread);
	
}
