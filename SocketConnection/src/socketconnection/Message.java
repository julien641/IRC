/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketconnection;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Random;


/**
 *
 * @author julien
 * @param <T>
 * @param <B>
 */
    public abstract class Message implements Serializable, messageInterface {
    
    private final static Random RANDOM = new Random();
    final private int id;
    final private Timestamp timestamp;
    final private Messagestype messagestype;
    final private String from;

    public Message(Messagestype messagestype, String from) {
        this.id =RANDOM.nextInt();
        this.timestamp = Timestamp.from(Instant.now());
        this.messagestype = messagestype;
       
        this.from = from;
    }
    public int getId() {
        return id;
    }
    public Messagestype getMessagestype() {
        return messagestype;
    }
    public String getFrom() {
        return from;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }



}
