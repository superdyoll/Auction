/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filter;

import Items.Item;
import java.util.List;

/**
 *
 * @author Lloyd
 */
public class OrFilter implements Filter{

    private Filter criteria;
    private Filter otherFilter;

    public OrFilter(Filter criteria, Filter otherFilter) {
        this.criteria = criteria;
        this.otherFilter = otherFilter;
    }

    @Override
    public List<Item> meetFilter(List<Item> items) {
        List<Item> firstFilterItems = criteria.meetFilter(items);
        List<Item> otherFilterItems = otherFilter.meetFilter(items);

        for (Item item : otherFilterItems) {
            if (!firstFilterItems.contains(item)) {
                firstFilterItems.add(item);
            }
        }
        return firstFilterItems;
    }
}
