/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import auction.Auction;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lloyd
 */
public class FilterClosed extends FilterBoolean{

    public FilterClosed(boolean filter) {
        super(filter);
    }

    @Override
    public List<Auction> meetFilter(List<Auction> items) {
        List<Auction> titleItems = new ArrayList<>();

        for (Auction item : titleItems) {
            if (item.isClosed()) {
                titleItems.add(item);
            }
        }
        return titleItems;
    }
    
}
