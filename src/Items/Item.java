/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Items;

import Bids.Bid;
import Users.User;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Lloyd
 */
public class Item {

    private String title;
    private String description;
    private final List<String> keywords;
    private User seller;
    private int reservePrice;
    private Calendar startTime;
    private Calendar closeTime;
    private List<Bid> allBids;

    public Item(String title, String description,
            User user, int reservePrice,
            Calendar startTime, Calendar closeTime) {
        this.title = title;
        this.description = description;
        this.keywords = new ArrayList<>();
        this.seller = user;
        this.reservePrice = reservePrice;
        this.startTime = startTime;
        this.closeTime = closeTime;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the keywords
     */
    public List<String> getKeyword() {
        return keywords;
    }

    /**
     * @param keyword the keywords to set
     */
    public void addKeyword(String keyword) {
        this.keywords.add(keyword);
    }

    /**
     *
     * @param keyword
     */
    public void removeKeyword(String keyword) {
        this.keywords.remove(keyword);
    }

    /**
     * Returns whether the item has a certain keyword
     *
     * @param keyword
     * @return
     */
    public boolean containsKeyword(String keyword) {
        return keywords.contains(keyword);
    }

    /**
     * @return the userID
     */
    public User getSeller() {
        return seller;
    }

    /**
     * @param user
     */
    public void setSeller(User user) {
        this.seller = user;
    }

    /**
     * @return the reservePrice
     */
    public int getReservePrice() {
        return reservePrice;
    }

    /**
     * @param reservePrice the reservePrice to set
     */
    public void setReservePrice(int reservePrice) {
        this.reservePrice = reservePrice;
    }

    /**
     * @return the startTime
     */
    public Calendar getStartTime() {
        return startTime;
    }

    /**
     * @param startTime the startTime to set
     */
    public void setStartTime(Calendar startTime) {
        this.startTime = startTime;
    }

    /**
     * @return the closeTime
     */
    public Calendar getCloseTime() {
        return closeTime;
    }

    /**
     * @param closeTime the closeTime to set
     */
    public void setCloseTime(Calendar closeTime) {
        this.closeTime = closeTime;
    }

    /**
     * @return the allBids
     */
    public List<Bid> getAllBids() {
        return allBids;
    }

    /**
     * Add a new bid on the object
     *
     * @param user
     * @param bid
     */
    public void addBid(User user, Double bid) {
        Bid newBid = new Bid(user, bid);
        addBid(newBid);
    }

    public boolean addBid(Bid bid) {
        if (bid.compareTo(getHighestBid()) > 0) {
            this.allBids.add(bid);
            return true;
        } else {
            return false;
        }
    }

    public Bid getHighestBid() {
        Bid currentHighest = null;
        for (Bid thisBid : allBids) {
            if (thisBid.compareTo(currentHighest) > 0) {
                currentHighest = thisBid;
            }
        }
        return currentHighest;
    }

}
