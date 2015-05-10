package filters;

import item.Item;
import java.util.List;

/**
 *
 * @author Lloyd
 */
public interface Filter {

    //Public interface for implementation of Filter Design Pattern
    
    public List<Item> meetFilter(List<Item> items);
}
