package client;

import comms.Comms;
import comms.SocketComms;
import java.io.*;
import javax.swing.JLabel;
import javax.swing.JPanel;
import message.Message;
import message.MessageJPanel;
import message.MessageString;

/**
 *
 * @author Lloyd
 */
public class Client {

    private Comms connection;
    String sessionID= "blah";

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
        new Client().initComponents();
    }

    public void closeConnection() throws IOException {
        System.out.println("Close");
        connection.close();
    }

    public void sendMessage(Message message) throws IOException {
        message.setSessionID(sessionID);
        System.out.println(message);
        connection.sendMessage(message);
    }

    public void sendMessage(String message) throws IOException {
        MessageString stringMessage = new MessageString(message);
        sendMessage(stringMessage);
    }

    public Message recieveMessage() throws IOException {
        return connection.recieveMessage();
    }

    public JPanel recieveJPanel() throws IOException {
        Message message = connection.recieveMessage();
        System.out.println(message);
        if (message instanceof MessageJPanel) {
            MessageJPanel returnPanel = (MessageJPanel) message;
            return returnPanel.getMessage();
        } else {
            JLabel label = new JLabel(message.toString());
            JPanel panel = new JPanel();
            panel.add(label);
            return panel;
        }
    }
    
    //public JPanel newAuction(){
        
    //}

    public void initComponents() {
        /**
         * Define a host server
         */
        String host = "localhost";

        /**
         * Define a port
         */
        int port = 19999;

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new GUIThread(this));

        System.out.println("SocketClient initialized");
        try {
            connection = new SocketComms(port, host);
            System.out.println("Try to connect");
            
            
            connection.connect();
            sendMessage("Hello");
            System.out.println("Recieving");
            System.out.println(recieveMessage().toString());
            closeConnection();
        } catch (IOException f) {
            System.out.println("IOException: " + f);
        } catch (Exception g) {
            System.out.println("Exception: " + g);
        }
    }

    private static class GUIThread extends Thread {

        Client base;

        public GUIThread(Client base) {
            this.base = base;
        }

        @Override
        public void run() {
            new ClientGUI(base).setVisible(true);
        }
    }
}
