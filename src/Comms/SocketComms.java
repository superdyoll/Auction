/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comms;

import message.Message;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import message.StringMessage;

/**
 *
 * @author Lloyd
 */
public class SocketComms implements Comms {

    protected int port;
    protected String host;
    String TimeStamp;
    static InetAddress address = null;
    static Socket connection;

    ObjectOutputStream oos;

    ObjectInputStream ois = null;

    public SocketComms(int port, String host) {
        this.port = port;
        this.host = host;
    }

    public SocketComms(Socket connection) {
        this.connection = connection;
        this.port = connection.getPort();
        this.address = connection.getInetAddress();
    }

    @Override
    public boolean sendMessage(Message message) throws IOException {

        /**
         * Instantiate a BufferedOutputStream object
         */
        OutputStream bos = new BufferedOutputStream(connection.getOutputStream());

        oos = new ObjectOutputStream(bos);

        //System.out.println("Buffered object set up");
        /**
         * Write across the socket connection and flush the buffer
         */
        oos.writeObject(message);
        //System.out.println("written");
        oos.flush();
        //System.out.println("flushed");
        return true;
    }

    @Override
    public boolean sendMessage(String message) throws IOException {
        StringMessage stringMessage = new StringMessage(message);
        return sendMessage(stringMessage);
    }

    @Override
    public Message recieveMessage() throws IOException {
        Message message = null;
        /**
         * Instantiate a BufferedInputStream object for reading incoming socket
         * streams.
         */

        InputStream buffer = new BufferedInputStream(connection.getInputStream());

        ois = new ObjectInputStream(buffer);

        try {
            message = (Message) ois.readObject();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SocketComms.class.getName()).log(Level.SEVERE, null, ex);
        }
        return message;

    }

    @Override
    public boolean close() throws IOException {
        try {
            /**
             * Close the socket connection.
             */
            oos.close();
            ois.close();
            connection.close();
        } catch (IOException ex) {
            Logger.getLogger(SocketComms.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    /**
     * Connect to the socket
     *
     * If you pass in a connection this will not need to be done unless the
     * connection is closed at some point
     *
     * @return
     * @throws IOException
     */
    @Override
    public boolean connect() throws IOException {
        try {
            /**
             * Obtain an address object of the server
             */
            if (address == null) {
                address = InetAddress.getByName(host);
            }
            /**
             * Establish a socket connection
             */
            connection = new Socket(address, port);
        } catch (IOException ex) {
            Logger.getLogger(SocketComms.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

}
