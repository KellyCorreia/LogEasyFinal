package com.example.kelly.logeasyfinal;

/**
 * Created by oanacozma on 04/04/15.
 */
public class UserClass {

    private int user_id;
    private String username;
    private String email;
    private String pass;
    private String avatar;

    public UserClass(){
        user_id = 0;
        username="";
        email="";
        pass="";
        avatar="";
    }

    public UserClass(int u_id, String user, String user_email, String user_password, String user_avatar){
        user_id=u_id;
        username=user;
        email=user_email;
        pass=user_password;
        avatar=user_avatar;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getPass() {
        return pass;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
