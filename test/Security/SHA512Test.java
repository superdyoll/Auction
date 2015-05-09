/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Security;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lloyd
 */
public class SHA512Test {
    
    public SHA512Test() {
    }

    /**
     * Test of getHashedRandomSalt method, of class SHA512.
     */
    @Test
    public void testGetHashedRandomSalt() {
        System.out.println("getHashedRandomSalt");
        SHA512 instance = new SHA512();
        String expResult = "";
        String result = instance.getHashedRandomSalt();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHashedPassword method, of class SHA512.
     */
    @Test
    public void testGetHashedPassword() {
        System.out.println("getHashedPassword");
        String password = "";
        String salt = "";
        SHA512 instance = new SHA512();
        String expResult = "";
        String result = instance.getHashedPassword(password, salt);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hash method, of class SHA512.
     */
    @Test
    public void testHash() {
        System.out.println("hash");
        String data = "";
        SHA512 instance = new SHA512();
        String expResult = "";
        String result = instance.hash(data);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of convertToHex method, of class SHA512.
     */
    @Test
    public void testConvertToHex() {
        System.out.println("convertToHex");
        byte[] bytes = null;
        SHA512 instance = new SHA512();
        String expResult = "";
        String result = instance.convertToHex(bytes);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
