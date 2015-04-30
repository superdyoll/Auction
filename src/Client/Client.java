/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;
/*  The java.net package contains the basics needed for network operations. */

import Comms.Comms;
import Comms.SocketComms;
import java.net.*;
/* The java.io package contains the basics needed for IO operations. */
import java.io.*;

/**
 * The SocketClient class is a simple example of a TCP/IP Socket Client.
 *
 */
/**
 *
 * @author Lloyd
 */
public class Client {

    public static void main(String[] args) {
        /**
         * Define a host server
         */
        String host = "localhost";
        /**
         * Define a port
         */
        int port = 19999;

        System.out.println("SocketClient initialized");
        try {
            Comms connection = new SocketComms(port, host);
            System.out.println("Try to connect");
            connection.connect();

            String TimeStamp = new java.util.Date().toString();
            String process = "Calling the Socket Server on " + host + " port " + port
                    + " at " + TimeStamp + (char) 13;

            System.out.println("Try sending message");
            connection.sendMessage(process);

            System.out.println("Retreive message");
            String returned = connection.recieveMessage();
            
            System.out.println(returned);
            
            System.out.println("Close");
            connection.close();
           
        } catch (IOException f) {
            System.out.println("IOException: " + f);
        } catch (Exception g) {
            System.out.println("Exception: " + g);
        }
    }
}
