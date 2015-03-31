/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Items;

import java.util.Calendar;
import java.util.HashMap;

/**
 *
 * @author Lloyd
 */
public class Item {
    
    private String title;
    private String description;
    private String keyword;
    private int userID;
    private int reservePrice;
    private Calendar startTime;
    private Calendar closeTime;
    private HashMap <Integer, Integer> currentBids;

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
     * @return the keyword
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     * @param keyword the keyword to set
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    /**
     * @return the userID
     */
    public int getUserID() {
        return userID;
    }

    /**
     * @param userID the userID to set
     */
    public void setUserID(int userID) {
        this.userID = userID;
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
     * @return the currentBids
     */
    public HashMap <Integer, Integer> getCurrentBids() {
        return currentBids;
    }

    /**
     * @param currentBids the currentBids to set
     */
    public void setCurrentBids(HashMap <Integer, Integer> currentBids) {
        this.currentBids = currentBids;
    }
    
}
