/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auction;

import databases.*;
import java.sql.Connection;
import java.util.List;
import users.User;

/**
 *
 * @author Lloyd
 */
public final class AuctionManager {
    
    Database database = new SQLite();
    
    Connection databaseConnection = database.getConnection();
    
    private List<User> users;
    
    private List<Auction> auctions;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Auction> getAuctions() {
        return auctions;
    }

    public void setAuctions(List<Auction> auctions) {
        this.auctions = auctions;
    }
    
    
    
}
