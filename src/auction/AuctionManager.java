/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auction;

import databases.*;
import item.Item;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
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

    private List<Item> items;

    public List<User> getUsers() {
        return users;
    }

    public User getUser(int index) {
        return users.get(index);
    }

    public void addUsers(List<User> users) {
        for (User user : users) {
            addUser(user);
        }
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public void addUserToDB(User user) {
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

    public void addAuction(Auction auction) {
        this.auctions.add(auction);
        addAuctionToDB(auction);
    }

    /**
     * @return the items
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * @param items the items to set
     */
    public void addItems(List<Item> items) {
        for (Item item : items) {
            addItem(item);
        }
    }

    public void addItem(Item item) {
        items.add(item);
    }

    private int addItemToDB(Item item) throws SQLException {
        String prep_stmt = "SELECT I_ID FROM Item WHERE name = ? LIMIT 1";
        try (PreparedStatement stmt = databaseConnection.prepareStatement(prep_stmt)) {
            stmt.setString(1, item.getTitle());
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt("I_ID");
            } else {
                String fileName = item.getTitle() + ".jpg";
                File outputfile = new File(fileName);
                ImageIO.write(item.getImage(), "jpg", outputfile);

                // Insert the new user into the database 
                PreparedStatement insert_stmt = databaseConnection.prepareStatement("INSERT INTO Item (name, description, img_location) VALUES (?, ?, ?)");

                insert_stmt.setString(1, item.getTitle());
                insert_stmt.setString(2, item.getDescription());
                insert_stmt.setString(3, fileName);

                // Execute the prepared query.
                if (!insert_stmt.execute()) {
                    return -1;
                } else {

                    rs = stmt.executeQuery();

                    if (rs.next()) {
                        return rs.getInt("I_ID");
                    }
                }
            }

        } catch (IOException ex) {
            Logger.getLogger(AuctionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    protected void addAuctionToDB(Auction auction) {
        try {
            int sellerID = -1;
            //Find the seller's ID
            for (User user : users) {
                if (auction.getSeller().equals(user)) {
                    sellerID = user.getPersonalID();
                }
            }
            //Add the Item
            addItem(auction.getItem());
            //Get the items ID
            int itemID = addItemToDB(auction.getItem());
            
            if (sellerID > -1 && itemID > -1) {
                // Insert the new auction into the database
                PreparedStatement insert_stmt = databaseConnection.prepareStatement("INSERT INTO Auction (I_ID, U_ID, reserve, start, end, status) VALUES (?, ?, ?, ?, ?, ?)");

                insert_stmt.setInt(1, itemID);
                insert_stmt.setInt(2, sellerID);
                insert_stmt.setDouble(3, auction.getReservePrice());
                insert_stmt.setTime(4, (Time) auction.getStartTime().getTime(), auction.getStartTime());
                insert_stmt.setTime(5, (Time) auction.getCloseTime().getTime(), auction.getCloseTime());
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(AuctionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
