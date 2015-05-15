/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import comms.SocketComms;
import java.awt.TrayIcon;
import java.io.IOException;
import java.net.Socket;
import message.Message;
import message.MessageString;

/**
 *
 * @author Lloyd
 */
public class ServerThread implements Runnable {

    private Socket connection;
    private Server theCreator;
    private int ID;

    ServerThread(Socket s, int i, Server theCreator) {
        System.out.println("New thread created");
        this.connection = s;
        this.ID = i;
        this.theCreator = theCreator;
    }

    @Override
    public void run() {
        try {
            theCreator.displayNotification("Recieved connection", TrayIcon.MessageType.INFO);
            SocketComms comms = new SocketComms(connection);
            Message message = comms.recieveMessage();
            System.out.println(message);
            Message returnMessage = switchMessage(message);
            comms.sendMessage(returnMessage);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                connection.close();
            } catch (IOException e) {
            }
        }
    }

    public Message switchMessage(Message message) {
        switch (message.getMessageID()) {
            case 0:
                break;
        }
        return message;
    }

}
