/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lloyd
 */
public class MySQL implements Database {

    String url = "jdbc:mysql://lloydremotemeuk.domaincommysql.com:3306/auction";
    String uname = "my_auction";
    String pswrd = "yuvNKJN2";
    Connection con = null;

    @Override
    public Connection getConnection() {
        if (con == null){
            try {
                con = DriverManager.getConnection(url, uname, pswrd);
            } catch (SQLException ex) {
                Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
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
