/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import comms.SocketComms;
import java.net.*;
import java.io.*;
import message.StringMessage;

/**
 *
 * @author Lloyd
 */
public class Server implements Runnable {

    private Socket connection;
    private String TimeStamp;
    private int ID;

    public static void main(String[] args) {
        int port = 19999;
        int count = 0;
        try {
            ServerSocket socket1 = new ServerSocket(port);
            System.out.println("MultipleSocketServer Initialized");
            while (true) {
                Socket connection = socket1.accept();
                Runnable runnable = new Server(connection, ++count);
                Thread thread = new Thread(runnable);
                thread.start();
            }
        } catch (Exception e) {
        }
    }

    Server(Socket s, int i) {
        this.connection = s;
        this.ID = i;
    }

    @Override
    public void run() {
        try {
            SocketComms comms = new SocketComms(connection);
            System.out.println(comms.recieveMessage());
            TimeStamp = new java.util.Date().toString();
            String returnCode = "MultipleSocketServer repsonded at " + TimeStamp + (char) 13;
            StringMessage message = new StringMessage(returnCode);
            comms.sendMessage(message);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                connection.close();
            } catch (IOException e) {
            }
        }
    }

}
