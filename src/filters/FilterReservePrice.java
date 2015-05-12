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
public class FilterReservePrice implements Filter {
    
    double reservePrice;
    int operator;

    /**
     * Find items where reserve price EXACTLY EQUALS the reserve price you enter
     *
     * @param reservePrice
     */
    public FilterReservePrice(double reservePrice) {
        this.reservePrice = reservePrice;
        this.operator = 0;
    }

    /**
     * Find items where the reserve price either is
     *
     * operator: >1 finds those that are greater than the reserve price entered
     * =1 finds those that are greater than or equal to the reserve entered =0
     * finds those that are the same as the reserve price entered =-1 finds
     * those that are less than or equal to the reserve entered <0 finds those
     * that are less than the reserve price entered
     *
     * @param reservePrice
     * @param operator
     */
    public FilterReservePrice(double reservePrice, int operator) {
        this.reservePrice = reservePrice;
        this.operator = operator;
    }
    
    @Override
    public List<Auction> meetFilter(List<Auction> items) {
        List<Auction> keyItems = new ArrayList<>();
        
        for (Auction item : keyItems) {
            if (operator > 0) {
                if (item.getReservePrice() > this.reservePrice) {
                    keyItems.add(item);
                }
            } else if (operator < 0) {
                if (item.getReservePrice() < this.reservePrice) {
                    keyItems.add(item);
                }
            } else {
                if (item.getReservePrice() == this.reservePrice) {
                    keyItems.add(item);
                }
            }
            
        }
        if (operator == 1 || operator == -1) {
            operator = 0;
            keyItems.addAll(meetFilter(items));
        }
        return keyItems;
    }
    
}
