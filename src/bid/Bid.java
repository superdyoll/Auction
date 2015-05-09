/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bid;

import users.User;

/**
 *
 * @author Lloyd
 */
public class Bid implements Comparable<Bid> {

    public User bidder;
    public Double bid;

    public Bid(User bidder, Double bid) {
        this.bidder = bidder;
        this.bid = bid;
    }

    /**
     * @return the bidder
     */
    public User getBidder() {
        return bidder;
    }

    /**
     * @return the bid
     */
    public Double getBid() {
        return bid;
    }

    @Override
    public int compareTo(Bid o) {
        return bid.compareTo(o.getBid());
    }
}
