/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import comms.SocketComms;
import java.awt.TrayIcon;
import java.net.*;
import java.io.*;
import message.MessageString;

/**
 *
 * @author Lloyd
 */
public class Server implements Runnable {

    private Socket connection;
    private String TimeStamp;
    private int ID;
    private static ServerGUI theGUI;
    private static ServerTrayIcon trayIcon;

    public static void main(String[] args) {
        int port = 19999;
        int count = 0;
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                theGUI = new ServerGUI();
                theGUI.setVisible(true);
                trayIcon = new ServerTrayIcon(theGUI);
                trayIcon.displayNotification("Server set up", TrayIcon.MessageType.INFO);
            }
        });
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
            MessageString message = new MessageString(returnCode);
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
