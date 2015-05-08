/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comms;

import java.util.ArrayList;

/**
 *
 * @author Lloyd
 */
public class Message<E> implements java.io.Serializable{
    //TODO implement encryption
    //TODO make message abstract and make different message types
    
    private int messageID;
    private ArrayList<E> objects;

    public Message(int messageID, ArrayList<E> objects) {
        this.messageID = messageID;
        this.objects = objects;
    }

    public Message(int messageID) {
        this(messageID, new ArrayList<E>());
        
    }
    
    

    /**
     * @return the messageID
     */
    public int getMessageID() {
        return messageID;
    }

    /**
     * @param messageID the messageID to set
     */
    public void setMessageID(int messageID) {
        this.messageID = messageID;
    }

    /**
     * @return the objects
     */
    public ArrayList getObjects() {
        return objects;
    }

    /**
     * @param objects the objects to set
     */
    public void setObjects(ArrayList<E> objects) {
        this.objects = objects;
    }
    
    
}
