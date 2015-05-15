/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package message;

import users.User;

/**
 *
 * @author Lloyd
 */
public class MessageUser extends Message{

    User user;
    int type;
    
    /**Send a User.
     * 
     * Type denotes what type of message is being sent
     * 0 - Just sending
     * 1 - Register
     * 2 - Log In
     * 3 - Log Out
     *
     * @param type
     */
    public MessageUser(User user, int type) {
        super(3);
        this.user = user;
        this.type = type;
    }

    @Override
    public User getMessage() {
        return user;
    }

    @Override
    public void setMessage(Object message) throws Exception {
        if (message instanceof User){
            this.user = (User) message;
        }else{
            throw new Exception("Not of type user");
        }
    }

    @Override
    public String toString() {
        String returned = "ID: " + getMessageID() + " Message: " + user;
        return returned;
    }
    
    public boolean isRegister(){
        if(type == 1){
            return true;
        }
        return false;
    }
    
    public boolean isLogIn(){
        if(type == 2){
            return true;
        }
        return false;
    }
    
    public boolean isLogOut(){
        if(type == 3){
            return true;
        }
        return false;
    }
    
}
