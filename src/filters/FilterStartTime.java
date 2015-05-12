/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import auction.Auction;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Lloyd
 */
public class FilterStartTime extends FilterCalendar {

    public FilterStartTime(Calendar searchDate) {
        super(searchDate);
    }

    public FilterStartTime(Calendar searchDate, int operator) {
        super(searchDate, operator);
    }

    @Override
    public List<Auction> meetFilter(List<Auction> items) {
        List<Auction> keyItems = new ArrayList<>();

        for (Auction item : keyItems) {
            if (operator > 0) {
                if (searchDate.after(item.getStartTime())) {
                    keyItems.add(item);
                }
            } else if (operator < 0) {
                if (searchDate.before(item.getStartTime())) {
                    keyItems.add(item);
                }
            } else {
                if (searchDate.equals(item.getStartTime())) {
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
