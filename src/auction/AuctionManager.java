/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auction;

import bid.Bid;
import databases.*;
import item.Item;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
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

    private final HashMap<User, String> users;

    private final List<Auction> auctions;

    private final List<Item> items;

    public AuctionManager() {
        users = new HashMap<>();
        auctions = new ArrayList<>();
        items = new ArrayList<>();
        //getDataFromDB();
    }

    public List<User> getUsers() {
        List<User> userList = new ArrayList<>();
        for (User user : users.keySet()) {
            userList.add(user);
        }
        return userList;
    }

    public String getSessionID(User user) {
        return users.get(user);
    }

    public void addUsers(List<User> users) {
        for (User user : users) {
            addUser(user);
        }
    }

    public void addUser(User user) {
        this.users.put(user, "");
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
        //addAuctionToDB(auction);
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
            for (User user : this.getUsers()) {
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
//TODO IMPLEMENT GETTING AUCTIONS FROM DB
    /*
     private void getDataFromDB() {
     String prep_stmt = "SELECT * FROM User";
     try (PreparedStatement stmt = databaseConnection.prepareStatement(prep_stmt)) {
     ResultSet rs = stmt.executeQuery();

     while (rs.next()) {
     User user = new User(rs.getString("firstname"),
     rs.getString("lastname"),
     rs.getString("uname"),
     rs.getString("password"),
     rs.getString("salt"),
     rs.getInt("points"));
     addUser(user);
     }
     } catch (SQLException ex) {
     Logger.getLogger(AuctionManager.class.getName()).log(Level.SEVERE, null, ex);
     }

     prep_stmt = "SELECT * FROM Item";
     try (PreparedStatement stmt = databaseConnection.prepareStatement(prep_stmt)) {
     ResultSet rs = stmt.executeQuery();

     while (rs.next()) {
     Item item = new Item(rs.getString("name"),
     rs.getString("description"));
     addItem(item);
     }
     } catch (SQLException ex) {
     Logger.getLogger(AuctionManager.class.getName()).log(Level.SEVERE, null, ex);
     }

     }

     private void getAuctionDataFromDB() {
     String prep_stmt = "SELECT * FROM Auction";
     try (PreparedStatement stmt = databaseConnection.prepareStatement(prep_stmt)) {
     ResultSet rs = stmt.executeQuery();

     while (rs.next()) {

     Item auctionItem;
     String item_stmt = "SELECT * FROM Item WHERE A_ID = ?";

     try (PreparedStatement itemPS = databaseConnection.prepareStatement(prep_stmt)) {
     itemPS.setInt(1, rs.getInt("A_ID"));
     ResultSet bidrs = itemPS.executeQuery();

     while (bidrs.next()) {
     Item item = new Item(rs.getString("name"),
     rs.getString("description"));
     auctionItem = item;
     }
     } catch (SQLException ex) {
     Logger.getLogger(AuctionManager.class.getName()).log(Level.SEVERE, null, ex);
     }

     Auction auction = new Auction(auctionItem, null, reservePrice, null, null);

     String bid_stmt = "SELECT * FROM Bid WHERE A_ID = ?";

     try (PreparedStatement bidPS = databaseConnection.prepareStatement(prep_stmt)) {
     bidPS.setInt(1, rs.getInt("A_ID"));
     ResultSet bidrs = bidPS.executeQuery();

     while (bidrs.next()) {
     Bid bid = new Bid(rs.getString("name"),
     rs.getString("description"));
     addItem(item);
     }
     } catch (SQLException ex) {
     Logger.getLogger(AuctionManager.class.getName()).log(Level.SEVERE, null, ex);
     }

     addAuction(auction);
     }
     } catch (SQLException ex) {
     Logger.getLogger(AuctionManager.class.getName()).log(Level.SEVERE, null, ex);
     }
     }
     */
}
