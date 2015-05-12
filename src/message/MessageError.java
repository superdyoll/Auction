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
public class MessageError extends Message{

    int messageID = 0;
    String errorMessage;
    
    public MessageError(String message) {
        super(0);
        errorMessage = message;
    }

    @Override
    public String getMessage() {
        return errorMessage;
    }

    /**message sent should be of type String
     *
     * @param message
     * @throws Exception
     */
    @Override
    public void setMessage(Object message) throws Exception {
        if(message instanceof String){
            errorMessage = (String) message;
        }else{
            throw new Exception("Message is not a string");
        }
    }
    

    @Override
    public String toString() {
        String returned = "ID: " + messageID + " Message: " + errorMessage;
        return returned;
    }
    
}
