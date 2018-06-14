package com.Kharido.postgresAPI.dto;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;

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
        final String hashed = Hashing.sha256()
                .hashString(password, StandardCharsets.UTF_8)
                .toString();

        return hashed;
    }

    public void setPassword(String password) {

        final String hashed = Hashing.sha256()
                .hashString(password, StandardCharsets.UTF_8)
                .toString();

        this.password = hashed;
    }
}