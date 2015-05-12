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
public class AndFilter implements Filter{

    private Filter criteria;
    private Filter otherFilter;
    private String where;

    public AndFilter(Filter criteria, Filter otherFilter) {
        this.criteria = criteria;
        this.otherFilter = otherFilter;
        where = criteria.getWhere() + " AND " + otherFilter.getWhere();
    }

    @Override
    public List<Auction> meetFilter(List<Auction> items) {
        List<Auction> firstFilterItems = criteria.meetFilter(items);
        return otherFilter.meetFilter(firstFilterItems);
    }

    @Override
    public String getWhere() {
        return where;
    }
}
