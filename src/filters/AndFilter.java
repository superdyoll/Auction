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
public class AndFilter extends Filter {

    private Filter criteria;
    private Filter otherFilter;

    public AndFilter(Filter criteria, Filter otherFilter) {
        this.criteria = criteria;
        this.otherFilter = otherFilter;
    }

    @Override
    public List<Auction> meetFilter(List<Auction> items) {
        List<Auction> firstFilterItems = criteria.meetFilter(items);
        return otherFilter.meetFilter(firstFilterItems);
    }

}
