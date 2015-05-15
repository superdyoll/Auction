/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import databases.SQLite;
import databases.Database;
import java.sql.Connection;

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
    
    public Register(Database db){
        this.db = db;
        con = db.getConnection();
    }
    
     if (strlen($password) != 128) {
        // The hashed pwd should be 128 characters long.
        // If it's not, something really odd has happened
        $error_msg .= '<p class="error">Invalid password configuration.</p>';
    }

    // Username validity and password validity have been checked client side.
    // This should should be adequate as nobody gains any advantage from
    // breaking these rules.
    //
    
    $prep_stmt = "SELECT id FROM members WHERE email = ? LIMIT 1";
    $stmt = $mysqli->prepare($prep_stmt);
    
    if ($stmt) {
        $stmt->bind_param('s', $email);
        $stmt->execute();
        $stmt->store_result();
        
        if ($stmt->num_rows == 1) {
            // A user with this email address already exists
            $error_msg .= '<p class="error">A user with this email address already exists.</p>';
        }
    } else {
        $error_msg .= '<p class="error">Database error</p>';
    }
	$stmt->close();
	//check username availability
    $prep_stmt = "SELECT id FROM members WHERE username = ? LIMIT 1";
    $stmt = $mysqli->prepare($prep_stmt);
    
    if ($stmt) {
        $stmt->bind_param('s', $username);
        $stmt->execute();
        $stmt->store_result();
        
        if ($stmt->num_rows == 1) {
            // A user with this email address already exists
            $error_msg .= '<p class="error">A user with this username already exists.</p>';
        }
    } else {
        $error_msg .= '<p class="error">Database error</p>';
    }
	$stmt->close();
    // TODO: 
    // We'll also have to account for the situation where the user doesn't have
    // rights to do registration, by checking what type of user is attempting to
    // perform the operation.

    if (empty($error_msg)) {
        // Create a random salt
        $random_salt = hash('sha512', uniqid(openssl_random_pseudo_bytes(16), TRUE));

        // Create salted password 
        $password = hash('sha512', $password . $random_salt);

        // Insert the new user into the database 
        if ($insert_stmt = $mysqli->prepare("INSERT INTO members (username, email, password, salt, grav_email) VALUES (?, ?, ?, ?, ?)")) {
            $insert_stmt->bind_param('sssss', $username, $email, $password, $random_salt, $email);
            // Execute the prepared query.
            if (! $insert_stmt->execute()) {
                header('Location: error.php?err=Registration failure: INSERT');
                exit();
            }
        }
        header('Location: register_success.php');
        exit();
    }
}
