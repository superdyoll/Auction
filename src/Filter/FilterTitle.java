/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filter;

import Items.Item;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lloyd
 */
public class FilterTitle extends FilterString {

    public FilterTitle(String filter) {
        super(filter);
    }

    @Override
    public List<Item> meetFilter(List<Item> items) {
        List<Item> titleItems = new ArrayList<>();

        for (Item item : titleItems) {
            if (item.getTitle().equalsIgnoreCase(filter)) {
                titleItems.add(item);
            }
        }
        return titleItems;
    }

}
