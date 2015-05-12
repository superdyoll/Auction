/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import bid.Bid;
import auction.Auction;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lloyd
 */
public class FilterBids implements Filter{
    
    Bid searchBid;
    String where;

    private void setWhere(){
        where = "MAX(Bid.amount) > " + searchBid.getBid() + " GROUP BY A_ID";
    }
   
    
    /**Find all bids less than the search bid
     *
     * @param searchBid
     */
    public FilterBids(Bid searchBid) {
        this.searchBid = searchBid;
    }
    
    /**Find all bids less than the search bid
     *
     * @param searchBid
     */
    public FilterBids(double searchBid) {
        this.searchBid = new Bid(searchBid);
    }
    
    @Override
    public List<Auction> meetFilter(List<Auction> items) {
        List<Auction> titleItems = new ArrayList<>();

        for (Auction item : titleItems) {
            if (item.getHighestBid().compareTo(searchBid) <= 0) {
                titleItems.add(item);
            }
        }
        return titleItems;
    }

    @Override
    public String getWhere() {
        return where;
    }
    
}
