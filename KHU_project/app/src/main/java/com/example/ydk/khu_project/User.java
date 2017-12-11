package com.example.ydk.khu_project;

/**
 * Created by USER on 2017-11-25.
 */

public class User {

    String user_id;
    String user_password;
    String user_name;

    User(String id, String password, String name){
        this.user_id=id;
        this.user_password=password;
        this.user_name=name;
    }

    public String getid(){
        return this.user_id;
    }
    public void setid(String id){
        this.user_id=id;
    }
    public String getpassword(){
        return this.user_password;
    }
    public void setpassword(String password){
        this.user_password=password;
    }
    public String getname(){
        return this.user_name;
    }
    public void setname(String name){
        this.user_name=name;
    }

}
