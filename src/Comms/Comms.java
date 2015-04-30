/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comms;

import java.io.IOException;

/**
 *
 * @author Lloyd
 */
public interface Comms {
    
    /**
     *
     * @param message
     * @return
     */
    public boolean sendMessage (String message) throws IOException;
    
    public String recieveMessage() throws IOException;
    
    public boolean close() throws IOException;
    
    public boolean connect() throws IOException;
}
