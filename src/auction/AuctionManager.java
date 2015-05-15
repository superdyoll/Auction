/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auction;

import databases.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import users.Register;
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

    public void addUsers(List<User> users) {
        for (User user : users) {
            addUser(user);
        }
    }
    
    public void addUser(User user){
        this.users.add(user);
        Register registerUser = new Register(database);
        try {
            registerUser.RegisterUser(user.getPersonalName(), user.getFamilyName(), user.getUsername(), user.getPassword());
        } catch (SQLException ex) {
            Logger.getLogger(AuctionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Auction> getAuctions() {
        return auctions;
    }

    public void addAuctions(List<Auction> auctions) {
        for (Auction auction : auctions) {
            addAuction(auction);
        }
    }
    
    public void addAuction(Auction auction){
        this.auctions.add(auction);
    }
    
}
