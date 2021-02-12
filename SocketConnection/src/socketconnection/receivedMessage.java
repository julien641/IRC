/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketconnection;

/**
 *
 * @author julien
 */
public class receivedMessage extends Message{
    private RC rc;
    public receivedMessage(Messagestype messagestype, String from,RC rc) {
        super(messagestype, from);
    }

    @Override
    public void process() {
      
    }
    
}
