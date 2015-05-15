/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import client.ClientGUI;
import comms.SocketComms;
import java.awt.TrayIcon;
import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import message.Message;
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
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

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
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            trayIcon.displayNotification("Recieved connection", TrayIcon.MessageType.INFO);
            SocketComms comms = new SocketComms(connection);
            Message message = comms.recieveMessage();
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
    
    public Message switchMessage (Message message){
        switch (message.getMessageID()){
            case 0:
                
        }
    }

}
