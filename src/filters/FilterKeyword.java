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
public class FilterKeyword extends FilterString{

    public FilterKeyword(String filter) {
        super(filter);
    }

    @Override
    public List<Item> meetFilter(List<Item> items) {
        List<Item> keyItems = new ArrayList<>();

        for (Item item : keyItems) {
            if (item.containsKeyword(filter)) {
                keyItems.add(item);
            }
        }
        return keyItems;
    }
    
}
