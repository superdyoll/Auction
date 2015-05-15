/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import auction.Auction;
import users.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lloyd
 */
public class FilterUser extends Filter{
    
    User searchUser;

    public FilterUser(User searchUser) {
        this.searchUser = searchUser;
    }
    
    public FilterUser(String username){
        this.searchUser = new User(username);
    }
    
    @Override
    public List<Auction> meetFilter(List<Auction> items) {
        List<Auction> keyItems = new ArrayList<>();

        for (Auction item : keyItems) {
            if (item.getSeller().equals(searchUser)) {
                keyItems.add(item);
            }
        }
        return keyItems;
    }
    
}
