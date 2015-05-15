/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import databases.SQLite;
import databases.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import security.SHA512;

/**
 *
 * @author Lloyd
 */
public class Register {

    Database db;
    Connection con;

    public Register() {
        this.db = new SQLite();
        con = db.getConnection();
    }

    public Register(Database db) {
        this.db = db;
        con = db.getConnection();
    }

    public boolean RegisterUser(String firstName, String lastName, String userName, String password) throws SQLException {

        String error_msg = "";

        if (password.length() != 128) {
            // The hashed pwd should be 128 characters long.
            // If it's not, something really odd has happened
            error_msg += "Invalid password configuration.";
        }

        // Username validity and password validity have been checked client side.
        // This should should be adequate as nobody gains any advantage from
        // breaking these rules.
        //
        String prep_stmt = "SELECT U_ID FROM User WHERE uname = ? LIMIT 1";
        try (PreparedStatement stmt = con.prepareStatement(prep_stmt)) {
            stmt.setString(1, userName);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                // A user with this email address already exists
                error_msg += "A user with this email address already exists.</p>";
            }
        }

        if (error_msg.isEmpty()) {
            SHA512 hasher = new SHA512();
            // Create a random salt
            String random_salt = hasher.getHashedRandomSalt();

            // Create salted password 
            password = hasher.getHashedPassword(password, random_salt);

            // Insert the new user into the database 
            PreparedStatement insert_stmt = con.prepareStatement("INSERT INTO members (username, email, password, salt, grav_email) VALUES (?, ?, ?, ?, ?)");

            insert_stmt.setString(1, firstName);
            insert_stmt.setString(2, lastName);
            insert_stmt.setString(3, userName);
            insert_stmt.setString(4, password);
            insert_stmt.setString(5, random_salt);

            // Execute the prepared query.
            if (!insert_stmt.execute()) {
                return false;

            }
            return true;
        }
        return false;

    }
}
