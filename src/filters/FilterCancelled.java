/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import item.Item;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lloyd
 */
public class FilterCancelled extends FilterBoolean{

    public FilterCancelled(boolean filter) {
        super(filter);
    }

    @Override
    public List<Item> meetFilter(List<Item> items) {
        List<Item> titleItems = new ArrayList<>();

        for (Item item : titleItems) {
            if (item.isCancelled()) {
                titleItems.add(item);
            }
        }
        return titleItems;
    }
    
}
