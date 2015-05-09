package Client;


import Comms.Comms;
import Comms.SocketComms;
import java.io.*;
import message.Message;
import message.StringMessage;

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
            StringMessage message = new StringMessage(process);
            connection.sendMessage(message);

            System.out.println("Retreive message");
            Message returned = connection.recieveMessage();
            
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
