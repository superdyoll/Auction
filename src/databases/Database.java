/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databases;

import java.sql.Connection;

/**
 *
 * @author Lloyd
 */
public interface Database {
       
    public Connection getConnection();
    
    public void close();
    
}
