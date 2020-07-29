package com.example.Entity;

import javax.persistence.Entity;

@Entity
public class LoginInfoEntity {

    private Integer slNo;
    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isValidUserNamePwd(String uName, String pwd) {

        if (userName.equals(uName) && password.equals(pwd)) {
            return true;
        } else {
            return false;
        }
    }
}
