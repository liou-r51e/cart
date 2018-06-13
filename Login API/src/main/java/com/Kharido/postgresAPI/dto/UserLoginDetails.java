package com.Kharido.postgresAPI.dto;

public class UserLoginDetails {

    private String emailId;
    private String password;

    @Override
    public String toString() {
        return "UserLoginDetails{" +
                "emailId='" + emailId + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
