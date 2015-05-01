/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Users;

import Database.*;
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
}
