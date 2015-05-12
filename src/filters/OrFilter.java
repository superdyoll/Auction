/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import auction.Auction;
import java.util.List;

/**
 *
 * @author Lloyd
 */
public class OrFilter implements Filter{

    private Filter criteria;
    private Filter otherFilter;
    private String where;

    public OrFilter(Filter criteria, Filter otherFilter) {
        this.criteria = criteria;
        this.otherFilter = otherFilter;
        where = criteria.getWhere() + " OR " + otherFilter.getWhere();
    }

    @Override
    public List<Auction> meetFilter(List<Auction> items) {
        List<Auction> firstFilterItems = criteria.meetFilter(items);
        List<Auction> otherFilterItems = otherFilter.meetFilter(items);

        for (Auction item : otherFilterItems) {
            if (!firstFilterItems.contains(item)) {
                firstFilterItems.add(item);
            }
        }
        return firstFilterItems;
    }

    @Override
    public String getWhere() {
        return where;
    }
}
