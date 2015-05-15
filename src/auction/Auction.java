/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auction;

import bid.Bid;
import users.User;
import config.Config;
import item.Item;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Lloyd
 */
public class Auction implements java.io.Serializable{

    //TODO Seperate item and things to do with auctions so that multiple auctions can have the same item
    private Item item;
    private List<String> keywords;
    private User seller;
    private double reservePrice;
    private Calendar startTime;
    private Calendar closeTime;
    private List<Bid> allBids;
    private boolean cancelled;
    private boolean closed;
    
    //Import Configuration File
    private Config config;

    public Auction(String title, String description,
            User user, int reservePrice,
            Calendar startTime, Calendar closeTime) {
        this.config = new Config();
        this.item = new Item(title, description);
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
        return item.getTitle();
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.item.setTitle(title);
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return item.getDescription();
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.item.setDescription(description);
    }

    /**
     * @return the keywords
     */
    public List<String> getKeywords() {
        return keywords;
    }

    /**
     * @param keywords the keywords to set
     */
    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
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
    public double getReservePrice() {
        return reservePrice;
    }

    /**
     * @param reservePrice the reservePrice to set
     */
    public void setReservePrice(double reservePrice) {
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
        if (!isCancelled() && !isClosed()) {
            if (!bid.getBidder().equals(seller)) {
                if (bid.compareTo(getHighestBid()) > 0) {
                    return this.allBids.add(bid);
                }
            }
        }
        return false;

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

    /**
     * @return the cancelled
     */
    public boolean isCancelled() {
        return cancelled;
    }

    /**
     * @param cancelled the cancelled to set
     */
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    /**
     * @return the closed
     */
    public boolean isClosed() {
        return closed;
    }

    /**
     * @param closed the closed to set
     */
    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    /**
     * @return the item
     */
    public Item getItem() {
        return item;
    }

    /**
     * @param item the item to set
     */
    public void setItem(Item item) {
        this.item = item;
    }

}
