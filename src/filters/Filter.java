package filters;

import auction.Auction;
import java.util.List;

/**
 *
 * @author Lloyd
 */
public interface Filter {

    //Public interface for implementation of Filter Design Pattern
    
    public List<Auction> meetFilter(List<Auction> items);
}
