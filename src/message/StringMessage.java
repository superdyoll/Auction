/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package message;

/**
 *
 * @author Lloyd
 */
public class StringMessage extends Message {

    int messageID = 1;
    String stringMessage;

    public StringMessage(String message) {
        super(1);
        stringMessage = message;
    }

    @Override
    public String getMessage() {
        return stringMessage;
    }

    @Override
    public void setMessage(Object message) throws Exception {
        if (message instanceof String) {
            stringMessage = (String) message;
        } else {
            throw new Exception("Message is not a string");
        }
    }

    @Override
    public String toString() {
        String returned = "ID: " + messageID + " Message: " + stringMessage;
        return returned;
    }

}
