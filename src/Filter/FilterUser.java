/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filter;

import Items.Item;
import Users.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lloyd
 */
public class FilterUser implements Filter{
    
    User searchUser;

    public FilterUser(User searchUser) {
        this.searchUser = searchUser;
    }
    
    public FilterUser(String username){
        this.searchUser = new User(username);
    }
    
    @Override
    public List<Item> meetFilter(List<Item> items) {
        List<Item> keyItems = new ArrayList<>();

        for (Item item : keyItems) {
            if (item.getSeller().equals(searchUser)) {
                keyItems.add(item);
            }
        }
        return keyItems;
    }
    
}
