/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientMessage.MessageData;

import Interface.Server.IControllerThread;

/**
 *
 * @author julien
 */
public interface IServerMessage {
	void setDefaultAction(IControllerThread controllerthread);
	
}
