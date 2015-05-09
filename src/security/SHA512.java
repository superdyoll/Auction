/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lloyd
 */
public class SHA512 implements Hash{
    
    MessageDigest md;

    public SHA512() {
        try {
            this.md = MessageDigest.getInstance("SHA-512", "BC");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(SHA512.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchProviderException ex) {
            Logger.getLogger(SHA512.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public String getHashedRandomSalt() {
        byte [] bytes = new byte [16];
        new Random().nextBytes(bytes);
        String salt = convertToHex(bytes);
        String hashedSalt = hash(salt);
        return hashedSalt;
    }

    @Override
    public String getHashedPassword(String password, String salt) {
        String saltedPassword = password + salt;
        String hashedPassword = hash(saltedPassword);
        return hashedPassword;
    }

    @Override
    public String hash(String data) {
        byte[] mdbytes = md.digest(data.getBytes());
        //convert the byte to hex format method 2
        String hexString = convertToHex(mdbytes);
        return hexString;
    }
    
    protected String convertToHex(byte [] bytes){
        StringBuilder hexString = new StringBuilder();
    	for (int i=0;i<bytes.length;i++) {
    	  hexString.append(Integer.toHexString(0xFF & bytes[i]));
    	}
        return hexString.toString();
    }
    
}
