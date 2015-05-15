/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package message;

import java.util.ArrayList;

/**
 *
 * @author Lloyd
 */
public abstract class Message<E> implements java.io.Serializable {
    //TODO implement encryption
    //TODO make different message types

    private int messageID;
    private String sessionID;

    public Message(int messageID) {
        this.messageID = messageID;
    }

    /**
     *
     * @return the SessionID
     */
    public String getSessionID() {
        return sessionID;
    }

    /**
     *
     * @param sessionID
     */
    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
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

    public abstract Object getMessage();

    public abstract void setMessage(Object message) throws Exception;

    @Override
    public abstract String toString();

}
