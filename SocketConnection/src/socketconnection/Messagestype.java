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
public  enum Messagestype{
    
    
    name {
        @Override
        public void process(String x) {
        }
    },
    chat {
        public void process(String x) {
        }
    },
    userlist {
        public void  process(String x) {
        }
    },
    connection {
        public void process(String x) {
        }
    },
    response {
        public void  process(String x) {
        }
    };

    public abstract void process(String x);
}
