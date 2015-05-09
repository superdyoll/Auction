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
public class FilterDescription extends FilterString {

    public FilterDescription(String filter) {
        super(filter);
    }

    @Override
    public List<Item> meetFilter(List<Item> items) {
        List<Item> descrItems = new ArrayList<>();

        for (Item item : descrItems) {
            if (item.getDescription().equalsIgnoreCase(filter)) {
                descrItems.add(item);
            }
        }
        return descrItems;
    }

}
