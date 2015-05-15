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
public abstract class FilterCalendar extends Filter{
    Calendar searchDate;
    int operator;

    /**
     * Find items where reserve price EXACTLY EQUALS the Calendar you enter
     *
     * @param searchDate
     */
    public FilterCalendar(Calendar searchDate) {
        this(searchDate, 0);
    }

    /**
     * Find items where the reserve price either is
     *
     * operator: 
     * >1 finds those that are greater than the Calendar entered
     * =1 finds those that are greater than or equal to the Calendar entered 
     * =0 finds those that are the same as the Calendar entered 
     * =-1 finds those that are less than or equal to the Calendar entered 
     * <0 finds those that are less than the Calendar entered
     *
     * @param searchDate
     * @param operator
     */
    public FilterCalendar(Calendar searchDate, int operator) {
        this.searchDate = searchDate;
        this.operator = operator;
    }
    
    @Override
    public abstract List<Auction> meetFilter(List<Auction> items);
    
}
