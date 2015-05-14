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
public class FilterCloseTime extends FilterCalendar{

    public FilterCloseTime(Calendar searchDate) {
        super(searchDate);
    }

    public FilterCloseTime(Calendar searchDate, int operator) {
        super(searchDate, operator);
    }

    @Override
    public List<Auction> meetFilter(List<Auction> items) {
        List<Auction> keyItems = new ArrayList<>();

        for (Auction item : keyItems) {
            if (operator > 0) {
                if (searchDate.after(item.getCloseTime())) {
                    keyItems.add(item);
                }
            } else if (operator < 0) {
                if (searchDate.before(item.getCloseTime())) {
                    keyItems.add(item);
                }
            } else {
                if (searchDate.equals(item.getCloseTime())) {
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

    @Override
    public String getWhere() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
