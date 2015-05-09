/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comms;

import message.Message;
import java.io.IOException;

/**
 *
 * @author Lloyd
 */
public interface Comms {

    /**Send the Message
     *
     * @param messageToSend
     * @return
     * @throws java.io.IOException
     */
    public boolean sendMessage(Message messageToSend) throws IOException;

    /**Takes a String input and transforms it into a StringMessage
     *
     * @param message
     * @return
     * @throws IOException
     */
    public boolean sendMessage(String message) throws IOException;

    /**Return the message
     *
     * @return
     * @throws IOException
     */
    public Message recieveMessage() throws IOException;

    /**Close the connection
     *
     * @return
     * @throws IOException
     */
    public boolean close() throws IOException;

    /**Connect to the socket
     *
     * If you pass in a connection this will not need to be done unless the 
     * connection is closed at some point
     * 
     * @return
     * @throws IOException
     */
    public boolean connect() throws IOException;
}
