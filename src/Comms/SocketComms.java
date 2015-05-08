/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comms;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lloyd
 */
public class SocketComms implements Comms {

    protected int port;
    protected String host;
    String TimeStamp;
    static InetAddress address;
    static Socket connection;
    BufferedInputStream bis = null;
    BufferedOutputStream bos;

    public SocketComms(int port, String host) {
        this.port = port;
        this.host = host;
    }

    @Override
    public boolean sendMessage(Message message) throws IOException {

        /**
         * Instantiate a BufferedOutputStream object
         */
        bos = new BufferedOutputStream(connection.
                getOutputStream());

        //System.out.println("Buffered object set up");
        /**
         * Instantiate an OutputStreamWriter object with the optional character
         * encoding.
         */
        OutputStreamWriter osw = new OutputStreamWriter(bos, "US-ASCII");

        //System.out.println("osw set up");
        /**
         * Write across the socket connection and flush the buffer
         */
        osw.write(message);
        //System.out.println("written");
        osw.flush();
        //System.out.println("flushed");
        return true;
    }

    @Override
    public String recieveMessage() throws IOException {
        StringBuffer instr = new StringBuffer();
        /**
         * Instantiate a BufferedInputStream object for reading /** Instantiate
         * a BufferedInputStream object for reading incoming socket streams.
         */
        bis = new BufferedInputStream(connection.
                getInputStream());
        /**
         * Read the socket's InputStream and append to a StringBuffer
         */
        /**
         * Instantiate an InputStreamReader with the optional character
         * encoding.
         */
        InputStreamReader isr = new InputStreamReader(bis, "US-ASCII");
        /**
         * Read the socket's InputStream and append to a StringBuffer
         */
        int c;
        while ((c = isr.read()) != 13) {
            instr.append((char) c);
        }

        return instr.toString();

    }

    @Override
    public boolean close() throws IOException {
        try {
            /**
             * Close the socket connection.
             */
            bos.close();
            bis.close();
            connection.close();
        } catch (IOException ex) {
            Logger.getLogger(SocketComms.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
    public boolean connect() throws IOException {
        try {
            /**
             * Obtain an address object of the server
             */
            address = InetAddress.getByName(host);
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
