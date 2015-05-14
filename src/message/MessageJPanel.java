/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package message;

import javax.swing.JPanel;

/**
 *
 * @author Lloyd
 */
public class MessageJPanel extends Message{

    JPanel panel;
    
    public MessageJPanel(JPanel panel) {
        super(2);
        this.panel = panel;
    }

    @Override
    public JPanel getMessage() {
        return panel;
    }

    @Override
    public void setMessage(Object message) throws Exception {
        if (message instanceof JPanel) {
            panel = (JPanel) message;
        } else {
            throw new Exception("Message is not a JPanel");
        }
    }

    @Override
    public String toString() {
        return "ID: 2 Message: JPanel " + panel.getName();
    }
    
}
