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
public class connectionMessage extends Message {
    String password;
    
    public connectionMessage(String username,String password){
         super(Messagestype.connection,username);
    }

    @Override
    public void process() {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

	@Override
	public void setupController() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}


    
}
