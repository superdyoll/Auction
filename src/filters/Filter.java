package filters;

import auction.Auction;
import java.util.List;

/**
 *
 * @author Lloyd
 */
public abstract class Filter implements java.io.Serializable{

    //Public interface for implementation of Filter Design Pattern
    
    public abstract List<Auction> meetFilter(List<Auction> items);
}
