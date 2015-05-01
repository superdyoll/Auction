/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Users;

/**
 *
 * @author Lloyd
 */
public class User {
    private String familyName;
    private String personalName;
    private String password;
    private String salt;
    private int personalID;
    
    
    public User (String personalName, String familyName,
            String password, String salt, int personalID){
        this.personalName = personalName;
        this.familyName = familyName;
        this.password = password;
        this.salt = salt;
        this.personalID = personalID;
    }

    /**
     * @return the familyName
     */
    public String getFamilyName() {
        return familyName;
    }

    /**
     * @param familyName the familyName to set
     */
    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    /**
     * @return the personalName
     */
    public String getPersonalName() {
        return personalName;
    }

    /**
     * @param personalName the personalName to set
     */
    public void setPersonalName(String personalName) {
        this.personalName = personalName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the salt
     */
    public String getSalt() {
        return salt;
    }

    /**
     * @param salt the salt to set
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * @return the personalID
     */
    public int getPersonalID() {
        return personalID;
    }

    /**
     * @param personalID the personalID to set
     */
    public void setPersonalID(int personalID) {
        this.personalID = personalID;
    }
}
