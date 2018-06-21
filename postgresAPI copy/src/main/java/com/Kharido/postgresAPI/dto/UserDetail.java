package com.Kharido.postgresAPI.dto;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;

public class UserDetail {

    private String emailId;
    private String fullName;
    private String password;
    private String phoneNumber;
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() { return password; }

    public void setPassword(String password) {
        final String hashed = Hashing.sha256()
                .hashString(password, StandardCharsets.UTF_8)
                .toString();
        this.password = hashed;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "UserDetail{" +
                "emailId='" + emailId + '\'' +
                ", fullName='" + fullName + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
