/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package message;

import auction.Auction;

/**
 *
 * @author Lloyd
 */
public class MessageAuction extends Message{

    Auction auction;
    
    public MessageAuction() {
        super(4);
    }

    @Override
    public Auction getMessage() {
        return auction;
    }

    @Override
    public void setMessage(Object message) throws Exception {
        auction = (Auction) message;
    }

    @Override
    public String toString() {
        return auction.toString();
    }
    
}
