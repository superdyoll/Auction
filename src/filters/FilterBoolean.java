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
public abstract class FilterBoolean implements Filter{
    boolean filter;

    public FilterBoolean(boolean filter) {
        this.filter = filter;
    }
    
    @Override
    public abstract List<Item> meetFilter(List<Item> items) ;
}
