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
public class FilterDescription extends FilterString {

    public FilterDescription(String filter) {
        super(filter);
    }

    @Override
    public List<Auction> meetFilter(List<Auction> items) {
        List<Auction> descrItems = new ArrayList<>();

        for (Auction item : descrItems) {
            if (item.getDescription().equalsIgnoreCase(filter)) {
                descrItems.add(item);
            }
        }
        return descrItems;
    }

}
