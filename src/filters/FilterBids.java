/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import bid.Bid;
import item.Item;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lloyd
 */
public class FilterBids implements Filter{
    
    Bid searchBid;

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
    public List<Item> meetFilter(List<Item> items) {
        List<Item> titleItems = new ArrayList<>();

        for (Item item : titleItems) {
            if (item.getHighestBid().compareTo(searchBid) <= 0) {
                titleItems.add(item);
            }
        }
        return titleItems;
    }
    
}
