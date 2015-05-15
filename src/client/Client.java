package client;

import comms.Comms;
import comms.SocketComms;
import java.io.*;
import message.Message;
import message.MessageString;

/**
 *
 * @author Lloyd
 */
public class Client {

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

        /**
         * Define a host server
         */
        String host = "localhost";

        /**
         * Define a port
         */
        int port = 19999;

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TestGUI().setVisible(true);
            }
        });

        System.out.println("SocketClient initialized");
        try {
            Comms connection = new SocketComms(port, host);
            System.out.println("Try to connect");
            connection.connect();

            String TimeStamp = new java.util.Date().toString();
            String process = "Calling the Socket Server on " + host + " port " + port
                    + " at " + TimeStamp + (char) 13;

            System.out.println("Try sending message");
            MessageString message = new MessageString(process);
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
