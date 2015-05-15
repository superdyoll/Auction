/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.awt.event.ActionEvent;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author Lloyd
 */
public class ServerTrayIcon {

    static ServerGUI theGUI;
    static TrayIcon trayIcon;

    public ServerTrayIcon(ServerGUI theGUI) {
        this.theGUI = theGUI;
        createAndShowGUI();
    }

    private static void createAndShowGUI() {
        //Check the SystemTray support
        if (!SystemTray.isSupported()) {
            System.out.println("SystemTray is not supported");
            return;
        }
        final PopupMenu popup = new PopupMenu();
        trayIcon = new TrayIcon(createImage("../resources/Icon.gif", "tray icon"));
        trayIcon.setImageAutoSize(true);
        final SystemTray tray = SystemTray.getSystemTray();

        // Create a popup menu components
        MenuItem itmAbout = new MenuItem("Display Server");
        MenuItem itmExit = new MenuItem("Exit");

        //Add components to popup menu
        popup.add(itmAbout);
        popup.addSeparator();
        popup.add(itmExit);

        trayIcon.setPopupMenu(popup);

        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            System.out.println("TrayIcon could not be added.");
            return;
        }

        trayIcon.addActionListener((ActionEvent e) -> {
            theGUI.setVisible(true);
        });

        itmAbout.addActionListener((ActionEvent e) -> {
            theGUI.setVisible(true);
        });

        itmExit.addActionListener((ActionEvent e) -> {
            tray.remove(trayIcon);
            System.exit(0);
        });
    }

    public void displayNotification(String message, MessageType type) {
        trayIcon.displayMessage("Auction Server", message, type);
    }

    //Obtain the image URL
    protected static Image createImage(String path, String description) {
        URL imageURL = TrayIconCreator.class.getResource(path);

        System.out.println(imageURL);

        if (imageURL == null) {
            System.err.println("Resource not found: " + path);
            return null;
        } else {
            return (new ImageIcon(imageURL, description)).getImage();
        }
    }
}
