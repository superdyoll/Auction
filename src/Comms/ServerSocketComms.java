/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comms;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author Lloyd
 */
public class ServerSocketComms implements Comms {

    //TODO implement deserialization
    
    Socket connection;

    @Override
    public boolean sendMessage(Message messageToSend) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public Object recieveMessage() throws IOException {
        BufferedInputStream is = new BufferedInputStream(connection.getInputStream());
        InputStreamReader isr = new InputStreamReader(is);
        int character;
        StringBuffer process = new StringBuffer();
        while ((character = isr.read()) != 13) {
            process.append((char) character);
        }
        return process.toString();
    }

    @Override
    public boolean close() throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean connect() throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
