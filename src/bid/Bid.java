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
public class Bid implements Comparable<Bid>, java.io.Serializable {

    public User bidder;
    public Double bid;

    public Bid(User bidder, Double bid) {
        this.bidder = bidder;
        this.bid = bid;
    }

    public Bid(Double bid) {
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

    /**
     * Compare 2 bids
     *
     * @param anotherBid
     * @return the bid - the value 0 if anotherBid is numerically equal to this
     * Bid; a value less than 0 if this Bid is numerically less than anotherBid;
     * and a value greater than 0 if this Bid is numerically greater than
     * anotherBid
     */
    @Override
    public int compareTo(Bid anotherBid) {
        return bid.compareTo(anotherBid.getBid());
    }
}
