/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filter;


import Items.Item;
import java.util.List;

/**
 *
 * @author Lloyd
 */
public interface Filter {   
    //TODO make filters
    public List<Item> meetCriteria(List<Item> items);
}
