/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

/**
 *
 * @author Lloyd
 */
public class User implements java.io.Serializable{

    private String familyName;
    private String personalName;
    public String username;
    private String password;
    private String salt;
    private int personalID = -1;
    public int penaltyPoints;
    //TODO implement penalty points properly

    public User(String personalName, String familyName, String username,
            String password, String salt, int personalID) {
        this.personalName = personalName;
        this.familyName = familyName;
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.personalID = personalID;
    }

    public User(String personalName, String familyName, String username,
            String password, String salt) {
        this.personalName = personalName;
        this.familyName = familyName;
        this.username = username;
        this.password = password;
        this.salt = salt;
    }

    public User(String personalName, String familyName, String username) {
        this.personalName = personalName;
        this.familyName = familyName;
        this.username = username;
    }

    public User(String username) {
        this.username = username;
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
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
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

    /**
     *
     * @param otherUser
     * @return
     */
    public boolean equals(User otherUser) {
        if (username.equals(otherUser.getUsername())) {
            return true;
        } else {
            return personalID == otherUser.getPersonalID();
        }
    }

    /**
     * @return the penaltyPoints
     */
    public int getPenaltyPoints() {
        return penaltyPoints;
    }

    /**
     * @param penaltyPoints the penaltyPoints to set
     */
    public void setPenaltyPoints(int penaltyPoints) {
        this.penaltyPoints = penaltyPoints;
    }

}
