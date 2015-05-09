/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import item.Item;
import java.util.List;

/**
 *
 * @author Lloyd
 */
public class AndFilter implements Filter{

    private Filter criteria;
    private Filter otherFilter;

    public AndFilter(Filter criteria, Filter otherFilter) {
        this.criteria = criteria;
        this.otherFilter = otherFilter;
    }

    @Override
    public List<Item> meetFilter(List<Item> items) {
        List<Item> firstFilterItems = criteria.meetFilter(items);
        return otherFilter.meetFilter(firstFilterItems);
    }
}
