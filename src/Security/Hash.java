/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Security;

/**
 *
 * @author Lloyd
 */
public interface Hash {
    
    public String getHashedRandomSalt();
    
    public String hash(String data);
    
    public String getHashedPassword(String password, String salt);
    
}
