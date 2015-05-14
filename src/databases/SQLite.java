/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lloyd
 */
public class SQLite implements Database{
    
    String url = "jdbc:sqlite:database.db";
    Connection con = null;

    @Override
    public Connection getConnection() {
        if (con == null){
            try {
                Class.forName("org.sqlite.JDBC");
                con = DriverManager.getConnection(url);
            } catch (SQLException ex) {
                Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SQLite.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return con;
    }

    @Override
    public void close() {
        if(con != null){
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
